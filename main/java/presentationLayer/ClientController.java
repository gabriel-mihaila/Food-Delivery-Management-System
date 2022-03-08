package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.util.stream.Collectors;

public class ClientController {

    public ClientController(ViewClient view) {

        view.getSearchByFiltresButton().addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) view.getOrderTable().getModel();

            model.setColumnCount(0);
            model.setRowCount(0);

            model.setColumnIdentifiers(Arrays.asList("Title", "Rating", "Calories", "Proteins", "Fats", "Sodium", "Price").toArray());

            List<MenuItem> waiting = view.getDeliveryService().getMenu();

            if(!view.getClientTitleField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> view.getClientTitleField().getText().equals(menu.getTitle())).collect(Collectors.toList());
            }

            if(!view.getClientRatingField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> {
                    double value;
                    if(menu instanceof BaseProduct)
                        value = ((BaseProduct) menu).getRating();
                    else
                        value = ((CompositeProduct) menu).getMenuItems().stream().filter(item -> item instanceof BaseProduct)
                                .map(item -> (BaseProduct) item).mapToDouble(BaseProduct::getRating).average().getAsDouble();
                    return Double.parseDouble(view.getClientRatingField().getText()) == value;
                }).collect(Collectors.toList());
            }

            if(!view.getClientCaloriesField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> {
                    int value;
                    if(menu instanceof BaseProduct)
                        value = ((BaseProduct) menu).getCalories();
                    else
                        value = ((CompositeProduct) menu).getMenuItems().stream().filter(item -> item instanceof BaseProduct)
                                .map(item -> (BaseProduct) item).mapToInt(BaseProduct::getCalories).sum();
                    return Integer.parseInt(view.getClientCaloriesField().getText()) == value;
                }).collect(Collectors.toList());
            }

            if(!view.getClientFatsField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> {
                    int value;
                    if(menu instanceof BaseProduct)
                        value = ((BaseProduct) menu).getFat();
                    else
                        value = ((CompositeProduct) menu).getMenuItems().stream().filter(item -> item instanceof BaseProduct)
                                .map(item -> (BaseProduct) item).mapToInt(BaseProduct::getFat).sum();
                    return Integer.parseInt(view.getClientFatsField().getText()) == value;
                }).collect(Collectors.toList());
            }

            if(!view.getClientProteinsField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> {
                    int value;
                    if(menu instanceof BaseProduct)
                        value = ((BaseProduct) menu).getProtein();
                    else
                        value = ((CompositeProduct) menu).getMenuItems().stream().filter(item -> item instanceof BaseProduct)
                                .map(item -> (BaseProduct) item).mapToInt(BaseProduct::getProtein).sum();
                    return Integer.parseInt(view.getClientProteinsField().getText()) == value;
                }).collect(Collectors.toList());
            }

            if(!view.getClientSodiumField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> {
                    int value;
                    if(menu instanceof BaseProduct)
                        value = ((BaseProduct) menu).getSodium();
                    else
                        value = ((CompositeProduct) menu).getMenuItems().stream().filter(item -> item instanceof BaseProduct)
                                .map(item -> (BaseProduct) item).mapToInt(BaseProduct::getSodium).sum();
                    return Integer.parseInt(view.getClientSodiumField().getText()) == value;
                }).collect(Collectors.toList());
            }

            if(!view.getClientPriceField().getText().isEmpty()){
                waiting = waiting.stream().filter(menu -> Integer.parseInt(view.getClientPriceField().getText()) == menu.computePrice()).collect(Collectors.toList());
            }

            List<MenuItem> items = view.getDeliveryService().toDisplay(waiting);

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

        view.getPlaceOrderButton().addActionListener(e -> {
            System.out.println("CASTED");
            String composed = view.getClientOrderField().getText();
            List<MenuItem> listed = Arrays.stream(composed.split(","))
                    .map(name -> view.getDeliveryService().fromName(name)).collect(Collectors.toList());
            dataLayer.FileWriter.createBill(listed);
            Order order = new Order(view.getClientID());
            view.getDeliveryService().addOrder(order, listed);
            view.getDeliveryService().sendInfo(listed);
        });

    }

}
