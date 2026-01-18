package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MedicinesLossesList {

    private Label title =
            new Label("Losses from Expired & Damaged Medicines");

    private TableView<MedicineLossRow> table =
            new TableView<>();
    private ObservableList<MedicineLossRow> data =
            FXCollections.observableArrayList();

    private TableColumn<MedicineLossRow, String> colBranch =
            new TableColumn<>("Branch");
    private TableColumn<MedicineLossRow, String> colMedId =
            new TableColumn<>("Medicine ID");
    private TableColumn<MedicineLossRow, String> colMedName =
            new TableColumn<>("Medicine Name");
    private TableColumn<MedicineLossRow, String> colStatus =
            new TableColumn<>("Status");
    private TableColumn<MedicineLossRow, String> colQty =
            new TableColumn<>("Quantity");
    private TableColumn<MedicineLossRow, String> colPrice =
            new TableColumn<>("Unit Price");
    private TableColumn<MedicineLossRow, String> colLoss =
            new TableColumn<>("Loss Amount");

    private Button back = new Button("Back");

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public MedicinesLossesList() {

        title.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:30px;"
        );

        colBranch.setCellValueFactory(d -> d.getValue().branchProperty());
        colMedId.setCellValueFactory(d -> d.getValue().medicineIdProperty());
        colMedName.setCellValueFactory(d -> d.getValue().medicineNameProperty());
        colStatus.setCellValueFactory(d -> d.getValue().statusProperty());
        colQty.setCellValueFactory(d -> d.getValue().quantityProperty());
        colPrice.setCellValueFactory(d -> d.getValue().unitPriceProperty());
        colLoss.setCellValueFactory(d -> d.getValue().lossAmountProperty());

        table.getColumns().addAll(
                colBranch, colMedId, colMedName,
                colStatus, colQty, colPrice, colLoss
        );

        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setFixedCellSize(40);
        table.setPrefHeight(300);

        table.setStyle(
                "-fx-background-color: #a2c4c9;" +
                "-fx-control-inner-background: rgba(255,255,255,0.55);" +
                "-fx-font-size: 16px;"
        );

        back.setStyle(
                "-fx-background-color: #76a5af;" +
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:20px;" +
                "-fx-background-radius: 25;" +
                "-fx-border-radius: 25;"
        );

        buttons.getChildren().add(back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9; -fx-padding: 20;");
    }

    // إضافة صف
    public void addLoss(
            String branch,
            String medId,
            String medName,
            String status,
            String qty,
            String price,
            String loss
    ) {
        data.add(
                new MedicineLossRow(
                        branch, medId, medName,
                        status, qty, price, loss
                )
        );
    }

    public void clearLosses() {
        data.clear();
    }

    public VBox getAll() { return all; }
    public Button getBack() { return back; }
    public TableView<MedicineLossRow> getTable() { return table; }
}
