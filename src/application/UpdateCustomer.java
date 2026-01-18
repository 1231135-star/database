package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UpdateCustomer {

    private Label editCust = new Label("Edit Customer");

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    private Label cidL = new Label("Customer ID :");
    private TextField cidT = new TextField();
    private HBox cidH = new HBox();

    private Label nameL = new Label("Full Name :");
    private TextField nameT = new TextField();
    private HBox nameH = new HBox();

    private Label pnL = new Label("Phone Number :");
    private TextField pnT = new TextField();
    private HBox pnH = new HBox();

    private Label eL = new Label("Email Address :");
    private TextField eT = new TextField();
    private HBox eH = new HBox();

    private Label addL = new Label("Address :");
    private TextField addT = new TextField();
    private HBox addH = new HBox();

    private Label dobL = new Label("Date Of Birth :");
    private DatePicker dobP = new DatePicker();
    private HBox dobH = new HBox();

    private Label genderL = new Label("Gender :");
    private ComboBox<String> genderC = new ComboBox<>();
    private HBox genderH = new HBox();

    private Image editM = new Image("icons8-edit-property-100.png");
    private ImageView editVM = new ImageView(editM);
    private Button edit = new Button("Edit", editVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image clearM = new Image("icons8-clear-100(1).png");
    private ImageView clearVM = new ImageView(clearM);
    private Button clear = new Button("clear", clearVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public UpdateCustomer() {

        genderC.getItems().addAll("Male", "Female");

        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));
        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        cidH.getChildren().addAll(cidL,cidT);
        cidH.setSpacing(10);
        cidH.setAlignment(Pos.CENTER);

        nameH.getChildren().addAll(nameL,nameT);
        nameH.setSpacing(10);
        nameH.setAlignment(Pos.CENTER);

        pnH.getChildren().addAll(pnL,pnT);
        pnH.setSpacing(10);
        pnH.setAlignment(Pos.CENTER);

        eH.getChildren().addAll(eL,eT);
        eH.setSpacing(10);
        eH.setAlignment(Pos.CENTER);

        addH.getChildren().addAll(addL,addT);
        addH.setSpacing(10);
        addH.setAlignment(Pos.CENTER);
        
 
        dobH.getChildren().addAll(dobL, dobP);
        dobL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        dobH.setAlignment(Pos.CENTER);
        dobH.setSpacing(20);

        genderH.getChildren().addAll(genderL, genderC);
        genderL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        genderH.setAlignment(Pos.CENTER);
        genderH.setSpacing(20);

        buttons.getChildren().addAll(edit, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
       
        all.getChildren().addAll(editCust, searchH, cidH, nameH, pnH, eH, addH, dobH, genderH, buttons);
        editCust.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        all.setAlignment(Pos.CENTER);
        all.setSpacing(15);
        all.setStyle("-fx-background-color: #a2c4c9;");

        cidT.setEditable(false);    
        edit.setDisable(true);      
    }

	public Label getEditCust() {
		return editCust;
	}

	public void setEditCust(Label editCust) {
		this.editCust = editCust;
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

	public Label getNameL() {
		return nameL;
	}

	public void setNameL(Label nameL) {
		this.nameL = nameL;
	}

	public TextField getNameT() {
		return nameT;
	}

	public void setNameT(TextField nameT) {
		this.nameT = nameT;
	}

	public HBox getNameH() {
		return nameH;
	}

	public void setNameH(HBox nameH) {
		this.nameH = nameH;
	}

	public Label getPnL() {
		return pnL;
	}

	public void setPnL(Label pnL) {
		this.pnL = pnL;
	}

	public TextField getPnT() {
		return pnT;
	}

	public void setPnT(TextField pnT) {
		this.pnT = pnT;
	}

	public HBox getPnH() {
		return pnH;
	}

	public void setPnH(HBox pnH) {
		this.pnH = pnH;
	}

	public Label geteL() {
		return eL;
	}

	public void seteL(Label eL) {
		this.eL = eL;
	}

	public TextField geteT() {
		return eT;
	}

	public void seteT(TextField eT) {
		this.eT = eT;
	}

	public HBox geteH() {
		return eH;
	}

	public void seteH(HBox eH) {
		this.eH = eH;
	}

	public Label getAddL() {
		return addL;
	}

	public void setAddL(Label addL) {
		this.addL = addL;
	}

	public TextField getAddT() {
		return addT;
	}

	public void setAddT(TextField addT) {
		this.addT = addT;
	}

	public HBox getAddH() {
		return addH;
	}

	public void setAddH(HBox addH) {
		this.addH = addH;
	}

	public Label getDobL() {
		return dobL;
	}

	public void setDobL(Label dobL) {
		this.dobL = dobL;
	}

	public DatePicker getDobP() {
		return dobP;
	}

	public void setDobP(DatePicker dobP) {
		this.dobP = dobP;
	}

	public HBox getDobH() {
		return dobH;
	}

	public void setDobH(HBox dobH) {
		this.dobH = dobH;
	}

	public Label getGenderL() {
		return genderL;
	}

	public void setGenderL(Label genderL) {
		this.genderL = genderL;
	}

	public ComboBox<String> getGenderC() {
		return genderC;
	}

	public void setGenderC(ComboBox<String> genderC) {
		this.genderC = genderC;
	}

	public HBox getGenderH() {
		return genderH;
	}

	public void setGenderH(HBox genderH) {
		this.genderH = genderH;
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
