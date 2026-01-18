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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InvoiceQ17TableView {

    private Label mt = new Label("Q17 - Sales Transactions (Invoice + Employee)");

    private TableView<InvoiceQ17Row> table = new TableView<>();
    private TableColumn<InvoiceQ17Row, Integer> colID = new TableColumn<>("InvoiceID");
    private TableColumn<InvoiceQ17Row, String> colDate = new TableColumn<>("InvoiceDate");
    private TableColumn<InvoiceQ17Row, Double> colTotal = new TableColumn<>("TotalAmount");
    private TableColumn<InvoiceQ17Row, String> colEmp = new TableColumn<>("EmployeeName");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public InvoiceQ17TableView() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 40));

        colID.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

        table.getColumns().addAll(colID, colDate, colTotal, colEmp);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(420);

        backVM.setFitWidth(42);
        backVM.setFitHeight(42);
        refVM.setFitWidth(42);
        refVM.setFitHeight(42);

  
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

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

    private ObservableList<InvoiceQ17Row> loadData() {
        ObservableList<InvoiceQ17Row> list = FXCollections.observableArrayList();

        String sql = """
                select i.invoiceid, i.invoicedate, i.totalamount, e.fullname
                from invoice i
                join employee e on i.empid = e.empid
                order by i.invoicedate desc
                """;


        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new InvoiceQ17Row(
                        rs.getInt("InvoiceID"),
                        rs.getString("InvoiceDate"),
                        rs.getDouble("TotalAmount"),
                        rs.getString("FullName")
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

	public TableView<InvoiceQ17Row> getTable() {
		return table;
	}

	public void setTable(TableView<InvoiceQ17Row> table) {
		this.table = table;
	}

	public TableColumn<InvoiceQ17Row, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<InvoiceQ17Row, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<InvoiceQ17Row, String> getColDate() {
		return colDate;
	}

	public void setColDate(TableColumn<InvoiceQ17Row, String> colDate) {
		this.colDate = colDate;
	}

	public TableColumn<InvoiceQ17Row, Double> getColTotal() {
		return colTotal;
	}

	public void setColTotal(TableColumn<InvoiceQ17Row, Double> colTotal) {
		this.colTotal = colTotal;
	}

	public TableColumn<InvoiceQ17Row, String> getColEmp() {
		return colEmp;
	}

	public void setColEmp(TableColumn<InvoiceQ17Row, String> colEmp) {
		this.colEmp = colEmp;
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
