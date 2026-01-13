package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddMedicine {
	private Label addMed=new Label("Add Medicine");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label mIDL=new Label("Medecine ID :");
	private TextField mIDT=new TextField();
	private HBox mIDH=new HBox();
	
	private Label mNL=new Label("Medecine Name :");
	private TextField mNT=new TextField();
	private HBox mNH=new HBox();
	
	private Label str=new Label("Strength :");
	private TextField strT=new TextField();
	private HBox strH=new HBox();

	private Label req=new Label("Require Preseption :");
	private TextField reqT=new TextField();
	private HBox reqH=new HBox();
	
	private Label descL=new Label("Description :");
	private TextField descT=new TextField();
	private HBox descH=new HBox();
	
	private Label catIDL=new Label("Category ID :");
	private TextField catIDT=new TextField();
	private HBox catIDH=new HBox();
	
	
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
	
	public AddMedicine() {
		mIDH.getChildren().addAll(mIDL,mIDT);
		mIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		mIDH.setAlignment(Pos.CENTER);
		mIDH.setSpacing(20);
		mNH.getChildren().addAll(mNL,mNT);
		mNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		mNH.setAlignment(Pos.CENTER);
		mNH.setSpacing(20);
		catIDH.getChildren().addAll(catIDL,catIDT);
		catIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		catIDH.setAlignment(Pos.CENTER);
		catIDH.setSpacing(20);
		strH.getChildren().addAll(str,strT);
		str.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		strH.setAlignment(Pos.CENTER);
		strH.setSpacing(20);
		
		reqH.getChildren().addAll(req,reqT);
		req.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		reqH.setAlignment(Pos.CENTER);
		reqH.setSpacing(20);
		descH.getChildren().addAll(descL,descT);
		descL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		descH.setAlignment(Pos.CENTER);
		descH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addMed,mIDH,mNH,catIDH,strH,reqH,descH,buttons);
		addMed.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	protected Label getAddMed() {
		return addMed;
	}

	protected void setAddMed(Label addMed) {
		this.addMed = addMed;
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

	protected Label getmIDL() {
		return mIDL;
	}

	protected void setmIDL(Label mIDL) {
		this.mIDL = mIDL;
	}

	protected TextField getmIDT() {
		return mIDT;
	}

	protected void setmIDT(TextField mIDT) {
		this.mIDT = mIDT;
	}

	protected HBox getmIDH() {
		return mIDH;
	}

	protected void setmIDH(HBox mIDH) {
		this.mIDH = mIDH;
	}

	protected Label getmNL() {
		return mNL;
	}

	protected void setmNL(Label mNL) {
		this.mNL = mNL;
	}

	protected TextField getmNT() {
		return mNT;
	}

	protected void setmNT(TextField mNT) {
		this.mNT = mNT;
	}

	protected HBox getmNH() {
		return mNH;
	}

	protected void setmNH(HBox mNH) {
		this.mNH = mNH;
	}

	protected Label getStr() {
		return str;
	}

	protected void setStr(Label str) {
		this.str = str;
	}

	protected TextField getStrT() {
		return strT;
	}

	protected void setStrT(TextField strT) {
		this.strT = strT;
	}

	protected HBox getStrH() {
		return strH;
	}

	protected void setStrH(HBox strH) {
		this.strH = strH;
	}

	protected Label getReq() {
		return req;
	}

	protected void setReq(Label req) {
		this.req = req;
	}

	protected TextField getReqT() {
		return reqT;
	}

	protected void setReqT(TextField reqT) {
		this.reqT = reqT;
	}

	protected HBox getReqH() {
		return reqH;
	}

	protected void setReqH(HBox reqH) {
		this.reqH = reqH;
	}

	protected Label getDescL() {
		return descL;
	}

	protected void setDescL(Label descL) {
		this.descL = descL;
	}

	protected TextField getDescT() {
		return descT;
	}

	protected void setDescT(TextField descT) {
		this.descT = descT;
	}

	protected HBox getDescH() {
		return descH;
	}

	protected void setDescH(HBox descH) {
		this.descH = descH;
	}

	protected Label getCatIDL() {
		return catIDL;
	}

	protected void setCatIDL(Label catIDL) {
		this.catIDL = catIDL;
	}

	protected TextField getCatIDT() {
		return catIDT;
	}

	protected void setCatIDT(TextField catIDT) {
		this.catIDT = catIDT;
	}

	protected HBox getCatIDH() {
		return catIDH;
	}

	protected void setCatIDH(HBox catIDH) {
		this.catIDH = catIDH;
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
