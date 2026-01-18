package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MedicinesExpiryList  {

    private Label mt =
            new Label("Expired & Near-Expiry Medicines");

    private Label daysL =
            new Label("Days ≤");
    private TextField daysT =
            new TextField("30");

    private Image searchM =
            new Image("icons8-search-100.png");
    private ImageView searchVM =
            new ImageView(searchM);
    private Button searchB =
            new Button("Search", searchVM);

    private Image clearM =
            new Image("icons8-refresh-100.png");
    private ImageView clearVM =
            new ImageView(clearM);
    private Button clearB =
            new Button("Clear", clearVM);

    private Image backM =
            new Image("icons8-back-100(2).png");
    private ImageView backVM =
            new ImageView(backM);
    private Button back =
            new Button("Back", backVM);

    private TableView<MedicineExpiryRow> table =
            new TableView<>();
    private ObservableList<MedicineExpiryRow> data =
            FXCollections.observableArrayList();

    private TableColumn<MedicineExpiryRow, String> colId =
            new TableColumn<>("Medicine ID");
    private TableColumn<MedicineExpiryRow, String> colName =
            new TableColumn<>("Medicine Name");
    private TableColumn<MedicineExpiryRow, String> colCategory =
            new TableColumn<>("Category");
    private TableColumn<MedicineExpiryRow, String> colSupplier =
            new TableColumn<>("Supplier");
    private TableColumn<MedicineExpiryRow, String> colExpiry =
            new TableColumn<>("Expiry Date");

    private HBox filtersH =
            new HBox();
    private HBox buttons =
            new HBox();
    private VBox all =
            new VBox();

    public MedicinesExpiryList() {

        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 35));

        daysL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        daysT.setPrefWidth(100);

        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);
        clearVM.setFitWidth(42);
        clearVM.setFitHeight(42);
        backVM.setFitWidth(42);
        backVM.setFitHeight(42);

        styleButton(searchB);
        styleButton(clearB);
        styleButton(back);

        filtersH.getChildren().addAll(daysL, daysT);
        filtersH.setSpacing(15);
        filtersH.setAlignment(Pos.CENTER);

        colId.setCellValueFactory(d -> d.getValue().idProperty());
        colName.setCellValueFactory(d -> d.getValue().nameProperty());
        colCategory.setCellValueFactory(d -> d.getValue().categoryProperty());
        colSupplier.setCellValueFactory(d -> d.getValue().supplierProperty());
        colExpiry.setCellValueFactory(d -> d.getValue().expiryProperty());

        table.getColumns().addAll(
                colId, colName, colCategory, colSupplier, colExpiry
        );
        table.setItems(data);
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

        int days;
        try {
            days = Integer.parseInt(daysT.getText().trim());
        } catch (Exception ex) {
            alert("Invalid days value");
            return;
        }

        data.clear();

        String sql = """
        	    SELECT 
        	        m.medicineid,
        	        m.medicinename,
        	        c.categoryname,
        	        s.suppliername,
        	        i.expirydate
        	    FROM inventory_item i
        	    JOIN medicine m ON i.medicineid = m.medicineid
        	    JOIN category c ON m.categoryid = c.categoryid
        	    JOIN supplier s ON i.supplierid = s.supplierid
        	    WHERE i.expirydate <= DATE_ADD(CURDATE(), INTERVAL ? DAY)
        	    ORDER BY i.expirydate
        	""";


        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, days);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                data.add(new MedicineExpiryRow(
                        rs.getString("MedicineID"),
                        rs.getString("MedicineName"),
                        rs.getString("CategoryName"),
                        rs.getString("SupplierName"),
                        rs.getString("ExpiryDate")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            alert(ex.getMessage());
        }
    }

    private void clear() {
        daysT.setText("30");
        data.clear();
    }

    private void styleButton(Button b) {
        b.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;"
                + "-fx-font-weight: bold;-fx-font-size:20px;"
                + "-fx-background-radius: 25;");
    }

    private void alert(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(msg);
        a.showAndWait();
    }

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
	}

	public Label getDaysL() {
		return daysL;
	}

	public void setDaysL(Label daysL) {
		this.daysL = daysL;
	}

	public TextField getDaysT() {
		return daysT;
	}

	public void setDaysT(TextField daysT) {
		this.daysT = daysT;
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

	public TableView<MedicineExpiryRow> getTable() {
		return table;
	}

	public void setTable(TableView<MedicineExpiryRow> table) {
		this.table = table;
	}

	public ObservableList<MedicineExpiryRow> getData() {
		return data;
	}

	public void setData(ObservableList<MedicineExpiryRow> data) {
		this.data = data;
	}

	public TableColumn<MedicineExpiryRow, String> getColId() {
		return colId;
	}

	public void setColId(TableColumn<MedicineExpiryRow, String> colId) {
		this.colId = colId;
	}

	public TableColumn<MedicineExpiryRow, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<MedicineExpiryRow, String> colName) {
		this.colName = colName;
	}

	public TableColumn<MedicineExpiryRow, String> getColCategory() {
		return colCategory;
	}

	public void setColCategory(TableColumn<MedicineExpiryRow, String> colCategory) {
		this.colCategory = colCategory;
	}

	public TableColumn<MedicineExpiryRow, String> getColSupplier() {
		return colSupplier;
	}

	public void setColSupplier(TableColumn<MedicineExpiryRow, String> colSupplier) {
		this.colSupplier = colSupplier;
	}

	public TableColumn<MedicineExpiryRow, String> getColExpiry() {
		return colExpiry;
	}

	public void setColExpiry(TableColumn<MedicineExpiryRow, String> colExpiry) {
		this.colExpiry = colExpiry;
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

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

    
}
