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

public class InvoiceQ33TableView {

    private Label mt = new Label("Q33 - Branch Summary Report");

    private TableView<InvoiceQ33Row> table = new TableView<>();
    private TableColumn<InvoiceQ33Row, Integer> colBID = new TableColumn<>("BranchID");
    private TableColumn<InvoiceQ33Row, String> colBName = new TableColumn<>("BranchName");
    private TableColumn<InvoiceQ33Row, Double> colSales = new TableColumn<>("TotalSales");
    private TableColumn<InvoiceQ33Row, Double> colProfit = new TableColumn<>("TotalProfit");
    private TableColumn<InvoiceQ33Row, String> colBestMed = new TableColumn<>("BestSellingMedicine");
    private TableColumn<InvoiceQ33Row, Integer> colBestQty = new TableColumn<>("BestQtySold");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public InvoiceQ33TableView() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 40));

        colBID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        colBName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        colSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));
        colProfit.setCellValueFactory(new PropertyValueFactory<>("totalProfit"));
        colBestMed.setCellValueFactory(new PropertyValueFactory<>("bestSellingMedicine"));
        colBestQty.setCellValueFactory(new PropertyValueFactory<>("bestSellingQty"));

        table.getColumns().addAll(colBID, colBName, colSales, colProfit, colBestMed, colBestQty);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(420);

        backVM.setFitWidth(42);
        backVM.setFitHeight(42);
        refVM.setFitWidth(42);
        refVM.setFitHeight(42);


        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

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

    private ObservableList<InvoiceQ33Row> loadData() {
        ObservableList<InvoiceQ33Row> list = FXCollections.observableArrayList();

        String sql = """
                SELECT 
                    b.BranchID,
                    b.BranchName,

                    IFNULL(SUM(i.TotalAmount),0) AS TotalSales,

                    (IFNULL(SUM(i.TotalAmount),0) - 
                     IFNULL((SELECT SUM(p.TotalCost) 
                             FROM Purchase p 
                             WHERE p.BranchID=b.BranchID),0)
                    ) AS TotalProfit,

                    (
                       SELECT m.MedName
                       FROM Invoice i2
                       JOIN Invoice_Item ii2 ON i2.InvoiceID = ii2.InvoiceID
                       JOIN Medicine m ON m.MedID = ii2.MedID
                       WHERE i2.BranchID = b.BranchID
                       GROUP BY m.MedID, m.MedName
                       ORDER BY SUM(ii2.Quantity) DESC
                       LIMIT 1
                    ) AS BestMedicine,

                    (
                       SELECT IFNULL(SUM(ii3.Quantity),0)
                       FROM Invoice i3
                       JOIN Invoice_Item ii3 ON i3.InvoiceID = ii3.InvoiceID
                       WHERE i3.BranchID = b.BranchID
                       GROUP BY ii3.MedID
                       ORDER BY SUM(ii3.Quantity) DESC
                       LIMIT 1
                    ) AS BestQty

                FROM Branch b
                LEFT JOIN Invoice i ON i.BranchID = b.BranchID
                GROUP BY b.BranchID, b.BranchName
                ORDER BY TotalSales DESC
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new InvoiceQ33Row(
                        rs.getInt("BranchID"),
                        rs.getString("BranchName"),
                        rs.getDouble("TotalSales"),
                        rs.getDouble("TotalProfit"),
                        rs.getString("BestMedicine"),
                        rs.getInt("BestQty")
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

	public TableView<InvoiceQ33Row> getTable() {
		return table;
	}

	public void setTable(TableView<InvoiceQ33Row> table) {
		this.table = table;
	}

	public TableColumn<InvoiceQ33Row, Integer> getColBID() {
		return colBID;
	}

	public void setColBID(TableColumn<InvoiceQ33Row, Integer> colBID) {
		this.colBID = colBID;
	}

	public TableColumn<InvoiceQ33Row, String> getColBName() {
		return colBName;
	}

	public void setColBName(TableColumn<InvoiceQ33Row, String> colBName) {
		this.colBName = colBName;
	}

	public TableColumn<InvoiceQ33Row, Double> getColSales() {
		return colSales;
	}

	public void setColSales(TableColumn<InvoiceQ33Row, Double> colSales) {
		this.colSales = colSales;
	}

	public TableColumn<InvoiceQ33Row, Double> getColProfit() {
		return colProfit;
	}

	public void setColProfit(TableColumn<InvoiceQ33Row, Double> colProfit) {
		this.colProfit = colProfit;
	}

	public TableColumn<InvoiceQ33Row, String> getColBestMed() {
		return colBestMed;
	}

	public void setColBestMed(TableColumn<InvoiceQ33Row, String> colBestMed) {
		this.colBestMed = colBestMed;
	}

	public TableColumn<InvoiceQ33Row, Integer> getColBestQty() {
		return colBestQty;
	}

	public void setColBestQty(TableColumn<InvoiceQ33Row, Integer> colBestQty) {
		this.colBestQty = colBestQty;
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
