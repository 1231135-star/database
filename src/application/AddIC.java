package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddIC {
	private Label addIP=new Label("Add Inssurance Company");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label cIDL=new Label("Inssurance Company ID :");
	private TextField cIDT=new TextField();
	private HBox cIDH=new HBox();
	
	private Label cNL=new Label("Company Name :");
	private TextField cNT=new TextField();
	private HBox cNH=new HBox();
	
	private Label LCN=new Label("Licend Number :");
	private TextField LCNT=new TextField();
	private HBox LCNH=new HBox();

	private Label pN=new Label("Phone Number :");
	private TextField pNT=new TextField();
	private HBox pNH=new HBox();
	
	private Label emL=new Label("Email Address :");
	private TextField emT=new TextField();
	private HBox emH=new HBox();
	
	private Label addL=new Label("Address :");
	private TextField addT=new TextField();
	private HBox addH=new HBox();
	
	
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
	
	public AddIC() {
		cIDH.getChildren().addAll(cIDL,cIDT);
		cIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		cIDH.setAlignment(Pos.CENTER);
		cIDH.setSpacing(20);
		cNH.getChildren().addAll(cNL,cNT);
		cNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		cNH.setAlignment(Pos.CENTER);
		cNH.setSpacing(20);
		addH.getChildren().addAll(addL,addT);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);
		LCNH.getChildren().addAll(LCN,LCNT);
		LCN.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		LCNH.setAlignment(Pos.CENTER);
		LCNH.setSpacing(20);
		
		pNH.getChildren().addAll(pN,pNT);
		pN.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
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
		all.getChildren().addAll(addIP,cIDH,cNH,addH,LCNH,pNH,emH,buttons);
		addIP.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	protected Label getAddIP() {
		return addIP;
	}

	protected void setAddIP(Label addIP) {
		this.addIP = addIP;
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

	protected Label getcNL() {
		return cNL;
	}

	protected void setcNL(Label cNL) {
		this.cNL = cNL;
	}

	protected TextField getcNT() {
		return cNT;
	}

	protected void setcNT(TextField cNT) {
		this.cNT = cNT;
	}

	protected HBox getcNH() {
		return cNH;
	}

	protected void setcNH(HBox cNH) {
		this.cNH = cNH;
	}

	protected Label getLCN() {
		return LCN;
	}

	protected void setLCN(Label lCN) {
		LCN = lCN;
	}

	protected TextField getLCNT() {
		return LCNT;
	}

	protected void setLCNT(TextField lCNT) {
		LCNT = lCNT;
	}

	protected HBox getLCNH() {
		return LCNH;
	}

	protected void setLCNH(HBox lCNH) {
		LCNH = lCNH;
	}

	protected Label getpN() {
		return pN;
	}

	protected void setpN(Label pN) {
		this.pN = pN;
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
