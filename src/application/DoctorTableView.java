package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DoctorTableView {

    private Label title = new Label("Doctors");
    private TableView<Doctor> table = new TableView<>();

    private TableColumn<Doctor, Integer> colID = new TableColumn<>("ID");
    private TableColumn<Doctor, String> colName = new TableColumn<>("Name");
    private TableColumn<Doctor, String> colLicense = new TableColumn<>("License Number");
    private TableColumn<Doctor, String> colPhone = new TableColumn<>("Phone");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
   	
	private HBox buttons=new HBox();

    private VBox all = new VBox();

    public DoctorTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        table.getColumns().addAll(colID, colName, colLicense, colPhone);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(450);

        backVM.setFitWidth(42);
        backVM.setFitHeight(42);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        buttons.getChildren().addAll(back,ref);
        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");

        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color:#a2c4c9;");
    }
    public void loadDoctorsData(Connection con) {

        ObservableList<Doctor> list = FXCollections.observableArrayList();

        String sql = """
            select doctorid, fullname, licensenumber, phonenumber, email, clinicaddress
            from doctor
            order by doctorid
            """;

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("doctorid"),
                        rs.getString("fullname"),
                        rs.getString("licensenumber"),
                        rs.getString("phonenumber"),
                        rs.getString("email"),
                        rs.getString("clinicaddress")
                );
                list.add(d);
            }

            table.setItems(list);

        } catch (Exception ex) {
            ex.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText("Error loading doctors data ❌");
            a.showAndWait();
        }
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

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TableView<Doctor> getTable() {
		return table;
	}

	public void setTable(TableView<Doctor> table) {
		this.table = table;
	}

	public TableColumn<Doctor, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Doctor, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Doctor, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Doctor, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Doctor, String> getColLicense() {
		return colLicense;
	}

	public void setColLicense(TableColumn<Doctor, String> colLicense) {
		this.colLicense = colLicense;
	}

	public TableColumn<Doctor, String> getColPhone() {
		return colPhone;
	}

	public void setColPhone(TableColumn<Doctor, String> colPhone) {
		this.colPhone = colPhone;
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

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

  
}
