package application;

import javafx.beans.property.SimpleStringProperty;

public class MedicineDetailsRow {

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty category;
    private SimpleStringProperty supplier;
    private SimpleStringProperty expiry;

    public MedicineDetailsRow(String id, String name, String category,
                              String supplier, String expiry) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.supplier = new SimpleStringProperty(supplier);
        this.expiry = new SimpleStringProperty(expiry);
    }

    public SimpleStringProperty idProperty() { return id; }
    public SimpleStringProperty nameProperty() { return name; }
    public SimpleStringProperty categoryProperty() { return category; }
    public SimpleStringProperty supplierProperty() { return supplier; }
    public SimpleStringProperty expiryProperty() { return expiry; }
}
