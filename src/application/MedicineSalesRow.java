package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineSalesRow {

    private SimpleStringProperty medicineId;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty timesSold;
    private SimpleStringProperty totalQuantity;

    public MedicineSalesRow(String medicineId,String medicineName,String timesSold,String totalQuantity) {
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.timesSold = new SimpleStringProperty(timesSold);
        this.totalQuantity = new SimpleStringProperty(totalQuantity);
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

	public SimpleStringProperty getTimesSold() {
		return timesSold;
	}

	public void setTimesSold(SimpleStringProperty timesSold) {
		this.timesSold = timesSold;
	}

	public SimpleStringProperty getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(SimpleStringProperty totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

    
}
