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

public class UpdateInvoiceItem {
	private Label addEmp=new Label("Add Invoice Item");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label invL=new Label("Invoice ID :");
	private TextField invT=new TextField();
	private HBox invH=new HBox();
	
	private Label invTL=new Label("Invntory ID :");
	private TextField invTT=new TextField();
	private HBox invTH=new HBox();
	
	private Label quanL=new Label("Quantity :");
	private DatePicker quanT=new DatePicker();
	private HBox quanH=new HBox();
	
	private Label upriL=new Label("Unit Price :");
	private TextField upriT=new TextField();
	private HBox upriH=new HBox();
	
	private Label lineTotL=new Label("Line Total :");
	private TextField lineTotT=new TextField();
	private HBox lineTotH=new HBox();

	
	
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
	
	public UpdateInvoiceItem(){
		invH.getChildren().addAll(invL,invT);
		invT.setEditable(false);
		invT.setVisible(true);
		invL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invH.setAlignment(Pos.CENTER);
		invH.setSpacing(20);
		invTH.getChildren().addAll(invTL,invTT);
		invTL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invTH.setAlignment(Pos.CENTER);
		invTH.setSpacing(20);
		quanH.getChildren().addAll(quanL,quanT);
		quanL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		quanH.setAlignment(Pos.CENTER);
		quanH.setSpacing(20);
		upriH.getChildren().addAll(upriL,upriT);
		upriL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		upriH.setAlignment(Pos.CENTER);
		upriH.setSpacing(20);
		lineTotH.getChildren().addAll(lineTotL,lineTotT);
		lineTotL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		lineTotH.setAlignment(Pos.CENTER);
		lineTotH.setSpacing(20);
		buttons.getChildren().addAll(edit,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addEmp,invH,invTH,quanH,upriH,lineTotH,buttons);
		addEmp.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");

	}

	public Label getAddEmp() {
		return addEmp;
	}

	public void setAddEmp(Label addEmp) {
		this.addEmp = addEmp;
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

	public Label getInvL() {
		return invL;
	}

	public void setInvL(Label invL) {
		this.invL = invL;
	}

	public TextField getInvT() {
		return invT;
	}

	public void setInvT(TextField invT) {
		this.invT = invT;
	}

	public HBox getInvH() {
		return invH;
	}

	public void setInvH(HBox invH) {
		this.invH = invH;
	}

	public Label getInvTL() {
		return invTL;
	}

	public void setInvTL(Label invTL) {
		this.invTL = invTL;
	}

	public TextField getInvTT() {
		return invTT;
	}

	public void setInvTT(TextField invTT) {
		this.invTT = invTT;
	}

	public HBox getInvTH() {
		return invTH;
	}

	public void setInvTH(HBox invTH) {
		this.invTH = invTH;
	}

	public Label getQuanL() {
		return quanL;
	}

	public void setQuanL(Label quanL) {
		this.quanL = quanL;
	}

	public DatePicker getQuanT() {
		return quanT;
	}

	public void setQuanT(DatePicker quanT) {
		this.quanT = quanT;
	}

	public HBox getQuanH() {
		return quanH;
	}

	public void setQuanH(HBox quanH) {
		this.quanH = quanH;
	}

	public Label getUpriL() {
		return upriL;
	}

	public void setUpriL(Label upriL) {
		this.upriL = upriL;
	}

	public TextField getUpriT() {
		return upriT;
	}

	public void setUpriT(TextField upriT) {
		this.upriT = upriT;
	}

	public HBox getUpriH() {
		return upriH;
	}

	public void setUpriH(HBox upriH) {
		this.upriH = upriH;
	}

	public Label getLineTotL() {
		return lineTotL;
	}

	public void setLineTotL(Label lineTotL) {
		this.lineTotL = lineTotL;
	}

	public TextField getLineTotT() {
		return lineTotT;
	}

	public void setLineTotT(TextField lineTotT) {
		this.lineTotT = lineTotT;
	}

	public HBox getLineTotH() {
		return lineTotH;
	}

	public void setLineTotH(HBox lineTotH) {
		this.lineTotH = lineTotH;
	}


	public Button getEdit() {
		return edit;
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
