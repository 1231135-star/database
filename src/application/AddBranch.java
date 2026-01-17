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
	private Label addB = new Label("Add Branch");
	private Image ph = new Image("bb.jpg");
	private ImageView phVM = new ImageView(ph);

	private Label bidL = new Label("Branch ID :");
	private TextField bidT = new TextField();
	private HBox bidH = new HBox();

	private Label bnL = new Label("Branch Name :");
	private TextField bnT = new TextField();
	private HBox bnH = new HBox();

	private Label addL = new Label("Address :");
	private TextField addT = new TextField();
	private HBox addH = new HBox();

	private Label pnL = new Label("Phone Number :");
	private TextField pnT = new TextField();
	private HBox pnH = new HBox();

	private Label eL = new Label("Email Address :");
	private TextField eT = new TextField();
	private HBox eH = new HBox();

	private Image addM = new Image("icons8-add-administrator-100.png");
	private ImageView addVM = new ImageView(addM);
	private Button add = new Button("Add", addVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private Image clearM = new Image("icons8-clear-100(1).png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clear = new Button("clear", clearVM);

	private HBox buttons = new HBox();
	private VBox all = new VBox();

	public AddBranch() {

		bidH.getChildren().addAll(bidL, bidT);
		bidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bidH.setAlignment(Pos.CENTER);
		bidH.setSpacing(20);

		bnH.getChildren().addAll(bnL, bnT);
		bnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bnH.setAlignment(Pos.CENTER);
		bnH.setSpacing(20);

		addH.getChildren().addAll(addL, addT);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);

		pnH.getChildren().addAll(pnL, pnT);
		pnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pnH.setAlignment(Pos.CENTER);
		pnH.setSpacing(20);

		eH.getChildren().addAll(eL, eT);
		eL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		eH.setAlignment(Pos.CENTER);
		eH.setSpacing(20);

		buttons.getChildren().addAll(add, back, clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		all.getChildren().addAll(addB, bidH, bnH, addH, pnH, eH, buttons);
		addB.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getAddB() {
		return addB;
	}

	public void setAddB(Label addB) {
		this.addB = addB;
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

	public Label getBidL() {
		return bidL;
	}

	public void setBidL(Label bidL) {
		this.bidL = bidL;
	}

	public TextField getBidT() {
		return bidT;
	}

	public void setBidT(TextField bidT) {
		this.bidT = bidT;
	}

	public HBox getBidH() {
		return bidH;
	}

	public void setBidH(HBox bidH) {
		this.bidH = bidH;
	}

	public Label getBnL() {
		return bnL;
	}

	public void setBnL(Label bnL) {
		this.bnL = bnL;
	}

	public TextField getBnT() {
		return bnT;
	}

	public void setBnT(TextField bnT) {
		this.bnT = bnT;
	}

	public HBox getBnH() {
		return bnH;
	}

	public void setBnH(HBox bnH) {
		this.bnH = bnH;
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

	public Label getPnL() {
		return pnL;
	}

	public void setPnL(Label pnL) {
		this.pnL = pnL;
	}

	public TextField getPnT() {
		return pnT;
	}

	public void setPnT(TextField pnT) {
		this.pnT = pnT;
	}

	public HBox getPnH() {
		return pnH;
	}

	public void setPnH(HBox pnH) {
		this.pnH = pnH;
	}

	public Label geteL() {
		return eL;
	}

	public void seteL(Label eL) {
		this.eL = eL;
	}

	public TextField geteT() {
		return eT;
	}

	public void seteT(TextField eT) {
		this.eT = eT;
	}

	public HBox geteH() {
		return eH;
	}

	public void seteH(HBox eH) {
		this.eH = eH;
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
