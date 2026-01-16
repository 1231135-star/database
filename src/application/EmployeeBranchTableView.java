package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EmployeeBranchTableView {
    private Label bt = new Label("Employees");
    private TableView<EmployeeBranch> table = new TableView<>();


	private Image searchM=new Image("icons8-search-100.png");
	private ImageView searchVM=new ImageView(searchM);
	private Button searchB=new Button("Search",searchVM);
	private Label searchL=new Label("put id :");
	private TextField searchT=new TextField();

	private HBox searchH=new HBox();
	
    private TableColumn<EmployeeBranch, String> colName = new TableColumn<>("FullName");
    private TableColumn<EmployeeBranch, String> colQual = new TableColumn<>("Qualification");
    private TableColumn<EmployeeBranch, Double> colSalary = new TableColumn<>("Salary");
    private TableColumn<EmployeeBranch, String> colBranch = new TableColumn<>("Branch");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);
 	
    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
   
   	
	private HBox buttons=new HBox();
    private VBox all = new VBox();

    public EmployeeBranchTableView() {
    	//private String fName,qual,bName;private double salary;
    	searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

		searchL.setFont(Font.font(null,FontWeight.BOLD,20));
		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);
		
		searchH.getChildren().addAll(searchL,searchT,searchB);
		searchH.setSpacing(10);
		searchH.setAlignment(Pos.CENTER);
		
        colName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        colQual.setCellValueFactory(new PropertyValueFactory<>("qual"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("bName"));

        table.getColumns().addAll(colName, colQual, colSalary, colBranch);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        bt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
     
        buttons.getChildren().addAll(back,ref);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        
        all.getChildren().addAll(bt,searchH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
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

	public Label getBt() {
		return bt;
	}

	public void setBt(Label bt) {
		this.bt = bt;
	}

	public TableView<EmployeeBranch> getTable() {
		return table;
	}

	public void setTable(TableView<EmployeeBranch> table) {
		this.table = table;
	}

	public TableColumn<EmployeeBranch, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<EmployeeBranch, String> colName) {
		this.colName = colName;
	}

	public TableColumn<EmployeeBranch, String> getColQual() {
		return colQual;
	}

	public void setColQual(TableColumn<EmployeeBranch, String> colQual) {
		this.colQual = colQual;
	}

	public TableColumn<EmployeeBranch, Double> getColSalary() {
		return colSalary;
	}

	public void setColSalary(TableColumn<EmployeeBranch, Double> colSalary) {
		this.colSalary = colSalary;
	}

	public TableColumn<EmployeeBranch, String> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<EmployeeBranch, String> colBranch) {
		this.colBranch = colBranch;
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
