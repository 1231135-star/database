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

public class UpdatePurchase {
	private Label addIP=new Label("Update Purchase");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label pIDL=new Label("Purchase ID :");
	private TextField pIDT=new TextField();
	private HBox pIDH=new HBox();
	
	private Label pDaL=new Label("Purchase Date :");
	private DatePicker pDaT=new DatePicker();
	private HBox pDaH=new HBox();
	
	private Label totCost=new Label("Total Cost :");
	private TextField totCostT=new TextField();
	private HBox totCostH=new HBox();

	private Label payStat=new Label("Payment Status :");
	private TextField payStatT=new TextField();
	private HBox payStatH=new HBox();
	
	private Label suppL=new Label("Supplier ID :");
	private TextField suppT=new TextField();
	private HBox suppH=new HBox();
	
	private Label braIDL=new Label("Address :");
	private TextField braIDT=new TextField();
	private HBox braIDH=new HBox();
	
	
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
	
	public UpdatePurchase() {
		pIDH.getChildren().addAll(pIDL,pIDT);
		pIDT.setEditable(false);
		pIDT.setVisible(true);
		pIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pIDH.setAlignment(Pos.CENTER);
		pIDH.setSpacing(20);
		pDaH.getChildren().addAll(pDaL,pDaT);
		pDaL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pDaH.setAlignment(Pos.CENTER);
		pDaH.setSpacing(20);
		braIDH.getChildren().addAll(braIDL,braIDT);
		braIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		braIDH.setAlignment(Pos.CENTER);
		braIDH.setSpacing(20);
		totCostH.getChildren().addAll(totCost,totCostT);
		totCost.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		totCostH.setAlignment(Pos.CENTER);
		totCostH.setSpacing(20);
		
		payStatH.getChildren().addAll(payStat,payStatT);
		payStat.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		payStatH.setAlignment(Pos.CENTER);
		payStatH.setSpacing(20);
		suppH.getChildren().addAll(suppL,suppT);
		suppL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		suppH.setAlignment(Pos.CENTER);
		suppH.setSpacing(20);
		buttons.getChildren().addAll(edit,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addIP,pIDH,pDaH,braIDH,totCostH,payStatH,suppH,buttons);
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

	public Label getpIDL() {
		return pIDL;
	}

	public void setpIDL(Label pIDL) {
		this.pIDL = pIDL;
	}

	public TextField getpIDT() {
		return pIDT;
	}

	public void setpIDT(TextField pIDT) {
		this.pIDT = pIDT;
	}

	public HBox getpIDH() {
		return pIDH;
	}

	public void setpIDH(HBox pIDH) {
		this.pIDH = pIDH;
	}

	public Label getpDaL() {
		return pDaL;
	}

	public void setpDaL(Label pDaL) {
		this.pDaL = pDaL;
	}

	public DatePicker getpDaT() {
		return pDaT;
	}

	public void setpDaT(DatePicker pDaT) {
		this.pDaT = pDaT;
	}

	public HBox getpDaH() {
		return pDaH;
	}

	public void setpDaH(HBox pDaH) {
		this.pDaH = pDaH;
	}

	public Label getTotCost() {
		return totCost;
	}

	public void setTotCost(Label totCost) {
		this.totCost = totCost;
	}

	public TextField getTotCostT() {
		return totCostT;
	}

	public void setTotCostT(TextField totCostT) {
		this.totCostT = totCostT;
	}

	public HBox getTotCostH() {
		return totCostH;
	}

	public void setTotCostH(HBox totCostH) {
		this.totCostH = totCostH;
	}

	public Label getPayStat() {
		return payStat;
	}

	public void setPayStat(Label payStat) {
		this.payStat = payStat;
	}

	public TextField getPayStatT() {
		return payStatT;
	}

	public void setPayStatT(TextField payStatT) {
		this.payStatT = payStatT;
	}

	public HBox getPayStatH() {
		return payStatH;
	}

	public void setPayStatH(HBox payStatH) {
		this.payStatH = payStatH;
	}

	public Label getSuppL() {
		return suppL;
	}

	public void setSuppL(Label suppL) {
		this.suppL = suppL;
	}

	public TextField getSuppT() {
		return suppT;
	}

	public void setSuppT(TextField suppT) {
		this.suppT = suppT;
	}

	public HBox getSuppH() {
		return suppH;
	}

	public void setSuppH(HBox suppH) {
		this.suppH = suppH;
	}

	public Label getBraIDL() {
		return braIDL;
	}

	public void setBraIDL(Label braIDL) {
		this.braIDL = braIDL;
	}

	public TextField getBraIDT() {
		return braIDT;
	}

	public void setBraIDT(TextField braIDT) {
		this.braIDT = braIDT;
	}

	public HBox getBraIDH() {
		return braIDH;
	}

	public void setBraIDH(HBox braIDH) {
		this.braIDH = braIDH;
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
