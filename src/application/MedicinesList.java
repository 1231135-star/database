package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MedicinesList {

	private Label title = new Label("Stored Medicines");

	private TableView<MedicineRo2> table = new TableView<>();
	private ObservableList<MedicineRo2> data = FXCollections.observableArrayList();

	private TableColumn<MedicineRo2, String> colId = new TableColumn<>("Medicine ID");
	private TableColumn<MedicineRo2, String> colName = new TableColumn<>("Medicine Name");

	private Button back = new Button("Back");

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public MedicinesList() {

		title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold; -fx-font-size:30px;");

		colId.setCellValueFactory(d -> d.getValue().medicineIdProperty());
		colName.setCellValueFactory(d -> d.getValue().medicineNameProperty());

		colId.setPrefWidth(140);
		colName.setPrefWidth(220);

		table.getColumns().addAll(colId, colName);
		table.setItems(data);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setFixedCellSize(40);
		table.setPrefHeight(260);

		table.setStyle("-fx-background-color: #a2c4c9;" + "-fx-control-inner-background: rgba(255,255,255,0.55);"
				+ "-fx-font-size: 16px;");

		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;"
				+ "-fx-font-weight: bold; -fx-font-size:20px; -fx-background-radius: 25; -fx-border-radius: 25;");

		buttons.getChildren().add(back);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(title, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9; -fx-padding: 20;");
	}

	public void addMedicine(String id, String name) {
		data.add(new MedicineRo2(id, name));
	}

	public void clearMedicines() {
		data.clear();
	}

	public VBox getAll() {
		return all;
	}

	public Button getBack() {
		return back;
	}

	public TableView<MedicineRo2> getTable() {
		return table;
	}
}
