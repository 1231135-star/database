package application;

import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SalesTransactionTableView {

    private Label title = new Label("Sales Transactions");
    private TableView<SalesTransaction> table = new TableView<>();

    private TableColumn<SalesTransaction, Integer> colInv = new TableColumn<>("InvoiceID");
    private TableColumn<SalesTransaction, LocalDate> colDate = new TableColumn<>("InvoiceDate");
    private TableColumn<SalesTransaction, String> colEmp = new TableColumn<>("EmployeeName");
    private TableColumn<SalesTransaction, Double> colTotal = new TableColumn<>("TotalAmount");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);
    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
	private HBox buttons=new HBox();
    private VBox all = new VBox();

    public SalesTransactionTableView() {
        colInv.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        table.getColumns().addAll(colInv, colDate, colEmp, colTotal);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");

        buttons.getChildren().addAll(back,ref);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TableView<SalesTransaction> getTable() {
		return table;
	}

	public void setTable(TableView<SalesTransaction> table) {
		this.table = table;
	}

	public TableColumn<SalesTransaction, Integer> getColInv() {
		return colInv;
	}

	public void setColInv(TableColumn<SalesTransaction, Integer> colInv) {
		this.colInv = colInv;
	}

	public TableColumn<SalesTransaction, LocalDate> getColDate() {
		return colDate;
	}

	public void setColDate(TableColumn<SalesTransaction, LocalDate> colDate) {
		this.colDate = colDate;
	}

	public TableColumn<SalesTransaction, String> getColEmp() {
		return colEmp;
	}

	public void setColEmp(TableColumn<SalesTransaction, String> colEmp) {
		this.colEmp = colEmp;
	}

	public TableColumn<SalesTransaction, Double> getColTotal() {
		return colTotal;
	}

	public void setColTotal(TableColumn<SalesTransaction, Double> colTotal) {
		this.colTotal = colTotal;
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
