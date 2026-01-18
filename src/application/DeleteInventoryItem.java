package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DeleteInventoryItem {

	private Label title = new Label("Delete Inventory Item");

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);
	private Label searchL = new Label("put id :");
	private TextField searchT = new TextField();
	private HBox searchH = new HBox();

	private Label idL = new Label("Inventory Item ID :");
	private TextField idT = new TextField();
	private HBox idH = new HBox();

	private Label batchL = new Label("Batch Number :");
	private TextField batchT = new TextField();
	private HBox batchH = new HBox();

	private Label qtyL = new Label("Quantity Available :");
	private TextField qtyT = new TextField();
	private HBox qtyH = new HBox();

	private Label expL = new Label("Expiry Date (YYYY-MM-DD) :");
	private TextField expT = new TextField();
	private HBox expH = new HBox();

	private Label recL = new Label("Received Date (YYYY-MM-DD) :");
	private TextField recT = new TextField();
	private HBox recH = new HBox();

	private Label priceL = new Label("Purchase Price :");
	private TextField priceT = new TextField();
	private HBox priceH = new HBox();

	private Label midL = new Label("Medicine ID :");
	private TextField midT = new TextField();
	private HBox midH = new HBox();

	private Label sidL = new Label("Supplier ID :");
	private TextField sidT = new TextField();
	private HBox sidH = new HBox();

	private Label bidL = new Label("Branch ID :");
	private TextField bidT = new TextField();
	private HBox bidH = new HBox();

	private Image deleteM = new Image("icons8-remove-employee-100.png");
	private ImageView deleteVM = new ImageView(deleteM);
	private Button delete = new Button("Delete", deleteVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private Image clearM = new Image("icons8-clear-100(1).png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clear = new Button("Clear", clearVM);

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public DeleteInventoryItem() {

		searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);

		searchH.getChildren().addAll(searchL, searchT, searchB);
		searchH.setSpacing(10);
		searchH.setAlignment(Pos.CENTER);

		idH.getChildren().addAll(idL, idT);
		idT.setEditable(false);
		idT.setVisible(true);
		idL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		idH.setAlignment(Pos.CENTER);
		idH.setSpacing(20);

		batchH.getChildren().addAll(batchL, batchT);
		batchT.setEditable(false);
		batchT.setVisible(true);
		batchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		batchH.setAlignment(Pos.CENTER);
		batchH.setSpacing(20);

		qtyH.getChildren().addAll(qtyL, qtyT);
		qtyT.setEditable(false);
		qtyT.setVisible(true);
		qtyL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		qtyH.setAlignment(Pos.CENTER);
		qtyH.setSpacing(20);

		expH.getChildren().addAll(expL, expT);
		expT.setEditable(false);
		expT.setVisible(true);
		expL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		expH.setAlignment(Pos.CENTER);
		expH.setSpacing(20);

		recH.getChildren().addAll(recL, recT);
		recT.setEditable(false);
		recT.setVisible(true);
		recL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		recH.setAlignment(Pos.CENTER);
		recH.setSpacing(20);

		priceH.getChildren().addAll(priceL, priceT);
		priceT.setEditable(false);
		priceT.setVisible(true);
		priceL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		priceH.setAlignment(Pos.CENTER);
		priceH.setSpacing(20);

		midH.getChildren().addAll(midL, midT);
		midT.setEditable(false);
		midT.setVisible(true);
		midL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		midH.setAlignment(Pos.CENTER);
		midH.setSpacing(20);

		sidH.getChildren().addAll(sidL, sidT);
		sidT.setEditable(false);
		sidT.setVisible(true);
		sidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		sidH.setAlignment(Pos.CENTER);
		sidH.setSpacing(20);

		bidH.getChildren().addAll(bidL, bidT);
		bidT.setEditable(false);
		bidT.setVisible(true);
		bidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bidH.setAlignment(Pos.CENTER);
		bidH.setSpacing(20);

		buttons.getChildren().addAll(delete, back, clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		delete.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		delete.setDisable(true);

		title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

		all.getChildren().addAll(title, searchH, idH, batchH, qtyH, expH, recH, priceH, midH, sidH, bidH, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(15);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
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

	public Label getIdL() {
		return idL;
	}

	public void setIdL(Label idL) {
		this.idL = idL;
	}

	public TextField getIdT() {
		return idT;
	}

	public void setIdT(TextField idT) {
		this.idT = idT;
	}

	public HBox getIdH() {
		return idH;
	}

	public void setIdH(HBox idH) {
		this.idH = idH;
	}

	public Label getBatchL() {
		return batchL;
	}

	public void setBatchL(Label batchL) {
		this.batchL = batchL;
	}

	public TextField getBatchT() {
		return batchT;
	}

	public void setBatchT(TextField batchT) {
		this.batchT = batchT;
	}

	public HBox getBatchH() {
		return batchH;
	}

	public void setBatchH(HBox batchH) {
		this.batchH = batchH;
	}

	public Label getQtyL() {
		return qtyL;
	}

	public void setQtyL(Label qtyL) {
		this.qtyL = qtyL;
	}

	public TextField getQtyT() {
		return qtyT;
	}

	public void setQtyT(TextField qtyT) {
		this.qtyT = qtyT;
	}

	public HBox getQtyH() {
		return qtyH;
	}

	public void setQtyH(HBox qtyH) {
		this.qtyH = qtyH;
	}

	public Label getExpL() {
		return expL;
	}

	public void setExpL(Label expL) {
		this.expL = expL;
	}

	public TextField getExpT() {
		return expT;
	}

	public void setExpT(TextField expT) {
		this.expT = expT;
	}

	public HBox getExpH() {
		return expH;
	}

	public void setExpH(HBox expH) {
		this.expH = expH;
	}

	public Label getRecL() {
		return recL;
	}

	public void setRecL(Label recL) {
		this.recL = recL;
	}

	public TextField getRecT() {
		return recT;
	}

	public void setRecT(TextField recT) {
		this.recT = recT;
	}

	public HBox getRecH() {
		return recH;
	}

	public void setRecH(HBox recH) {
		this.recH = recH;
	}

	public Label getPriceL() {
		return priceL;
	}

	public void setPriceL(Label priceL) {
		this.priceL = priceL;
	}

	public TextField getPriceT() {
		return priceT;
	}

	public void setPriceT(TextField priceT) {
		this.priceT = priceT;
	}

	public HBox getPriceH() {
		return priceH;
	}

	public void setPriceH(HBox priceH) {
		this.priceH = priceH;
	}

	public Label getMidL() {
		return midL;
	}

	public void setMidL(Label midL) {
		this.midL = midL;
	}

	public TextField getMidT() {
		return midT;
	}

	public void setMidT(TextField midT) {
		this.midT = midT;
	}

	public HBox getMidH() {
		return midH;
	}

	public void setMidH(HBox midH) {
		this.midH = midH;
	}

	public Label getSidL() {
		return sidL;
	}

	public void setSidL(Label sidL) {
		this.sidL = sidL;
	}

	public TextField getSidT() {
		return sidT;
	}

	public void setSidT(TextField sidT) {
		this.sidT = sidT;
	}

	public HBox getSidH() {
		return sidH;
	}

	public void setSidH(HBox sidH) {
		this.sidH = sidH;
	}

	public Label getBidL() {
		return bidL;
	}

	public void setBidL(Label bidL) {
		this.bidL = bidL;
	}

	public TextField getBidT() {
		return bidT;
	}

	public void setBidT(TextField bidT) {
		this.bidT = bidT;
	}

	public HBox getBidH() {
		return bidH;
	}

	public void setBidH(HBox bidH) {
		this.bidH = bidH;
	}

	public Image getDeleteM() {
		return deleteM;
	}

	public void setDeleteM(Image deleteM) {
		this.deleteM = deleteM;
	}

	public ImageView getDeleteVM() {
		return deleteVM;
	}

	public void setDeleteVM(ImageView deleteVM) {
		this.deleteVM = deleteVM;
	}

	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
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

	public Image getClearM() {
		return clearM;
	}

	public void setClearM(Image clearM) {
		this.clearM = clearM;
	}

	public ImageView getClearVM() {
		return clearVM;
	}

	public void setClearVM(ImageView clearVM) {
		this.clearVM = clearVM;
	}

	public Button getClear() {
		return clear;
	}

	public void setClear(Button clear) {
		this.clear = clear;
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
