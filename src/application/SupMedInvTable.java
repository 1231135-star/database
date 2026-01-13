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

public class SupMedInvTable {
    private Label bt = new Label("Supplier Inventory Medicines");
    private TableView<SupMedInv> table = new TableView<>();

    private TableColumn<SupMedInv, String> colSupp = new TableColumn<>("Supplier");
    private TableColumn<SupMedInv, String> colMed = new TableColumn<>("Medicine");
    private TableColumn<SupMedInv, String> colBatch = new TableColumn<>("BatchNumber");
    private TableColumn<SupMedInv, Integer> colQty = new TableColumn<>("Quantity");
    private TableColumn<SupMedInv, String> colExp = new TableColumn<>("ExpiryDate");
    private TableColumn<SupMedInv, String> colRec = new TableColumn<>("ReceivedDate");
    private TableColumn<SupMedInv, String> colBranch = new TableColumn<>("Branch");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private VBox all = new VBox();

    public SupMedInvTable() {
    	/*
    	 private String supName,medName,bNum,exDate,recDate,bName;
    private int quant;
    	 */
        colSupp.setCellValueFactory(new PropertyValueFactory<>("supName"));
        colMed.setCellValueFactory(new PropertyValueFactory<>("medName"));
        colBatch.setCellValueFactory(new PropertyValueFactory<>("bNum"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quant"));
        colExp.setCellValueFactory(new PropertyValueFactory<>("exDate"));
        colRec.setCellValueFactory(new PropertyValueFactory<>("recDate"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("bName"));

        table.getColumns().addAll(colSupp, colMed, colBatch, colQty, colExp, colRec, colBranch);

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

	public TableView<SupMedInv> getTable() {
		return table;
	}

	public void setTable(TableView<SupMedInv> table) {
		this.table = table;
	}

	public TableColumn<SupMedInv, String> getColSupp() {
		return colSupp;
	}

	public void setColSupp(TableColumn<SupMedInv, String> colSupp) {
		this.colSupp = colSupp;
	}

	public TableColumn<SupMedInv, String> getColMed() {
		return colMed;
	}

	public void setColMed(TableColumn<SupMedInv, String> colMed) {
		this.colMed = colMed;
	}

	public TableColumn<SupMedInv, String> getColBatch() {
		return colBatch;
	}

	public void setColBatch(TableColumn<SupMedInv, String> colBatch) {
		this.colBatch = colBatch;
	}

	public TableColumn<SupMedInv, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<SupMedInv, Integer> colQty) {
		this.colQty = colQty;
	}

	public TableColumn<SupMedInv, String> getColExp() {
		return colExp;
	}

	public void setColExp(TableColumn<SupMedInv, String> colExp) {
		this.colExp = colExp;
	}

	public TableColumn<SupMedInv, String> getColRec() {
		return colRec;
	}

	public void setColRec(TableColumn<SupMedInv, String> colRec) {
		this.colRec = colRec;
	}

	public TableColumn<SupMedInv, String> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<SupMedInv, String> colBranch) {
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

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

}
