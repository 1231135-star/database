package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddBranch {
	//sysoutggghghghghggggg
	private Label addBra=new Label("Add Branch");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label bIDL=new Label("Branch ID :");
	private TextField bIDT=new TextField();
	private HBox bIDH=new HBox();
	
	private Label bNL=new Label("Branch Name :");
	private TextField bNT=new TextField();
	private HBox bNH=new HBox();
	
	private Label addL=new Label("Address :");
	private TextField addT=new TextField();
	private HBox addH=new HBox();

	private Label pnL=new Label("Phone Number :");
	private TextField pnT=new TextField();
	private HBox pnH=new HBox();
	
	private Label eL=new Label("Email Address :");
	private TextField eT=new TextField();
	private HBox eH=new HBox();
	
	private Label midL=new Label("Maneger ID :");
	private TextField midT=new TextField();
	private HBox midH=new HBox();
	
	private Label wsL=new Label("Working hours starts at :");
	private TextField wsT=new TextField();
	private HBox wsH=new HBox();
	
	private Label weL=new Label("Working hours ends at :");
	private TextField weT=new TextField();
	private HBox weH=new HBox();
	
	private Label hL=new Label("weekly holiday(sepretade by comma) :");
	private TextField hT=new TextField();
	private HBox hH=new HBox();
	
	private Image addM=new Image("icons8-out-patient-department-100.png");
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
	
	public AddBranch() {
		bIDH.getChildren().addAll(bIDL,bIDT);
		bIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bIDH.setAlignment(Pos.CENTER);
		bIDH.setSpacing(20);
		bNH.getChildren().addAll(bNL,bNT);
		bNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bNH.setAlignment(Pos.CENTER);
		bNH.setSpacing(20);
		midH.getChildren().addAll(midL,midT);
		midL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		midH.setAlignment(Pos.CENTER);
		midH.setSpacing(20);
		addH.getChildren().addAll(addL,addT);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);
		wsH.getChildren().addAll(wsL,wsT);
		wsL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		wsH.setAlignment(Pos.CENTER);
		wsH.setSpacing(20);
		pnH.getChildren().addAll(pnL,pnT);
		pnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pnH.setAlignment(Pos.CENTER);
		pnH.setSpacing(20);
		eH.getChildren().addAll(eL,eT);
		eL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		eH.setAlignment(Pos.CENTER);
		eH.setSpacing(20);
		weH.getChildren().addAll(weL,weT);
		weL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		weH.setAlignment(Pos.CENTER);
		weH.setSpacing(20);
		hH.getChildren().addAll(hL,hT);
		hL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		hH.setAlignment(Pos.CENTER);
		hH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addBra,bIDH,bNH,midH,addH,pnH,eH,wsH,weH,hH,buttons);
		addBra.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	protected Label getAddBra() {
		return addBra;
	}

	protected void setAddBra(Label addBra) {
		this.addBra = addBra;
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

	protected Label getbIDL() {
		return bIDL;
	}

	protected void setbIDL(Label bIDL) {
		this.bIDL = bIDL;
	}

	protected TextField getbIDT() {
		return bIDT;
	}

	protected void setbIDT(TextField bIDT) {
		this.bIDT = bIDT;
	}

	protected HBox getbIDH() {
		return bIDH;
	}

	protected void setbIDH(HBox bIDH) {
		this.bIDH = bIDH;
	}

	protected Label getbNL() {
		return bNL;
	}

	protected void setbNL(Label bNL) {
		this.bNL = bNL;
	}

	protected TextField getbNT() {
		return bNT;
	}

	protected void setbNT(TextField bNT) {
		this.bNT = bNT;
	}

	protected HBox getbNH() {
		return bNH;
	}

	protected void setbNH(HBox bNH) {
		this.bNH = bNH;
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

	protected Label getPnL() {
		return pnL;
	}

	protected void setPnL(Label pnL) {
		this.pnL = pnL;
	}

	protected TextField getPnT() {
		return pnT;
	}

	protected void setPnT(TextField pnT) {
		this.pnT = pnT;
	}

	protected HBox getPnH() {
		return pnH;
	}

	protected void setPnH(HBox pnH) {
		this.pnH = pnH;
	}

	protected Label geteL() {
		return eL;
	}

	protected void seteL(Label eL) {
		this.eL = eL;
	}

	protected TextField geteT() {
		return eT;
	}

	protected void seteT(TextField eT) {
		this.eT = eT;
	}

	protected HBox geteH() {
		return eH;
	}

	protected void seteH(HBox eH) {
		this.eH = eH;
	}

	protected Label getMidL() {
		return midL;
	}

	protected void setMidL(Label midL) {
		this.midL = midL;
	}

	protected TextField getMidT() {
		return midT;
	}

	protected void setMidT(TextField midT) {
		this.midT = midT;
	}

	protected HBox getMidH() {
		return midH;
	}

	protected void setMidH(HBox midH) {
		this.midH = midH;
	}

	protected Label getWsL() {
		return wsL;
	}

	protected void setWsL(Label wsL) {
		this.wsL = wsL;
	}

	protected TextField getWsT() {
		return wsT;
	}

	protected void setWsT(TextField wsT) {
		this.wsT = wsT;
	}

	protected HBox getWsH() {
		return wsH;
	}

	protected void setWsH(HBox wsH) {
		this.wsH = wsH;
	}

	protected Label getWeL() {
		return weL;
	}

	protected void setWeL(Label weL) {
		this.weL = weL;
	}

	protected TextField getWeT() {
		return weT;
	}

	protected void setWeT(TextField weT) {
		this.weT = weT;
	}

	protected HBox getWeH() {
		return weH;
	}

	protected void setWeH(HBox weH) {
		this.weH = weH;
	}

	protected Label gethL() {
		return hL;
	}

	protected void sethL(Label hL) {
		this.hL = hL;
	}

	protected TextField gethT() {
		return hT;
	}

	protected void sethT(TextField hT) {
		this.hT = hT;
	}

	protected HBox gethH() {
		return hH;
	}

	protected void sethH(HBox hH) {
		this.hH = hH;
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
