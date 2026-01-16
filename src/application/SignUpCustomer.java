package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SignUpCustomer {

    private Label title = new Label("Customer Sign Up");

    private Label idL = new Label("customer id (national id) :");
    private TextField idT = new TextField();
    private HBox idH = new HBox();

    private Label nameL = new Label("full name :");
    private TextField nameT = new TextField();
    private HBox nameH = new HBox();

    private Label phoneL = new Label("phone :");
    private TextField phoneT = new TextField();
    private HBox phoneH = new HBox();

    private Label emailL = new Label("email :");
    private TextField emailT = new TextField();
    private HBox emailH = new HBox();

    private Label addressL = new Label("address :");
    private TextField addressT = new TextField();
    private HBox addressH = new HBox();

    private Image suM = new Image("icons8-sign-up-100.png");
    private ImageView suVM = new ImageView(suM);
    private Button create = new Button("create account",suVM);
    
    private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	
	private Image clearM=new Image("icons8-clear-100(1).png");
	private ImageView clearVM=new ImageView(clearM);
	private Button clear=new Button("clear",clearVM);
	
    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public SignUpCustomer() {
        idH.getChildren().addAll(idL, idT);
        nameH.getChildren().addAll(nameL, nameT);
        phoneH.getChildren().addAll(phoneL, phoneT);
        emailH.getChildren().addAll(emailL, emailT);
        addressH.getChildren().addAll(addressL, addressT);


        idL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        nameL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        phoneL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        emailL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        addressL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

        idH.setAlignment(Pos.CENTER); idH.setSpacing(20);
        nameH.setAlignment(Pos.CENTER); nameH.setSpacing(20);
        phoneH.setAlignment(Pos.CENTER); phoneH.setSpacing(20);
        emailH.setAlignment(Pos.CENTER); emailH.setSpacing(20);
        addressH.setAlignment(Pos.CENTER); addressH.setSpacing(20);

        create.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        buttons.getChildren().addAll(create, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        all.getChildren().addAll(title, idH, nameH, phoneH, emailH, addressH, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        clear.setOnAction(e -> {
            idT.clear();
            nameT.clear();
            phoneT.clear();
            emailT.clear();
            addressT.clear();
        });

        create.setOnAction(e -> {

            String id = idT.getText().trim();
            String name = nameT.getText().trim();
            String phone = phoneT.getText().trim();

            if (id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("error empty feilds");
                a.setHeaderText("error empty feilds");
                a.setContentText("customer ID name, and phone are required");
                a.showAndWait();
                return;
            }

            if (!id.matches("\\d+")) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("invalid customer id");
                a.setContentText("invalid customer id");
                a.showAndWait();
                return;
            }

            if (!phone.matches("\\d+")) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("invalid phone number");
                a.setContentText("invalid phone number");
                a.showAndWait();
                return;
            }

            Alert ok = new Alert(Alert.AlertType.INFORMATION);
            ok.setTitle("success");
            ok.setHeaderText("account created Succesfuly");
            ok.setContentText("account created Succesfuly");
            ok.showAndWait();
        });
    }

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public Label getIdL() {
		return idL;
	}

	public void setIdL(Label idL) {
		this.idL = idL;
	}

	public TextField getIdT() {
		return idT;
	}

	public void setIdT(TextField idT) {
		this.idT = idT;
	}

	public HBox getIdH() {
		return idH;
	}

	public void setIdH(HBox idH) {
		this.idH = idH;
	}

	public Label getNameL() {
		return nameL;
	}

	public void setNameL(Label nameL) {
		this.nameL = nameL;
	}

	public TextField getNameT() {
		return nameT;
	}

	public void setNameT(TextField nameT) {
		this.nameT = nameT;
	}

	public HBox getNameH() {
		return nameH;
	}

	public void setNameH(HBox nameH) {
		this.nameH = nameH;
	}

	public Label getPhoneL() {
		return phoneL;
	}

	public void setPhoneL(Label phoneL) {
		this.phoneL = phoneL;
	}

	public TextField getPhoneT() {
		return phoneT;
	}

	public void setPhoneT(TextField phoneT) {
		this.phoneT = phoneT;
	}

	public HBox getPhoneH() {
		return phoneH;
	}

	public void setPhoneH(HBox phoneH) {
		this.phoneH = phoneH;
	}

	public Label getEmailL() {
		return emailL;
	}

	public void setEmailL(Label emailL) {
		this.emailL = emailL;
	}

	public TextField getEmailT() {
		return emailT;
	}

	public void setEmailT(TextField emailT) {
		this.emailT = emailT;
	}

	public HBox getEmailH() {
		return emailH;
	}

	public void setEmailH(HBox emailH) {
		this.emailH = emailH;
	}

	public Label getAddressL() {
		return addressL;
	}

	public void setAddressL(Label addressL) {
		this.addressL = addressL;
	}

	public TextField getAddressT() {
		return addressT;
	}

	public void setAddressT(TextField addressT) {
		this.addressT = addressT;
	}

	public HBox getAddressH() {
		return addressH;
	}

	public void setAddressH(HBox addressH) {
		this.addressH = addressH;
	}

	public Image getSuM() {
		return suM;
	}

	public void setSuM(Image suM) {
		this.suM = suM;
	}

	public ImageView getSuVM() {
		return suVM;
	}

	public void setSuVM(ImageView suVM) {
		this.suVM = suVM;
	}

	public Button getCreate() {
		return create;
	}

	public void setCreate(Button create) {
		this.create = create;
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
