package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StoredMedicinesTable {

    private Label title = new Label("Stored Medicines");

    private TableView<MedicineRow> table = new TableView<>();
    private ObservableList<MedicineRow> data = FXCollections.observableArrayList();

    private TableColumn<MedicineRow, String> colId =
            new TableColumn<>("ID");
    private TableColumn<MedicineRow, String> colName =
            new TableColumn<>("Medicine Name");
    private TableColumn<MedicineRow, String> colCategory =
            new TableColumn<>("Category");
    private TableColumn<MedicineRow, Number> colPrice =
            new TableColumn<>("Price");

    private Button back = new Button("Back");

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public StoredMedicinesTable() {

        title.setStyle("-fx-text-fill:#0c343d; -fx-font-weight:bold; -fx-font-size:30px;");

        colId.setCellValueFactory(d -> d.getValue().idProperty());
        colName.setCellValueFactory(d -> d.getValue().nameProperty());
        colCategory.setCellValueFactory(d -> d.getValue().categoryProperty());
        colPrice.setCellValueFactory(d -> d.getValue().priceProperty());

        table.getColumns().addAll(colId, colName, colCategory, colPrice);
        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(260);

        table.setStyle(
                "-fx-background-color:#a2c4c9;" +
                "-fx-control-inner-background:rgba(255,255,255,0.6);" +
                "-fx-font-size:16px;"
        );

        back.setStyle(
                "-fx-background-color:#76a5af;" +
                "-fx-text-fill:#0c343d;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:20px;" +
                "-fx-background-radius:25;"
        );

        buttons.getChildren().add(back);
        buttons.setAlignment(Pos.CENTER);

        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color:#a2c4c9; -fx-padding:20;");
    }

    public void addMedicine(String id, String name, String category, double price) {
        data.add(new MedicineRow(id, name, category, price));
    }

    public void clearTable() {
        data.clear();
    }

    public VBox getAll() {
        return all;
    }

    public Button getBack() {
        return back;
    }
}
