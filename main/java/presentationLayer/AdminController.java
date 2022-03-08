package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.MenuItem;
import businessLayer.Order;
import dataLayer.FileWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class AdminController {

    public AdminController(ViewAdmin view) {

        view.getImportCSVButton().addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(fileChooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Files.lines(file.getAbsoluteFile().toPath()).map(listt -> listt.split(",")).skip(1)
                            .map(splitted -> new BaseProduct(view.getDeliveryService(), splitted[0], Double.parseDouble(splitted[1]), Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]), Integer.parseInt(splitted[5]), Integer.parseInt(splitted[6])))
                            .count();

                    view.getDeliveryService().getMenu().stream().map(MenuItem::getTitle).forEach(System.out::println);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        view.getRefreshButton().addActionListener(e -> {

            DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();

            model.setColumnCount(0);
            model.setRowCount(0);

            model.setColumnIdentifiers(Arrays.asList("Title", "Rating", "Calories", "Proteins", "Fats", "Sodium", "Price").toArray());

            List<MenuItem> items = view.getDeliveryService().toDisplay(view.getDeliveryService().getMenu());

            String printing = "";

            for(MenuItem product : items) {
                if(product == null) {
                    printing = printing.substring(0, printing.length() - 2);
                    continue;
                }
                if(product instanceof BaseProduct) {
                    model.addRow(new Vector<>(Arrays.asList(printing + product.getTitle(), ((BaseProduct) product).getRating(), ((BaseProduct) product).getCalories(), ((BaseProduct) product).getProtein(), ((BaseProduct) product).getFat(), ((BaseProduct) product).getSodium(), ((BaseProduct) product).getPrice())));
                } else {
                    model.addRow(new Vector<>(Arrays.asList(printing + product.getTitle(), 0, 0, 0, 0, 0, 0)));
                    printing += "* ";
                }
            }
        });

        view.getInsertBaseProductButton().addActionListener(e -> new BaseProduct(view.getDeliveryService(), view.getTitleField1().getText(), Double.parseDouble(view.getRatingField2().getText()), Integer.parseInt(view.getCaloriesField3().getText()), Integer.parseInt(view.getProteinsField4().getText()), Integer.parseInt(view.getFatsField5().getText()), Integer.parseInt(view.getSodiumField6().getText()), Integer.parseInt(view.getPriceField7().getText())));

        view.getUpdateBaseProductButton().addActionListener(e -> {
            AtomicReference<MenuItem> toRemove = new AtomicReference<>();
            view.getDeliveryService().getMenu().stream().filter(item -> item.getTitle().equals(view.getTitleField1().getText()))
                    .findAny().ifPresent(toRemove::set);
            if(toRemove.get() != null) {
                view.getDeliveryService().removeMenu(toRemove.get());
            }
            new BaseProduct(view.getDeliveryService(), view.getTitleField1().getText(), Double.parseDouble(view.getRatingField2().getText()), Integer.parseInt(view.getCaloriesField3().getText()), Integer.parseInt(view.getProteinsField4().getText()), Integer.parseInt(view.getFatsField5().getText()), Integer.parseInt(view.getSodiumField6().getText()), Integer.parseInt(view.getPriceField7().getText()));
        });

        view.getDeleteBaseProductButton().addActionListener(e -> {
            AtomicReference<MenuItem> toRemove = new AtomicReference<>();
            view.getDeliveryService().getMenu().stream().filter(item -> item.getTitle().equals(view.getTitleField1().getText()))
                    .findAny().ifPresent(toRemove::set);
            if(toRemove.get() != null)
                view.getDeliveryService().removeMenu(toRemove.get());
        });

        view.getInsertCompositeButton().addActionListener(e -> {
            new CompositeProduct(view.getDeliveryService(), view.getCompositeNameField8().getText(),
                    Arrays.stream(view.getCompositeBaseProdField9().getText().split(","))
                    .map(name -> view.getDeliveryService().fromName(name)).collect(Collectors.toList()));
        });

        view.getDeleteCompositeButton().addActionListener(e -> {
            view.getDeliveryService().removeMenu(view.getDeliveryService().fromName(view.getCompositeNameField8().getText()));
        });

        view.getOrderReportButton().addActionListener(e -> {
            int startHour = Integer.parseInt(view.getStartHourField10().getText());
            int finishHour = Integer.parseInt(view.getFinishHourField11().getText());
            Map<Order, List<MenuItem>> listed = view.getDeliveryService().getOrders();
            FileWriter.writeReport(listed.entrySet().stream()
                    .filter(entry -> entry.getKey().getDate().getHour() >= startHour)
                    .filter(entry -> entry.getKey().getDate().getHour() <= finishHour)
                    .map(current -> "Order id " + current.getKey().getId() + " ordered by " + current.getKey().getClientID() + " consisting of " + current.getValue().stream().map(MenuItem::getTitle).collect(Collectors.joining(", ")))
                    .collect(Collectors.toList()));
        });

        view.getProbuctByTimesReportButton().addActionListener(e -> {
            int amountOfTimes = Integer.parseInt(view.getNrTimesProdField12().getText());
            Map<Order, List<MenuItem>> listed = view.getDeliveryService().getOrders();
            List<MenuItem> flatted = new ArrayList<>();
            listed.values().stream()
                    .map(temporary -> view.getDeliveryService().toDisplay(temporary).stream()
                            .filter(item -> item instanceof BaseProduct).collect(Collectors.toList()))
                    .forEach(flatted::addAll);
            FileWriter.writeReport(flatted.stream().collect(Collectors.groupingBy(MenuItem::getTitle,
                    Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() >= amountOfTimes)
                    .map(entry -> "Product id " + entry.getKey() + " which has been ordered " + entry.getValue() + " times")
                    .collect(Collectors.toList()));
        });

        view.getClientReportButton().addActionListener(e -> {
            int numberOfTimesClient = Integer.parseInt(view.getNrTimesClientField13().getText());
            int price = Integer.parseInt(view.getPriceField7().getText());
            Map<Order, List<MenuItem>> listed = view.getDeliveryService().getOrders();
            FileWriter.writeReport(listed.entrySet().stream()
                    .filter(entry -> price <= entry.getValue().stream().mapToInt(MenuItem::computePrice).sum())
                .map(Map.Entry::getKey).collect(Collectors.groupingBy(Order::getClientID, Collectors.counting()))
                    .entrySet().stream().filter(entry -> entry.getValue() >= numberOfTimesClient)
                    .map(entry -> "User id " + view.getDeliveryService().getAccounts().stream().filter(account -> account.getId() == entry.getValue()).findAny().get().getUsername() + " ordered " + entry.getKey() + " times")
                    .collect(Collectors.toList()));
        });

        view.getProductByDayReportButton().addActionListener(e -> {
            int day = Integer.parseInt(view.getDayReportField15().getText());
            Map<Order, List<MenuItem>> listed = view.getDeliveryService().getOrders();
            FileWriter.writeReport(listed.entrySet().stream().filter(entry -> entry.getKey().getDate().getDayOfMonth() == day)
                .map(Map.Entry::getValue).flatMap(Collection::stream).collect(Collectors.groupingBy(MenuItem::getTitle,
                            Collectors.counting())).entrySet().stream()
                    .map(entry -> "Product id " + entry.getKey() + " which has been ordered " + entry.getValue() + " times")
                    .collect(Collectors.toList()));
        });

    }

}
