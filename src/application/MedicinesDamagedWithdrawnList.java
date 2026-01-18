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

public class MedicinesDamagedWithdrawnList {

    private Label title =
            new Label("Damaged & Withdrawn Medicines by Branch");

    private TableView<MedicineDamageRow> table =
            new TableView<>();
    private ObservableList<MedicineDamageRow> data =
            FXCollections.observableArrayList();

    private TableColumn<MedicineDamageRow, String> colBranch =
            new TableColumn<>("Branch");
    private TableColumn<MedicineDamageRow, String> colMedId =
            new TableColumn<>("Medicine ID");
    private TableColumn<MedicineDamageRow, String> colMedName =
            new TableColumn<>("Medicine Name");
    private TableColumn<MedicineDamageRow, String> colStatus =
            new TableColumn<>("Status");
    private TableColumn<MedicineDamageRow, String> colQuantity =
            new TableColumn<>("Quantity");

    private Button back = new Button("Back");

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public MedicinesDamagedWithdrawnList() {

        title.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:30px;"
        );

        colBranch.setCellValueFactory(
                d -> d.getValue().branchProperty()
        );
        colMedId.setCellValueFactory(
                d -> d.getValue().medicineIdProperty()
        );
        colMedName.setCellValueFactory(
                d -> d.getValue().medicineNameProperty()
        );
        colStatus.setCellValueFactory(
                d -> d.getValue().statusProperty()
        );
        colQuantity.setCellValueFactory(
                d -> d.getValue().quantityProperty()
        );

        colBranch.setPrefWidth(200);
        colMedId.setPrefWidth(120);
        colMedName.setPrefWidth(200);
        colStatus.setPrefWidth(150);
        colQuantity.setPrefWidth(100);

        table.getColumns().addAll(
                colBranch, colMedId, colMedName, colStatus, colQuantity
        );
        table.setItems(data);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );
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
    public void addMedicine(
            String branch,
            String medicineId,
            String medicineName,
            String status,
            String quantity
    ) {
        data.add(
                new MedicineDamageRow(
                        branch, medicineId, medicineName, status, quantity
                )
        );
    }

    // تفريغ الجدول
    public void clearMedicines() {
        data.clear();
    }

    public VBox getAll() { return all; }
    public Button getBack() { return back; }
    public TableView<MedicineDamageRow> getTable() { return table; }
}
