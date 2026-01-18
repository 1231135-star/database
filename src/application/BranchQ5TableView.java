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

public class BranchQ5TableView {

	private Label mt = new Label("Q5 - Branches With Address & Phone");

	private TableView<BranchQ5Row> table = new TableView<>();
	private TableColumn<BranchQ5Row, Integer> colID = new TableColumn<>("BranchID");
	private TableColumn<BranchQ5Row, String> colName = new TableColumn<>("BranchName");
	private TableColumn<BranchQ5Row, String> colAddress = new TableColumn<>("Address");
	private TableColumn<BranchQ5Row, String> colPhone = new TableColumn<>("PhoneNumber");

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private Image refM = new Image("icons8-refresh-100.png");
	private ImageView refVM = new ImageView(refM);
	private Button ref = new Button("Refresh", refVM);

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public BranchQ5TableView() {

		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
		mt.setFont(Font.font(null, FontWeight.BOLD, 40));

		colID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
		colName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
		colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
		colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

		table.getColumns().addAll(colID, colName, colAddress, colPhone);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefHeight(420);

		backVM.setFitWidth(42);
		backVM.setFitHeight(42);
		refVM.setFitWidth(42);
		refVM.setFitHeight(42);

		String style = "-fx-background-color: #76a5af; -fx-text-fill: #0c343d;"
				+ "-fx-font-weight: bold;-fx-font-size:20px;"
				+ "-fx-background-radius: 25;-fx-border-radius: 25;";

		back.setStyle(style);
		ref.setStyle(style);

		buttons.getChildren().addAll(back, ref);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(mt, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");

		// load data first time
		table.setItems(loadData());

		ref.setOnAction(e -> table.setItems(loadData()));
	}

	private ObservableList<BranchQ5Row> loadData() {
		ObservableList<BranchQ5Row> list = FXCollections.observableArrayList();

		String sql = """
		        select branchid, branchname, address, phonenumber
		        from branch
		        """;


		try (Connection con = DatabaseConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(new BranchQ5Row(
						rs.getInt("BranchID"),
						rs.getString("BranchName"),
						rs.getString("Address"),
						rs.getString("PhoneNumber")
				));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public VBox getAll() {
		return all;
	}

	public Button getBack() {
		return back;
	}

	public Button getRef() {
		return ref;
	}

	public TableView<BranchQ5Row> getTable() {
		return table;
	}
}
