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

        // ===== Title =====
        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 35));

        // ===== Filter =====
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

        // ===== Table =====
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

        // ===== Buttons =====
        buttons.getChildren().addAll(back, searchB, clearB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        // ===== Layout =====
        all.getChildren().addAll(mt, filtersH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        // ===== Actions =====
        searchB.setOnAction(e -> doSearch());
        clearB.setOnAction(e -> clear());
    }

    // ================= SEARCH =================
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
            SELECT m.MedicineID,
                   m.MedicineName,
                   c.CategoryName,
                   s.SupplierName,
                   i.ExpiryDate
            FROM Inventory i
            JOIN Medicine m ON i.MedicineID = m.MedicineID
            JOIN Category c ON m.CategoryID = c.CategoryID
            JOIN Supplier s ON i.SupplierID = s.SupplierID
            WHERE i.ExpiryDate <= DATE_ADD(CURDATE(), INTERVAL ? DAY)
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

    // ================= CLEAR =================
    private void clear() {
        daysT.setText("30");
        data.clear();
    }

    // ================= HELPERS =================
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

    public VBox getAll() { return all; }
    public Button getBack() { return back; }
    public TableView<MedicineExpiryRow> getTable() { return table; }
}
