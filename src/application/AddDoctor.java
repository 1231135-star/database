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

public class AddDoctor {
	private Label addc=new Label("Add Doctor");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label dIDL=new Label(" Doctor ID :");
	private TextField dIDT=new TextField();
	private HBox dIDH=new HBox();
	
	private Label fNL=new Label("Full Name :");
	private TextField fNT=new TextField();
	private HBox fNH=new HBox();
	
	private Label LNL=new Label("License Number :");
	private TextField LN=new TextField();
	private HBox LNH=new HBox();

	private Label pNL=new Label("Phone Number :");
	private TextField pNT=new TextField();
	private HBox pNH=new HBox();
	
	private Label emL=new Label("Email Address :");
	private TextField emT=new TextField();
	private HBox emH=new HBox();
	
	private Label addL=new Label("Clinic Address :");
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
	
	public AddDoctor() {
		dIDH.getChildren().addAll(dIDL,dIDT);
		dIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		dIDH.setAlignment(Pos.CENTER);
		dIDH.setSpacing(20);
		fNH.getChildren().addAll(fNL,fNT);
		fNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		fNH.setAlignment(Pos.CENTER);
		fNH.setSpacing(20);
		addH.getChildren().addAll(addL,addT);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);
		LNH.getChildren().addAll(LNL,LN);
		LNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		LNH.setAlignment(Pos.CENTER);
		LNH.setSpacing(20);
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
		all.getChildren().addAll(addc,dIDH,fNH,addH,LNH,pNH,emH,buttons);
		addc.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddc() {
		return addc;
	}

	public void setAddc(Label addc) {
		this.addc = addc;
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

	public Label getdIDL() {
		return dIDL;
	}

	public void setdIDL(Label dIDL) {
		this.dIDL = dIDL;
	}

	public TextField getdIDT() {
		return dIDT;
	}

	public void setdIDT(TextField dIDT) {
		this.dIDT = dIDT;
	}

	public HBox getdIDH() {
		return dIDH;
	}

	public void setdIDH(HBox dIDH) {
		this.dIDH = dIDH;
	}

	public Label getfNL() {
		return fNL;
	}

	public void setfNL(Label fNL) {
		this.fNL = fNL;
	}

	public TextField getfNT() {
		return fNT;
	}

	public void setfNT(TextField fNT) {
		this.fNT = fNT;
	}

	public HBox getfNH() {
		return fNH;
	}

	public void setfNH(HBox fNH) {
		this.fNH = fNH;
	}

	public Label getLNL() {
		return LNL;
	}

	public void setLNL(Label lNL) {
		LNL = lNL;
	}

	public TextField getLN() {
		return LN;
	}

	public void setLN(TextField lN) {
		LN = lN;
	}

	public HBox getLNH() {
		return LNH;
	}

	public void setLNH(HBox lNH) {
		LNH = lNH;
	}

	public Label getpNL() {
		return pNL;
	}

	public void setpNL(Label pNL) {
		this.pNL = pNL;
	}

	public TextField getpNT() {
		return pNT;
	}

	public void setpNT(TextField pNT) {
		this.pNT = pNT;
	}

	public HBox getpNH() {
		return pNH;
	}

	public void setpNH(HBox pNH) {
		this.pNH = pNH;
	}

	public Label getEmL() {
		return emL;
	}

	public void setEmL(Label emL) {
		this.emL = emL;
	}

	public TextField getEmT() {
		return emT;
	}

	public void setEmT(TextField emT) {
		this.emT = emT;
	}

	public HBox getEmH() {
		return emH;
	}

	public void setEmH(HBox emH) {
		this.emH = emH;
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
