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
public class EmployeeTableView {
	private Label mt=new Label("Employees");
    private TableView<Employee> table = new TableView<>();
    private TableColumn<Employee, Integer> colID = new TableColumn<>("EmpID");
    private TableColumn<Employee, String> colName = new TableColumn<>("FullName");
    private TableColumn<Employee, String> colQualification = new TableColumn<>("Qualification");
    private TableColumn<Employee, String> colPhone = new TableColumn<>("Phone");
    private TableColumn<Employee, Double> colSalary = new TableColumn<>("Salary");
    private TableColumn<Employee, Integer> colBranchID = new TableColumn<>("BranchID");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();
   	
    public EmployeeTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colQualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colBranchID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        table.getColumns().addAll(colID, colName, colQualification, colPhone, colSalary, colBranchID);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(mt,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
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

	public void setTable(TableView<Employee> table) {
		this.table = table;
	}

	public TableColumn<Employee, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Employee, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Employee, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Employee, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Employee, String> getColQualification() {
		return colQualification;
	}

	public void setColQualification(TableColumn<Employee, String> colQualification) {
		this.colQualification = colQualification;
	}

	public TableColumn<Employee, String> getColPhone() {
		return colPhone;
	}

	public void setColPhone(TableColumn<Employee, String> colPhone) {
		this.colPhone = colPhone;
	}

	public TableColumn<Employee, Double> getColSalary() {
		return colSalary;
	}

	public void setColSalary(TableColumn<Employee, Double> colSalary) {
		this.colSalary = colSalary;
	}

	public TableColumn<Employee, Integer> getColBranchID() {
		return colBranchID;
	}

	public void setColBranchID(TableColumn<Employee, Integer> colBranchID) {
		this.colBranchID = colBranchID;
	}

	public TableView<Employee> getTable() {
		return table;
	}

}
