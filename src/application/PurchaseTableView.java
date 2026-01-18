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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PurchaseTableView {

	private Label mt = new Label("Purchases Table");

	private Label searchL = new Label("Purchase ID :");
	private TextField searchT = new TextField();

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);

	private Image refreshM = new Image("icons8-refresh-100.png");
	private ImageView refreshVM = new ImageView(refreshM);
	private Button refreshB = new Button("Refresh", refreshVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private Image deleteM = new Image("icons8-delete-100(1).png");
	private ImageView deleteVM = new ImageView(deleteM);
	private Button deleteB = new Button("Delete", deleteVM);

	private Image updateM = new Image("icons8-edit-property-100.png");
	private ImageView updateVM = new ImageView(updateM);
	private Button updateB = new Button("Update", updateVM);

	private HBox searchH = new HBox();
	private HBox buttons = new HBox();

	private TableView<Purchase> table = new TableView<>();
	TableColumn<Purchase, Integer> idCol = new TableColumn<>("Purchase ID");
	TableColumn<Purchase, String> dateCol = new TableColumn<>("Purchase Date");
	TableColumn<Purchase, Double> costCol = new TableColumn<>("Total Cost");
	TableColumn<Purchase, String> payCol = new TableColumn<>("Payment Status");
	TableColumn<Purchase, Integer> supCol = new TableColumn<>("Supplier ID");
	TableColumn<Purchase, Integer> branchCol = new TableColumn<>("Branch ID");
	private ObservableList<Purchase> list = FXCollections.observableArrayList();

	private VBox all = new VBox();

	public PurchaseTableView() {
		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

		searchVM.setFitWidth(35);
		searchVM.setFitHeight(35);
		refreshVM.setFitWidth(35);
		refreshVM.setFitHeight(35);
		backVM.setFitWidth(35);
		backVM.setFitHeight(35);

		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:18px;-fx-background-radius: 25;-fx-border-radius: 25;");
		refreshB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:18px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:18px;-fx-background-radius: 25;-fx-border-radius: 25;");
		deleteVM.setFitWidth(35);
		deleteVM.setFitHeight(35);
		updateVM.setFitWidth(35);
		updateVM.setFitHeight(35);

		deleteB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:18px;-fx-background-radius: 25;-fx-border-radius: 25;");
		updateB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:18px;-fx-background-radius: 25;-fx-border-radius: 25;");
		deleteB.setDisable(true);
		updateB.setDisable(true);

		searchH.getChildren().addAll(searchL, searchT, searchB, refreshB);
		searchH.setAlignment(Pos.CENTER);
		searchH.setSpacing(12);

		buttons.getChildren().addAll(deleteB, updateB, back);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		idCol.setCellValueFactory(new PropertyValueFactory<>("purchaseID"));
		idCol.setMinWidth(110);

		dateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
		dateCol.setMinWidth(160);

		costCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
		costCol.setMinWidth(120);

		payCol.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
		payCol.setMinWidth(150);

		supCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
		supCol.setMinWidth(120);

		branchCol.setCellValueFactory(new PropertyValueFactory<>("branchID"));
		branchCol.setMinWidth(120);

		table.getColumns().addAll(idCol, dateCol, costCol, payCol, supCol, branchCol);
		table.setItems(list);
		table.setStyle("-fx-font-size:16px;");

		all.getChildren().addAll(mt, searchH, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(18);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Image getDeleteM() {
		return deleteM;
	}

	public void setDeleteM(Image deleteM) {
		this.deleteM = deleteM;
	}

	public ImageView getDeleteVM() {
		return deleteVM;
	}

	public void setDeleteVM(ImageView deleteVM) {
		this.deleteVM = deleteVM;
	}

	public Button getDeleteB() {
		return deleteB;
	}

	public void setDeleteB(Button deleteB) {
		this.deleteB = deleteB;
	}

	public Image getUpdateM() {
		return updateM;
	}

	public void setUpdateM(Image updateM) {
		this.updateM = updateM;
	}

	public ImageView getUpdateVM() {
		return updateVM;
	}

	public void setUpdateVM(ImageView updateVM) {
		this.updateVM = updateVM;
	}

	public Button getUpdateB() {
		return updateB;
	}

	public void setUpdateB(Button updateB) {
		this.updateB = updateB;
	}

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
	}

	public Label getSearchL() {
		return searchL;
	}

	public void setSearchL(Label searchL) {
		this.searchL = searchL;
	}

	public TextField getSearchT() {
		return searchT;
	}

	public void setSearchT(TextField searchT) {
		this.searchT = searchT;
	}

	public Image getSearchM() {
		return searchM;
	}

	public void setSearchM(Image searchM) {
		this.searchM = searchM;
	}

	public ImageView getSearchVM() {
		return searchVM;
	}

	public void setSearchVM(ImageView searchVM) {
		this.searchVM = searchVM;
	}

	public Button getSearchB() {
		return searchB;
	}

	public void setSearchB(Button searchB) {
		this.searchB = searchB;
	}

	public Image getRefreshM() {
		return refreshM;
	}

	public void setRefreshM(Image refreshM) {
		this.refreshM = refreshM;
	}

	public ImageView getRefreshVM() {
		return refreshVM;
	}

	public void setRefreshVM(ImageView refreshVM) {
		this.refreshVM = refreshVM;
	}

	public Button getRefreshB() {
		return refreshB;
	}

	public void setRefreshB(Button refreshB) {
		this.refreshB = refreshB;
	}

	public Image getBackM() {
		return backM;
	}

	public void setBackM(Image backM) {
		this.backM = backM;
	}

	public ImageView getBackVM() {
		return backVM;
	}

	public void setBackVM(ImageView backVM) {
		this.backVM = backVM;
	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}

	public HBox getSearchH() {
		return searchH;
	}

	public void setSearchH(HBox searchH) {
		this.searchH = searchH;
	}

	public HBox getButtons() {
		return buttons;
	}

	public void setButtons(HBox buttons) {
		this.buttons = buttons;
	}

	public TableView<Purchase> getTable() {
		return table;
	}

	public void setTable(TableView<Purchase> table) {
		this.table = table;
	}

	public TableColumn<Purchase, Integer> getIdCol() {
		return idCol;
	}

	public void setIdCol(TableColumn<Purchase, Integer> idCol) {
		this.idCol = idCol;
	}

	public TableColumn<Purchase, String> getDateCol() {
		return dateCol;
	}

	public void setDateCol(TableColumn<Purchase, String> dateCol) {
		this.dateCol = dateCol;
	}

	public TableColumn<Purchase, Double> getCostCol() {
		return costCol;
	}

	public void setCostCol(TableColumn<Purchase, Double> costCol) {
		this.costCol = costCol;
	}

	public TableColumn<Purchase, String> getPayCol() {
		return payCol;
	}

	public void setPayCol(TableColumn<Purchase, String> payCol) {
		this.payCol = payCol;
	}

	public TableColumn<Purchase, Integer> getSupCol() {
		return supCol;
	}

	public void setSupCol(TableColumn<Purchase, Integer> supCol) {
		this.supCol = supCol;
	}

	public TableColumn<Purchase, Integer> getBranchCol() {
		return branchCol;
	}

	public void setBranchCol(TableColumn<Purchase, Integer> branchCol) {
		this.branchCol = branchCol;
	}

	public ObservableList<Purchase> getList() {
		return list;
	}

	public void setList(ObservableList<Purchase> list) {
		this.list = list;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}
	
}
