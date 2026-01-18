package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineRo2 {

    private final SimpleStringProperty medicineId;
    private final SimpleStringProperty medicineName;

    public MedicineRo2(String medicineId, String medicineName) {
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
    }

    public String getMedicineId() {
        return medicineId.get();
    }

    public String getMedicineName() {
        return medicineName.get();
    }

    public SimpleStringProperty medicineIdProperty() {
        return medicineId;
    }

    public SimpleStringProperty medicineNameProperty() {
        return medicineName;
    }
}
