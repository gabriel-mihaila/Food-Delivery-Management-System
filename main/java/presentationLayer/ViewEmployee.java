package presentationLayer;

import businessLayer.DeliveryService;

import javax.swing.*;



public class ViewEmployee {
    private JPanel employeePanel;
    private JTextPane employeePane1;
    private DeliveryService deliveryService;

    public ViewEmployee(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
        new EmployeeController(this);
    }

    public DeliveryService getDeliveryService() {
        return deliveryService;
    }

    public JTextPane getEmployeePane1() {
        return employeePane1;
    }

    public JPanel getEmployeePanel() {
        return employeePanel;
    }


}
