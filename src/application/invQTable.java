package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class invQTable {

    private Label title = new Label("Inventory");
    private TableView<InvQ> table = new TableView<>();

    private TableColumn<InvQ, Integer> colID = new TableColumn<>("ID");
    private TableColumn<InvQ, String> colBatch = new TableColumn<>("Batch Number");
    private TableColumn<InvQ, String> colMed = new TableColumn<>("Medicine");
    private TableColumn<InvQ, String> colSupp = new TableColumn<>("Supplier");
    private TableColumn<InvQ, String> colBranch = new TableColumn<>("Branch");

    private TableColumn<InvQ, Integer> colQty = new TableColumn<>("Quantity");
    private TableColumn<InvQ, LocalDate> colExp = new TableColumn<>("Expiry Date");
    private TableColumn<InvQ, LocalDate> colRec = new TableColumn<>("Received Date");
    private TableColumn<InvQ, Double> colPrice = new TableColumn<>("Purchase Price");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private VBox all = new VBox();

    public invQTable() {
    	/*
    	  private int invID,quant;
    private String bnum,medName,suppName,bName;
    private LocalDate exDate,recDate;
    private double purchasPrice;

    	 */
        colID.setCellValueFactory(new PropertyValueFactory<>("invID"));
        colBatch.setCellValueFactory(new PropertyValueFactory<>("bnum"));
        colMed.setCellValueFactory(new PropertyValueFactory<>("medName"));
        colSupp.setCellValueFactory(new PropertyValueFactory<>("suppName"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("bName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quant"));
        colExp.setCellValueFactory(new PropertyValueFactory<>("exDate"));
        colRec.setCellValueFactory(new PropertyValueFactory<>("recDate"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("purchasPrice"));
        table.getColumns().addAll(colID, colBatch, colMed, colSupp, colBranch,colQty, colExp, colRec, colPrice);

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

	public TableView<InvQ> getTable() {
		return table;
	}

	public void setTable(TableView<InvQ> table) {
		this.table = table;
	}

	public TableColumn<InvQ, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<InvQ, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<InvQ, String> getColBatch() {
		return colBatch;
	}

	public void setColBatch(TableColumn<InvQ, String> colBatch) {
		this.colBatch = colBatch;
	}

	public TableColumn<InvQ, String> getColMed() {
		return colMed;
	}

	public void setColMed(TableColumn<InvQ, String> colMed) {
		this.colMed = colMed;
	}

	public TableColumn<InvQ, String> getColSupp() {
		return colSupp;
	}

	public void setColSupp(TableColumn<InvQ, String> colSupp) {
		this.colSupp = colSupp;
	}

	public TableColumn<InvQ, String> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<InvQ, String> colBranch) {
		this.colBranch = colBranch;
	}

	public TableColumn<InvQ, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<InvQ, Integer> colQty) {
		this.colQty = colQty;
	}

	public TableColumn<InvQ, LocalDate> getColExp() {
		return colExp;
	}

	public void setColExp(TableColumn<InvQ, LocalDate> colExp) {
		this.colExp = colExp;
	}

	public TableColumn<InvQ, LocalDate> getColRec() {
		return colRec;
	}

	public void setColRec(TableColumn<InvQ, LocalDate> colRec) {
		this.colRec = colRec;
	}

	public TableColumn<InvQ, Double> getColPrice() {
		return colPrice;
	}

	public void setColPrice(TableColumn<InvQ, Double> colPrice) {
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
