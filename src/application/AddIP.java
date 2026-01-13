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

public class AddIP {
	private Label addIP=new Label("Add Inssurance Ploicy");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label pIDL=new Label(" Policy ID :");
	private TextField pIDT=new TextField();
	private HBox pIDH=new HBox();
	
	private Label pNL=new Label("Policy Number :");
	private TextField pNT=new TextField();
	private HBox pNH=new HBox();
	
	private Label issueD=new Label("Issue Date :");
	private DatePicker issueDT=new DatePicker();
	private HBox issueDH=new HBox();

	private Label expiryD=new Label("Expiry Date :");
	private DatePicker expiryDT=new DatePicker();
	private HBox expiryDH=new HBox();
	
	private Label cpL=new Label("Coverage Percentege :");
	private TextField cpT=new TextField();
	private HBox cpH=new HBox();
	
	private Label CustIDL=new Label("Customer ID :");
	private TextField CustIDT=new TextField();
	private HBox CustIDH=new HBox();
	
	private Label icL=new Label("Inssurance Company :");
	private TextField icT=new TextField();
	private HBox icH=new HBox();
	
	
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

	public AddIP () {
		pIDH.getChildren().addAll(pIDL,pIDT);
		pIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pIDH.setAlignment(Pos.CENTER);
		pIDH.setSpacing(20);
		pNH.getChildren().addAll(pNL,pNT);
		pNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pNH.setAlignment(Pos.CENTER);
		pNH.setSpacing(20);
		CustIDH.getChildren().addAll(CustIDL,CustIDT);
		CustIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		CustIDH.setAlignment(Pos.CENTER);
		CustIDH.setSpacing(20);
		issueDH.getChildren().addAll(issueD,issueDT);
		issueD.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		issueDH.setAlignment(Pos.CENTER);
		issueDH.setSpacing(20);
		icH.getChildren().addAll(icL,icT);
		icL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		icH.setAlignment(Pos.CENTER);
		icH.setSpacing(20);
		expiryDH.getChildren().addAll(expiryD,expiryDT);
		expiryD.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		expiryDH.setAlignment(Pos.CENTER);
		expiryDH.setSpacing(20);
		cpH.getChildren().addAll(cpL,cpT);
		cpL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		cpH.setAlignment(Pos.CENTER);
		cpH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addIP,pIDH,pNH,CustIDH,issueDH,expiryDH,cpH,icH,buttons);
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

	protected Label getpIDL() {
		return pIDL;
	}

	protected void setpIDL(Label pIDL) {
		this.pIDL = pIDL;
	}

	protected TextField getpIDT() {
		return pIDT;
	}

	protected void setpIDT(TextField pIDT) {
		this.pIDT = pIDT;
	}

	protected HBox getpIDH() {
		return pIDH;
	}

	protected void setpIDH(HBox pIDH) {
		this.pIDH = pIDH;
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

	protected Label getIssueD() {
		return issueD;
	}

	protected void setIssueD(Label issueD) {
		this.issueD = issueD;
	}

	protected DatePicker getIssueDT() {
		return issueDT;
	}

	protected void setIssueDT(DatePicker issueDT) {
		this.issueDT = issueDT;
	}

	protected HBox getIssueDH() {
		return issueDH;
	}

	protected void setIssueDH(HBox issueDH) {
		this.issueDH = issueDH;
	}

	protected Label getExpiryD() {
		return expiryD;
	}

	protected void setExpiryD(Label expiryD) {
		this.expiryD = expiryD;
	}

	protected DatePicker getExpiryDT() {
		return expiryDT;
	}

	protected void setExpiryDT(DatePicker expiryDT) {
		this.expiryDT = expiryDT;
	}

	protected HBox getExpiryDH() {
		return expiryDH;
	}

	protected void setExpiryDH(HBox expiryDH) {
		this.expiryDH = expiryDH;
	}

	protected Label getCpL() {
		return cpL;
	}

	protected void setCpL(Label cpL) {
		this.cpL = cpL;
	}

	protected TextField getCpT() {
		return cpT;
	}

	protected void setCpT(TextField cpT) {
		this.cpT = cpT;
	}

	protected HBox getCpH() {
		return cpH;
	}

	protected void setCpH(HBox cpH) {
		this.cpH = cpH;
	}

	protected Label getCustIDL() {
		return CustIDL;
	}

	protected void setCustIDL(Label custIDL) {
		CustIDL = custIDL;
	}

	protected TextField getCustIDT() {
		return CustIDT;
	}

	protected void setCustIDT(TextField custIDT) {
		CustIDT = custIDT;
	}

	protected HBox getCustIDH() {
		return CustIDH;
	}

	protected void setCustIDH(HBox custIDH) {
		CustIDH = custIDH;
	}

	protected Label getIcL() {
		return icL;
	}

	protected void setIcL(Label icL) {
		this.icL = icL;
	}

	protected TextField getIcT() {
		return icT;
	}

	protected void setIcT(TextField icT) {
		this.icT = icT;
	}

	protected HBox getIcH() {
		return icH;
	}

	protected void setIcH(HBox icH) {
		this.icH = icH;
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
