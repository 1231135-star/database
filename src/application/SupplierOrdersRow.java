package application;

import javafx.beans.property.SimpleStringProperty;

public class SupplierOrdersRow {

    private SimpleStringProperty supplierName;
    private SimpleStringProperty totalQuantity;
    private SimpleStringProperty totalAmount;

    public SupplierOrdersRow(
            String supplierName,
            String totalQuantity,
            String totalAmount
    ) {
        this.supplierName = new SimpleStringProperty(supplierName);
        this.totalQuantity = new SimpleStringProperty(totalQuantity);
        this.totalAmount = new SimpleStringProperty(totalAmount);
    }

    public SimpleStringProperty supplierNameProperty() {
        return supplierName;
    }

    public SimpleStringProperty totalQuantityProperty() {
        return totalQuantity;
    }

    public SimpleStringProperty totalAmountProperty() {
        return totalAmount;
    }
}
