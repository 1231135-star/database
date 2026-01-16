package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;

public class LoginPage {
	private Image ph=new Image("bb.jpg");
	private ImageView phVM=new ImageView(ph);
    private Label title = new Label("Login to MaryCare Pharmacy System");

    private Label userL = new Label("Username :");
    private TextField userT = new TextField();
    private HBox userH = new HBox();

    private Label passL = new Label("Password :");
    private PasswordField passT = new PasswordField();
    private HBox passH = new HBox();

    private Label roleL = new Label("Role :");
    private ChoiceBox<String> roleC = new ChoiceBox<>();
    private HBox roleH = new HBox();

    private Image loginM = new Image("icons8-login-100.png");
    private ImageView loginVM = new ImageView(loginM);
    private Button login = new Button("Login", loginVM);

    private Image clearM = new Image("icons8-clear-100(1).png");
    private ImageView clearVM = new ImageView(clearM);
    private Button clear = new Button("Clear", clearVM);
    
    private Image suM = new Image("icons8-sign-up-100.png");
    private ImageView suVM = new ImageView(suM);
    private Button signup = new Button("Sign Up",suVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public LoginPage() {

        roleC.getItems().addAll("Admin", "Manegar", "Employee", "Customer","Guest");
        roleC.setValue("Guest");

        userH.getChildren().addAll(userL, userT);
        userL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        userH.setAlignment(Pos.CENTER);
        userH.setSpacing(20);

        passH.getChildren().addAll(passL, passT);
        passL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        passH.setAlignment(Pos.CENTER);
        passH.setSpacing(20);

        roleH.getChildren().addAll(roleL, roleC);
        roleL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        roleH.setAlignment(Pos.CENTER);
        roleH.setSpacing(20);

        buttons.getChildren().addAll(login, clear,signup);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        clear.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        login.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        signup.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        
        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");
//        phVM.setStyle("-fx-background-radius: 25;-fx-border-radius: 25;");
        phVM.setFitWidth(150);
        phVM.setFitHeight(150);

        Ellipse clip = new Ellipse(75, 75);
        clip.setCenterX(75);
        clip.setCenterY(75);
        phVM.setClip(clip);

        all.getChildren().addAll(phVM,title, userH, passH, roleH, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        clear.setOnAction(e -> {
            userT.clear();
            passT.clear();
            roleC.setValue("Guest");
        });
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


	public Button getSignup() {
		return signup;
	}


	public void setSignup(Button signup) {
		this.signup = signup;
	}


	public boolean isValidLogin() {

	    String u = userT.getText().trim();
	    String p = passT.getText().trim();
	    String r = roleC.getValue();

	    // Admin account
	    if (r.equals("Admin") && u.equals("admin") && p.equals("admin123")) return true;

	    // Manager account
	    if (r.equals("MANAGER") && u.equals("manager") && p.equals("manager123")) return true;

	    // Employee account
	    if (r.equals("EMPLOYEE") && u.equals("emp") && p.equals("emp123")) return true;

	    // Customer login from DB
	    if (r.equals("CUSTOMER")) {

	        if (u.isEmpty() || p.isEmpty()) return false;

	        // phone must be digits
	        if (!u.matches("\\d+")) return false;

	        // customerId must be digits
	        if (!p.matches("\\d+")) return false;

	        int customerID = Integer.parseInt(p);

	      // return DBCustomer.existsCustomer(customerID, u);
	    }

	    return false;
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public Label getUserL() {
		return userL;
	}

	public void setUserL(Label userL) {
		this.userL = userL;
	}

	public TextField getUserT() {
		return userT;
	}

	public void setUserT(TextField userT) {
		this.userT = userT;
	}

	public HBox getUserH() {
		return userH;
	}

	public void setUserH(HBox userH) {
		this.userH = userH;
	}

	public Label getPassL() {
		return passL;
	}

	public void setPassL(Label passL) {
		this.passL = passL;
	}

	public PasswordField getPassT() {
		return passT;
	}

	public void setPassT(PasswordField passT) {
		this.passT = passT;
	}

	public HBox getPassH() {
		return passH;
	}

	public void setPassH(HBox passH) {
		this.passH = passH;
	}

	public Label getRoleL() {
		return roleL;
	}

	public void setRoleL(Label roleL) {
		this.roleL = roleL;
	}

	public ChoiceBox<String> getRoleC() {
		return roleC;
	}

	public void setRoleC(ChoiceBox<String> roleC) {
		this.roleC = roleC;
	}

	public HBox getRoleH() {
		return roleH;
	}

	public void setRoleH(HBox roleH) {
		this.roleH = roleH;
	}

	public Image getLoginM() {
		return loginM;
	}

	public void setLoginM(Image loginM) {
		this.loginM = loginM;
	}

	public ImageView getLoginVM() {
		return loginVM;
	}

	public void setLoginVM(ImageView loginVM) {
		this.loginVM = loginVM;
	}

	public Button getLogin() {
		return login;
	}

	public void setLogin(Button login) {
		this.login = login;
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
