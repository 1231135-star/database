package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class InsuranceCompanyTableView {

    private Label title = new Label("Insurance Companies");
    private TableView<InsuranceCompany> table = new TableView<>();

    private TableColumn<InsuranceCompany,Integer> colID =new TableColumn<>("ID");
    private TableColumn<InsuranceCompany, String> colName =new TableColumn<>("Company Name");
    private TableColumn<InsuranceCompany, String> colPhone =new TableColumn<>("Phone");
    private TableColumn<InsuranceCompany, String> colEmail =new TableColumn<>("Email");
    private TableColumn<InsuranceCompany, String> colAddress =new TableColumn<>("Address");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();

    public InsuranceCompanyTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("insuranceCompanyID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        table.getColumns().addAll(colID, colName, colPhone, colEmail, colAddress);

        title.setStyle("-fx-text-fill:#0c343d;-fx-font-size:40px;-fx-font-weight:bold;");
        back.setStyle("-fx-background-color:#76a5af;-fx-text-fill:#0c343d;-fx-font-size:20px;-fx-font-weight:bold;-fx-background-radius:25;");
        all.getChildren().addAll(title, table, back);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color:#a2c4c9;");
    }

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TableView<InsuranceCompany> getTable() {
		return table;
	}

	public void setTable(TableView<InsuranceCompany> table) {
		this.table = table;
	}

	public TableColumn<InsuranceCompany, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<InsuranceCompany, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<InsuranceCompany, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<InsuranceCompany, String> colName) {
		this.colName = colName;
	}

	public TableColumn<InsuranceCompany, String> getColPhone() {
		return colPhone;
	}

	public void setColPhone(TableColumn<InsuranceCompany, String> colPhone) {
		this.colPhone = colPhone;
	}

	public TableColumn<InsuranceCompany, String> getColEmail() {
		return colEmail;
	}

	public void setColEmail(TableColumn<InsuranceCompany, String> colEmail) {
		this.colEmail = colEmail;
	}

	public TableColumn<InsuranceCompany, String> getColAddress() {
		return colAddress;
	}

	public void setColAddress(TableColumn<InsuranceCompany, String> colAddress) {
		this.colAddress = colAddress;
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

}
