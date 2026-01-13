package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeleteMedicine {
	private Label addMed=new Label("Delete Medicine");
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
	
	
	private Image deleteM=new Image("icons8-delete-100(1).png");
	private ImageView deleteVM=new ImageView(deleteM);
	private Button delete=new Button("Delete",deleteVM);
	
	private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	
	private Image clearM=new Image("icons8-clear-100(1).png");
	private ImageView clearVM=new ImageView(clearM);
	private Button clear=new Button("clear",clearVM);
	
	private HBox buttons=new HBox();
	private VBox all=new VBox();
	
	public DeleteMedicine() {
		mIDH.getChildren().addAll(mIDL,mIDT);
		mIDT.setEditable(false);
		mIDT.setVisible(true);
		mIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		mIDH.setAlignment(Pos.CENTER);
		mIDH.setSpacing(20);
		mNH.getChildren().addAll(mNL,mNT);
		mNT.setEditable(false);
		mNT.setVisible(true);
		mNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		mNH.setAlignment(Pos.CENTER);
		mNH.setSpacing(20);
		catIDH.getChildren().addAll(catIDL,catIDT);
		catIDT.setEditable(false);
		catIDT.setVisible(true);
		catIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		catIDH.setAlignment(Pos.CENTER);
		catIDH.setSpacing(20);
		strH.getChildren().addAll(str,strT);
		strT.setEditable(false);
		strT.setVisible(true);
		str.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		strH.setAlignment(Pos.CENTER);
		strH.setSpacing(20);
		
		reqH.getChildren().addAll(req,reqT);
		reqT.setEditable(false);
		reqT.setVisible(true);
		req.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		reqH.setAlignment(Pos.CENTER);
		reqH.setSpacing(20);
		descH.getChildren().addAll(descL,descT);
		descT.setEditable(false);
		descT.setVisible(true);
		descL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		descH.setAlignment(Pos.CENTER);
		descH.setSpacing(20);
		buttons.getChildren().addAll(delete,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		delete.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addMed,mIDH,mNH,catIDH,strH,reqH,descH,buttons);
		addMed.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddMed() {
		return addMed;
	}

	public void setAddMed(Label addMed) {
		this.addMed = addMed;
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

	public Label getmIDL() {
		return mIDL;
	}

	public void setmIDL(Label mIDL) {
		this.mIDL = mIDL;
	}

	public TextField getmIDT() {
		return mIDT;
	}

	public void setmIDT(TextField mIDT) {
		this.mIDT = mIDT;
	}

	public HBox getmIDH() {
		return mIDH;
	}

	public void setmIDH(HBox mIDH) {
		this.mIDH = mIDH;
	}

	public Label getmNL() {
		return mNL;
	}

	public void setmNL(Label mNL) {
		this.mNL = mNL;
	}

	public TextField getmNT() {
		return mNT;
	}

	public void setmNT(TextField mNT) {
		this.mNT = mNT;
	}

	public HBox getmNH() {
		return mNH;
	}

	public void setmNH(HBox mNH) {
		this.mNH = mNH;
	}

	public Label getStr() {
		return str;
	}

	public void setStr(Label str) {
		this.str = str;
	}

	public TextField getStrT() {
		return strT;
	}

	public void setStrT(TextField strT) {
		this.strT = strT;
	}

	public HBox getStrH() {
		return strH;
	}

	public void setStrH(HBox strH) {
		this.strH = strH;
	}

	public Label getReq() {
		return req;
	}

	public void setReq(Label req) {
		this.req = req;
	}

	public TextField getReqT() {
		return reqT;
	}

	public void setReqT(TextField reqT) {
		this.reqT = reqT;
	}

	public HBox getReqH() {
		return reqH;
	}

	public void setReqH(HBox reqH) {
		this.reqH = reqH;
	}

	public Label getDescL() {
		return descL;
	}

	public void setDescL(Label descL) {
		this.descL = descL;
	}

	public TextField getDescT() {
		return descT;
	}

	public void setDescT(TextField descT) {
		this.descT = descT;
	}

	public HBox getDescH() {
		return descH;
	}

	public void setDescH(HBox descH) {
		this.descH = descH;
	}

	public Label getCatIDL() {
		return catIDL;
	}

	public void setCatIDL(Label catIDL) {
		this.catIDL = catIDL;
	}

	public TextField getCatIDT() {
		return catIDT;
	}

	public void setCatIDT(TextField catIDT) {
		this.catIDT = catIDT;
	}

	public HBox getCatIDH() {
		return catIDH;
	}

	public void setCatIDH(HBox catIDH) {
		this.catIDH = catIDH;
	}

	public Button getDelete() {
		return delete;
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
