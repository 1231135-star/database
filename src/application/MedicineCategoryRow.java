package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineCategoryRow {

    private SimpleStringProperty category;
    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;

    public MedicineCategoryRow(
            String category,
            String medicineId,
            String medicineName
    ) {
        this.category = new SimpleStringProperty(category);
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
    }

    public SimpleStringProperty categoryProperty() { return category; }
    public SimpleStringProperty medicineIdProperty() { return medicineId; }
    public SimpleStringProperty medicineNameProperty() { return medicineName; }
}
