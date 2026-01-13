package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeleteEmployee {
	private Label dEmp=new Label("Delete Employee");
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
	
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
	
	private Image deleteM=new Image("icons8-remove-employee-100.png");
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
	
	public DeleteEmployee() {
		empIDH.getChildren().addAll(empIDL,empIDT);
		empIDT.setEditable(false);
		empIDT.setVisible(true);
		empIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		empIDH.setAlignment(Pos.CENTER);
		empIDH.setSpacing(20);
		empNH.getChildren().addAll(empNL,empNT);
		empNT.setEditable(false);
		empNT.setVisible(true);
		empNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		empNH.setAlignment(Pos.CENTER);
		empNH.setSpacing(20);
		qH.getChildren().addAll(qL,qT);
		qT.setEditable(false);
		qT.setVisible(true);
		qL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		qH.setAlignment(Pos.CENTER);
		qH.setSpacing(20);
		plnH.getChildren().addAll(plnL,plnT);
		plnT.setEditable(false);
		plnT.setVisible(true);
		plnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		plnH.setAlignment(Pos.CENTER);
		plnH.setSpacing(20);
		addH.getChildren().addAll(addL,addT);
		addT.setEditable(false);
		addT.setVisible(true);
		addL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		addH.setAlignment(Pos.CENTER);
		addH.setSpacing(20);
		naH.getChildren().addAll(naL,naT);
		naT.setEditable(false);
		naT.setVisible(true);
		naL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		naH.setAlignment(Pos.CENTER);
		naH.setSpacing(20);
		pnH.getChildren().addAll(pnL,pnT);
		pnT.setEditable(false);
		pnT.setVisible(true);
		pnL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		pnH.setAlignment(Pos.CENTER);
		pnH.setSpacing(20);
		eH.getChildren().addAll(eL,eT);
		eT.setEditable(false);
		eT.setVisible(true);
		eL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		eH.setAlignment(Pos.CENTER);
		eH.setSpacing(20);
		sH.getChildren().addAll(sL,sT);
		sT.setEditable(false);
		sT.setVisible(true);
		sL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		sH.setAlignment(Pos.CENTER);
		sH.setSpacing(20);
		bidH.getChildren().addAll(bidL,bidT);
		bidT.setEditable(false);
		bidT.setVisible(true);
		bidL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		bidH.setAlignment(Pos.CENTER);
		bidH.setSpacing(20);
		buttons.getChildren().addAll(delete,back,clear);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		delete.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		all.getChildren().addAll(dEmp,empIDH,empNH,qH,plnH,addH,naH,pnH,eH,sH,bidH,buttons);
		dEmp.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
	}

	protected Label getdEmp() {
		return dEmp;
	}

	protected void setdEmp(Label dEmp) {
		this.dEmp = dEmp;
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

	protected Label getEmpIDL() {
		return empIDL;
	}

	protected void setEmpIDL(Label empIDL) {
		this.empIDL = empIDL;
	}

	protected TextField getEmpIDT() {
		return empIDT;
	}

	protected void setEmpIDT(TextField empIDT) {
		this.empIDT = empIDT;
	}

	protected HBox getEmpIDH() {
		return empIDH;
	}

	protected void setEmpIDH(HBox empIDH) {
		this.empIDH = empIDH;
	}

	protected Label getEmpNL() {
		return empNL;
	}

	protected void setEmpNL(Label empNL) {
		this.empNL = empNL;
	}

	protected TextField getEmpNT() {
		return empNT;
	}

	protected void setEmpNT(TextField empNT) {
		this.empNT = empNT;
	}

	protected HBox getEmpNH() {
		return empNH;
	}

	protected void setEmpNH(HBox empNH) {
		this.empNH = empNH;
	}

	protected Label getqL() {
		return qL;
	}

	protected void setqL(Label qL) {
		this.qL = qL;
	}

	protected TextField getqT() {
		return qT;
	}

	protected void setqT(TextField qT) {
		this.qT = qT;
	}

	protected HBox getqH() {
		return qH;
	}

	protected void setqH(HBox qH) {
		this.qH = qH;
	}

	protected Label getPlnL() {
		return plnL;
	}

	protected void setPlnL(Label plnL) {
		this.plnL = plnL;
	}

	protected TextField getPlnT() {
		return plnT;
	}

	protected void setPlnT(TextField plnT) {
		this.plnT = plnT;
	}

	protected HBox getPlnH() {
		return plnH;
	}

	protected void setPlnH(HBox plnH) {
		this.plnH = plnH;
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

	protected Label getNaL() {
		return naL;
	}

	protected void setNaL(Label naL) {
		this.naL = naL;
	}

	protected TextField getNaT() {
		return naT;
	}

	protected void setNaT(TextField naT) {
		this.naT = naT;
	}

	protected HBox getNaH() {
		return naH;
	}

	protected void setNaH(HBox naH) {
		this.naH = naH;
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

	protected Label getsL() {
		return sL;
	}

	protected void setsL(Label sL) {
		this.sL = sL;
	}

	protected TextField getsT() {
		return sT;
	}

	protected void setsT(TextField sT) {
		this.sT = sT;
	}

	protected HBox getsH() {
		return sH;
	}

	protected void setsH(HBox sH) {
		this.sH = sH;
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

	protected Image getDeleteM() {
		return deleteM;
	}

	protected void setDeleteM(Image deleteM) {
		this.deleteM = deleteM;
	}

	protected ImageView getDeleteVM() {
		return deleteVM;
	}

	protected void setDeleteVM(ImageView deleteVM) {
		this.deleteVM = deleteVM;
	}

	protected Button getDelete() {
		return delete;
	}

	protected void setDelete(Button delete) {
		this.delete = delete;
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
