package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MedicinesLowStockTableView {

	private Label mt = new Label("Out of Stock / Low Stock Medicines");

	private Label qtyL = new Label("Quantity ≤");
	private TextField qtyT = new TextField("5");

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);

	private Image clearM = new Image("icons8-refresh-100.png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clearB = new Button("Clear", clearVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private TableView<MedicineStockRow> table = new TableView<>();
	private ObservableList<MedicineStockRow> data = FXCollections.observableArrayList();

	private TableColumn<MedicineStockRow, String> colId = new TableColumn<>("Medicine ID");
	private TableColumn<MedicineStockRow, String> colName = new TableColumn<>("Medicine Name");
	private TableColumn<MedicineStockRow, String> colCategory = new TableColumn<>("Category");
	private TableColumn<MedicineStockRow, String> colSupplier = new TableColumn<>("Supplier");
	private TableColumn<MedicineStockRow, String> colQuantity = new TableColumn<>("Quantity");

	private HBox filtersH = new HBox();
	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public MedicinesLowStockTableView() {

		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");
		mt.setFont(Font.font(null, FontWeight.BOLD, 35));

		qtyL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		qtyT.setPrefWidth(100);

		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);
		clearVM.setFitWidth(42);
		clearVM.setFitHeight(42);
		backVM.setFitWidth(42);
		backVM.setFitHeight(42);

		styleButton(searchB);
		styleButton(clearB);
		styleButton(back);

		filtersH.getChildren().addAll(qtyL, qtyT);
		filtersH.setSpacing(15);
		filtersH.setAlignment(Pos.CENTER);

		colId.setCellValueFactory(d -> d.getValue().idProperty());
		colName.setCellValueFactory(d -> d.getValue().nameProperty());
		colCategory.setCellValueFactory(d -> d.getValue().categoryProperty());
		colSupplier.setCellValueFactory(d -> d.getValue().supplierProperty());
		colQuantity.setCellValueFactory(d -> d.getValue().quantityProperty());

		table.getColumns().addAll(colId, colName, colCategory, colSupplier, colQuantity);
		table.setItems(data);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefHeight(420);

		buttons.getChildren().addAll(back, searchB, clearB);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(mt, filtersH, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");

		searchB.setOnAction(e -> doSearch());
		clearB.setOnAction(e -> clear());
	}

	private void doSearch() {

		int qty;
		try {
			qty = Integer.parseInt(qtyT.getText().trim());
		} catch (Exception ex) {
			alert("Invalid quantity value");
			return;
		}

		data.clear();
		String sql = """
			    SELECT 
			        m.medicineid,
			        m.medicinename,
			        c.categoryname,
			        s.suppliername,
			        i.quantityavailable
			    FROM inventory_item i
			    JOIN medicine m ON i.medicineid = m.medicineid
			    JOIN category c ON m.categoryid = c.categoryid
			    JOIN supplier s ON i.supplierid = s.supplierid
			    WHERE i.quantityavailable <= ?
			    ORDER BY i.quantityavailable ASC
			""";


		try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, qty);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				data.add(new MedicineStockRow(rs.getString("MedicineID"), rs.getString("MedicineName"),
						rs.getString("CategoryName"), rs.getString("SupplierName"), rs.getString("Quantity")));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			alert(ex.getMessage());
		}
	}

	private void clear() {
		qtyT.setText("5");
		data.clear();
	}

	private void styleButton(Button b) {
		b.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;"
				+ "-fx-font-weight: bold;-fx-font-size:20px;" + "-fx-background-radius: 25;");
	}

	private void alert(String msg) {
		Alert a = new Alert(Alert.AlertType.ERROR);
		a.setTitle("Error");
		a.setHeaderText(msg);
		a.showAndWait();
	}

	public VBox getAll() {
		return all;
	}

	public Button getBack() {
		return back;
	}

	public TableView<MedicineStockRow> getTable() {
		return table;
	}
}
