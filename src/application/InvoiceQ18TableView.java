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

public class InvoiceQ18TableView {

    private Label mt = new Label("Q18 - Total Sales & Purchases (Current Month)");

    private TableView<InvoiceQ18Row> table = new TableView<>();
    private TableColumn<InvoiceQ18Row, Double> colSales = new TableColumn<>("Total Sales");
    private TableColumn<InvoiceQ18Row, Double> colPurch = new TableColumn<>("Total Purchases");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public InvoiceQ18TableView() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 40));

        colSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));
        colPurch.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));

        table.getColumns().addAll(colSales, colPurch);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(250);

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

    private ObservableList<InvoiceQ18Row> loadData() {
        ObservableList<InvoiceQ18Row> list = FXCollections.observableArrayList();

        String sql = """
                SELECT
                   (SELECT IFNULL(SUM(TotalAmount),0)
                    FROM Invoice
                    WHERE MONTH(InvoiceDate)=MONTH(CURDATE())
                    AND YEAR(InvoiceDate)=YEAR(CURDATE())
                   ) AS TotalSales,

                   (SELECT IFNULL(SUM(TotalCost),0)
                    FROM Purchase
                    WHERE MONTH(PurchaseDate)=MONTH(CURDATE())
                    AND YEAR(PurchaseDate)=YEAR(CURDATE())
                   ) AS TotalPurchases
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                list.add(new InvoiceQ18Row(rs.getDouble("TotalSales"),rs.getDouble("TotalPurchases")));
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

	public TableView<InvoiceQ18Row> getTable() {
		return table;
	}

	public void setTable(TableView<InvoiceQ18Row> table) {
		this.table = table;
	}

	public TableColumn<InvoiceQ18Row, Double> getColSales() {
		return colSales;
	}

	public void setColSales(TableColumn<InvoiceQ18Row, Double> colSales) {
		this.colSales = colSales;
	}

	public TableColumn<InvoiceQ18Row, Double> getColPurch() {
		return colPurch;
	}

	public void setColPurch(TableColumn<InvoiceQ18Row, Double> colPurch) {
		this.colPurch = colPurch;
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
