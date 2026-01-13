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

public class AddCategory {
	private Label addc=new Label("Add Category");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label cIDL=new Label(" Category ID :");
	private TextField cIDT=new TextField();
	private HBox cIDH=new HBox();
	
	private Label fNL=new Label("Category Name :");
	private TextField fNT=new TextField();
	private HBox fNH=new HBox();
	
	private Label dbL=new Label("Ddescription :");
	private TextField db=new TextField();
	private HBox dbH=new HBox();
	
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
	
	public AddCategory() {
		cIDH.getChildren().addAll(cIDL,cIDT);
		cIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		cIDH.setAlignment(Pos.CENTER);
		cIDH.setSpacing(20);
		fNH.getChildren().addAll(fNL,fNT);
		fNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		fNH.setAlignment(Pos.CENTER);
		fNH.setSpacing(20);
		dbH.getChildren().addAll(dbL,db);
		dbL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		dbH.setAlignment(Pos.CENTER);
		dbH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addc,cIDH,fNH,dbH,buttons);
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

	protected TextField getDb() {
		return db;
	}

	protected void setDb(TextField db) {
		this.db = db;
	}

	protected HBox getDbH() {
		return dbH;
	}

	protected void setDbH(HBox dbH) {
		this.dbH = dbH;
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
