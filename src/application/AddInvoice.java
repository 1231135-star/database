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

public class AddInvoice {
	private Label addEmp=new Label("Add Invoice");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label invL=new Label("Invoice ID :");
	private TextField invT=new TextField();
	private HBox invH=new HBox();
	
	private Label invTL=new Label("Invoice Time :");
	private TextField invTT=new TextField();
	private HBox invTH=new HBox();
	
	private Label invDL=new Label("Invoice Date :");
	private DatePicker invDT=new DatePicker();
	private HBox invDH=new HBox();
	
	private Label sbTotL=new Label("Sub Total :");
	private TextField sbTotT=new TextField();
	private HBox sbTotH=new HBox();
	
	private Label dicustL=new Label("Discount :");
	private TextField dicustT=new TextField();
	private HBox dicustH=new HBox();

	private Label taxL=new Label("Tax :");
	private TextField taxT=new TextField();
	private HBox taxH=new HBox();
	
	private Label totAL=new Label("Total Amount :");
	private TextField totAT=new TextField();
	private HBox totAH=new HBox();
	
	private Label payL=new Label("Payment Status :");
	private TextField payT=new TextField();
	private HBox payH=new HBox();
	
	private Label custL=new Label("Customer ID :");
	private TextField custT=new TextField();
	private HBox custH=new HBox();
	
	private Label empL=new Label("Employee ID :");
	private TextField empT=new TextField();
	private HBox empH=new HBox();
	
	private Label bidL=new Label("Branch ID :");
	private TextField bidT=new TextField();
	private HBox bidH=new HBox();
	
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
	
