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

public class MedQTable {
    private Label bt = new Label("Medicine Batches Expiry");
    private TableView<MedQ> table = new TableView<>();
    private TableColumn<MedQ, String> colMed = new TableColumn<>("Medicine");
    private TableColumn<MedQ, String> colBatch = new TableColumn<>("BatchNumber");
    private TableColumn<MedQ, String> colExp = new TableColumn<>("ExpiryDate");
    private TableColumn<MedQ, Integer> colQty = new TableColumn<>("Quantity");
    private TableColumn<MedQ, String> colBranch = new TableColumn<>("Branch");
    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);
    private VBox all = new VBox();

    public MedQTable() {
    	/*
   	 private String medName,bNum,exDate,bName;
       private int quant;
   	 */
        colMed.setCellValueFactory(new PropertyValueFactory<>("medName"));
        colBatch.setCellValueFactory(new PropertyValueFactory<>("bNum"));
        colExp.setCellValueFactory(new PropertyValueFactory<>("exDate"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quant"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("bName"));
        table.getColumns().addAll(colMed, colBatch, colExp, colQty, colBranch);
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

	public TableView<MedQ> getTable() {
		return table;
	}

	public void setTable(TableView<MedQ> table) {
		this.table = table;
	}

	public TableColumn<MedQ, String> getColMed() {
		return colMed;
	}

	public void setColMed(TableColumn<MedQ, String> colMed) {
		this.colMed = colMed;
	}

	public TableColumn<MedQ, String> getColBatch() {
		return colBatch;
	}

	public void setColBatch(TableColumn<MedQ, String> colBatch) {
		this.colBatch = colBatch;
	}

	public TableColumn<MedQ, String> getColExp() {
		return colExp;
	}

	public void setColExp(TableColumn<MedQ, String> colExp) {
		this.colExp = colExp;
	}

	public TableColumn<MedQ, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<MedQ, Integer> colQty) {
		this.colQty = colQty;
	}

	public TableColumn<MedQ, String> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<MedQ, String> colBranch) {
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
