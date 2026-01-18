package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddPre {

	private Label title = new Label("Add Prescription");

	private Label idL = new Label("Prescription ID :");
	private TextField idT = new TextField();
	private HBox idH = new HBox();

	private Label dateL = new Label("Issue Date (YYYY-MM-DD) :");
	private TextField dateT = new TextField();
	private HBox dateH = new HBox();

	private Label notesL = new Label("Notes :");
	private TextField notesT = new TextField();
	private HBox notesH = new HBox();

	private Label docL = new Label("Doctor ID :");
	private TextField docT = new TextField();
	private HBox docH = new HBox();

	private Label invL = new Label("Invoice ID :");
	private TextField invT = new TextField();
	private HBox invH = new HBox();

	private Image addM = new Image("icons8-add-administrator-100.png");
	private ImageView addVM = new ImageView(addM);
	private Button add = new Button("Add", addVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private Image clearM = new Image("icons8-clear-100(1).png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clear = new Button("Clear", clearVM);

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public AddPre() {

		idH.getChildren().addAll(idL, idT);
		idL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		idH.setAlignment(Pos.CENTER);
		idH.setSpacing(20);

		dateH.getChildren().addAll(dateL, dateT);
		dateL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		dateH.setAlignment(Pos.CENTER);
		dateH.setSpacing(20);

		notesH.getChildren().addAll(notesL, notesT);
		notesL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		notesH.setAlignment(Pos.CENTER);
		notesH.setSpacing(20);

		docH.getChildren().addAll(docL, docT);
		docL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		docH.setAlignment(Pos.CENTER);
		docH.setSpacing(20);

		invH.getChildren().addAll(invL, invT);
		invL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invH.setAlignment(Pos.CENTER);
		invH.setSpacing(20);

		buttons.getChildren().addAll(add, back, clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

		all.getChildren().addAll(title, idH, dateH, notesH, docH, invH, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(18);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
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

	public Label getNotesL() {
		return notesL;
	}

	public void setNotesL(Label notesL) {
		this.notesL = notesL;
	}

	public TextField getNotesT() {
		return notesT;
	}

	public void setNotesT(TextField notesT) {
		this.notesT = notesT;
	}

	public HBox getNotesH() {
		return notesH;
	}

	public void setNotesH(HBox notesH) {
		this.notesH = notesH;
	}

	public Label getDocL() {
		return docL;
	}

	public void setDocL(Label docL) {
		this.docL = docL;
	}

	public TextField getDocT() {
		return docT;
	}

	public void setDocT(TextField docT) {
		this.docT = docT;
	}

	public HBox getDocH() {
		return docH;
	}

	public void setDocH(HBox docH) {
		this.docH = docH;
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

	public Image getAddM() {
		return addM;
	}

	public void setAddM(Image addM) {
		this.addM = addM;
	}

	public ImageView getAddVM() {
		return addVM;
	}

	public void setAddVM(ImageView addVM) {
		this.addVM = addVM;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
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