	public AddInvoice(){
		invH.getChildren().addAll(invL,invT);
		invL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invH.setAlignment(Pos.CENTER);
		invH.setSpacing(20);
		invTH.getChildren().addAll(invTL,invTT);
		invTL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invTH.setAlignment(Pos.CENTER);
		invTH.setSpacing(20);
		invDH.getChildren().addAll(invDL,invDT);
		invDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invDH.setAlignment(Pos.CENTER);
		invDH.setSpacing(20);
		sbTotH.getChildren().addAll(sbTotL,sbTotT);
		sbTotL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		sbTotH.setAlignment(Pos.CENTER);
		sbTotH.setSpacing(20);
		dicustH.getChildren().addAll(dicustL,dicustT);
		dicustL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		dicustH.setAlignment(Pos.CENTER);
		dicustH.setSpacing(20);
		taxH.getChildren().addAll(taxL,taxT);
		taxL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		taxH.setAlignment(Pos.CENTER);
		taxH.setSpacing(20);
		totAH.getChildren().addAll(totAL,totAT);
		totAL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		totAH.setAlignment(Pos.CENTER);
		totAH.setSpacing(20);
		payH.getChildren().addAll(payL,payT);
		payL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		payH.setAlignment(Pos.CENTER);
		payH.setSpacing(20);
		custH.getChildren().addAll(custL,custT);
		custL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		custH.setAlignment(Pos.CENTER);
		custH.setSpacing(20);
		empH.getChildren().addAll(empL,empT);
		empL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		empH.setAlignment(Pos.CENTER);
		empH.setSpacing(20);
		bidH.getChildren().addAll(bidL,bidT);
		bidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bidH.setAlignment(Pos.CENTER);
		bidH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addEmp,invH,invTH,invDH,sbTotH,dicustH,taxH,totAH,payH,empH,custH,bidH,buttons);
		addEmp.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");

	}

	protected Label getAddEmp() {
		return addEmp;
	}

	protected void setAddEmp(Label addEmp) {
		this.addEmp = addEmp;
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

	protected Label getInvL() {
		return invL;
	}

	protected void setInvL(Label invL) {
		this.invL = invL;
	}

	protected TextField getInvT() {
		return invT;
	}

	protected void setInvT(TextField invT) {
		this.invT = invT;
	}

	protected HBox getInvH() {
		return invH;
	}

	protected void setInvH(HBox invH) {
		this.invH = invH;
	}

	protected Label getInvTL() {
		return invTL;
	}

	protected void setInvTL(Label invTL) {
		this.invTL = invTL;
	}

	protected TextField getInvTT() {
		return invTT;
	}

	protected void setInvTT(TextField invTT) {
		this.invTT = invTT;
	}

	protected HBox getInvTH() {
		return invTH;
	}

	protected void setInvTH(HBox invTH) {
		this.invTH = invTH;
	}

	protected Label getInvDL() {
		return invDL;
	}

	protected void setInvDL(Label invDL) {
		this.invDL = invDL;
	}

	protected DatePicker getInvDT() {
		return invDT;
	}

	protected void setInvDT(DatePicker invDT) {
		this.invDT = invDT;
	}

	protected HBox getInvDH() {
		return invDH;
	}

	protected void setInvDH(HBox invDH) {
		this.invDH = invDH;
	}

	protected Label getSbTotL() {
		return sbTotL;
	}

	protected void setSbTotL(Label sbTotL) {
		this.sbTotL = sbTotL;
	}

	protected TextField getSbTotT() {
		return sbTotT;
	}

	protected void setSbTotT(TextField sbTotT) {
		this.sbTotT = sbTotT;
	}

	protected HBox getSbTotH() {
		return sbTotH;
	}

	protected void setSbTotH(HBox sbTotH) {
		this.sbTotH = sbTotH;
	}

	protected Label getDicustL() {
		return dicustL;
	}

	protected void setDicustL(Label dicustL) {
		this.dicustL = dicustL;
	}

	protected TextField getDicustT() {
		return dicustT;
	}

	protected void setDicustT(TextField dicustT) {
		this.dicustT = dicustT;
	}

	protected HBox getDicustH() {
		return dicustH;
	}

	protected void setDicustH(HBox dicustH) {
		this.dicustH = dicustH;
	}

	protected Label getTaxL() {
		return taxL;
	}

	protected void setTaxL(Label taxL) {
		this.taxL = taxL;
	}

	protected TextField getTaxT() {
		return taxT;
	}

	protected void setTaxT(TextField taxT) {
		this.taxT = taxT;
	}

	protected HBox getTaxH() {
		return taxH;
	}

	protected void setTaxH(HBox taxH) {
		this.taxH = taxH;
	}

	protected Label getTotAL() {
		return totAL;
	}

	protected void setTotAL(Label totAL) {
		this.totAL = totAL;
	}

	protected TextField getTotAT() {
		return totAT;
	}

	protected void setTotAT(TextField totAT) {
		this.totAT = totAT;
	}

	protected HBox getTotAH() {
		return totAH;
	}

	protected void setTotAH(HBox totAH) {
		this.totAH = totAH;
	}

	protected Label getPayL() {
		return payL;
	}

	protected void setPayL(Label payL) {
		this.payL = payL;
	}

	protected TextField getPayT() {
		return payT;
	}

	protected void setPayT(TextField payT) {
		this.payT = payT;
	}

	protected HBox getPayH() {
		return payH;
	}

	protected void setPayH(HBox payH) {
		this.payH = payH;
	}

	protected Label getCustL() {
		return custL;
	}

	protected void setCustL(Label custL) {
		this.custL = custL;
	}

	protected TextField getCustT() {
		return custT;
	}

	protected void setCustT(TextField custT) {
		this.custT = custT;
	}

	protected HBox getCustH() {
		return custH;
	}

	protected void setCustH(HBox custH) {
		this.custH = custH;
	}

	protected Label getEmpL() {
		return empL;
	}

	protected void setEmpL(Label empL) {
		this.empL = empL;
	}

	protected TextField getEmpT() {
		return empT;
	}

	protected void setEmpT(TextField empT) {
		this.empT = empT;
	}

	protected HBox getEmpH() {
		return empH;
	}

	protected void setEmpH(HBox empH) {
		this.empH = empH;
	}

	protected Label getBidL() {
		return bidL;
	}

	protected void setBidL(Label bidL) {
		this.bidL = bidL;
	}

	protected TextField getBidT() {
		return bidT;
	}

	protected void setBidT(TextField bidT) {
		this.bidT = bidT;
	}

	protected HBox getBidH() {
		return bidH;
	}

	protected void setBidH(HBox bidH) {
		this.bidH = bidH;
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
