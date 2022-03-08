package presentationLayer;

import businessLayer.DeliveryService;

import javax.swing.*;

public class ViewClient {
    private JPanel clientPanel;
    private JTextField clientTitleField;
    private JTextField clientRatingField;
    private JTextField clientCaloriesField;
    private JTextField clientProteinsField;
    private JTextField clientFatsField;
    private JTextField clientSodiumField;
    private JTextField clientPriceField;
    private JButton searchByFiltresButton;
    private JTextField clientOrderField;
    private JButton placeOrderButton;
    private JTable orderTable;
    private DeliveryService service;
    private int clientID;

    public ViewClient(DeliveryService service, int clientID)
    {
        this.clientID = clientID;
        this.service = service;
        new ClientController(this);
    }

    public int getClientID() {
        return clientID;
    }

    public DeliveryService getDeliveryService() {
        return service;
    }

    public JPanel getClientPanel() {
        return clientPanel;
    }

    public JTextField getClientTitleField() {
        return clientTitleField;
    }

    public JTextField getClientRatingField() {
        return clientRatingField;
    }

    public JTextField getClientCaloriesField() {
        return clientCaloriesField;
    }

    public JTextField getClientProteinsField() {
        return clientProteinsField;
    }

    public JTextField getClientFatsField() {
        return clientFatsField;
    }

    public JTextField getClientSodiumField() {
        return clientSodiumField;
    }

    public JTextField getClientPriceField() {
        return clientPriceField;
    }

    public JButton getSearchByFiltresButton() {
        return searchByFiltresButton;
    }

    public JTextField getClientOrderField() {
        return clientOrderField;
    }

    public JButton getPlaceOrderButton() {
        return placeOrderButton;
    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public int getClientPanelHeight() {
        return clientPanel.getHeight();
    }

    public int getClientTitleFieldHeight() {
        return clientTitleField.getHeight();
    }

    public int getClientRatingFieldHeight() {
        return clientRatingField.getHeight();
    }

    public int getClientCaloriesFieldHeight() {
        return clientCaloriesField.getHeight();
    }

    public int getClientProteinsFieldHeight() {
        return clientProteinsField.getHeight();
    }

    public int getClientFatsFieldHeight() {
        return clientFatsField.getHeight();
    }

    public int getClientSodiumFieldHeight() {
        return clientSodiumField.getHeight();
    }

    public int getClientPriceFieldHeight() {
        return clientPriceField.getHeight();
    }

    public int getSearchByFiltresButtonHeight() {
        return searchByFiltresButton.getHeight();
    }

    public int getClientOrderFieldHeight() {
        return clientOrderField.getHeight();
    }

    public int getPlaceOrderButtonHeight() {
        return placeOrderButton.getHeight();
    }

    public int getOrderTableHeight() {
        return orderTable.getHeight();
    }

}
