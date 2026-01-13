package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class InventoryItemTableView {

    private Label title = new Label("Inventory");
    private TableView<InventoryItem> table = new TableView<>();

    private TableColumn<InventoryItem, Integer> colID =new TableColumn<>("ID");
    private TableColumn<InventoryItem, Integer> colQty =new TableColumn<>("Quantity");
    private TableColumn<InventoryItem, LocalDate> colExp =new TableColumn<>("Expiry Date");
    private TableColumn<InventoryItem, Double> colPrice =new TableColumn<>("Purchase Price");

    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();

    public InventoryItemTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("inventoryItemID"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colExp.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));

        table.getColumns().addAll(colID, colQty, colExp, colPrice);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        title.setStyle("-fx-font-size:40px;-fx-font-weight:bold;");
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

	public TableView<InventoryItem> getTable() {
		return table;
	}

	public void setTable(TableView<InventoryItem> table) {
		this.table = table;
	}

	public TableColumn<InventoryItem, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<InventoryItem, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<InventoryItem, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<InventoryItem, Integer> colQty) {
		this.colQty = colQty;
	}

	public TableColumn<InventoryItem, LocalDate> getColExp() {
		return colExp;
	}

	public void setColExp(TableColumn<InventoryItem, LocalDate> colExp) {
		this.colExp = colExp;
	}

	public TableColumn<InventoryItem, Double> getColPrice() {
		return colPrice;
	}

	public void setColPrice(TableColumn<InventoryItem, Double> colPrice) {
		this.colPrice = colPrice;
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