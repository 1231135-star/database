package application;

import javafx.beans.property.SimpleStringProperty;

public class SupplierSummaryRow {

    private SimpleStringProperty supplier;
    private SimpleStringProperty medicineCount;
    private SimpleStringProperty totalCost;

    public SupplierSummaryRow(
            String supplier,
            String medicineCount,
            String totalCost
    ) {
        this.supplier = new SimpleStringProperty(supplier);
        this.medicineCount = new SimpleStringProperty(medicineCount);
        this.totalCost = new SimpleStringProperty(totalCost);
    }

    public SimpleStringProperty supplierProperty() { return supplier; }
    public SimpleStringProperty medicineCountProperty() { return medicineCount; }
    public SimpleStringProperty totalCostProperty() { return totalCost; }
}
