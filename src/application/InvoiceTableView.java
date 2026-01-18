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

import java.time.LocalDate;
import java.time.LocalTime;

public class InvoiceTableView {

    private Label mt = new Label("Invoices");

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();

    private HBox searchH = new HBox();

    private TableView<Invoice> table = new TableView<>();

    private TableColumn<Invoice, Integer> colID = new TableColumn<>("InvoiceID");
    private TableColumn<Invoice, LocalDate> colDate = new TableColumn<>("Date");
    private TableColumn<Invoice, LocalTime> colTime = new TableColumn<>("Time");

    private TableColumn<Invoice, Double> colSubtotal = new TableColumn<>("Subtotal");
    private TableColumn<Invoice, Double> colDiscount = new TableColumn<>("Discount");
    private TableColumn<Invoice, Double> colTax = new TableColumn<>("Tax");
    private TableColumn<Invoice, Double> colTotal = new TableColumn<>("TotalAmount");

    private TableColumn<Invoice, String> colPayStatus = new TableColumn<>("PaymentStatus");

    private TableColumn<Invoice, Integer> colCustomer = new TableColumn<>("CustomerID");
    private TableColumn<Invoice, Integer> colEmp = new TableColumn<>("EmpID");
    private TableColumn<Invoice, Integer> colBranch = new TableColumn<>("BranchID");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private Image delM = new Image("icons8-remove-employee-100.png");
    private ImageView delVM = new ImageView(delM);
    private Button deleteB = new Button("Delete", delVM);

    private Image upM = new Image("icons8-edit-property-100.png");
    private ImageView upVM = new ImageView(upM);
    private Button updateB = new Button("Update", upVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public InvoiceTableView() {

        
        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        colID.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("invoiceTime"));

        colSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTax.setCellValueFactory(new PropertyValueFactory<>("tax"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        colPayStatus.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

        colCustomer.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branchID"));

        colID.setPrefWidth(90);
        colDate.setPrefWidth(110);
        colTime.setPrefWidth(90);

        colSubtotal.setPrefWidth(90);
        colDiscount.setPrefWidth(90);
        colTax.setPrefWidth(70);
        colTotal.setPrefWidth(100);

        colPayStatus.setPrefWidth(140);

        colCustomer.setPrefWidth(95);
        colEmp.setPrefWidth(80);
        colBranch.setPrefWidth(85);

        table.getColumns().addAll(colID, colDate, colTime,colSubtotal, colDiscount, colTax, colTotal,colPayStatus,colCustomer, colEmp, colBranch);

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

        buttons.getChildren().addAll(back, ref, updateB, deleteB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(mt, searchH, table, buttons);
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

	public TableView<Invoice> getTable() {
		return table;
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

	public TableColumn<Invoice, Double> getColSubtotal() {
		return colSubtotal;
	}

	public void setColSubtotal(TableColumn<Invoice, Double> colSubtotal) {
		this.colSubtotal = colSubtotal;
	}

	public TableColumn<Invoice, Double> getColDiscount() {
		return colDiscount;
	}

	public void setColDiscount(TableColumn<Invoice, Double> colDiscount) {
		this.colDiscount = colDiscount;
	}

	public TableColumn<Invoice, Double> getColTax() {
		return colTax;
	}

	public void setColTax(TableColumn<Invoice, Double> colTax) {
		this.colTax = colTax;
	}

	public TableColumn<Invoice, Double> getColTotal() {
		return colTotal;
	}

	public void setColTotal(TableColumn<Invoice, Double> colTotal) {
		this.colTotal = colTotal;
	}

	public TableColumn<Invoice, String> getColPayStatus() {
		return colPayStatus;
	}

	public void setColPayStatus(TableColumn<Invoice, String> colPayStatus) {
		this.colPayStatus = colPayStatus;
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
