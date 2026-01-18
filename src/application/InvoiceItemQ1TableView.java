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

    // ===== Title =====
    private Label mt = new Label("Invoice Items - All");

    // ===== Table =====
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

    // ===== Buttons =====
    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    // ===== Constructor (مطابق لـ Q20) =====
    public InvoiceItemQ1TableView() {

        // ----- Title style -----
        mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        mt.setFont(Font.font(null, FontWeight.BOLD, 40));

        // ----- Column bindings -----
        colInvoiceID.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        colMedicineID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colLineTotal.setCellValueFactory(new PropertyValueFactory<>("lineTotal"));

        table.getColumns().addAll(
                colInvoiceID,
                colMedicineID,
                colQuantity,
                colUnitPrice,
                colLineTotal
        );

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(300);

        // ----- Icons size -----
        backVM.setFitWidth(42);
        backVM.setFitHeight(42);
        refVM.setFitWidth(42);
        refVM.setFitHeight(42);

        // ----- Button style -----
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;");

        buttons.getChildren().addAll(back, ref);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        // ----- Layout -----
        all.getChildren().addAll(mt, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        // ----- Load data -----
        table.setItems(loadData());
        ref.setOnAction(e -> table.setItems(loadData()));
    }

    // ===== Query (loadData) =====
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

    // ===== Getter =====
    public VBox getAll() {
        return all;
    }
}
