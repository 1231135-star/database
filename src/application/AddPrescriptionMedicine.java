package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddPrescriptionMedicine {

    private Label title = new Label("Add Prescription Medicine");

    private Label pidL = new Label("Prescription ID :");
    private TextField pidT = new TextField();
    private HBox pidH = new HBox();

    private Label midL = new Label("Medicine ID :");
    private TextField midT = new TextField();
    private HBox midH = new HBox();

    private Label dosL = new Label("Dosage :");
    private TextField dosT = new TextField();
    private HBox dosH = new HBox();

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

    public AddPrescriptionMedicine() {

        addVM.setFitWidth(42); addVM.setFitHeight(42);
        backVM.setFitWidth(42); backVM.setFitHeight(42);
        clearVM.setFitWidth(42); clearVM.setFitHeight(42);

        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        pidH.getChildren().addAll(pidL, pidT);
        pidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        pidH.setAlignment(Pos.CENTER);
        pidH.setSpacing(20);

        midH.getChildren().addAll(midL, midT);
        midL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        midH.setAlignment(Pos.CENTER);
        midH.setSpacing(20);

        dosH.getChildren().addAll(dosL, dosT);
        dosL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        dosH.setAlignment(Pos.CENTER);
        dosH.setSpacing(20);

        buttons.getChildren().addAll(add, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        all.getChildren().addAll(title, pidH, midH, dosH, buttons);
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

	public Label getPidL() {
		return pidL;
	}

	public void setPidL(Label pidL) {
		this.pidL = pidL;
	}

	public TextField getPidT() {
		return pidT;
	}

	public void setPidT(TextField pidT) {
		this.pidT = pidT;
	}

	public HBox getPidH() {
		return pidH;
	}

	public void setPidH(HBox pidH) {
		this.pidH = pidH;
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

	public Label getDosL() {
		return dosL;
	}

	public void setDosL(Label dosL) {
		this.dosL = dosL;
	}

	public TextField getDosT() {
		return dosT;
	}

	public void setDosT(TextField dosT) {
		this.dosT = dosT;
	}

	public HBox getDosH() {
		return dosH;
	}

	public void setDosH(HBox dosH) {
		this.dosH = dosH;
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
