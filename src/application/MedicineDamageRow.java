package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineDamageRow {

    private SimpleStringProperty branch;
    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty status;
    private SimpleStringProperty quantity;

    public MedicineDamageRow(
            String branch,
            String medicineId,
            String medicineName,
            String status,
            String quantity
    ) {
        this.branch = new SimpleStringProperty(branch);
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.status = new SimpleStringProperty(status);
        this.quantity = new SimpleStringProperty(quantity);
    }

    public SimpleStringProperty branchProperty() { return branch; }
    public SimpleStringProperty medicineIdProperty() { return medicineId; }
    public SimpleStringProperty medicineNameProperty() { return medicineName; }
    public SimpleStringProperty statusProperty() { return status; }
    public SimpleStringProperty quantityProperty() { return quantity; }
}
