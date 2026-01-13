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

public class InvoiceItemTableView {
	private Label iit=new Label("Invoice Items");
    private TableView<InvoiceItem> table = new TableView<>();
    private TableColumn<InvoiceItem, Integer> colInvoiceID = new TableColumn<>("InvoiceID");
    private TableColumn<InvoiceItem, Integer> colMedicineID = new TableColumn<>("MedicineID");
    private TableColumn<InvoiceItem, Integer> colQuantity = new TableColumn<>("Quantity");
    private TableColumn<InvoiceItem, Double> colUnitPrice = new TableColumn<>("UnitPrice");
    private TableColumn<InvoiceItem, Double> colLineTotal = new TableColumn<>("LineTotal");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();
   	
    public InvoiceItemTableView() {
        colInvoiceID.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colMedicineID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colLineTotal.setCellValueFactory(new PropertyValueFactory<>("lineTotal"));
        table.getColumns().addAll(colInvoiceID, colMedicineID, colQuantity, colUnitPrice, colLineTotal);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		iit.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(iit,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getIit() {
		return iit;
	}

	public void setIit(Label iit) {
		this.iit = iit;
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

	public void setTable(TableView<InvoiceItem> table) {
		this.table = table;
	}

	public TableColumn<InvoiceItem, Integer> getColInvoiceID() {
		return colInvoiceID;
	}

	public void setColInvoiceID(TableColumn<InvoiceItem, Integer> colInvoiceID) {
		this.colInvoiceID = colInvoiceID;
	}

	public TableColumn<InvoiceItem, Integer> getColMedicineID() {
		return colMedicineID;
	}

	public void setColMedicineID(TableColumn<InvoiceItem, Integer> colMedicineID) {
		this.colMedicineID = colMedicineID;
	}

	public TableColumn<InvoiceItem, Integer> getColQuantity() {
		return colQuantity;
	}

	public void setColQuantity(TableColumn<InvoiceItem, Integer> colQuantity) {
		this.colQuantity = colQuantity;
	}

	public TableColumn<InvoiceItem, Double> getColUnitPrice() {
		return colUnitPrice;
	}

	public void setColUnitPrice(TableColumn<InvoiceItem, Double> colUnitPrice) {
		this.colUnitPrice = colUnitPrice;
	}

	public TableColumn<InvoiceItem, Double> getColLineTotal() {
		return colLineTotal;
	}

	public void setColLineTotal(TableColumn<InvoiceItem, Double> colLineTotal) {
		this.colLineTotal = colLineTotal;
	}

	public TableView<InvoiceItem> getTable() {
		return table;
	}

   
}
