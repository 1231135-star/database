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

public class DeletePrescriptionMedicine {

    private Label title = new Label("Delete Prescription Medicine");

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);

    private Label spidL = new Label("Prescription ID :");
    private TextField spidT = new TextField();
    private HBox spidH = new HBox();

    private Label smidL = new Label("Medicine ID :");
    private TextField smidT = new TextField();
    private HBox smidH = new HBox();

    private HBox searchH = new HBox();

    private Label pidL = new Label("Prescription ID :");
    private TextField pidT = new TextField();
    private HBox pidH = new HBox();

    private Label midL = new Label("Medicine ID :");
    private TextField midT = new TextField();
    private HBox midH = new HBox();

    private Label dosL = new Label("Dosage :");
    private TextField dosT = new TextField();
    private HBox dosH = new HBox();

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

    public DeletePrescriptionMedicine() {

        searchVM.setFitWidth(42); searchVM.setFitHeight(42);
        deleteVM.setFitWidth(42); deleteVM.setFitHeight(42);
        backVM.setFitWidth(42); backVM.setFitHeight(42);
        clearVM.setFitWidth(42); clearVM.setFitHeight(42);

        spidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        smidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        spidL.setFont(Font.font(null, FontWeight.BOLD, 20));
        smidL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        spidH.getChildren().addAll(spidL, spidT);
        spidH.setAlignment(Pos.CENTER);
        spidH.setSpacing(20);

        smidH.getChildren().addAll(smidL, smidT);
        smidH.setAlignment(Pos.CENTER);
        smidH.setSpacing(20);

        searchH.getChildren().addAll(spidH, smidH, searchB);
        searchH.setAlignment(Pos.CENTER);
        searchH.setSpacing(15);

        pidH.getChildren().addAll(pidL, pidT);
        pidT.setEditable(false);
        pidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        pidH.setAlignment(Pos.CENTER);
        pidH.setSpacing(20);

        midH.getChildren().addAll(midL, midT);
        midT.setEditable(false);
        midL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        midH.setAlignment(Pos.CENTER);
        midH.setSpacing(20);

        dosH.getChildren().addAll(dosL, dosT);
        dosT.setEditable(false);
        dosL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        dosH.setAlignment(Pos.CENTER);
        dosH.setSpacing(20);

        buttons.getChildren().addAll(delete, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        delete.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        delete.setDisable(true);

        
        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        all.getChildren().addAll(title, searchH, pidH, midH, dosH, buttons);
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

	public Label getSpidL() {
		return spidL;
	}

	public void setSpidL(Label spidL) {
		this.spidL = spidL;
	}

	public TextField getSpidT() {
		return spidT;
	}

	public void setSpidT(TextField spidT) {
		this.spidT = spidT;
	}

	public HBox getSpidH() {
		return spidH;
	}

	public void setSpidH(HBox spidH) {
		this.spidH = spidH;
	}

	public Label getSmidL() {
		return smidL;
	}

	public void setSmidL(Label smidL) {
		this.smidL = smidL;
	}

	public TextField getSmidT() {
		return smidT;
	}

	public void setSmidT(TextField smidT) {
		this.smidT = smidT;
	}

	public HBox getSmidH() {
		return smidH;
	}

	public void setSmidH(HBox smidH) {
		this.smidH = smidH;
	}

	public HBox getSearchH() {
		return searchH;
	}

	public void setSearchH(HBox searchH) {
		this.searchH = searchH;
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
