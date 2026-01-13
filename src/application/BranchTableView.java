package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
public class BranchTableView {
	private Label bt=new Label("Branchs");
	private TableView<Branch> table = new TableView<>();
	private TableColumn<Branch, Integer> colID = new TableColumn<>("BranchID");
	private TableColumn<Branch, String> colName = new TableColumn<>("BranchName");
	private TableColumn<Branch, String> colAddress = new TableColumn<>("Address");
	private TableColumn<Branch, String> colPhone = new TableColumn<>("Phone");
	private TableColumn<Branch, String> colEmail = new TableColumn<>("Email");
	private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	private VBox all=new VBox();
    public BranchTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.getColumns().addAll(colID, colName, colAddress, colPhone, colEmail);
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		bt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(bt,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
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

	public Label getBt() {
		return bt;
	}

	public void setBt(Label bt) {
		this.bt = bt;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

	public void setTable(TableView<Branch> table) {
		this.table = table;
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

	public TableView<Branch> getTable() {
		return table;
	}

}
