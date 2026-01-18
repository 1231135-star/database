package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineCategoryRow {

    private SimpleStringProperty category;
    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;

    public MedicineCategoryRow(String category,String medicineId,String medicineName) {
        this.category = new SimpleStringProperty(category);
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
    }

	public SimpleStringProperty getCategory() {
		return category;
	}

	public void setCategory(SimpleStringProperty category) {
		this.category = category;
	}

	public SimpleStringProperty getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(SimpleStringProperty medicineId) {
		this.medicineId = medicineId;
	}

	public SimpleStringProperty getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(SimpleStringProperty medicineName) {
		this.medicineName = medicineName;
	}

}
