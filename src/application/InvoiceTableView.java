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

import java.time.LocalDate;
import java.time.LocalTime;

public class InvoiceTableView {
	private Label it=new Label("Invoices");
    private TableView<Invoice> table = new TableView<>();
    private TableColumn<Invoice, Integer> colID = new TableColumn<>("InvoiceID");
    private TableColumn<Invoice, LocalDate> colDate = new TableColumn<>("InvoiceDate");
    private TableColumn<Invoice, LocalTime> colTime = new TableColumn<>("InvoiceTime");
    private TableColumn<Invoice, Double> colTotal = new TableColumn<>("TotalAmount");
    private TableColumn<Invoice, Integer> colCustomer = new TableColumn<>("CustomerID");
    private TableColumn<Invoice, Integer> colEmp = new TableColumn<>("EmpID");
    private TableColumn<Invoice, Integer> colBranch = new TableColumn<>("BranchID");
    private Image backM=new Image("icons8-back-100(2).png");
  	private ImageView backVM=new ImageView(backM);
  	private Button back=new Button("Back", backVM);
  	private VBox all=new VBox();
    public InvoiceTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("invoiceTime"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        colCustomer.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        table.getColumns().addAll(colID, colDate, colTime, colTotal, colCustomer, colEmp, colBranch);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		it.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(it,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getIt() {
		return it;
	}

	public void setIt(Label it) {
		this.it = it;
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

	public void setTable(TableView<Invoice> table) {
		this.table = table;
	}

	public TableColumn<Invoice, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Invoice, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Invoice, LocalDate> getColDate() {
		return colDate;
	}

	public void setColDate(TableColumn<Invoice, LocalDate> colDate) {
		this.colDate = colDate;
	}

	public TableColumn<Invoice, LocalTime> getColTime() {
		return colTime;
	}

	public void setColTime(TableColumn<Invoice, LocalTime> colTime) {
		this.colTime = colTime;
	}

	public TableColumn<Invoice, Double> getColTotal() {
		return colTotal;
	}

	public void setColTotal(TableColumn<Invoice, Double> colTotal) {
		this.colTotal = colTotal;
	}

	public TableColumn<Invoice, Integer> getColCustomer() {
		return colCustomer;
	}

	public void setColCustomer(TableColumn<Invoice, Integer> colCustomer) {
		this.colCustomer = colCustomer;
	}

	public TableColumn<Invoice, Integer> getColEmp() {
		return colEmp;
	}

	public void setColEmp(TableColumn<Invoice, Integer> colEmp) {
		this.colEmp = colEmp;
	}

	public TableColumn<Invoice, Integer> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<Invoice, Integer> colBranch) {
		this.colBranch = colBranch;
	}

	public TableView<Invoice> getTable() {
		return table;
	}

 
}
