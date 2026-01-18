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

    public MedicineLossRow(String branch,String medicineId,String medicineName,String status,String quantity,String unitPrice,String lossAmount) {
        this.branch = new SimpleStringProperty(branch);
        this.medicineId = new SimpleStringProperty(medicineId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.status = new SimpleStringProperty(status);
        this.quantity = new SimpleStringProperty(quantity);
        this.unitPrice = new SimpleStringProperty(unitPrice);
        this.lossAmount = new SimpleStringProperty(lossAmount);
    }

	public SimpleStringProperty getBranch() {
		return branch;
	}

	public void setBranch(SimpleStringProperty branch) {
		this.branch = branch;
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

	public SimpleStringProperty getStatus() {
		return status;
	}

	public void setStatus(SimpleStringProperty status) {
		this.status = status;
	}

	public SimpleStringProperty getQuantity() {
		return quantity;
	}

	public void setQuantity(SimpleStringProperty quantity) {
		this.quantity = quantity;
	}

	public SimpleStringProperty getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(SimpleStringProperty unitPrice) {
		this.unitPrice = unitPrice;
	}

	public SimpleStringProperty getLossAmount() {
		return lossAmount;
	}

	public void setLossAmount(SimpleStringProperty lossAmount) {
		this.lossAmount = lossAmount;
	}

 
}
