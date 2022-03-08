package dataLayer;

import businessLayer.DeliveryService;

import java.io.*;

public class Serializator {

    public static void save(DeliveryService deliveryService) {
        FileOutputStream fileOut;
        ObjectOutputStream out ;
        try {
            fileOut = new FileOutputStream("file.txt");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DeliveryService read() {
        FileInputStream fileIn;
        int verify;
        Boolean ok = true;
        DeliveryService deliveryService;
        try {
            fileIn = new FileInputStream("file.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deliveryService = (DeliveryService) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException | IOException e) {
            return new DeliveryService();
        }
        return deliveryService;
    }

}
