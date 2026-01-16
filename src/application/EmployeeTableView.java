package application;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class EmployeeTableView {
	private Label mt=new Label("Employees");

	private Image searchM=new Image("icons8-search-100.png");
	private ImageView searchVM=new ImageView(searchM);
	private Button searchB=new Button("Search",searchVM);
	private Label searchL=new Label("put id :");
	private TextField searchT=new TextField();

	private HBox searchH=new HBox();
	
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
    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
   	
   	private Image delM=new Image("icons8-remove-employee-100.png");
   	private ImageView delVM=new ImageView(delM);
   	private Button deleteB=new Button("Delete ",delVM);

   	private Image upM=new Image("icons8-edit-property-100.png");   
   	private ImageView upVM=new ImageView(upM);
   	private Button updateB=new Button("Update",upVM);

   	
	private HBox buttons=new HBox();

   	private VBox all=new VBox();
   	
    public EmployeeTableView() {
    	searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

		searchL.setFont(Font.font(null,FontWeight.BOLD,20));
		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);
		
		searchH.getChildren().addAll(searchL,searchT,searchB);
		searchH.setSpacing(10);
		searchH.setAlignment(Pos.CENTER);
		
        colID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colQualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colBranchID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        table.getColumns().addAll(colID, colName, colQualification, colPhone, colSalary, colBranchID);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        deleteB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        updateB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        delVM.setFitWidth(42);
        delVM.setFitHeight(42);
        upVM.setFitWidth(42);
        upVM.setFitHeight(42);

        deleteB.setDisable(true);
        updateB.setDisable(true);

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
      
        buttons.getChildren().addAll(back,ref,updateB,deleteB);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		
		all.getChildren().addAll(mt,searchH,table,buttons);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
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
