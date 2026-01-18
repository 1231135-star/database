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

public class MedicinesSalesList {

	private Label title = new Label("Frequently Sold & Best-Selling Medicines");

	private TableView<MedicineSalesRow> table = new TableView<>();
	private ObservableList<MedicineSalesRow> data = FXCollections.observableArrayList();

	private TableColumn<MedicineSalesRow, String> colId = new TableColumn<>("Medicine ID");
	private TableColumn<MedicineSalesRow, String> colName = new TableColumn<>("Medicine Name");
	private TableColumn<MedicineSalesRow, String> colTimes = new TableColumn<>("Times Sold");
	private TableColumn<MedicineSalesRow, String> colQty = new TableColumn<>("Total Quantity");

	private Button back = new Button("Back");

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public MedicinesSalesList() {

		title.setStyle("-fx-text-fill: #0c343d;" + "-fx-font-weight: bold;" + "-fx-font-size:30px;");

		colId.setCellValueFactory(d -> d.getValue().medicineIdProperty());
		colName.setCellValueFactory(d -> d.getValue().medicineNameProperty());
		colTimes.setCellValueFactory(d -> d.getValue().timesSoldProperty());
		colQty.setCellValueFactory(d -> d.getValue().totalQuantityProperty());

		colId.setPrefWidth(150);
		colName.setPrefWidth(220);
		colTimes.setPrefWidth(150);
		colQty.setPrefWidth(150);

		table.getColumns().addAll(colId, colName, colTimes, colQty);
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

	public void addMedicine(String id, String name, String timesSold, String totalQuantity) {
		data.add(new MedicineSalesRow(id, name, timesSold, totalQuantity));
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

	public TableView<MedicineSalesRow> getTable() {
		return table;
	}
}
