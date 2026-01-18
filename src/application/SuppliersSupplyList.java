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

public class SuppliersSupplyList {

    private Label title =
            new Label("Suppliers & Supplied Medicines");

    private TableView<SupplierSupplyRow> table =
            new TableView<>();
    private ObservableList<SupplierSupplyRow> data =
            FXCollections.observableArrayList();

    private TableColumn<SupplierSupplyRow, String> colSupplier =
            new TableColumn<>("Supplier Name");
    private TableColumn<SupplierSupplyRow, String> colCount =
            new TableColumn<>("Number of Medicines");
    private TableColumn<SupplierSupplyRow, String> colDate =
            new TableColumn<>("Supply Date");

    private Button back = new Button("Back");

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public SuppliersSupplyList() {

        title.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:30px;"
        );

        colSupplier.setCellValueFactory(
                d -> d.getValue().supplierNameProperty()
        );
        colCount.setCellValueFactory(
                d -> d.getValue().medicineCountProperty()
        );
        colDate.setCellValueFactory(
                d -> d.getValue().supplyDateProperty()
        );

        colSupplier.setPrefWidth(250);
        colCount.setPrefWidth(200);
        colDate.setPrefWidth(200);

        table.getColumns().addAll(
                colSupplier, colCount, colDate
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
        all.setStyle(
                "-fx-background-color: #a2c4c9; -fx-padding: 20;"
        );
    }

    // إضافة صف
    public void addSupplierSupply(
            String supplierName,
            String medicineCount,
            String supplyDate
    ) {
        data.add(
                new SupplierSupplyRow(
                        supplierName, medicineCount, supplyDate
                )
        );
    }

    // تفريغ الجدول
    public void clearSupplies() {
        data.clear();
    }

    public VBox getAll() { return all; }
    public Button getBack() { return back; }
    public TableView<SupplierSupplyRow> getTable() { return table; }
}
