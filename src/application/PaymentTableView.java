package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class PaymentTableView {

    private Label mt = new Label("Payments");

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    private TableView<Payment> table = new TableView<>();

    private TableColumn<Payment, Integer> colID = new TableColumn<>("PaymentID");
    private TableColumn<Payment, LocalDate> colDate = new TableColumn<>("PaymentDate");
    private TableColumn<Payment, String> colType = new TableColumn<>("PaymentType");
    private TableColumn<Payment, Double> colAmount = new TableColumn<>("Amount");
    private TableColumn<Payment, String> colRef = new TableColumn<>("ReferenceNumber");
    private TableColumn<Payment, Integer> colInvoice = new TableColumn<>("InvoiceID");
    private TableColumn<Payment, Integer> colPolicy = new TableColumn<>("PolicyID");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private Image delM = new Image("icons8-remove-employee-100.png");
    private ImageView delVM = new ImageView(delM);
    private Button deleteB = new Button("Delete", delVM);

    private Image upM = new Image("icons8-edit-property-100.png");
    private ImageView upVM = new ImageView(upM);
    private Button updateB = new Button("Update", upVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public PaymentTableView() {

        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");

        colID.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        colType.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colRef.setCellValueFactory(new PropertyValueFactory<>("referenceNumber"));
        colInvoice.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colPolicy.setCellValueFactory(new PropertyValueFactory<>("policyID"));

        colID.setPrefWidth(90);
        colDate.setPrefWidth(120);
        colType.setPrefWidth(140);
        colAmount.setPrefWidth(90);
        colRef.setPrefWidth(160);
        colInvoice.setPrefWidth(90);
        colPolicy.setPrefWidth(90);

        table.getColumns().addAll(colID, colDate, colType, colAmount, colRef, colInvoice, colPolicy);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        deleteB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        updateB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        delVM.setFitWidth(42);
        delVM.setFitHeight(42);
        upVM.setFitWidth(42);
        upVM.setFitHeight(42);

        deleteB.setDisable(true);
        updateB.setDisable(true);

        buttons.getChildren().addAll(back, ref, updateB, deleteB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(mt, searchH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        table.setItems(loadAllPayments());

        ref.setOnAction(e ->{
        	table.setItems(loadAllPayments());
        });

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            boolean selected = (newSel != null);
            deleteB.setDisable(!selected);
            updateB.setDisable(!selected);
        });

        searchB.setOnAction(e -> {
            String id = searchT.getText();
            if (id == null || id.trim().isEmpty()) {
                table.setItems(loadAllPayments());
                return;
            }

            if (!id.matches("\\d+")) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Invalid ID");
                a.setHeaderText("Invalid PaymentID");
                a.setContentText("Please enter a numeric PaymentID.");
                a.showAndWait();
                return;
            }

            table.setItems(searchPaymentByID(Integer.parseInt(id.trim())));
        });
    }


    private ObservableList<Payment> loadAllPayments() {
        ObservableList<Payment> list = FXCollections.observableArrayList();

        String sql = """
                SELECT paymentid, paymentdate, paymenttype, amount, referencenumber, invoiceid, policyid
                FROM payment
                ORDER BY paymentdate DESC
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Payment(
                        rs.getInt("paymentid"),
                        rs.getDate("paymentdate").toLocalDate(),
                        rs.getString("paymenttype"),
                        rs.getDouble("amount"),
                        rs.getString("referencenumber"),
                        rs.getInt("invoiceid"),
                        rs.getInt("policyid")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private ObservableList<Payment> searchPaymentByID(int paymentID) {
        ObservableList<Payment> list = FXCollections.observableArrayList();

        String sql = """
                SELECT paymentid, paymentdate, paymenttype, amount, referencenumber, invoiceid, policyid
                FROM payment
                WHERE paymentid = ?
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, paymentID);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Payment(
                            rs.getInt("paymentid"),
                            rs.getDate("paymentdate").toLocalDate(),
                            rs.getString("paymenttype"),
                            rs.getDouble("amount"),
                            rs.getString("referencenumber"),
                            rs.getInt("invoiceid"),
                            rs.getInt("policyid")
                    ));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }


	public Label getMt() {
		return mt;
	}


	public void setMt(Label mt) {
		this.mt = mt;
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


	public TableView<Payment> getTable() {
		return table;
	}


	public void setTable(TableView<Payment> table) {
		this.table = table;
	}


	public TableColumn<Payment, Integer> getColID() {
		return colID;
	}


	public void setColID(TableColumn<Payment, Integer> colID) {
		this.colID = colID;
	}


	public TableColumn<Payment, LocalDate> getColDate() {
		return colDate;
	}


	public void setColDate(TableColumn<Payment, LocalDate> colDate) {
		this.colDate = colDate;
	}


	public TableColumn<Payment, String> getColType() {
		return colType;
	}


	public void setColType(TableColumn<Payment, String> colType) {
		this.colType = colType;
	}


	public TableColumn<Payment, Double> getColAmount() {
		return colAmount;
	}


	public void setColAmount(TableColumn<Payment, Double> colAmount) {
		this.colAmount = colAmount;
	}


	public TableColumn<Payment, String> getColRef() {
		return colRef;
	}


	public void setColRef(TableColumn<Payment, String> colRef) {
		this.colRef = colRef;
	}


	public TableColumn<Payment, Integer> getColInvoice() {
		return colInvoice;
	}


	public void setColInvoice(TableColumn<Payment, Integer> colInvoice) {
		this.colInvoice = colInvoice;
	}


	public TableColumn<Payment, Integer> getColPolicy() {
		return colPolicy;
	}


	public void setColPolicy(TableColumn<Payment, Integer> colPolicy) {
		this.colPolicy = colPolicy;
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


	public Image getDelM() {
		return delM;
	}


	public void setDelM(Image delM) {
		this.delM = delM;
	}


	public ImageView getDelVM() {
		return delVM;
	}


	public void setDelVM(ImageView delVM) {
		this.delVM = delVM;
	}


	public Button getDeleteB() {
		return deleteB;
	}


	public void setDeleteB(Button deleteB) {
		this.deleteB = deleteB;
	}


	public Image getUpM() {
		return upM;
	}


	public void setUpM(Image upM) {
		this.upM = upM;
	}


	public ImageView getUpVM() {
		return upVM;
	}


	public void setUpVM(ImageView upVM) {
		this.upVM = upVM;
	}


	public Button getUpdateB() {
		return updateB;
	}


	public void setUpdateB(Button updateB) {
		this.updateB = updateB;
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
