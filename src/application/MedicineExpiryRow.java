package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineExpiryRow {

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty category;
    private SimpleStringProperty supplier;
    private SimpleStringProperty expiry;

    public MedicineExpiryRow(String id,String name,String category,String supplier,String expiry) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.supplier = new SimpleStringProperty(supplier);
        this.expiry = new SimpleStringProperty(expiry);
    }

	public SimpleStringProperty getId() {
		return id;
	}

	public void setId(SimpleStringProperty id) {
		this.id = id;
	}

	public SimpleStringProperty getName() {
		return name;
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}

	public SimpleStringProperty getCategory() {
		return category;
	}

	public void setCategory(SimpleStringProperty category) {
		this.category = category;
	}

	public SimpleStringProperty getSupplier() {
		return supplier;
	}

	public void setSupplier(SimpleStringProperty supplier) {
		this.supplier = supplier;
	}

	public SimpleStringProperty getExpiry() {
		return expiry;
	}

	public void setExpiry(SimpleStringProperty expiry) {
		this.expiry = expiry;
	}

   
}
