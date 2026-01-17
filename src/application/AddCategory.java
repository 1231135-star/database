package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddCategory {

    private Label addCat = new Label("Add Category");

    private Label catIDL = new Label("Category ID :");
    private TextField catIDT = new TextField();
    private HBox catIDH = new HBox();

    private Label catNL = new Label("Category Name :");
    private TextField catNT = new TextField();
    private HBox catNH = new HBox();

    private Label dL = new Label("Description :");
    private TextField dT = new TextField();
    private HBox dH = new HBox();

    private Image addM = new Image("icons8-add-administrator-100.png");
    private ImageView addVM = new ImageView(addM);
    private Button add = new Button("Add", addVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image clearM = new Image("icons8-clear-100(1).png");
    private ImageView clearVM = new ImageView(clearM);
    private Button clear = new Button("clear", clearVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public AddCategory() {

        catIDH.getChildren().addAll(catIDL, catIDT);
        catIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        catIDH.setAlignment(Pos.CENTER);
        catIDH.setSpacing(20);

        catNH.getChildren().addAll(catNL, catNT);
        catNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        catNH.setAlignment(Pos.CENTER);
        catNH.setSpacing(20);

        dH.getChildren().addAll(dL, dT);
        dL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        dH.setAlignment(Pos.CENTER);
        dH.setSpacing(20);

        buttons.getChildren().addAll(add, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        all.getChildren().addAll(addCat, catIDH, catNH, dH, buttons);
        addCat.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getAddCat() {
		return addCat;
	}

	public void setAddCat(Label addCat) {
		this.addCat = addCat;
	}

	public Label getCatIDL() {
		return catIDL;
	}

	public void setCatIDL(Label catIDL) {
		this.catIDL = catIDL;
	}

	public TextField getCatIDT() {
		return catIDT;
	}

	public void setCatIDT(TextField catIDT) {
		this.catIDT = catIDT;
	}

	public HBox getCatIDH() {
		return catIDH;
	}

	public void setCatIDH(HBox catIDH) {
		this.catIDH = catIDH;
	}

	public Label getCatNL() {
		return catNL;
	}

	public void setCatNL(Label catNL) {
		this.catNL = catNL;
	}

	public TextField getCatNT() {
		return catNT;
	}

	public void setCatNT(TextField catNT) {
		this.catNT = catNT;
	}

	public HBox getCatNH() {
		return catNH;
	}

	public void setCatNH(HBox catNH) {
		this.catNH = catNH;
	}

	public Label getdL() {
		return dL;
	}

	public void setdL(Label dL) {
		this.dL = dL;
	}

	public TextField getdT() {
		return dT;
	}

	public void setdT(TextField dT) {
		this.dT = dT;
	}

	public HBox getdH() {
		return dH;
	}

	public void setdH(HBox dH) {
		this.dH = dH;
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
