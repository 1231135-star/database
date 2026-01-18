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

public class UpdateDoctor {

    private Label editDoc = new Label("Edit Doctor");

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    private Label docIDL = new Label("Doctor ID :");
    private TextField docIDT = new TextField();
    private HBox docIDH = new HBox();

    private Label docNL = new Label("Doctor Full Name :");
    private TextField docNT = new TextField();
    private HBox docNH = new HBox();

    private Label licL = new Label("License Number :");
    private TextField licT = new TextField();
    private HBox licH = new HBox();


    private Label pnL = new Label("Phone Number :");
    private TextField pnT = new TextField();
    private HBox pnH = new HBox();

    private Label eL = new Label("Email Address :");
    private TextField eT = new TextField();
    private HBox eH = new HBox();

    private Label caL = new Label("Clinic Address :");
    private TextField caT = new TextField();
    private HBox caH = new HBox();

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

    public UpdateDoctor() {

        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));
        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        docIDH.getChildren().addAll(docIDL, docIDT);
        docIDT.setEditable(false);

        docNH.getChildren().addAll(docNL, docNT);
        licH.getChildren().addAll(licL, licT);
        licT.setEditable(false);
        pnH.getChildren().addAll(pnL, pnT);
        eH.getChildren().addAll(eL, eT);
        caH.getChildren().addAll(caL, caT);

        docIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        docIDH.setAlignment(Pos.CENTER);
        docIDH.setSpacing(20);

        docNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        docNH.setAlignment(Pos.CENTER);
        docNH.setSpacing(20);
        
        licL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        licH.setAlignment(Pos.CENTER);
        licH.setSpacing(20);
        
        pnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        pnH.setAlignment(Pos.CENTER);
        pnH.setSpacing(20);
        
        eL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        eH.setAlignment(Pos.CENTER);
        eH.setSpacing(20);
        
        caL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        caH.setAlignment(Pos.CENTER);
        caH.setSpacing(20);
        

        buttons.getChildren().addAll(edit, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        
        
        edit.setDisable(true);

        all.getChildren().addAll(editDoc, searchH, docIDH, docNH, licH, pnH, eH, caH, buttons);
        editDoc.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
        all.setAlignment(Pos.CENTER);
        all.setSpacing(15);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getEditDoc() {
		return editDoc;
	}

	public void setEditDoc(Label editDoc) {
		this.editDoc = editDoc;
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

	public Label getDocIDL() {
		return docIDL;
	}

	public void setDocIDL(Label docIDL) {
		this.docIDL = docIDL;
	}

	public TextField getDocIDT() {
		return docIDT;
	}

	public void setDocIDT(TextField docIDT) {
		this.docIDT = docIDT;
	}

	public HBox getDocIDH() {
		return docIDH;
	}

	public void setDocIDH(HBox docIDH) {
		this.docIDH = docIDH;
	}

	public Label getDocNL() {
		return docNL;
	}

	public void setDocNL(Label docNL) {
		this.docNL = docNL;
	}

	public TextField getDocNT() {
		return docNT;
	}

	public void setDocNT(TextField docNT) {
		this.docNT = docNT;
	}

	public HBox getDocNH() {
		return docNH;
	}

	public void setDocNH(HBox docNH) {
		this.docNH = docNH;
	}


	public Label getLicL() {
		return licL;
	}

	public void setLicL(Label licL) {
		this.licL = licL;
	}

	public TextField getLicT() {
		return licT;
	}

	public void setLicT(TextField licT) {
		this.licT = licT;
	}

	public HBox getLicH() {
		return licH;
	}

	public void setLicH(HBox licH) {
		this.licH = licH;
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

	public Label getCaL() {
		return caL;
	}

	public void setCaL(Label caL) {
		this.caL = caL;
	}

	public TextField getCaT() {
		return caT;
	}

	public void setCaT(TextField caT) {
		this.caT = caT;
	}

	public HBox getCaH() {
		return caH;
	}

	public void setCaH(HBox caH) {
		this.caH = caH;
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
