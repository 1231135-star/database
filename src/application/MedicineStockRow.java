package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineStockRow {

	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty category;
	private SimpleStringProperty supplier;
	private SimpleStringProperty quantity;

	public MedicineStockRow(String id, String name, String category, String supplier, String quantity) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.category = new SimpleStringProperty(category);
		this.supplier = new SimpleStringProperty(supplier);
		this.quantity = new SimpleStringProperty(quantity);
	}

	public SimpleStringProperty idProperty() {
		return id;
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public SimpleStringProperty categoryProperty() {
		return category;
	}

	public SimpleStringProperty supplierProperty() {
		return supplier;
	}

	public SimpleStringProperty quantityProperty() {
		return quantity;
	}
}
