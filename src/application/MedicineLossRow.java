package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineLossRow {

    private SimpleStringProperty branch;
    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty status;
    private SimpleStringProperty quantity;
    private SimpleStringProperty unitPrice;
    private SimpleStringProperty lossAmount;

    public MedicineLossRow(
            String branch,
            String medicineId,
            String medicineName,
            String status,
            String quantity,
            String unitPrice,
            String lossAmount
    ) {
        this.branch = new SimpleStringProperty(branch);
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.status = new SimpleStringProperty(status);
        this.quantity = new SimpleStringProperty(quantity);
        this.unitPrice = new SimpleStringProperty(unitPrice);
        this.lossAmount = new SimpleStringProperty(lossAmount);
    }

    public SimpleStringProperty branchProperty() { return branch; }
    public SimpleStringProperty medicineIdProperty() { return medicineId; }
    public SimpleStringProperty medicineNameProperty() { return medicineName; }
    public SimpleStringProperty statusProperty() { return status; }
    public SimpleStringProperty quantityProperty() { return quantity; }
    public SimpleStringProperty unitPriceProperty() { return unitPrice; }
    public SimpleStringProperty lossAmountProperty() { return lossAmount; }
}
