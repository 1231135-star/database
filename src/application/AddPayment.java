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

public class AddPayment {
	private Label addp=new Label("Add Payment");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label payIDL=new Label("Payment ID :");
	private TextField payIDT=new TextField();
	private HBox payIDH=new HBox();
	
	private Label payNL=new Label("Payment Name :");
	private TextField payNT=new TextField();
	private HBox payNH=new HBox();
	
	private Label ptL=new Label("Payment Type :");
	private TextField pt=new TextField();
	private HBox ptH=new HBox();

	private Label amL=new Label("Amount :");
	private TextField amT=new TextField();
	private HBox amH=new HBox();
	
	private Label refNL=new Label("Reference Number :");
	private TextField refNT=new TextField();
	private HBox refNH=new HBox();
	
	private Label invIDL=new Label("Invoice ID :");
	private TextField invIDT=new TextField();
	private HBox invIDH=new HBox();
	
	private Label insL=new Label("Gender :");
	private TextField insT=new TextField();
	private HBox insH=new HBox();
	
	
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
	
	public AddPayment() {
		payIDH.getChildren().addAll(payIDL,payIDT);
		payIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		payIDH.setAlignment(Pos.CENTER);
		payIDH.setSpacing(20);
		payNH.getChildren().addAll(payNL,payNT);
		payNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		payNH.setAlignment(Pos.CENTER);
		payNH.setSpacing(20);
		invIDH.getChildren().addAll(invIDL,invIDT);
		invIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invIDH.setAlignment(Pos.CENTER);
		invIDH.setSpacing(20);
		ptH.getChildren().addAll(ptL,pt);
		ptL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		ptH.setAlignment(Pos.CENTER);
		ptH.setSpacing(20);
		insH.getChildren().addAll(insL,insT);
		insL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		insH.setAlignment(Pos.CENTER);
		insH.setSpacing(20);
		amH.getChildren().addAll(amL,amT);
		amL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		amH.setAlignment(Pos.CENTER);
		amH.setSpacing(20);
		refNH.getChildren().addAll(refNL,refNT);
		refNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		refNH.setAlignment(Pos.CENTER);
		refNH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addp,payIDH,payNH,invIDH,ptH,amH,refNH,insH,buttons);
		addp.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddp() {
		return addp;
	}

	public void setAddp(Label addp) {
		this.addp = addp;
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

	public Label getPayIDL() {
		return payIDL;
	}

	public void setPayIDL(Label payIDL) {
		this.payIDL = payIDL;
	}

	public TextField getPayIDT() {
		return payIDT;
	}

	public void setPayIDT(TextField payIDT) {
		this.payIDT = payIDT;
	}

	public HBox getPayIDH() {
		return payIDH;
	}

	public void setPayIDH(HBox payIDH) {
		this.payIDH = payIDH;
	}

	public Label getPayNL() {
		return payNL;
	}

	public void setPayNL(Label payNL) {
		this.payNL = payNL;
	}

	public TextField getPayNT() {
		return payNT;
	}

	public void setPayNT(TextField payNT) {
		this.payNT = payNT;
	}

	public HBox getPayNH() {
		return payNH;
	}

	public void setPayNH(HBox payNH) {
		this.payNH = payNH;
	}

	public Label getPtL() {
		return ptL;
	}

	public void setPtL(Label ptL) {
		this.ptL = ptL;
	}



	public HBox getPtH() {
		return ptH;
	}

	public void setPtH(HBox ptH) {
		this.ptH = ptH;
	}

	public Label getAmL() {
		return amL;
	}

	public void setAmL(Label amL) {
		this.amL = amL;
	}

	public TextField getAmT() {
		return amT;
	}

	public void setAmT(TextField amT) {
		this.amT = amT;
	}

	public HBox getAmH() {
		return amH;
	}

	public void setAmH(HBox amH) {
		this.amH = amH;
	}

	public Label getRefNL() {
		return refNL;
	}

	public void setRefNL(Label refNL) {
		this.refNL = refNL;
	}

	public TextField getRefNT() {
		return refNT;
	}

	public void setRefNT(TextField refNT) {
		this.refNT = refNT;
	}

	public HBox getRefNH() {
		return refNH;
	}

	public void setRefNH(HBox refNH) {
		this.refNH = refNH;
	}

	public Label getInvIDL() {
		return invIDL;
	}

	public void setInvIDL(Label invIDL) {
		this.invIDL = invIDL;
	}

	public TextField getInvIDT() {
		return invIDT;
	}

	public void setInvIDT(TextField invIDT) {
		this.invIDT = invIDT;
	}

	public HBox getInvIDH() {
		return invIDH;
	}

	public void setInvIDH(HBox invIDH) {
		this.invIDH = invIDH;
	}

	public Label getInsL() {
		return insL;
	}

	public void setInsL(Label insL) {
		this.insL = insL;
	}


	public TextField getPt() {
		return pt;
	}

	public void setPt(TextField pt) {
		this.pt = pt;
	}

	public TextField getInsT() {
		return insT;
	}

	public void setInsT(TextField insT) {
		this.insT = insT;
	}

	public HBox getInsH() {
		return insH;
	}

	public void setInsH(HBox insH) {
		this.insH = insH;
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
