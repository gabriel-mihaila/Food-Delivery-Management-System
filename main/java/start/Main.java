package start;
import businessLayer.Account;
import businessLayer.DeliveryService;
import dataLayer.Serializator;
import presentationLayer.ViewLogin;

import javax.swing.*;

public class Main {

    private static DeliveryService deliveryService;

    public static void main(String[] args) {

        JFrame frame;
        deliveryService = Serializator.read();

        new Account("gabi", "1234", 1);
        new Account("mihai", "1234", 2);

        frame = new JFrame("Account");
        frame.setContentPane(new ViewLogin(deliveryService).getLoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Serializator.save(deliveryService);
        }));

    }

    public static DeliveryService getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        Main.deliveryService = deliveryService;
    }
}
