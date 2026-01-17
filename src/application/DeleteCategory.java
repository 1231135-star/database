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

public class DeleteCategory {

    private Label dCat = new Label("Delete Category");

    private Image ph = new Image("bb.jpg");
    private ImageView phVM = new ImageView(ph);

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    private Label catIDL = new Label("Category ID :");
    private TextField catIDT = new TextField();
    private HBox catIDH = new HBox();

    private Label catNL = new Label("Category Name :");
    private TextField catNT = new TextField();
    private HBox catNH = new HBox();

    private Label dL = new Label("Description :");
    private TextField dT = new TextField();
    private HBox dH = new HBox();

    private Image deleteM = new Image("icons8-remove-employee-100.png"); 
    private ImageView deleteVM = new ImageView(deleteM);
    private Button delete = new Button("Delete", deleteVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image clearM = new Image("icons8-clear-100(1).png");
    private ImageView clearVM = new ImageView(clearM);
    private Button clear = new Button("clear", clearVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public DeleteCategory() {

        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        catIDH.getChildren().addAll(catIDL, catIDT);
        catIDT.setEditable(false);
        catIDT.setVisible(true);
        catIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        catIDH.setAlignment(Pos.CENTER);
        catIDH.setSpacing(20);

        catNH.getChildren().addAll(catNL, catNT);
        catNT.setEditable(false);
        catNT.setVisible(true);
        catNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        catNH.setAlignment(Pos.CENTER);
        catNH.setSpacing(20);

        dH.getChildren().addAll(dL, dT);
        dT.setEditable(false);
        dT.setVisible(true);
        dL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        dH.setAlignment(Pos.CENTER);
        dH.setSpacing(20);

        buttons.getChildren().addAll(delete, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        delete.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        delete.setDisable(true);

        all.getChildren().addAll(dCat, searchH, catIDH, catNH, dH, buttons);
        dCat.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        all.setAlignment(Pos.CENTER);
        all.setSpacing(15);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getdCat() {
		return dCat;
	}

	public void setdCat(Label dCat) {
		this.dCat = dCat;
	}

	public Image getPh() {
		return ph;
	}

	public void setPh(Image ph) {
		this.ph = ph;
	}

	public ImageView getPhVM() {
		return phVM;
	}

	public void setPhVM(ImageView phVM) {
		this.phVM = phVM;
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
