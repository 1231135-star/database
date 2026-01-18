package application;

import javafx.beans.property.SimpleStringProperty;

public class SupplierMedicinePeriodRow {

    private SimpleStringProperty supplierName;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty supplyDate;

    public SupplierMedicinePeriodRow(
            String supplierName,
            String medicineName,
            String supplyDate
    ) {
        this.supplierName = new SimpleStringProperty(supplierName);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.supplyDate = new SimpleStringProperty(supplyDate);
    }

    public SimpleStringProperty supplierNameProperty() {
        return supplierName;
    }

    public SimpleStringProperty medicineNameProperty() {
        return medicineName;
    }

    public SimpleStringProperty supplyDateProperty() {
        return supplyDate;
    }
}
