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

public class InvoiceQ32TableView {

    private Label mt = new Label("Q32 - Medicines Sold in Time Period");

    private Label fromL = new Label("From (YYYY-MM-DD):");
    private TextField fromT = new TextField();

    private Label toL = new Label("To (YYYY-MM-DD):");
    private TextField toT = new TextField();

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);

    private Image clearM = new Image("icons8-refresh-100.png");
    private ImageView clearVM = new ImageView(clearM);
    private Button clearB = new Button("Clear", clearVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private HBox filtersH = new HBox();
    private HBox buttons = new HBox();

    private TableView<InvoiceQ32Row> table = new TableView<>();
    private TableColumn<InvoiceQ32Row, Integer> colMID = new TableColumn<>("MedicineID");
    private TableColumn<InvoiceQ32Row, String> colMName = new TableColumn<>("MedicineName");
    private TableColumn<InvoiceQ32Row, Integer> colQty = new TableColumn<>("TotalQtySold");
    private TableColumn<InvoiceQ32Row, Double> colSales = new TableColumn<>("TotalSales");

    private VBox all = new VBox();

    public InvoiceQ32TableView() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 35));

        fromL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        toL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

        fromT.setPromptText("2025-01-01");
        toT.setPromptText("2025-12-31");
        fromT.setPrefWidth(160);
        toT.setPrefWidth(160);

        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);
        clearVM.setFitWidth(42);
        clearVM.setFitHeight(42);
        backVM.setFitWidth(42);
        backVM.setFitHeight(42);


        searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        clearB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        filtersH.getChildren().addAll(fromL, fromT, toL, toT);
        filtersH.setSpacing(15);
        filtersH.setAlignment(Pos.CENTER);

        colMID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colMName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("totalQtySold"));
        colSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));

        table.getColumns().addAll(colMID, colMName, colQty, colSales);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(420);

        buttons.getChildren().addAll(back, searchB, clearB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(mt, filtersH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        searchB.setOnAction(e -> doSearch());
        clearB.setOnAction(e -> clear());
    }

    private void doSearch() {

        String from = fromT.getText().trim();
        String to = toT.getText().trim();

        if (from.isEmpty() || to.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Missing Dates");
            a.setHeaderText("Please enter From and To dates");
            a.showAndWait();
            return;
        }

        ObservableList<InvoiceQ32Row> list = FXCollections.observableArrayList();

        String sql = """
        	    select
        	        m.medicineid as medicineid,
        	        m.medicinename as medicinename,
        	        sum(ii.quantity) as totalqty,
        	        sum(ii.quantity * ii.unitprice) as totalsales
        	    from invoice i
        	    join invoice_item ii on i.invoiceid = ii.invoiceid
        	    join inventory_item inv on inv.inventoryitemid = ii.inventoryitemid
        	    join medicine m on m.medicineid = inv.medicineid
        	    where i.invoicedate between ? and ?
        	    group by m.medicineid, m.medicinename
        	    order by totalsales desc
        	    """;


        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, from);
            ps.setString(2, to);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new InvoiceQ32Row(
                        rs.getInt("MedID"),
                        rs.getString("MedName"),
                        rs.getInt("TotalQty"),
                        rs.getDouble("TotalSales")
                ));
            }

            table.setItems(list);

            if (list.isEmpty()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("No Results");
                a.setHeaderText("No medicines sold in this period");
                a.showAndWait();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(ex.getMessage());
            a.showAndWait();
        }
    }

    private void clear() {
        fromT.clear();
        toT.clear();
        table.setItems(FXCollections.observableArrayList());
    }

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
	}

	public Label getFromL() {
		return fromL;
	}

	public void setFromL(Label fromL) {
		this.fromL = fromL;
	}

	public TextField getFromT() {
		return fromT;
	}

	public void setFromT(TextField fromT) {
		this.fromT = fromT;
	}

	public Label getToL() {
		return toL;
	}

	public void setToL(Label toL) {
		this.toL = toL;
	}

	public TextField getToT() {
		return toT;
	}

	public void setToT(TextField toT) {
		this.toT = toT;
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

	public Button getClearB() {
		return clearB;
	}

	public void setClearB(Button clearB) {
		this.clearB = clearB;
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

	public HBox getFiltersH() {
		return filtersH;
	}

	public void setFiltersH(HBox filtersH) {
		this.filtersH = filtersH;
	}

	public HBox getButtons() {
		return buttons;
	}

	public void setButtons(HBox buttons) {
		this.buttons = buttons;
	}

	public TableView<InvoiceQ32Row> getTable() {
		return table;
	}

	public void setTable(TableView<InvoiceQ32Row> table) {
		this.table = table;
	}

	public TableColumn<InvoiceQ32Row, Integer> getColMID() {
		return colMID;
	}

	public void setColMID(TableColumn<InvoiceQ32Row, Integer> colMID) {
		this.colMID = colMID;
	}

	public TableColumn<InvoiceQ32Row, String> getColMName() {
		return colMName;
	}

	public void setColMName(TableColumn<InvoiceQ32Row, String> colMName) {
		this.colMName = colMName;
	}

	public TableColumn<InvoiceQ32Row, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<InvoiceQ32Row, Integer> colQty) {
		this.colQty = colQty;
	}

	public TableColumn<InvoiceQ32Row, Double> getColSales() {
		return colSales;
	}

	public void setColSales(TableColumn<InvoiceQ32Row, Double> colSales) {
		this.colSales = colSales;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

}
