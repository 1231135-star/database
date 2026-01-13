package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddSupplier {
	private Label addSup=new Label("Add Supplier");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label sIDL=new Label("Supplier ID :");
	private TextField sIDT=new TextField();
	private HBox sIDH=new HBox();
	
	private Label sNL=new Label("Supplier Name :");
	private TextField sNT=new TextField();
	private HBox sNH=new HBox();
	
	private Label lN=new Label("Licensed Number :");
	private TextField lNT=new TextField();
	private HBox lNH=new HBox();

	private Label phN=new Label("Phone Number :");
	private TextField phNT=new TextField();
	private HBox phNH=new HBox();
	
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
	
	public AddSupplier() {
		sIDH.getChildren().addAll(sIDL,sIDT);
		sIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		sIDH.setAlignment(Pos.CENTER);
		sIDH.setSpacing(20);
		sNH.getChildren().addAll(sNL,sNT);
		sNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		sNH.setAlignment(Pos.CENTER);
		sNH.setSpacing(20);
		addH.getChildren().addAll(addL,addT);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);
		lNH.getChildren().addAll(lN,lNT);
		lN.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		lNH.setAlignment(Pos.CENTER);
		lNH.setSpacing(20);
		
		phNH.getChildren().addAll(phN,phNT);
		phN.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		phNH.setAlignment(Pos.CENTER);
		phNH.setSpacing(20);
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
		all.getChildren().addAll(addSup,sIDH,sNH,addH,lNH,phNH,emH,buttons);
		addSup.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddSup() {
		return addSup;
	}

	public void setAddSup(Label addSup) {
		this.addSup = addSup;
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

	public Label getsIDL() {
		return sIDL;
	}

	public void setsIDL(Label sIDL) {
		this.sIDL = sIDL;
	}

	public TextField getsIDT() {
		return sIDT;
	}

	public void setsIDT(TextField sIDT) {
		this.sIDT = sIDT;
	}

	public HBox getsIDH() {
		return sIDH;
	}

	public void setsIDH(HBox sIDH) {
		this.sIDH = sIDH;
	}

	public Label getsNL() {
		return sNL;
	}

	public void setsNL(Label sNL) {
		this.sNL = sNL;
	}

	public TextField getsNT() {
		return sNT;
	}

	public void setsNT(TextField sNT) {
		this.sNT = sNT;
	}

	public HBox getsNH() {
		return sNH;
	}

	public void setsNH(HBox sNH) {
		this.sNH = sNH;
	}

	public Label getlN() {
		return lN;
	}

	public void setlN(Label lN) {
		this.lN = lN;
	}

	public TextField getlNT() {
		return lNT;
	}

	public void setlNT(TextField lNT) {
		this.lNT = lNT;
	}

	public HBox getlNH() {
		return lNH;
	}

	public void setlNH(HBox lNH) {
		this.lNH = lNH;
	}

	public Label getPhN() {
		return phN;
	}

	public void setPhN(Label phN) {
		this.phN = phN;
	}

	public TextField getPhNT() {
		return phNT;
	}

	public void setPhNT(TextField phNT) {
		this.phNT = phNT;
	}

	public HBox getPhNH() {
		return phNH;
	}

	public void setPhNH(HBox phNH) {
		this.phNH = phNH;
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
