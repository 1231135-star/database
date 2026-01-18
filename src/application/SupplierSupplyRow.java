package application;

import javafx.beans.property.SimpleStringProperty;

public class SupplierSupplyRow {

	private SimpleStringProperty supplierName;
	private SimpleStringProperty medicineCount;
	private SimpleStringProperty supplyDate;

	public SupplierSupplyRow(String supplierName, String medicineCount, String supplyDate) {
		this.supplierName = new SimpleStringProperty(supplierName);
		this.medicineCount = new SimpleStringProperty(medicineCount);
		this.supplyDate = new SimpleStringProperty(supplyDate);
	}

	public SimpleStringProperty supplierNameProperty() {
		return supplierName;
	}

	public SimpleStringProperty medicineCountProperty() {
		return medicineCount;
	}

	public SimpleStringProperty supplyDateProperty() {
		return supplyDate;
	}
}
