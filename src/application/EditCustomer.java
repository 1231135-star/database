package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditCustomer {
	private Label addc=new Label("Add Customer");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label cIDL=new Label(" Customer ID :");
	private TextField cIDT=new TextField();
	private HBox cIDH=new HBox();
	
	private Label fNL=new Label("Full Name :");
	private TextField fNT=new TextField();
	private HBox fNH=new HBox();
	
	private Label dbL=new Label("Date of Birth :");
	private DatePicker db=new DatePicker();
	private HBox dbH=new HBox();

	private Label pNL=new Label("Phone Number :");
	private TextField pNT=new TextField();
	private HBox pNH=new HBox();
	
	private Label emL=new Label("Email Address :");
	private TextField emT=new TextField();
	private HBox emH=new HBox();
	
	private Label addL=new Label("Address :");
	private TextField addT=new TextField();
	private HBox addH=new HBox();
	
	private Label genL=new Label("Gender :");
	private ComboBox<String> genT=new ComboBox<String>();
	private HBox genH=new HBox();
	
	
	private Image addM=new Image("icons8-add-100(1).png");
	private ImageView addVM=new ImageView(addM);
	private Button add=new Button("Add",addVM);
	
	private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	
	private Image clearM=new Image("icons8-clear-100(1).png");
	private ImageView clearVM=new ImageView(clearM);
	private Button clear=new Button("clear",clearVM);
	
	private HBox buttons=new HBox();
	private VBox all=new VBox();
	
	public EditCustomer(){
			cIDH.getChildren().addAll(cIDL,cIDT);
			cIDT.setEditable(false);
			cIDT.setVisible(true);
			cIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			cIDH.setAlignment(Pos.CENTER);
			cIDH.setSpacing(20);
			fNH.getChildren().addAll(fNL,fNT);
			fNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			fNH.setAlignment(Pos.CENTER);
			fNH.setSpacing(20);
			addH.getChildren().addAll(addL,addT);
			addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			addH.setAlignment(Pos.CENTER);
			addH.setSpacing(20);
			dbH.getChildren().addAll(dbL,db);
			dbL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			dbH.setAlignment(Pos.CENTER);
			dbH.setSpacing(20);
			genT.getItems().addAll("male","Female");
			genT.getSelectionModel().select("male");
			genH.getChildren().addAll(genL,genT);
			genL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			genH.setAlignment(Pos.CENTER);
			genH.setSpacing(20);
			pNH.getChildren().addAll(pNL,pNT);
			pNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			pNH.setAlignment(Pos.CENTER);
			pNH.setSpacing(20);
			emH.getChildren().addAll(emL,emT);
			emL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			emH.setAlignment(Pos.CENTER);
			emH.setSpacing(20);
			buttons.getChildren().addAll(add,back,clear);
			buttons.setAlignment(Pos.CENTER);
			buttons.setSpacing(20);
			clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
			back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
			add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
			all.getChildren().addAll(addc,cIDH,fNH,addH,dbH,pNH,emH,genH,buttons);
			addc.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
			all.setAlignment(Pos.CENTER);
			all.setSpacing(20);
			all.setStyle("-fx-background-color: #a2c4c9;");
	}

	protected Label getAddc() {
		return addc;
	}

	protected void setAddc(Label addc) {
		this.addc = addc;
	}

	protected Image getPh() {
		return ph;
	}

	protected void setPh(Image ph) {
		this.ph = ph;
	}

	protected ImageView getPhVM() {
		return phVM;
	}

	protected void setPhVM(ImageView phVM) {
		this.phVM = phVM;
	}

	protected Label getcIDL() {
		return cIDL;
	}

	protected void setcIDL(Label cIDL) {
		this.cIDL = cIDL;
	}

	protected TextField getcIDT() {
		return cIDT;
	}

	protected void setcIDT(TextField cIDT) {
		this.cIDT = cIDT;
	}

	protected HBox getcIDH() {
		return cIDH;
	}

	protected void setcIDH(HBox cIDH) {
		this.cIDH = cIDH;
	}

	protected Label getfNL() {
		return fNL;
	}

	protected void setfNL(Label fNL) {
		this.fNL = fNL;
	}

	protected TextField getfNT() {
		return fNT;
	}

	protected void setfNT(TextField fNT) {
		this.fNT = fNT;
	}

	protected HBox getfNH() {
		return fNH;
	}

	protected void setfNH(HBox fNH) {
		this.fNH = fNH;
	}

	protected Label getDbL() {
		return dbL;
	}

	protected void setDbL(Label dbL) {
		this.dbL = dbL;
	}

	protected DatePicker getDb() {
		return db;
	}

	protected void setDb(DatePicker db) {
		this.db = db;
	}

	protected HBox getDbH() {
		return dbH;
	}

	protected void setDbH(HBox dbH) {
		this.dbH = dbH;
	}

	protected Label getpNL() {
		return pNL;
	}

	protected void setpNL(Label pNL) {
		this.pNL = pNL;
	}

	protected TextField getpNT() {
		return pNT;
	}

	protected void setpNT(TextField pNT) {
		this.pNT = pNT;
	}

	protected HBox getpNH() {
		return pNH;
	}

	protected void setpNH(HBox pNH) {
		this.pNH = pNH;
	}

	protected Label getEmL() {
		return emL;
	}

	protected void setEmL(Label emL) {
		this.emL = emL;
	}

	protected TextField getEmT() {
		return emT;
	}

	protected void setEmT(TextField emT) {
		this.emT = emT;
	}

	protected HBox getEmH() {
		return emH;
	}

	protected void setEmH(HBox emH) {
		this.emH = emH;
	}

	protected Label getAddL() {
		return addL;
	}

	protected void setAddL(Label addL) {
		this.addL = addL;
	}

	protected TextField getAddT() {
		return addT;
	}

	protected void setAddT(TextField addT) {
		this.addT = addT;
	}

	protected HBox getAddH() {
		return addH;
	}

	protected void setAddH(HBox addH) {
		this.addH = addH;
	}

	protected Label getGenL() {
		return genL;
	}

	protected void setGenL(Label genL) {
		this.genL = genL;
	}

	protected ComboBox<String> getGenT() {
		return genT;
	}

	protected void setGenT(ComboBox<String> genT) {
		this.genT = genT;
	}

	protected HBox getGenH() {
		return genH;
	}

	protected void setGenH(HBox genH) {
		this.genH = genH;
	}

	protected Image getAddM() {
		return addM;
	}

	protected void setAddM(Image addM) {
		this.addM = addM;
	}

	protected ImageView getAddVM() {
		return addVM;
	}

	protected void setAddVM(ImageView addVM) {
		this.addVM = addVM;
	}

	protected Button getAdd() {
		return add;
	}

	protected void setAdd(Button add) {
		this.add = add;
	}

	protected Image getBackM() {
		return backM;
	}

	protected void setBackM(Image backM) {
		this.backM = backM;
	}

	protected ImageView getBackVM() {
		return backVM;
	}

	protected void setBackVM(ImageView backVM) {
		this.backVM = backVM;
	}

	protected Button getBack() {
		return back;
	}

	protected void setBack(Button back) {
		this.back = back;
	}

	protected Image getClearM() {
		return clearM;
	}

	protected void setClearM(Image clearM) {
		this.clearM = clearM;
	}

	protected ImageView getClearVM() {
		return clearVM;
	}

	protected void setClearVM(ImageView clearVM) {
		this.clearVM = clearVM;
	}

	protected Button getClear() {
		return clear;
	}

	protected void setClear(Button clear) {
		this.clear = clear;
	}

	protected HBox getButtons() {
		return buttons;
	}

	protected void setButtons(HBox buttons) {
		this.buttons = buttons;
	}

	protected VBox getAll() {
		return all;
	}

	protected void setAll(VBox all) {
		this.all = all;
	}
	
}
