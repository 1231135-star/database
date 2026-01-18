package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class MedicineRow {

    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty category;
    private final SimpleDoubleProperty price;

    public MedicineRow(String id, String name, String category, double price) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getId() { return id.get(); }
    public String getName() { return name.get(); }
    public String getCategory() { return category.get(); }
    public double getPrice() { return price.get(); }

    public SimpleStringProperty idProperty() { return id; }
    public SimpleStringProperty nameProperty() { return name; }
    public SimpleStringProperty categoryProperty() { return category; }
    public SimpleDoubleProperty priceProperty() { return price; }
}
