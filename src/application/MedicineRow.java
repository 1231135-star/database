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

	public SimpleStringProperty getId() {
		return id;
	}

	public SimpleStringProperty getName() {
		return name;
	}

	public SimpleStringProperty getCategory() {
		return category;
	}

	public SimpleDoubleProperty getPrice() {
		return price;
	}

    
}
