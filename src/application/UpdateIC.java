package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UpdateIC {
	private Label addIP=new Label("Update Inssurance Company");
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
	
	
	private Image editM=new Image("icons8-edit-property-100.png");
	private ImageView editVM=new ImageView(editM);
	private Button edit=new Button("edit",editVM);
	
	private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	
	private Image clearM=new Image("icons8-clear-100(1).png");
	private ImageView clearVM=new ImageView(clearM);
	private Button clear=new Button("clear",clearVM);
	
	private HBox buttons=new HBox();
	private VBox all=new VBox();
	
	public UpdateIC() {
		cIDH.getChildren().addAll(cIDL,cIDT);
		cIDT.setEditable(false);
		cIDT.setVisible(true);
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
		buttons.getChildren().addAll(edit,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addIP,cIDH,cNH,addH,LCNH,pNH,emH,buttons);
		addIP.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddIP() {
		return addIP;
	}

	public void setAddIP(Label addIP) {
		this.addIP = addIP;
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

	public Label getcIDL() {
		return cIDL;
	}

	public void setcIDL(Label cIDL) {
		this.cIDL = cIDL;
	}

	public TextField getcIDT() {
		return cIDT;
	}

	public void setcIDT(TextField cIDT) {
		this.cIDT = cIDT;
	}

	public HBox getcIDH() {
		return cIDH;
	}

	public void setcIDH(HBox cIDH) {
		this.cIDH = cIDH;
	}

	public Label getcNL() {
		return cNL;
	}

	public void setcNL(Label cNL) {
		this.cNL = cNL;
	}

	public TextField getcNT() {
		return cNT;
	}

	public void setcNT(TextField cNT) {
		this.cNT = cNT;
	}

	public HBox getcNH() {
		return cNH;
	}

	public void setcNH(HBox cNH) {
		this.cNH = cNH;
	}

	public Label getLCN() {
		return LCN;
	}

	public void setLCN(Label lCN) {
		LCN = lCN;
	}

	public TextField getLCNT() {
		return LCNT;
	}

	public void setLCNT(TextField lCNT) {
		LCNT = lCNT;
	}

	public HBox getLCNH() {
		return LCNH;
	}

	public void setLCNH(HBox lCNH) {
		LCNH = lCNH;
	}

	public Label getpN() {
		return pN;
	}

	public void setpN(Label pN) {
		this.pN = pN;
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
