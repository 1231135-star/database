package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

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

public class MedicinesSuppliedBySupplierTableView {

    private Label mt =
            new Label("Medicines Supplied by Supplier");

    private Label supplierL =
            new Label("Supplier:");
    private ComboBox<SupplierItem> supplierC =
            new ComboBox<>();

    private Label fromL =
            new Label("From:");
    private DatePicker fromD =
            new DatePicker();

    private Label toL =
            new Label("To:");
    private DatePicker toD =
            new DatePicker();

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

    private TableView<MedicineSupplyRow> table =
            new TableView<>();
    private ObservableList<MedicineSupplyRow> data =
            FXCollections.observableArrayList();

    private TableColumn<MedicineSupplyRow, String> colSupplier =
            new TableColumn<>("Supplier");
    private TableColumn<MedicineSupplyRow, String> colMedId =
            new TableColumn<>("Medicine ID");
    private TableColumn<MedicineSupplyRow, String> colMedName =
            new TableColumn<>("Medicine Name");
    private TableColumn<MedicineSupplyRow, String> colSupplyDate =
            new TableColumn<>("Supply Date");

    private HBox filtersH =
            new HBox();
    private HBox buttons =
            new HBox();
    private VBox all =
            new VBox();

    public MedicinesSuppliedBySupplierTableView() {

        // ===== Title =====
        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 35));

        // ===== Filters =====
        supplierL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:18px;");
        fromL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:18px;");
        toL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:18px;");

        supplierC.setPromptText("select supplier");
        supplierC.setPrefWidth(220);
        supplierC.setItems(loadSuppliers());

        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);
        clearVM.setFitWidth(42);
        clearVM.setFitHeight(42);
        backVM.setFitWidth(42);
        backVM.setFitHeight(42);

        styleButton(searchB);
        styleButton(clearB);
        styleButton(back);

        filtersH.getChildren().addAll(
                supplierL, supplierC,
                fromL, fromD,
                toL, toD
        );
        filtersH.setSpacing(12);
        filtersH.setAlignment(Pos.CENTER);

        // ===== Table =====
        colSupplier.setCellValueFactory(d -> d.getValue().supplierProperty());
        colMedId.setCellValueFactory(d -> d.getValue().medicineIdProperty());
        colMedName.setCellValueFactory(d -> d.getValue().medicineNameProperty());
        colSupplyDate.setCellValueFactory(d -> d.getValue().supplyDateProperty());

        table.getColumns().addAll(
                colSupplier, colMedId, colMedName, colSupplyDate
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

        SupplierItem supplier = supplierC.getValue();
        LocalDate from = fromD.getValue();
        LocalDate to = toD.getValue();

        if (supplier == null) {
            alert("Please select supplier");
            return;
        }

        data.clear();

        String sql = """
            SELECT s.SupplierName,
                   m.MedicineID,
                   m.MedicineName,
                   p.SupplyDate
            FROM Purchase p
            JOIN Supplier s ON p.SupplierID = s.SupplierID
            JOIN Medicine m ON p.MedicineID = m.MedicineID
            WHERE p.SupplierID = ?
              AND (? IS NULL OR p.SupplyDate >= ?)
              AND (? IS NULL OR p.SupplyDate <= ?)
        """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, supplier.getSupplierID());

            ps.setObject(2, from);
            ps.setObject(3, from);

            ps.setObject(4, to);
            ps.setObject(5, to);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                data.add(new MedicineSupplyRow(
                        rs.getString("SupplierName"),
                        rs.getString("MedicineID"),
                        rs.getString("MedicineName"),
                        rs.getString("SupplyDate")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            alert(ex.getMessage());
        }
    }

    // ================= CLEAR =================
    private void clear() {
        supplierC.setValue(null);
        fromD.setValue(null);
        toD.setValue(null);
        data.clear();
    }

    // ================= LOAD SUPPLIERS =================
    private ObservableList<SupplierItem> loadSuppliers() {

        ObservableList<SupplierItem> list =
                FXCollections.observableArrayList();

        String sql =
                "SELECT SupplierID, SupplierName FROM Supplier";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new SupplierItem(
                        rs.getInt("SupplierID"),
                        rs.getString("SupplierName")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
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
    public TableView<MedicineSupplyRow> getTable() { return table; }
}
