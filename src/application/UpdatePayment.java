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

public class UpdatePayment {

	private Label title = new Label("Edit Payment");

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);
	private Label searchL = new Label("put id :");
	private TextField searchT = new TextField();
	private HBox searchH = new HBox();

	private Label idL = new Label("Payment ID :");
	private TextField idT = new TextField();
	private HBox idH = new HBox();

	private Label dateL = new Label("Payment Date (YYYY-MM-DD) :");
	private TextField dateT = new TextField();
	private HBox dateH = new HBox();

	private Label typeL = new Label("Payment Type :");
	private TextField typeT = new TextField();
	private HBox typeH = new HBox();

	private Label amountL = new Label("Amount :");
	private TextField amountT = new TextField();
	private HBox amountH = new HBox();

	private Label refL = new Label("Reference Number :");
	private TextField refT = new TextField();
	private HBox refH = new HBox();

	private Label invL = new Label("Invoice ID :");
	private TextField invT = new TextField();
	private HBox invH = new HBox();

	private Label polL = new Label("Policy ID :");
	private TextField polT = new TextField();
	private HBox polH = new HBox();

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

	public UpdatePayment() {

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

		typeH.getChildren().addAll(typeL, typeT);
		typeL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		typeH.setAlignment(Pos.CENTER);
		typeH.setSpacing(20);

		amountH.getChildren().addAll(amountL, amountT);
		amountL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		amountH.setAlignment(Pos.CENTER);
		amountH.setSpacing(20);

		refH.getChildren().addAll(refL, refT);
		refL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		refH.setAlignment(Pos.CENTER);
		refH.setSpacing(20);

		invH.getChildren().addAll(invL, invT);
		invL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invH.setAlignment(Pos.CENTER);
		invH.setSpacing(20);

		polH.getChildren().addAll(polL, polT);
		polL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		polH.setAlignment(Pos.CENTER);
		polH.setSpacing(20);

		buttons.getChildren().addAll(edit, back, clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

		edit.setDisable(true);

		all.getChildren().addAll(title, searchH, idH, dateH, typeH, amountH, refH, invH, polH, buttons);
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

	public Label getTypeL() {
		return typeL;
	}

	public void setTypeL(Label typeL) {
		this.typeL = typeL;
	}

	public TextField getTypeT() {
		return typeT;
	}

	public void setTypeT(TextField typeT) {
		this.typeT = typeT;
	}

	public HBox getTypeH() {
		return typeH;
	}

	public void setTypeH(HBox typeH) {
		this.typeH = typeH;
	}

	public Label getAmountL() {
		return amountL;
	}

	public void setAmountL(Label amountL) {
		this.amountL = amountL;
	}

	public TextField getAmountT() {
		return amountT;
	}

	public void setAmountT(TextField amountT) {
		this.amountT = amountT;
	}

	public HBox getAmountH() {
		return amountH;
	}

	public void setAmountH(HBox amountH) {
		this.amountH = amountH;
	}

	public Label getRefL() {
		return refL;
	}

	public void setRefL(Label refL) {
		this.refL = refL;
	}

	public TextField getRefT() {
		return refT;
	}

	public void setRefT(TextField refT) {
		this.refT = refT;
	}

	public HBox getRefH() {
		return refH;
	}

	public void setRefH(HBox refH) {
		this.refH = refH;
	}

	public Label getInvL() {
		return invL;
	}

	public void setInvL(Label invL) {
		this.invL = invL;
	}

	public TextField getInvT() {
		return invT;
	}

	public void setInvT(TextField invT) {
		this.invT = invT;
	}

	public HBox getInvH() {
		return invH;
	}

	public void setInvH(HBox invH) {
		this.invH = invH;
	}

	public Label getPolL() {
		return polL;
	}

	public void setPolL(Label polL) {
		this.polL = polL;
	}

	public TextField getPolT() {
		return polT;
	}

	public void setPolT(TextField polT) {
		this.polT = polT;
	}

	public HBox getPolH() {
		return polH;
	}

	public void setPolH(HBox polH) {
		this.polH = polH;
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
