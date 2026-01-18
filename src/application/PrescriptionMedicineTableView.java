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

public class PrescriptionMedicineTableView {

    private Label title = new Label("Prescription Medicine Table");

    private TableView<PrescriptionMedicineRow> table = new TableView<>();
    private ObservableList<PrescriptionMedicineRow> data = FXCollections.observableArrayList();

    private TableColumn<PrescriptionMedicineRow, Integer> preIDCol = new TableColumn<>("Prescription ID");
    private TableColumn<PrescriptionMedicineRow, Integer> medIDCol = new TableColumn<>("Medicine ID");
    private TableColumn<PrescriptionMedicineRow, String> dosageCol = new TableColumn<>("Dosage");

    private Label preIDL = new Label("Prescription ID :");
    private TextField preIDT = new TextField();
    private HBox preIDH = new HBox();

    private Label medIDL = new Label("Medicine ID :");
    private TextField medIDT = new TextField();
    private HBox medIDH = new HBox();

    private Label dosageL = new Label("Dosage :");
    private TextField dosageT = new TextField();
    private HBox dosageH = new HBox();

    private Image refreshM = new Image("icons8-refresh-100.png");
    private ImageView refreshVM = new ImageView(refreshM);
    private Button refresh = new Button("Refresh", refreshVM);

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private HBox buttons = new HBox();
    private VBox all = new VBox();

    public PrescriptionMedicineTableView() {

        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:30px;");

        preIDCol.setCellValueFactory(new PropertyValueFactory<>("prescriptionid"));
        medIDCol.setCellValueFactory(new PropertyValueFactory<>("medicineid"));
        dosageCol.setCellValueFactory(new PropertyValueFactory<>("dosage"));

        preIDCol.setPrefWidth(200);
        medIDCol.setPrefWidth(200);
        dosageCol.setPrefWidth(250);

        table.getColumns().addAll(preIDCol, medIDCol, dosageCol);
        table.setItems(data);
        table.setPrefHeight(350);

        preIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        medIDL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
        dosageL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

        preIDL.setFont(Font.font(null, FontWeight.BOLD, 20));
        medIDL.setFont(Font.font(null, FontWeight.BOLD, 20));
        dosageL.setFont(Font.font(null, FontWeight.BOLD, 20));

        preIDT.setEditable(false);
        medIDT.setEditable(false);
        dosageT.setEditable(false);

        preIDH.getChildren().addAll(preIDL, preIDT);
        preIDH.setAlignment(Pos.CENTER);
        preIDH.setSpacing(20);

        medIDH.getChildren().addAll(medIDL, medIDT);
        medIDH.setAlignment(Pos.CENTER);
        medIDH.setSpacing(20);

        dosageH.getChildren().addAll(dosageL, dosageT);
        dosageH.setAlignment(Pos.CENTER);
        dosageH.setSpacing(20);

        refreshVM.setFitWidth(42); refreshVM.setFitHeight(42);
        backVM.setFitWidth(42); backVM.setFitHeight(42);

        refresh.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

        buttons.getChildren().addAll(refresh,back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(title, table, preIDH, medIDH, dosageH, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(18);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TableView<PrescriptionMedicineRow> getTable() {
		return table;
	}

	public void setTable(TableView<PrescriptionMedicineRow> table) {
		this.table = table;
	}

	public ObservableList<PrescriptionMedicineRow> getData() {
		return data;
	}

	public void setData(ObservableList<PrescriptionMedicineRow> data) {
		this.data = data;
	}

	public TableColumn<PrescriptionMedicineRow, Integer> getPreIDCol() {
		return preIDCol;
	}

	public void setPreIDCol(TableColumn<PrescriptionMedicineRow, Integer> preIDCol) {
		this.preIDCol = preIDCol;
	}

	public TableColumn<PrescriptionMedicineRow, Integer> getMedIDCol() {
		return medIDCol;
	}

	public void setMedIDCol(TableColumn<PrescriptionMedicineRow, Integer> medIDCol) {
		this.medIDCol = medIDCol;
	}

	public TableColumn<PrescriptionMedicineRow, String> getDosageCol() {
		return dosageCol;
	}

	public void setDosageCol(TableColumn<PrescriptionMedicineRow, String> dosageCol) {
		this.dosageCol = dosageCol;
	}

	public Label getPreIDL() {
		return preIDL;
	}

	public void setPreIDL(Label preIDL) {
		this.preIDL = preIDL;
	}

	public TextField getPreIDT() {
		return preIDT;
	}

	public void setPreIDT(TextField preIDT) {
		this.preIDT = preIDT;
	}

	public HBox getPreIDH() {
		return preIDH;
	}

	public void setPreIDH(HBox preIDH) {
		this.preIDH = preIDH;
	}

	public Label getMedIDL() {
		return medIDL;
	}

	public void setMedIDL(Label medIDL) {
		this.medIDL = medIDL;
	}

	public TextField getMedIDT() {
		return medIDT;
	}

	public void setMedIDT(TextField medIDT) {
		this.medIDT = medIDT;
	}

	public HBox getMedIDH() {
		return medIDH;
	}

	public void setMedIDH(HBox medIDH) {
		this.medIDH = medIDH;
	}

	public Label getDosageL() {
		return dosageL;
	}

	public void setDosageL(Label dosageL) {
		this.dosageL = dosageL;
	}

	public TextField getDosageT() {
		return dosageT;
	}

	public void setDosageT(TextField dosageT) {
		this.dosageT = dosageT;
	}

	public HBox getDosageH() {
		return dosageH;
	}

	public void setDosageH(HBox dosageH) {
		this.dosageH = dosageH;
	}

	public Image getRefreshM() {
		return refreshM;
	}

	public void setRefreshM(Image refreshM) {
		this.refreshM = refreshM;
	}

	public ImageView getRefreshVM() {
		return refreshVM;
	}

	public void setRefreshVM(ImageView refreshVM) {
		this.refreshVM = refreshVM;
	}

	public Button getRefresh() {
		return refresh;
	}

	public void setRefresh(Button refresh) {
		this.refresh = refresh;
	}

	public Image getBackM() {
		return backM;
	}

	public void setBackM(Image backM) {
		this.backM = backM;
	}

	public ImageView getBackVM() {
		return backVM;
	}

	public void setBackVM(ImageView backVM) {
		this.backVM = backVM;
	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}

	public HBox getButtons() {
		return buttons;
	}

	public void setButtons(HBox buttons) {
		this.buttons = buttons;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

    
}
