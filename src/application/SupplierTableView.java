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

public class SupplierTableView {
	private Label st=new Label("Suppliers");
    private TableView<Supplier> table = new TableView<>();
    private TableColumn<Supplier, Integer> colID = new TableColumn<>("SupplierID");
    private TableColumn<Supplier, String> colName = new TableColumn<>("SupplierName");
    private TableColumn<Supplier, String> colPhone = new TableColumn<>("Phone");
    private TableColumn<Supplier, String> colEmail = new TableColumn<>("Email");
    private TableColumn<Supplier, String> colAddress = new TableColumn<>("Address");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();
    public SupplierTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.getColumns().addAll(colID, colName, colPhone, colEmail, colAddress);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		st.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(st,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getSt() {
		return st;
	}

	public void setSt(Label st) {
		this.st = st;
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

	public void setTable(TableView<Supplier> table) {
		this.table = table;
	}

	public TableColumn<Supplier, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Supplier, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Supplier, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Supplier, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Supplier, String> getColPhone() {
		return colPhone;
	}

	public void setColPhone(TableColumn<Supplier, String> colPhone) {
		this.colPhone = colPhone;
	}

	public TableColumn<Supplier, String> getColEmail() {
		return colEmail;
	}

	public void setColEmail(TableColumn<Supplier, String> colEmail) {
		this.colEmail = colEmail;
	}

	public TableColumn<Supplier, String> getColAddress() {
		return colAddress;
	}

	public void setColAddress(TableColumn<Supplier, String> colAddress) {
		this.colAddress = colAddress;
	}

	public TableView<Supplier> getTable() {
		return table;
	}
    
}
