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

public class CustomerTableView {
	private Label ct=new Label("Customers");
    private  TableView<Customer> table = new TableView<>();
    private TableColumn<Customer, Integer> colID = new TableColumn<>("CustomerID");
    private TableColumn<Customer, String> colName = new TableColumn<>("FullName");
    private TableColumn<Customer, String> colPhone = new TableColumn<>("Phone");
    private TableColumn<Customer, String> colEmail = new TableColumn<>("Email");
    private TableColumn<Customer, String> colAddress = new TableColumn<>("Address");
    private Image backM=new Image("icons8-back-100(2).png");
  	private ImageView backVM=new ImageView(backM);
  	private Button back=new Button("Back", backVM);
  	private VBox all=new VBox();
    public CustomerTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.getColumns().addAll(colID, colName, colPhone, colEmail, colAddress);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		ct.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(ct,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getCt() {
		return ct;
	}

	public void setCt(Label ct) {
		this.ct = ct;
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

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

	public void setTable(TableView<Customer> table) {
		this.table = table;
	}

	public TableColumn<Customer, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Customer, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Customer, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Customer, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Customer, String> getColPhone() {
		return colPhone;
	}

	public void setColPhone(TableColumn<Customer, String> colPhone) {
		this.colPhone = colPhone;
	}

	public TableColumn<Customer, String> getColEmail() {
		return colEmail;
	}

	public void setColEmail(TableColumn<Customer, String> colEmail) {
		this.colEmail = colEmail;
	}

	public TableColumn<Customer, String> getColAddress() {
		return colAddress;
	}

	public void setColAddress(TableColumn<Customer, String> colAddress) {
		this.colAddress = colAddress;
	}

	public TableView<Customer> getTable() {
		return table;
	}

}
