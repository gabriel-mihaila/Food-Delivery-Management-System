package presentationLayer;

import businessLayer.DeliveryService;

import javax.swing.*;

public class ViewAdmin {
    private JPanel adminPanel;
    private JTable table1;
    private JTextField titleField1;
    private JTextField ratingField2;
    private JTextField caloriesField3;
    private JTextField proteinsField4;
    private JTextField fatsField5;
    private JTextField sodiumField6;
    private JTextField priceField7;
    private JButton importCSVButton;
    private JTextField compositeNameField8;
    private JTextField compositeBaseProdField9;
    private JTextField startHourField10;
    private JTextField finishHourField11;
    private JTextField nrTimesProdField12;
    private JTextField nrTimesClientField13;
    private JTextField priceReportField14;
    private JTextField dayReportField15;
    private JButton orderReportButton;
    private JButton probuctByTimesReportButton;
    private JButton clientReportButton;
    private JButton productByDayReportButton;
    private JButton insertBaseProductButton;
    private JButton updateBaseProductButton;
    private JButton refreshButton;
    private JButton insertCompositeButton;
    private JButton deleteBaseProductButton;
    private JButton deleteCompositeButton;

    private DeliveryService deliveryService;

    public ViewAdmin(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        new AdminController(this);
    }

    public JTable getTable1() {
        return table1;
    }

    public JTextField getTitleField1() {
        return titleField1;
    }

    public JTextField getRatingField2() {
        return ratingField2;
    }

    public JTextField getCaloriesField3() {
        return caloriesField3;
    }

    public JTextField getProteinsField4() {
        return proteinsField4;
    }

    public JTextField getFatsField5() {
        return fatsField5;
    }

    public JTextField getSodiumField6() {
        return sodiumField6;
    }

    public JTextField getPriceField7() {
        return priceField7;
    }

    public JButton getImportCSVButton() {
        return importCSVButton;
    }

    public JTextField getCompositeNameField8() {
        return compositeNameField8;
    }

    public JTextField getCompositeBaseProdField9() {
        return compositeBaseProdField9;
    }

    public JTextField getStartHourField10() {
        return startHourField10;
    }

    public JTextField getFinishHourField11() {
        return finishHourField11;
    }

    public JTextField getNrTimesProdField12() {
        return nrTimesProdField12;
    }

    public JTextField getNrTimesClientField13() {
        return nrTimesClientField13;
    }

    public JTextField getDayReportField15() {
        return dayReportField15;
    }

    public JButton getOrderReportButton() {
        return orderReportButton;
    }

    public JButton getProbuctByTimesReportButton() {
        return probuctByTimesReportButton;
    }

    public JButton getClientReportButton() {
        return clientReportButton;
    }

    public JButton getProductByDayReportButton() {
        return productByDayReportButton;
    }

    public JButton getInsertBaseProductButton() {
        return insertBaseProductButton;
    }

    public JButton getUpdateBaseProductButton() {
        return updateBaseProductButton;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JButton getInsertCompositeButton() {
        return insertCompositeButton;
    }

    public JButton getDeleteBaseProductButton() {
        return deleteBaseProductButton;
    }

    public JButton getDeleteCompositeButton() {
        return deleteCompositeButton;
    }

    public DeliveryService getDeliveryService() {
        return deliveryService;
    }

    public JPanel getAdminPanel() {
        return adminPanel;
    }


    public int getTable1Height() {
        return table1.getHeight();
    }

    public int getTitleField1Height() {
        return titleField1.getHeight();
    }

    public int getRatingField2Height() {
        return ratingField2.getHeight();
    }

    public int getCaloriesField3Height() {
        return caloriesField3.getHeight();
    }

    public int getProteinsField4Height() {
        return proteinsField4.getHeight();
    }

    public int getFatsField5Height() {
        return fatsField5.getHeight();
    }

    public int getSodiumField6Height() {
        return sodiumField6.getHeight();
    }

    public int getPriceField7Height() {
        return priceField7.getHeight();
    }

    public int getImportCSVButtonHeight() {
        return importCSVButton.getHeight();
    }

    public int getCompositeNameField8Height() {
        return compositeNameField8.getHeight();
    }

    public int getCompositeBaseProdField9Height() {
        return compositeBaseProdField9.getHeight();
    }

    public int getStartHourField10Height() {
        return startHourField10.getHeight();
    }

    public int getFinishHourField11Height() {
        return finishHourField11.getHeight();
    }

    public int getNrTimesProdField12Height() {
        return nrTimesProdField12.getHeight();
    }

    public int getNrTimesClientField13Height() {
        return nrTimesClientField13.getHeight();
    }

    public int getDayReportField15Height() {
        return dayReportField15.getHeight();
    }

    public int getOrderReportButtonHeight() {
        return orderReportButton.getHeight();
    }

    public int getProbuctByTimesReportButtonHeight() {
        return probuctByTimesReportButton.getHeight();
    }

    public int getClientReportButtonHeight() {
        return clientReportButton.getHeight();
    }

    public int getProductByDayReportButtonHeight() {
        return productByDayReportButton.getHeight();
    }

    public int getInsertBaseProductButtonHeight() {
        return insertBaseProductButton.getHeight();
    }

    public int getUpdateBaseProductButtonHeight() {
        return updateBaseProductButton.getHeight();
    }

    public int getRefreshButtonHeight() {
        return refreshButton.getHeight();
    }

    public int getInsertCompositeButtonHeight() {
        return insertCompositeButton.getHeight();
    }

    public int getDeleteBaseProductButtonHeight() {
        return deleteBaseProductButton.getHeight();
    }

    public int getDeleteCompositeButtonHeight() {
        return deleteCompositeButton.getHeight();
    }



}


