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

public class MedicinesByCategoryList {

    private Label title =
            new Label("Medicines Grouped by Category");

    private TableView<MedicineCategoryRow> table =
            new TableView<>();
    private ObservableList<MedicineCategoryRow> data =
            FXCollections.observableArrayList();

    private TableColumn<MedicineCategoryRow, String> colCategory =
            new TableColumn<>("Category");
    private TableColumn<MedicineCategoryRow, String> colMedId =
            new TableColumn<>("Medicine ID");
    private TableColumn<MedicineCategoryRow, String> colMedName =
            new TableColumn<>("Medicine Name");

    private Button back = new Button("Back");

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public MedicinesByCategoryList() {

        title.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:30px;"
        );

        colCategory.setCellValueFactory(
                d -> d.getValue().categoryProperty()
        );
        colMedId.setCellValueFactory(
                d -> d.getValue().medicineIdProperty()
        );
        colMedName.setCellValueFactory(
                d -> d.getValue().medicineNameProperty()
        );

        colCategory.setPrefWidth(220);
        colMedId.setPrefWidth(150);
        colMedName.setPrefWidth(250);

        table.getColumns().addAll(
                colCategory, colMedId, colMedName
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
            String category,
            String medicineId,
            String medicineName
    ) {
        data.add(
                new MedicineCategoryRow(
                        category, medicineId, medicineName
                )
        );
    }

    // تفريغ الجدول
    public void clearMedicines() {
        data.clear();
    }

    public VBox getAll() { return all; }
    public Button getBack() { return back; }
    public TableView<MedicineCategoryRow> getTable() { return table; }
}
