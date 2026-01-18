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

public class SupplierTableView {

    private Label st = new Label("Suppliers");

    // ===== Search =====
    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

    // ===== Table =====
    private TableView<Supplier> table = new TableView<>();

    private TableColumn<Supplier, Integer> colID =
            new TableColumn<>("SupplierID");
    private TableColumn<Supplier, String> colName =
            new TableColumn<>("SupplierName");
    private TableColumn<Supplier, String> colPhone =
            new TableColumn<>("Phone");
    private TableColumn<Supplier, String> colEmail =
            new TableColumn<>("Email");
    private TableColumn<Supplier, String> colAddress =
            new TableColumn<>("Address");

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

    public SupplierTableView() {

        // ===== Search style =====
        searchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold; -fx-font-size:20px;");
        searchL.setFont(Font.font(null, FontWeight.BOLD, 20));

        searchB.setStyle(
                "-fx-background-color: #76a5af;" +
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:20px;" +
                "-fx-background-radius: 25;" +
                "-fx-border-radius: 25;"
        );

        searchVM.setFitWidth(42);
        searchVM.setFitHeight(42);

        searchH.getChildren().addAll(searchL, searchT, searchB);
        searchH.setSpacing(10);
        searchH.setAlignment(Pos.CENTER);

        // ===== Table columns =====
        colID.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        table.getColumns().addAll(
                colID, colName, colPhone, colEmail, colAddress
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
        st.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold; -fx-font-size:40px;");

        // ===== Buttons layout =====
        buttons.getChildren().addAll(back, ref, updateB, deleteB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        // ===== Main layout =====
        all.getChildren().addAll(st, searchH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

    // ===== Reusable style =====
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
    public TableView<Supplier> getTable() { return table; }

    public Button getBack() { return back; }
    public Button getRef() { return ref; }
    public Button getDeleteB() { return deleteB; }
    public Button getUpdateB() { return updateB; }
    public Button getSearchB() { return searchB; }

    public TextField getSearchT() { return searchT; }
}
