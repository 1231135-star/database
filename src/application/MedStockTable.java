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

public class MedStockTable{
    private Label bt = new Label("Out Of Stock Medicines");
    private TableView<MedStock> table = new TableView<>();
    private TableColumn<MedStock, Integer> colID = new TableColumn<>("MedicineID");
    private TableColumn<MedStock, String> colName = new TableColumn<>("MedicineName");
    private TableColumn<MedStock, Integer> colQty = new TableColumn<>("TotalQuantity");
    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);
    private VBox all = new VBox();

    public MedStockTable() {
    	/*
    	 private int medID,totQuantity;
         private String medName;
    	 */
        colID.setCellValueFactory(new PropertyValueFactory<>("medID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("medName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("totQuantity"));
        table.getColumns().addAll(colID, colName, colQty);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        bt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(bt, table, back);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getBt() {
		return bt;
	}

	public void setBt(Label bt) {
		this.bt = bt;
	}

	public TableView<MedStock> getTable() {
		return table;
	}

	public void setTable(TableView<MedStock> table) {
		this.table = table;
	}

	public TableColumn<MedStock, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<MedStock, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<MedStock, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<MedStock, String> colName) {
		this.colName = colName;
	}

	public TableColumn<MedStock, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<MedStock, Integer> colQty) {
		this.colQty = colQty;
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
