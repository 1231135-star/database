package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UpdateInvoiceItem {

    private Label title = new Label("Update Invoice Item");

    private Label invL = new Label("Invoice ID :");
    private TextField invT = new TextField();
    private HBox invH = new HBox();

    private Label invTL = new Label("Inventory ID :");
    private TextField invTT = new TextField();
    private HBox invTH = new HBox();

    private Label quanL = new Label("Quantity :");
    private TextField quanT = new TextField();
    private HBox quanH = new HBox();

    private Label upriL = new Label("Unit Price :");
    private TextField upriT = new TextField();
    private HBox upriH = new HBox();

    private Image editM = new Image("icons8-edit-property-100.png");
    private ImageView editVM = new ImageView(editM);
    private Button edit = new Button("Edit", editVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image clearM = new Image("icons8-clear-100(1).png");
    private ImageView clearVM = new ImageView(clearM);
    private Button clear = new Button("Clear", clearVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public UpdateInvoiceItem() {

        invT.setEditable(false);
        invTT.setEditable(false);

        invH.getChildren().addAll(invL, invT);
        invTH.getChildren().addAll(invTL, invTT);
        quanH.getChildren().addAll(quanL, quanT);
        upriH.getChildren().addAll(upriL, upriT);

        invH.setAlignment(Pos.CENTER);
        invTH.setAlignment(Pos.CENTER);
        quanH.setAlignment(Pos.CENTER);
        upriH.setAlignment(Pos.CENTER);

        invH.setSpacing(20);
        invTH.setSpacing(20);
        quanH.setSpacing(20);
        upriH.setSpacing(20);

        buttons.getChildren().addAll(edit, back, clear);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(title, invH, invTH, quanH, upriH, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");

        title.setStyle("-fx-font-size:30px; -fx-font-weight:bold;");

        clear.setOnAction(e -> clearFields());
    }

    // ===== Getters =====
    public TextField getInvT() { return invT; }
    public TextField getInvTT() { return invTT; }
    public TextField getQuanT() { return quanT; }
    public TextField getUpriT() { return upriT; }
    public Button getEdit() { return edit; }
    public Button getBack() { return back; }
    public VBox getAll() { return all; }

    // ===== Helper =====
    public void clearFields() {
        quanT.clear();
        upriT.clear();
    }
}
