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

public class AddPerMed {
	private Label addc=new Label("Add Persception Medecein");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label perIDL=new Label("Perscreption ID :");
	private TextField perIDT=new TextField();
	private HBox perIDH=new HBox();
	
	private Label mIDL=new Label("Medecine ID:");
	private TextField mIDT=new TextField();
	private HBox mIDH=new HBox();
	
	private Label dosL=new Label("Dosage :");
	private DatePicker dos=new DatePicker();
	private HBox dosH=new HBox();
	
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
	
	public AddPerMed() {
		perIDH.getChildren().addAll(perIDL,perIDT);
		perIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		perIDH.setAlignment(Pos.CENTER);
		perIDH.setSpacing(20);
		mIDH.getChildren().addAll(mIDL,mIDT);
		mIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		mIDH.setAlignment(Pos.CENTER);
		mIDH.setSpacing(20);
		dosH.getChildren().addAll(dosL,dos);
		dosL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		dosH.setAlignment(Pos.CENTER);
		dosH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addc,perIDH,mIDH,dosH,buttons);
		addc.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddc() {
		return addc;
	}

	public void setAddc(Label addc) {
		this.addc = addc;
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

	public Label getPerIDL() {
		return perIDL;
	}

	public void setPerIDL(Label perIDL) {
		this.perIDL = perIDL;
	}

	public TextField getPerIDT() {
		return perIDT;
	}

	public void setPerIDT(TextField perIDT) {
		this.perIDT = perIDT;
	}

	public HBox getPerIDH() {
		return perIDH;
	}

	public void setPerIDH(HBox perIDH) {
		this.perIDH = perIDH;
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

	public Label getDosL() {
		return dosL;
	}

	public void setDosL(Label dosL) {
		this.dosL = dosL;
	}

	public DatePicker getDos() {
		return dos;
	}

	public void setDos(DatePicker dos) {
		this.dos = dos;
	}

	public HBox getDosH() {
		return dosH;
	}

	public void setDosH(HBox dosH) {
		this.dosH = dosH;
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
