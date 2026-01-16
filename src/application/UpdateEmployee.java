package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UpdateEmployee {
	private Label editEmp=new Label("Edit Employee");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
	private Image searchM=new Image("icons8-search-100.png");
	private ImageView searchVM=new ImageView(searchM);
	private Button searchB=new Button("Search",searchVM);
	private Label searchL=new Label("put id :");
	private TextField searchT=new TextField();

	private HBox searchH=new HBox();
	
	private Label empIDL=new Label("Employee ID :");
	private TextField empIDT=new TextField();
	private HBox empIDH=new HBox();
	
	private Label empNL=new Label("Employee Name(Full Name) :");
	private TextField empNT=new TextField();
	private HBox empNH=new HBox();
	
	private Label qL=new Label("Qualification :");
	private TextField qT=new TextField();
	private HBox qH=new HBox();
	
	private Label plnL=new Label("Proffessional License Number :");
	private TextField plnT=new TextField();
	private HBox plnH=new HBox();
	
	private Label addL=new Label("Address :");
	private TextField addT=new TextField();
	private HBox addH=new HBox();

	private Label naL=new Label("National ID :");
	private TextField naT=new TextField();
	private HBox naH=new HBox();
	
	private Label pnL=new Label("Phone Number :");
	private TextField pnT=new TextField();
	private HBox pnH=new HBox();
	
	private Label eL=new Label("Email Address :");
	private TextField eT=new TextField();
	private HBox eH=new HBox();
	
	private Label sL=new Label("Salary :");
	private TextField sT=new TextField();
	private HBox sH=new HBox();
	
	private Label bidL=new Label("Branch ID :");
	private TextField bidT=new TextField();
	private HBox bidH=new HBox();
	
	private Image editM=new Image("icons8-edit-property-100.png");
	private ImageView editVM=new ImageView(editM);
	private Button edit=new Button("Edit",editVM);
	
	private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	
	private Image clearM=new Image("icons8-clear-100(1).png");
	private ImageView clearVM=new ImageView(clearM);
	private Button clear=new Button("clear",clearVM);
	
	private HBox buttons=new HBox();
	private VBox all=new VBox();
	
	public UpdateEmployee() {
		searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

		searchL.setFont(Font.font(null,FontWeight.BOLD,20));
		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);
		
		searchH.getChildren().addAll(searchL,searchT,searchB);
		searchH.setSpacing(10);
		searchH.setAlignment(Pos.CENTER);
		
		empIDH.getChildren().addAll(empIDL,empIDT);
		empIDT.setEditable(false);
		empIDT.setVisible(true);
		empIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		empIDH.setAlignment(Pos.CENTER);
		empIDH.setSpacing(20);
		empNH.getChildren().addAll(empNL,empNT);
		empNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		empNH.setAlignment(Pos.CENTER);
		empNH.setSpacing(20);
		qH.getChildren().addAll(qL,qT);
		qL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		qH.setAlignment(Pos.CENTER);
		qH.setSpacing(20);
		plnH.getChildren().addAll(plnL,plnT);
		plnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		plnH.setAlignment(Pos.CENTER);
		plnH.setSpacing(20);
		addH.getChildren().addAll(addL,addT);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);
		naH.getChildren().addAll(naL,naT);
		naL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		naH.setAlignment(Pos.CENTER);
		naH.setSpacing(20);
		pnH.getChildren().addAll(pnL,pnT);
		pnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pnH.setAlignment(Pos.CENTER);
		pnH.setSpacing(20);
		eH.getChildren().addAll(eL,eT);
		eL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		eH.setAlignment(Pos.CENTER);
		eH.setSpacing(20);
		sH.getChildren().addAll(sL,sT);
		sL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		sH.setAlignment(Pos.CENTER);
		sH.setSpacing(20);
		bidH.getChildren().addAll(bidL,bidT);
		bidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bidH.setAlignment(Pos.CENTER);
		bidH.setSpacing(20);
		buttons.getChildren().addAll(edit,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		edit.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(editEmp,searchH,empIDH,empNH,qH,plnH,addH,naH,pnH,eH,sH,bidH,buttons);
		editEmp.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
      
		edit.setDisable(true);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(15);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	public Label getEditEmp() {
		return editEmp;
	}

	public void setEditEmp(Label editEmp) {
		this.editEmp = editEmp;
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

	public Image getSearchM() {
		return searchM;
	}

	public void setSearchM(Image searchM) {
		this.searchM = searchM;
	}

	public ImageView getSearchVM() {
		return searchVM;
	}

	public void setSearchVM(ImageView searchVM) {
		this.searchVM = searchVM;
	}

	public Button getSearchB() {
		return searchB;
	}

	public void setSearchB(Button searchB) {
		this.searchB = searchB;
	}

	public Label getSearchL() {
		return searchL;
	}

	public void setSearchL(Label searchL) {
		this.searchL = searchL;
	}

	public TextField getSearchT() {
		return searchT;
	}

	public void setSearchT(TextField searchT) {
		this.searchT = searchT;
	}

	public HBox getSearchH() {
		return searchH;
	}

	public void setSearchH(HBox searchH) {
		this.searchH = searchH;
	}

	public Label getEmpIDL() {
		return empIDL;
	}

	public void setEmpIDL(Label empIDL) {
		this.empIDL = empIDL;
	}

	public TextField getEmpIDT() {
		return empIDT;
	}

	public void setEmpIDT(TextField empIDT) {
		this.empIDT = empIDT;
	}

	public HBox getEmpIDH() {
		return empIDH;
	}

	public void setEmpIDH(HBox empIDH) {
		this.empIDH = empIDH;
	}

	public Label getEmpNL() {
		return empNL;
	}

	public void setEmpNL(Label empNL) {
		this.empNL = empNL;
	}

	public TextField getEmpNT() {
		return empNT;
	}

	public void setEmpNT(TextField empNT) {
		this.empNT = empNT;
	}

	public HBox getEmpNH() {
		return empNH;
	}

	public void setEmpNH(HBox empNH) {
		this.empNH = empNH;
	}

	public Label getqL() {
		return qL;
	}

	public void setqL(Label qL) {
		this.qL = qL;
	}

	public TextField getqT() {
		return qT;
	}

	public void setqT(TextField qT) {
		this.qT = qT;
	}

	public HBox getqH() {
		return qH;
	}

	public void setqH(HBox qH) {
		this.qH = qH;
	}

	public Label getPlnL() {
		return plnL;
	}

	public void setPlnL(Label plnL) {
		this.plnL = plnL;
	}

	public TextField getPlnT() {
		return plnT;
	}

	public void setPlnT(TextField plnT) {
		this.plnT = plnT;
	}

	public HBox getPlnH() {
		return plnH;
	}

	public void setPlnH(HBox plnH) {
		this.plnH = plnH;
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

	public Label getNaL() {
		return naL;
	}

	public void setNaL(Label naL) {
		this.naL = naL;
	}

	public TextField getNaT() {
		return naT;
	}

	public void setNaT(TextField naT) {
		this.naT = naT;
	}

	public HBox getNaH() {
		return naH;
	}

	public void setNaH(HBox naH) {
		this.naH = naH;
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

	public Label getsL() {
		return sL;
	}

	public void setsL(Label sL) {
		this.sL = sL;
	}

	public TextField getsT() {
		return sT;
	}

	public void setsT(TextField sT) {
		this.sT = sT;
	}

	public HBox getsH() {
		return sH;
	}

	public void setsH(HBox sH) {
		this.sH = sH;
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
