package dataLayer;
import businessLayer.MenuItem;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriter {

    public static void createBill(List<MenuItem> listed) {
        java.io.FileWriter myWriter;
        try {
            myWriter = new java.io.FileWriter("order.txt");
            myWriter.write("Order placed for the menu items: " + listed.stream().map(MenuItem::getTitle).collect(Collectors.joining(", ")) + "\n");
            myWriter.write("The total price is: " + listed.stream().mapToInt(MenuItem::computePrice).sum());
            myWriter.close();
            System.out.println("Successfully wrote the bill.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeReport(List<String> data) {
        java.io.FileWriter myWriter;
        try {
            myWriter = new java.io.FileWriter("report.txt");
            myWriter.write(String.join("\n", data));
            myWriter.close();
            System.out.println("Successfully wrote the report.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
