package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EmployeeQ8TableView {

	private Label mt = new Label("Q8 - Top Selling Employees");

	private Label topL = new Label("Top:");
	private TextField topT = new TextField();

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);

	private Image clearM = new Image("icons8-refresh-100.png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clearB = new Button("Clear", clearVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private HBox filtersH = new HBox();
	private HBox buttons = new HBox();

	private TableView<Q8EmployeeRow> table = new TableView<>();
	private TableColumn<Q8EmployeeRow, Integer> colID = new TableColumn<>("EmpID");
	private TableColumn<Q8EmployeeRow, String> colName = new TableColumn<>("FullName");
	private TableColumn<Q8EmployeeRow, Double> colSales = new TableColumn<>("Total Sales");

	private VBox all = new VBox();

	public EmployeeQ8TableView() {

		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
		mt.setFont(Font.font(null, FontWeight.BOLD, 40));

		topL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		topL.setFont(Font.font(null, FontWeight.BOLD, 20));

		topT.setPromptText("example: 5");
		topT.setPrefWidth(140);

		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);

		clearVM.setFitWidth(42);
		clearVM.setFitHeight(42);

		backVM.setFitWidth(42);
		backVM.setFitHeight(42);

		String style = "-fx-background-color: #76a5af; -fx-text-fill: #0c343d;"
				+ "-fx-font-weight: bold;-fx-font-size:20px;"
				+ "-fx-background-radius: 25;-fx-border-radius: 25;";

		searchB.setStyle(style);
		clearB.setStyle(style);
		back.setStyle(style);

		filtersH.getChildren().addAll(topL, topT, searchB, clearB);
		filtersH.setSpacing(10);
		filtersH.setAlignment(Pos.CENTER);

		colID.setCellValueFactory(new PropertyValueFactory<>("empID"));
		colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		colSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));

		table.getColumns().addAll(colID, colName, colSales);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefHeight(420);

		buttons.getChildren().addAll(back);
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

		String topText = topT.getText().trim();

		int topN = 5; // default
		if (!topText.isEmpty()) {
			try {
				topN = Integer.parseInt(topText);
				if (topN <= 0) topN = 5;
			} catch (Exception ex) {
				Alert a = new Alert(Alert.AlertType.ERROR);
				a.setTitle("invalid number");
				a.setHeaderText("invalid number");
				a.showAndWait();
				return;
			}
		}

		String sql = """
		        select e.empid, e.fullname, sum(i.totalamount) as totalsales
		        from invoice i
		        join employee e on i.empid = e.empid
		        group by e.empid, e.fullname
		        order by totalsales desc
		        """;


		ObservableList<Q8EmployeeRow> list = FXCollections.observableArrayList();

		try (Connection con = DatabaseConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, topN);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Q8EmployeeRow(
						rs.getInt("EmpID"),
						rs.getString("FullName"),
						rs.getDouble("TotalSales")
				));
			}

			table.setItems(list);

			if (list.isEmpty()) {
				Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setTitle("No results");
				a.setHeaderText("No results");
				a.showAndWait();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setTitle("Error");
			a.setHeaderText(ex.getMessage());
			a.showAndWait();
		}
	}

	private void clear() {
		topT.clear();
		table.setItems(FXCollections.observableArrayList());
	}

	public VBox getAll() {
		return all;
	}

	public Button getBack() {
		return back;
	}

	public TableView<Q8EmployeeRow> getTable() {
		return table;
	}
}
