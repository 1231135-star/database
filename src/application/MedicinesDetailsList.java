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

public class MedicinesDetailsList {

	private Label title = new Label("Stored Medicines Details");

	private TableView<MedicineDetailsRow> table = new TableView<>();
	private ObservableList<MedicineDetailsRow> data = FXCollections.observableArrayList();

	private TableColumn<MedicineDetailsRow, String> colId = new TableColumn<>("Medicine ID");
	private TableColumn<MedicineDetailsRow, String> colName = new TableColumn<>("Medicine Name");
	private TableColumn<MedicineDetailsRow, String> colCategory = new TableColumn<>("Category");
	private TableColumn<MedicineDetailsRow, String> colSupplier = new TableColumn<>("Supplier");
	private TableColumn<MedicineDetailsRow, String> colExpiry = new TableColumn<>("Expiry Date");

	private Button back = new Button("Back");

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public MedicinesDetailsList() {

		title.setStyle("-fx-text-fill: #0c343d;" + "-fx-font-weight: bold;" + "-fx-font-size:30px;");

		colId.setCellValueFactory(d -> d.getValue().idProperty());
		colName.setCellValueFactory(d -> d.getValue().nameProperty());
		colCategory.setCellValueFactory(d -> d.getValue().categoryProperty());
		colSupplier.setCellValueFactory(d -> d.getValue().supplierProperty());
		colExpiry.setCellValueFactory(d -> d.getValue().expiryProperty());

		colId.setPrefWidth(120);
		colName.setPrefWidth(180);
		colCategory.setPrefWidth(160);
		colSupplier.setPrefWidth(160);
		colExpiry.setPrefWidth(140);

		table.getColumns().addAll(colId, colName, colCategory, colSupplier, colExpiry);
		table.setItems(data);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setFixedCellSize(40);
		table.setPrefHeight(300);

		table.setStyle("-fx-background-color: #a2c4c9;" + "-fx-control-inner-background: rgba(255,255,255,0.55);"
				+ "-fx-font-size: 16px;");

		back.setStyle("-fx-background-color: #76a5af;" + "-fx-text-fill: #0c343d;" + "-fx-font-weight: bold;"
				+ "-fx-font-size:20px;" + "-fx-background-radius: 25;" + "-fx-border-radius: 25;");

		buttons.getChildren().add(back);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(title, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9; -fx-padding: 20;");
	}

	public void addMedicine(String id, String name, String category, String supplier, String expiry) {
		data.add(new MedicineDetailsRow(id, name, category, supplier, expiry));
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

	public TableView<MedicineDetailsRow> getTable() {
		return table;
	}
}
