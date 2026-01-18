package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InsuranceCompanyTableView {

    private Label title = new Label("Insurance Companies");

    private TableView<InsuranceCompany> table = new TableView<>();
    private ObservableList<InsuranceCompany> data = FXCollections.observableArrayList();

    private TableColumn<InsuranceCompany, Integer> idCol = new TableColumn<>("ID");
    private TableColumn<InsuranceCompany, String> nameCol = new TableColumn<>("Company Name");
    private TableColumn<InsuranceCompany, String> licCol = new TableColumn<>("License No");
    private TableColumn<InsuranceCompany, String> phoneCol = new TableColumn<>("Phone");
    private TableColumn<InsuranceCompany, String> emailCol = new TableColumn<>("Email");
    private TableColumn<InsuranceCompany, String> addressCol = new TableColumn<>("Address");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);
    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
   	
    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public InsuranceCompanyTableView() {

        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        idCol.setCellValueFactory(new PropertyValueFactory<>("insuranceCompanyID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        licCol.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        idCol.setPrefWidth(80);
        nameCol.setPrefWidth(170);
        licCol.setPrefWidth(140);
        phoneCol.setPrefWidth(120);
        emailCol.setPrefWidth(180);
        addressCol.setPrefWidth(200);

        table.getColumns().addAll(idCol, nameCol, licCol, phoneCol, emailCol, addressCol);
        table.setItems(data);
        table.setPrefHeight(500);

        table.setStyle("-fx-background-color: white; -fx-border-color: #0c343d; -fx-border-width:2;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        backVM.setFitWidth(42);
        backVM.setFitHeight(42);

        buttons.getChildren().addAll(back,ref);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

    public void loadData(Connection con) {
        data.clear();

        try {
            String sql = "SELECT * FROM insurance_company";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("insurancecompanyid");
                String name = rs.getString("companyname");
                String lic = rs.getString("licenseno");
                String phone = rs.getString("phonenumber");
                String email = rs.getString("email");
                String addr = rs.getString("address");

                data.add(new InsuranceCompany(id, name, lic, phone, email, addr));
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TableView<InsuranceCompany> getTable() {
		return table;
	}

	public void setTable(TableView<InsuranceCompany> table) {
		this.table = table;
	}

	public ObservableList<InsuranceCompany> getData() {
		return data;
	}

	public void setData(ObservableList<InsuranceCompany> data) {
		this.data = data;
	}

	public TableColumn<InsuranceCompany, Integer> getIdCol() {
		return idCol;
	}

	public void setIdCol(TableColumn<InsuranceCompany, Integer> idCol) {
		this.idCol = idCol;
	}

	public TableColumn<InsuranceCompany, String> getNameCol() {
		return nameCol;
	}

	public void setNameCol(TableColumn<InsuranceCompany, String> nameCol) {
		this.nameCol = nameCol;
	}

	public TableColumn<InsuranceCompany, String> getLicCol() {
		return licCol;
	}

	public void setLicCol(TableColumn<InsuranceCompany, String> licCol) {
		this.licCol = licCol;
	}

	public TableColumn<InsuranceCompany, String> getPhoneCol() {
		return phoneCol;
	}

	public void setPhoneCol(TableColumn<InsuranceCompany, String> phoneCol) {
		this.phoneCol = phoneCol;
	}

	public TableColumn<InsuranceCompany, String> getEmailCol() {
		return emailCol;
	}

	public void setEmailCol(TableColumn<InsuranceCompany, String> emailCol) {
		this.emailCol = emailCol;
	}

	public TableColumn<InsuranceCompany, String> getAddressCol() {
		return addressCol;
	}

	public void setAddressCol(TableColumn<InsuranceCompany, String> addressCol) {
		this.addressCol = addressCol;
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

	public Image getRefM() {
		return refM;
	}

	public void setRefM(Image refM) {
		this.refM = refM;
	}

	public ImageView getRefVM() {
		return refVM;
	}

	public void setRefVM(ImageView refVM) {
		this.refVM = refVM;
	}

	public Button getRef() {
		return ref;
	}

	public void setRef(Button ref) {
		this.ref = ref;
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
