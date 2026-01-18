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

public class UpdateInvoice {

	private Label title = new Label("Edit Invoice");

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);
	private Label searchL = new Label("put id :");
	private TextField searchT = new TextField();
	private HBox searchH = new HBox();

	private Label idL = new Label("Invoice ID :");
	private TextField idT = new TextField();
	private HBox idH = new HBox();

	private Label dateL = new Label("Invoice Date (YYYY-MM-DD) :");
	private TextField dateT = new TextField();
	private HBox dateH = new HBox();

	private Label timeL = new Label("Invoice Time (HH:MM:SS) :");
	private TextField timeT = new TextField();
	private HBox timeH = new HBox();

	private Label subL = new Label("Subtotal :");
	private TextField subT = new TextField();
	private HBox subH = new HBox();

	private Label disL = new Label("Discount :");
	private TextField disT = new TextField();
	private HBox disH = new HBox();

	private Label taxL = new Label("Tax :");
	private TextField taxT = new TextField();
	private HBox taxH = new HBox();

	private Label totalL = new Label("Total Amount :");
	private TextField totalT = new TextField();
	private HBox totalH = new HBox();

	private Label payL = new Label("Payment Status :");
	private TextField payT = new TextField();
	private HBox payH = new HBox();

	private Label cidL = new Label("Customer ID :");
	private TextField cidT = new TextField();
	private HBox cidH = new HBox();

	private Label eidL = new Label("Employee ID :");
	private TextField eidT = new TextField();
	private HBox eidH = new HBox();

	private Label bidL = new Label("Branch ID :");
	private TextField bidT = new TextField();
	private HBox bidH = new HBox();

	private Image editM = new Image("icons8-edit-property-100.png");
	private ImageView editVM = new ImageView(editM);
	private Button edit = new Button("Edit", editVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private Image clearM = new Image("icons8-clear-100(1).png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clear = new Button("Clear", clearVM);

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public UpdateInvoice() {

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

		dateH.getChildren().addAll(dateL, dateT);
		dateL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		dateH.setAlignment(Pos.CENTER);
		dateH.setSpacing(20);

		timeH.getChildren().addAll(timeL, timeT);
		timeL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		timeH.setAlignment(Pos.CENTER);
		timeH.setSpacing(20);

		subH.getChildren().addAll(subL, subT);
		subL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		subH.setAlignment(Pos.CENTER);
		subH.setSpacing(20);

		disH.getChildren().addAll(disL, disT);
		disL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		disH.setAlignment(Pos.CENTER);
		disH.setSpacing(20);

		taxH.getChildren().addAll(taxL, taxT);
		taxL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		taxH.setAlignment(Pos.CENTER);
		taxH.setSpacing(20);

		totalH.getChildren().addAll(totalL, totalT);
		totalL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		totalH.setAlignment(Pos.CENTER);
		totalH.setSpacing(20);

		payH.getChildren().addAll(payL, payT);
		payL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		payH.setAlignment(Pos.CENTER);
		payH.setSpacing(20);

		cidH.getChildren().addAll(cidL, cidT);
		cidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		cidH.setAlignment(Pos.CENTER);
		cidH.setSpacing(20);

		eidH.getChildren().addAll(eidL, eidT);
		eidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		eidH.setAlignment(Pos.CENTER);
		eidH.setSpacing(20);

		bidH.getChildren().addAll(bidL, bidT);
		bidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bidH.setAlignment(Pos.CENTER);
		bidH.setSpacing(20);

		buttons.getChildren().addAll(edit, back, clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

		edit.setDisable(true);

		all.getChildren().addAll(title, searchH, idH, dateH, timeH, subH, disH, taxH, totalH, payH, cidH, eidH, bidH,buttons);
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

	public Label getDateL() {
		return dateL;
	}

	public void setDateL(Label dateL) {
		this.dateL = dateL;
	}

	public TextField getDateT() {
		return dateT;
	}

	public void setDateT(TextField dateT) {
		this.dateT = dateT;
	}

	public HBox getDateH() {
		return dateH;
	}

	public void setDateH(HBox dateH) {
		this.dateH = dateH;
	}

	public Label getTimeL() {
		return timeL;
	}

	public void setTimeL(Label timeL) {
		this.timeL = timeL;
	}

	public TextField getTimeT() {
		return timeT;
	}

	public void setTimeT(TextField timeT) {
		this.timeT = timeT;
	}

	public HBox getTimeH() {
		return timeH;
	}

	public void setTimeH(HBox timeH) {
		this.timeH = timeH;
	}

	public Label getSubL() {
		return subL;
	}

	public void setSubL(Label subL) {
		this.subL = subL;
	}

	public TextField getSubT() {
		return subT;
	}

	public void setSubT(TextField subT) {
		this.subT = subT;
	}

	public HBox getSubH() {
		return subH;
	}

	public void setSubH(HBox subH) {
		this.subH = subH;
	}

	public Label getDisL() {
		return disL;
	}

	public void setDisL(Label disL) {
		this.disL = disL;
	}

	public TextField getDisT() {
		return disT;
	}

	public void setDisT(TextField disT) {
		this.disT = disT;
	}

	public HBox getDisH() {
		return disH;
	}

	public void setDisH(HBox disH) {
		this.disH = disH;
	}

	public Label getTaxL() {
		return taxL;
	}

	public void setTaxL(Label taxL) {
		this.taxL = taxL;
	}

	public TextField getTaxT() {
		return taxT;
	}

	public void setTaxT(TextField taxT) {
		this.taxT = taxT;
	}

	public HBox getTaxH() {
		return taxH;
	}

	public void setTaxH(HBox taxH) {
		this.taxH = taxH;
	}

	public Label getTotalL() {
		return totalL;
	}

	public void setTotalL(Label totalL) {
		this.totalL = totalL;
	}

	public TextField getTotalT() {
		return totalT;
	}

	public void setTotalT(TextField totalT) {
		this.totalT = totalT;
	}

	public HBox getTotalH() {
		return totalH;
	}

	public void setTotalH(HBox totalH) {
		this.totalH = totalH;
	}

	public Label getPayL() {
		return payL;
	}

	public void setPayL(Label payL) {
		this.payL = payL;
	}

	public TextField getPayT() {
		return payT;
	}

	public void setPayT(TextField payT) {
		this.payT = payT;
	}

	public HBox getPayH() {
		return payH;
	}

	public void setPayH(HBox payH) {
		this.payH = payH;
	}

	public Label getCidL() {
		return cidL;
	}

	public void setCidL(Label cidL) {
		this.cidL = cidL;
	}

	public TextField getCidT() {
		return cidT;
	}

	public void setCidT(TextField cidT) {
		this.cidT = cidT;
	}

	public HBox getCidH() {
		return cidH;
	}

	public void setCidH(HBox cidH) {
		this.cidH = cidH;
	}

	public Label getEidL() {
		return eidL;
	}

	public void setEidL(Label eidL) {
		this.eidL = eidL;
	}

	public TextField getEidT() {
		return eidT;
	}

	public void setEidT(TextField eidT) {
		this.eidT = eidT;
	}

	public HBox getEidH() {
		return eidH;
	}

	public void setEidH(HBox eidH) {
		this.eidH = eidH;
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

	public Image getEditM() {
		return editM;
	}

	public void setEditM(Image editM) {
		this.editM = editM;
	}

	public ImageView getEditVM() {
		return editVM;
	}

	public void setEditVM(ImageView editVM) {
		this.editVM = editVM;
	}

	public Button getEdit() {
		return edit;
	}

	public void setEdit(Button edit) {
		this.edit = edit;
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
