package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MedicineTableView {

    private Label mt = new Label("Medicines");

    // ===== Search =====
    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    // ===== Table =====
    private TableView<Medicine> table = new TableView<>();

    private TableColumn<Medicine, Integer> colID =
            new TableColumn<>("MedicineID");
    private TableColumn<Medicine, String> colName =
            new TableColumn<>("MedicineName");
    private TableColumn<Medicine, String> colStrength =
            new TableColumn<>("Strength");
    private TableColumn<Medicine, Boolean> colReqPres =
            new TableColumn<>("RequiresPrescription");
    private TableColumn<Medicine, Integer> colCategoryID =
            new TableColumn<>("CategoryID");

    // ===== Buttons =====
    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM = new Image("icons8-refresh-100.png");
    private ImageView refVM = new ImageView(refM);
    private Button ref = new Button("Refresh", refVM);

    private Image delM = new Image("icons8-remove-employee-100.png");
    private ImageView delVM = new ImageView(delM);
    private Button deleteB = new Button("Delete", delVM);

    private Image upM = new Image("icons8-edit-property-100.png");
    private ImageView upVM = new ImageView(upM);
    private Button updateB = new Button("Update", upVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public MedicineTableView() {

        // ===== Search style =====
        searchL.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:20px;"
        );
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle(buttonStyle());
        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        // ===== Table columns =====
        colID.setCellValueFactory(
                new PropertyValueFactory<>("medicineID")
        );
        colName.setCellValueFactory(
                new PropertyValueFactory<>("medicineName")
        );
        colStrength.setCellValueFactory(
                new PropertyValueFactory<>("strength")
        );
        colReqPres.setCellValueFactory(
                new PropertyValueFactory<>("requiresPrescription")
        );
        colCategoryID.setCellValueFactory(
                new PropertyValueFactory<>("categoryID")
        );

        table.getColumns().addAll(
                colID, colName, colStrength, colReqPres, colCategoryID
        );

        // ===== Buttons style =====
        back.setStyle(buttonStyle());
        ref.setStyle(buttonStyle());
        deleteB.setStyle(buttonStyle());
        updateB.setStyle(buttonStyle());

        delVM.setFitWidth(42);
        delVM.setFitHeight(42);
        upVM.setFitWidth(42);
        upVM.setFitHeight(42);

        deleteB.setDisable(true);
        updateB.setDisable(true);

        // ===== Title =====
        mt.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:40px;"
        );

        // ===== Buttons layout =====
        buttons.getChildren().addAll(back, ref, updateB, deleteB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        // ===== Main layout =====
        all.getChildren().addAll(mt, searchH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

    // ===== Reusable button style =====
    private String buttonStyle() {
        return "-fx-background-color: #76a5af;" +
               "-fx-text-fill: #0c343d;" +
               "-fx-font-weight: bold;" +
               "-fx-font-size:20px;" +
               "-fx-background-radius: 25;" +
               "-fx-border-radius: 25;";
    }

    // ===== Getters =====
    public VBox getAll() { return all; }
    public TableView<Medicine> getTable() { return table; }

    public Button getBack() { return back; }
    public Button getRef() { return ref; }
    public Button getDeleteB() { return deleteB; }
    public Button getUpdateB() { return updateB; }
    public Button getSearchB() { return searchB; }
    public TextField getSearchT() { return searchT; }
}
