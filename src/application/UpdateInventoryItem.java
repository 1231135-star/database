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

public class UpdateInventoryItem {
		private Label addEmp=new Label("Update Inventory Item");
		private Image ph=new Image("bb.jpg");
		private ImageView phVM=new ImageView(ph);
		
		private Label invL=new Label("Inventory Item ID :");
		private TextField invT=new TextField();
		private HBox invH=new HBox();
		
		private Label baNL=new Label("Batch Number :");
		private TextField baNT=new TextField();
		private HBox baNH=new HBox();
		
		private Label expDL=new Label("Expiry Date :");
		private DatePicker expDT=new DatePicker();
		private HBox expDH=new HBox();
		
		private Label recDL=new Label("Receive Date :");
		private TextField recDT=new TextField();
		private HBox recDH=new HBox();
		
		private Label quanAvL=new Label("Quantity Available :");
		private TextField quanAvT=new TextField();
		private HBox quanAvH=new HBox();

		private Label purPL=new Label("Purchase Price :");
		private TextField purPT=new TextField();
		private HBox purPH=new HBox();
		
		private Label medIDL=new Label("Medecine :");
		private TextField medIDT=new TextField();
		private HBox medIDH=new HBox();
		
		private Label supL=new Label("supplier ID :");
		private TextField supT=new TextField();
		private HBox supH=new HBox();
		
		private Label bidL=new Label("Branch ID :");
		private TextField bidT=new TextField();
		private HBox bidH=new HBox();
		
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
		
		public UpdateInventoryItem(){
			invH.getChildren().addAll(invL,invT);
			invT.setEditable(false);
			invT.setVisible(true);
			invL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			invH.setAlignment(Pos.CENTER);
			invH.setSpacing(20);
			baNH.getChildren().addAll(baNL,baNT);
			baNL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			baNH.setAlignment(Pos.CENTER);
			baNH.setSpacing(20);
			expDH.getChildren().addAll(expDL,expDT);
			expDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			expDH.setAlignment(Pos.CENTER);
			expDH.setSpacing(20);
			recDH.getChildren().addAll(recDL,recDT);
			recDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			recDH.setAlignment(Pos.CENTER);
			recDH.setSpacing(20);
			quanAvH.getChildren().addAll(quanAvL,quanAvT);
			quanAvL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			quanAvH.setAlignment(Pos.CENTER);
			quanAvH.setSpacing(20);
			purPH.getChildren().addAll(purPL,purPT);
			purPL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			purPH.setAlignment(Pos.CENTER);
			purPH.setSpacing(20);
			medIDH.getChildren().addAll(medIDL,medIDT);
			medIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			medIDH.setAlignment(Pos.CENTER);
			medIDH.setSpacing(20);
			supH.getChildren().addAll(supL,supT);
			supL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
			supH.setAlignment(Pos.CENTER);
			supH.setSpacing(20);
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
			all.getChildren().addAll(addEmp,invH,baNH,expDH,recDH,quanAvH,purPH,medIDH,supH,bidH,buttons);
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

		public Label getBaNL() {
			return baNL;
		}

		public void setBaNL(Label baNL) {
			this.baNL = baNL;
		}

		public TextField getBaNT() {
			return baNT;
		}

		public void setBaNT(TextField baNT) {
			this.baNT = baNT;
		}

		public HBox getBaNH() {
			return baNH;
		}

		public void setBaNH(HBox baNH) {
			this.baNH = baNH;
		}

		public Label getExpDL() {
			return expDL;
		}

		public void setExpDL(Label expDL) {
			this.expDL = expDL;
		}

		public DatePicker getExpDT() {
			return expDT;
		}

		public void setExpDT(DatePicker expDT) {
			this.expDT = expDT;
		}

		public HBox getExpDH() {
			return expDH;
		}

		public void setExpDH(HBox expDH) {
			this.expDH = expDH;
		}

		public Label getRecDL() {
			return recDL;
		}

		public void setRecDL(Label recDL) {
			this.recDL = recDL;
		}

		public TextField getRecDT() {
			return recDT;
		}

		public void setRecDT(TextField recDT) {
			this.recDT = recDT;
		}

		public HBox getRecDH() {
			return recDH;
		}

		public void setRecDH(HBox recDH) {
			this.recDH = recDH;
		}

		public Label getQuanAvL() {
			return quanAvL;
		}

		public void setQuanAvL(Label quanAvL) {
			this.quanAvL = quanAvL;
		}

		public TextField getQuanAvT() {
			return quanAvT;
		}

		public void setQuanAvT(TextField quanAvT) {
			this.quanAvT = quanAvT;
		}

		public HBox getQuanAvH() {
			return quanAvH;
		}

		public void setQuanAvH(HBox quanAvH) {
			this.quanAvH = quanAvH;
		}

		public Label getPurPL() {
			return purPL;
		}

		public void setPurPL(Label purPL) {
			this.purPL = purPL;
		}

		public TextField getPurPT() {
			return purPT;
		}

		public void setPurPT(TextField purPT) {
			this.purPT = purPT;
		}

		public HBox getPurPH() {
			return purPH;
		}

		public void setPurPH(HBox purPH) {
			this.purPH = purPH;
		}

		public Label getMedIDL() {
			return medIDL;
		}

		public void setMedIDL(Label medIDL) {
			this.medIDL = medIDL;
		}

		public TextField getMedIDT() {
			return medIDT;
		}

		public void setMedIDT(TextField medIDT) {
			this.medIDT = medIDT;
		}

		public HBox getMedIDH() {
			return medIDH;
		}

		public void setMedIDH(HBox medIDH) {
			this.medIDH = medIDH;
		}

		public Label getSupL() {
			return supL;
		}

		public void setSupL(Label supL) {
			this.supL = supL;
		}

		public TextField getSupT() {
			return supT;
		}

		public void setSupT(TextField supT) {
			this.supT = supT;
		}

		public HBox getSupH() {
			return supH;
		}

		public void setSupH(HBox supH) {
			this.supH = supH;
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

		
		public Button getEdit() {
			return edit;
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
