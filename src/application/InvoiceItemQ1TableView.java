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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InvoiceItemQ1TableView {
    private Label mt = new Label("Invoice Items - All");
    private TableView<InvoiceItemQ1Row> table = new TableView<>();

    private TableColumn<InvoiceItemQ1Row, Integer> colInvoiceID =
            new TableColumn<>("InvoiceID");
    private TableColumn<InvoiceItemQ1Row, Integer> colMedicineID =
            new TableColumn<>("MedicineID");
    private TableColumn<InvoiceItemQ1Row, Integer> colQuantity =
            new TableColumn<>("Quantity");
    private TableColumn<InvoiceItemQ1Row, Double> colUnitPrice =
            new TableColumn<>("UnitPrice");
    private TableColumn<InvoiceItemQ1Row, Double> colLineTotal =
            new TableColumn<>("LineTotal");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public InvoiceItemQ1TableView() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 40));

        colInvoiceID.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colMedicineID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colLineTotal.setCellValueFactory(new PropertyValueFactory<>("lineTotal"));

        table.getColumns().addAll(colInvoiceID,colMedicineID,colQuantity,colUnitPrice,colLineTotal);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(300);

        backVM.setFitWidth(42);
        backVM.setFitHeight(42);
        refVM.setFitWidth(42);
        refVM.setFitHeight(42);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;");

        buttons.getChildren().addAll(back, ref);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(mt, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        table.setItems(loadData());
        ref.setOnAction(e -> table.setItems(loadData()));
    }

    private ObservableList<InvoiceItemQ1Row> loadData() {

        ObservableList<InvoiceItemQ1Row> list =
                FXCollections.observableArrayList();

        String sql = """
                SELECT invoiceID, medicineID, quantity, unitPrice, lineTotal
                FROM Invoice_Item
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new InvoiceItemQ1Row(
                        rs.getInt("invoiceID"),
                        rs.getInt("medicineID"),
                        rs.getInt("quantity"),
                        rs.getDouble("unitPrice"),
                        rs.getDouble("lineTotal")
                ));
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

	public TableView<InvoiceItemQ1Row> getTable() {
		return table;
	}

	public void setTable(TableView<InvoiceItemQ1Row> table) {
		this.table = table;
	}

	public TableColumn<InvoiceItemQ1Row, Integer> getColInvoiceID() {
		return colInvoiceID;
	}

	public void setColInvoiceID(TableColumn<InvoiceItemQ1Row, Integer> colInvoiceID) {
		this.colInvoiceID = colInvoiceID;
	}

	public TableColumn<InvoiceItemQ1Row, Integer> getColMedicineID() {
		return colMedicineID;
	}

	public void setColMedicineID(TableColumn<InvoiceItemQ1Row, Integer> colMedicineID) {
		this.colMedicineID = colMedicineID;
	}

	public TableColumn<InvoiceItemQ1Row, Integer> getColQuantity() {
		return colQuantity;
	}

	public void setColQuantity(TableColumn<InvoiceItemQ1Row, Integer> colQuantity) {
		this.colQuantity = colQuantity;
	}

	public TableColumn<InvoiceItemQ1Row, Double> getColUnitPrice() {
		return colUnitPrice;
	}

	public void setColUnitPrice(TableColumn<InvoiceItemQ1Row, Double> colUnitPrice) {
		this.colUnitPrice = colUnitPrice;
	}

	public TableColumn<InvoiceItemQ1Row, Double> getColLineTotal() {
		return colLineTotal;
	}

	public void setColLineTotal(TableColumn<InvoiceItemQ1Row, Double> colLineTotal) {
		this.colLineTotal = colLineTotal;
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
