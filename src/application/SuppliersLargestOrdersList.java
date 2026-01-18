package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SuppliersLargestOrdersList {

	private Label title = new Label("Suppliers with Largest Orders (Last Month)");

	private TableView<SupplierOrdersRow> table = new TableView<>();
	private ObservableList<SupplierOrdersRow> data = FXCollections.observableArrayList();

	private TableColumn<SupplierOrdersRow, String> colSupplier = new TableColumn<>("Supplier Name");
	private TableColumn<SupplierOrdersRow, String> colQty = new TableColumn<>("Total Quantity");
	private TableColumn<SupplierOrdersRow, String> colAmount = new TableColumn<>("Total Order Amount");

	private Button back = new Button("Back");
	private Button ref = new Button("Refresh");

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public SuppliersLargestOrdersList() {

		title.setStyle("-fx-text-fill: #0c343d;" + "-fx-font-weight: bold;" + "-fx-font-size:30px;");

		colSupplier.setCellValueFactory(d -> d.getValue().supplierNameProperty());
		colQty.setCellValueFactory(d -> d.getValue().totalQuantityProperty());
		colAmount.setCellValueFactory(d -> d.getValue().totalAmountProperty());

		colSupplier.setPrefWidth(300);
		colQty.setPrefWidth(200);
		colAmount.setPrefWidth(200);

		table.getColumns().addAll(colSupplier, colQty, colAmount);

		table.setItems(data);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setFixedCellSize(40);
		table.setPrefHeight(300);

		table.setStyle("-fx-background-color: #a2c4c9;" + "-fx-control-inner-background: rgba(255,255,255,0.55);"
				+ "-fx-font-size: 16px;");

		back.setStyle(buttonStyle());
		ref.setStyle(buttonStyle());

		buttons.getChildren().addAll(back, ref);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(title, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9; -fx-padding: 20;");

		ref.setOnAction(e -> loadData());

		loadData();
	}

	private void loadData() {

		data.clear();

		String sql = """
				    SELECT
				        s.suppliername,
				        SUM(i.quantity) AS total_quantity,
				        SUM(i.quantity * i.unitprice) AS total_amount
				    FROM supplier s
				    JOIN inventory i ON s.supplierid = i.supplierid
				    WHERE i.supplydate >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
				    GROUP BY s.supplierid, s.suppliername
				    ORDER BY total_amount DESC
				""";

		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				data.add(new SupplierOrdersRow(rs.getString("suppliername"), rs.getString("total_quantity"),
						rs.getString("total_amount")));
			}

			table.setItems(data);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clear() {
		table.getItems().clear();
	}

	private String buttonStyle() {
		return "-fx-background-color: #76a5af;" + "-fx-text-fill: #0c343d;" + "-fx-font-weight: bold;"
				+ "-fx-font-size:20px;" + "-fx-background-radius: 25;" + "-fx-border-radius: 25;";
	}

	public VBox getAll() {
		return all;
	}

	public Button getBack() {
		return back;
	}

	public TableView<SupplierOrdersRow> getTable() {
		return table;
	}
}
