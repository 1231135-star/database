package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddPre {
	private Label addEmp=new Label("Add Prescription");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Label pIDL=new Label("Prescription ID :");
	private TextField pIDT=new TextField();
	private HBox pIDH=new HBox();
	
	private Label pIDTL=new Label("Issue Date :");
	private DatePicker pIDTT=new DatePicker();
	private HBox pIDTH=new HBox();
	
	private Label notesL=new Label("Notes :");
	private TextArea notesT=new TextArea();
	private HBox notesH=new HBox();
	
	private Label docIDL=new Label("Doctor ID :");
	private DatePicker docIDT=new DatePicker();
	private HBox docIDH=new HBox();
	
	private Label invL=new Label("Invoice ID");
	private TextField invT=new TextField();
	private HBox invH=new HBox();
	
	
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
	
	public AddPre(){
		pIDH.getChildren().addAll(pIDL,pIDT);
		pIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pIDH.setAlignment(Pos.CENTER);
		pIDH.setSpacing(20);
		pIDTH.getChildren().addAll(pIDTL,pIDTT);
		pIDTL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pIDTH.setAlignment(Pos.CENTER);
		pIDTH.setSpacing(20);
		docIDH.getChildren().addAll(docIDL,docIDT);
		docIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		docIDH.setAlignment(Pos.CENTER);
		docIDH.setSpacing(20);
		notesH.getChildren().addAll(notesL,notesT);
		notesL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		notesH.setAlignment(Pos.CENTER);
		notesH.setSpacing(20);
		invH.getChildren().addAll(invL,invT);
		invL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		invH.setAlignment(Pos.CENTER);
		invH.setSpacing(20);
		buttons.getChildren().addAll(add,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		add.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(addEmp,pIDTH,docIDH,notesH,pIDH,invH,buttons);
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

	public Label getpIDTL() {
		return pIDTL;
	}

	public void setpIDTL(Label pIDTL) {
		this.pIDTL = pIDTL;
	}

	public DatePicker getpIDTT() {
		return pIDTT;
	}

	public void setpIDTT(DatePicker pIDTT) {
		this.pIDTT = pIDTT;
	}

	public HBox getpIDTH() {
		return pIDTH;
	}

	public void setpIDTH(HBox pIDTH) {
		this.pIDTH = pIDTH;
	}

	public Label getNotesL() {
		return notesL;
	}

	public void setNotesL(Label notesL) {
		this.notesL = notesL;
	}

	public TextArea getNotesT() {
		return notesT;
	}

	public void setNotesT(TextArea notesT) {
		this.notesT = notesT;
	}

	public HBox getNotesH() {
		return notesH;
	}

	public void setNotesH(HBox notesH) {
		this.notesH = notesH;
	}

	public Label getDocIDL() {
		return docIDL;
	}

	public void setDocIDL(Label docIDL) {
		this.docIDL = docIDL;
	}

	public DatePicker getDocIDT() {
		return docIDT;
	}

	public void setDocIDT(DatePicker docIDT) {
		this.docIDT = docIDT;
	}

	public HBox getDocIDH() {
		return docIDH;
	}

	public void setDocIDH(HBox docIDH) {
		this.docIDH = docIDH;
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
