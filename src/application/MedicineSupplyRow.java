package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineSupplyRow {

    private SimpleStringProperty supplier;
    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty supplyDate;

    public MedicineSupplyRow(
            String supplier,
            String medicineId,
            String medicineName,
            String supplyDate
    ) {
        this.supplier = new SimpleStringProperty(supplier);
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.supplyDate = new SimpleStringProperty(supplyDate);
    }

    public SimpleStringProperty supplierProperty() { return supplier; }
    public SimpleStringProperty medicineIdProperty() { return medicineId; }
    public SimpleStringProperty medicineNameProperty() { return medicineName; }
    public SimpleStringProperty supplyDateProperty() { return supplyDate; }
}
