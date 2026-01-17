package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class CustomerTableView {

    private Label mt = new Label("Customers Table");

    private TableView<Customer> table = new TableView<>();
    private ObservableList<Customer> data = FXCollections.observableArrayList();

    private TableColumn<Customer, Integer> cidC = new TableColumn<>("Customer ID");
    private TableColumn<Customer, String> nameC = new TableColumn<>("Full Name");
    private TableColumn<Customer, String> phoneC = new TableColumn<>("Phone Number");
    private TableColumn<Customer, String> emailC = new TableColumn<>("Email");
    private TableColumn<Customer, String> addressC = new TableColumn<>("Address");

    private Image refreshM = new Image("icons8-refresh-100.png");
    private ImageView refreshVM = new ImageView(refreshM);
    private Button refresh = new Button("Refresh", refreshVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public CustomerTableView() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        cidC.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneC.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailC.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressC.setCellValueFactory(new PropertyValueFactory<>("address"));

        cidC.setPrefWidth(120);
        nameC.setPrefWidth(180);
        phoneC.setPrefWidth(150);
        emailC.setPrefWidth(180);
        addressC.setPrefWidth(220);

        table.getColumns().addAll(cidC, nameC, phoneC, emailC, addressC);
        table.setItems(data);
        table.setStyle("-fx-font-size:16px;");

        refreshVM.setFitWidth(35);
        refreshVM.setFitHeight(35);

        backVM.setFitWidth(35);
        backVM.setFitHeight(35);

        refresh.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        buttons.getChildren().addAll(refresh, back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(mt, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

    public void loadData(Connection con) {
        data.clear();

        try {
            String sql = "SELECT * FROM Customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String name = rs.getString("FullName");
                String phone = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                String address = rs.getString("Address");

                data.add(new Customer(id, name, phone, email, address));
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
	}

	public TableView<Customer> getTable() {
		return table;
	}

	public void setTable(TableView<Customer> table) {
		this.table = table;
	}

	public ObservableList<Customer> getData() {
		return data;
	}

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public TableColumn<Customer, Integer> getCidC() {
		return cidC;
	}

	public void setCidC(TableColumn<Customer, Integer> cidC) {
		this.cidC = cidC;
	}

	public TableColumn<Customer, String> getNameC() {
		return nameC;
	}

	public void setNameC(TableColumn<Customer, String> nameC) {
		this.nameC = nameC;
	}

	public TableColumn<Customer, String> getPhoneC() {
		return phoneC;
	}

	public void setPhoneC(TableColumn<Customer, String> phoneC) {
		this.phoneC = phoneC;
	}

	public TableColumn<Customer, String> getEmailC() {
		return emailC;
	}

	public void setEmailC(TableColumn<Customer, String> emailC) {
		this.emailC = emailC;
	}

	public TableColumn<Customer, String> getAddressC() {
		return addressC;
	}

	public void setAddressC(TableColumn<Customer, String> addressC) {
		this.addressC = addressC;
	}

	public Image getRefreshM() {
		return refreshM;
	}

	public void setRefreshM(Image refreshM) {
		this.refreshM = refreshM;
	}

	public ImageView getRefreshVM() {
		return refreshVM;
	}

	public void setRefreshVM(ImageView refreshVM) {
		this.refreshVM = refreshVM;
	}

	public Button getRefresh() {
		return refresh;
	}

	public void setRefresh(Button refresh) {
		this.refresh = refresh;
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
