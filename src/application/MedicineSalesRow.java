package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineSalesRow {

    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty timesSold;
    private SimpleStringProperty totalQuantity;

    public MedicineSalesRow(
            String medicineId,
            String medicineName,
            String timesSold,
            String totalQuantity
    ) {
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.timesSold = new SimpleStringProperty(timesSold);
        this.totalQuantity = new SimpleStringProperty(totalQuantity);
    }

    public SimpleStringProperty medicineIdProperty() { return medicineId; }
    public SimpleStringProperty medicineNameProperty() { return medicineName; }
    public SimpleStringProperty timesSoldProperty() { return timesSold; }
    public SimpleStringProperty totalQuantityProperty() { return totalQuantity; }
}
