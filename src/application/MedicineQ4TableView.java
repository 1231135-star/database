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

public class MedicineQ4TableView {

    private Label title = new Label("Q4 - All Stored Medicines");

    private TableView<MedicineQ4Row> table = new TableView<>();

    private TableColumn<MedicineQ4Row, Integer> colID =
            new TableColumn<>("Medicine ID");
    private TableColumn<MedicineQ4Row, String> colName =
            new TableColumn<>("Medicine Name");
    private TableColumn<MedicineQ4Row, String> colStrength =
            new TableColumn<>("Strength");
    private TableColumn<MedicineQ4Row, Boolean> colReq =
            new TableColumn<>("Prescription");
    private TableColumn<MedicineQ4Row, String> colDesc =
            new TableColumn<>("Description");

    private ImageView backVM =
            new ImageView(new Image("icons8-back-100(2).png"));
    private Button back = new Button("Back", backVM);

    private ImageView refVM =
            new ImageView(new Image("icons8-refresh-100.png"));
    private Button ref = new Button("Refresh", refVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public MedicineQ4TableView() {

        title.setFont(Font.font(null, FontWeight.BOLD, 40));
        title.setStyle("-fx-text-fill: #0c343d;");

        colID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colStrength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        colReq.setCellValueFactory(new PropertyValueFactory<>("requiresPrescription"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));

        table.getColumns().addAll(colID, colName, colStrength, colReq, colDesc);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(420);

        backVM.setFitWidth(42);
        backVM.setFitHeight(42);
        refVM.setFitWidth(42);
        refVM.setFitHeight(42);

        String style =
                "-fx-background-color: #76a5af;" +
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 20px;" +
                "-fx-background-radius: 25;";

        back.setStyle(style);
        ref.setStyle(style);

        buttons.getChildren().addAll(back, ref);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        table.setItems(loadData());
        ref.setOnAction(e -> table.setItems(loadData()));
    }

    private ObservableList<MedicineQ4Row> loadData() {

        ObservableList<MedicineQ4Row> list =
                FXCollections.observableArrayList();

        String sql = """
                SELECT medicineid, medicinename, strength,
                       requirespre, description
                FROM medicine
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new MedicineQ4Row(
                        rs.getInt("medicineid"),
                        rs.getString("medicinename"),
                        rs.getString("strength"),
                        rs.getBoolean("requirespre"),
                        rs.getString("description")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public VBox getAll() {
        return all;
    }

    public Button getBack() {
        return back;
    }
}
