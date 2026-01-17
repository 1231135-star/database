package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BranchTableView {

    private Label bt = new Label("Branches");
    private TableView<Branch> table = new TableView<>();

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    private TableColumn<Branch, Integer> colID = new TableColumn<>("BranchID");
    private TableColumn<Branch, String> colName = new TableColumn<>("BranchName");
    private TableColumn<Branch, String> colAddress = new TableColumn<>("Address");
    private TableColumn<Branch, String> colPhone = new TableColumn<>("PhoneNumber");
    private TableColumn<Branch, String> colEmail = new TableColumn<>("Email");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private Image delM = new Image("icons8-delete-all-100.png");
    private ImageView delVM = new ImageView(delM);
    private Button deleteB = new Button("Delete", delVM);

    private Image upM = new Image("icons8-edit-property-100.png");
    private ImageView upVM = new ImageView(upM);
    private Button updateB = new Button("Update", upVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public BranchTableView() {

        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        colID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(colID, colName, colAddress, colPhone, colEmail);

        // buttons style
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        deleteB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        updateB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        bt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");

        deleteB.setDisable(true);
        updateB.setDisable(true);

        buttons.getChildren().addAll(back, ref, updateB, deleteB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(bt, searchH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getBt() {
		return bt;
	}

	public void setBt(Label bt) {
		this.bt = bt;
	}

	public TableView<Branch> getTable() {
		return table;
	}

	public void setTable(TableView<Branch> table) {
		this.table = table;
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

	public HBox getSearchH() {
		return searchH;
	}

	public void setSearchH(HBox searchH) {
		this.searchH = searchH;
	}

	public TableColumn<Branch, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Branch, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Branch, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Branch, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Branch, String> getColAddress() {
		return colAddress;
	}

	public void setColAddress(TableColumn<Branch, String> colAddress) {
		this.colAddress = colAddress;
	}

	public TableColumn<Branch, String> getColPhone() {
		return colPhone;
	}

	public void setColPhone(TableColumn<Branch, String> colPhone) {
		this.colPhone = colPhone;
	}

	public TableColumn<Branch, String> getColEmail() {
		return colEmail;
	}

	public void setColEmail(TableColumn<Branch, String> colEmail) {
		this.colEmail = colEmail;
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

	public Image getRefM() {
		return refM;
	}

	public void setRefM(Image refM) {
		this.refM = refM;
	}

	public ImageView getRefVM() {
		return refVM;
	}

	public void setRefVM(ImageView refVM) {
		this.refVM = refVM;
	}

	public Button getRef() {
		return ref;
	}

	public void setRef(Button ref) {
		this.ref = ref;
	}

	public Image getDelM() {
		return delM;
	}

	public void setDelM(Image delM) {
		this.delM = delM;
	}

	public ImageView getDelVM() {
		return delVM;
	}

	public void setDelVM(ImageView delVM) {
		this.delVM = delVM;
	}

	public Button getDeleteB() {
		return deleteB;
	}

	public void setDeleteB(Button deleteB) {
		this.deleteB = deleteB;
	}

	public Image getUpM() {
		return upM;
	}

	public void setUpM(Image upM) {
		this.upM = upM;
	}

	public ImageView getUpVM() {
		return upVM;
	}

	public void setUpVM(ImageView upVM) {
		this.upVM = upVM;
	}

	public Button getUpdateB() {
		return updateB;
	}

	public void setUpdateB(Button updateB) {
		this.updateB = updateB;
	}

	public HBox getButtons() {
		return buttons;
	}

	public void setButtons(HBox buttons) {
		this.buttons = buttons;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

  
}
