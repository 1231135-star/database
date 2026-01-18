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

    private Image searchM = new Image("icons8-search-100.png");
    private ImageView searchVM = new ImageView(searchM);
    private Button searchB = new Button("Search", searchVM);
    private Label searchL = new Label("put id :");
    private TextField searchT = new TextField();
    private HBox searchH = new HBox();

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

        mt.setStyle(
                "-fx-text-fill: #0c343d;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size:40px;"
        );

        buttons.getChildren().addAll(back, ref, updateB, deleteB);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        all.getChildren().addAll(mt, searchH, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

    private String buttonStyle() {
        return "-fx-background-color: #76a5af;" +
               "-fx-text-fill: #0c343d;" +
               "-fx-font-weight: bold;" +
               "-fx-font-size:20px;" +
               "-fx-background-radius: 25;" +
               "-fx-border-radius: 25;";
    }

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
	}

	public Image getSearchM() {
		return searchM;
	}

	public void setSearchM(Image searchM) {
		this.searchM = searchM;
	}

	public ImageView getSearchVM() {
		return searchVM;
	}

	public void setSearchVM(ImageView searchVM) {
		this.searchVM = searchVM;
	}

	public Button getSearchB() {
		return searchB;
	}

	public void setSearchB(Button searchB) {
		this.searchB = searchB;
	}

	public Label getSearchL() {
		return searchL;
	}

	public void setSearchL(Label searchL) {
		this.searchL = searchL;
	}

	public TextField getSearchT() {
		return searchT;
	}

	public void setSearchT(TextField searchT) {
		this.searchT = searchT;
	}

	public HBox getSearchH() {
		return searchH;
	}

	public void setSearchH(HBox searchH) {
		this.searchH = searchH;
	}

	public TableView<Medicine> getTable() {
		return table;
	}

	public void setTable(TableView<Medicine> table) {
		this.table = table;
	}

	public TableColumn<Medicine, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Medicine, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Medicine, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Medicine, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Medicine, String> getColStrength() {
		return colStrength;
	}

	public void setColStrength(TableColumn<Medicine, String> colStrength) {
		this.colStrength = colStrength;
	}

	public TableColumn<Medicine, Boolean> getColReqPres() {
		return colReqPres;
	}

	public void setColReqPres(TableColumn<Medicine, Boolean> colReqPres) {
		this.colReqPres = colReqPres;
	}

	public TableColumn<Medicine, Integer> getColCategoryID() {
		return colCategoryID;
	}

	public void setColCategoryID(TableColumn<Medicine, Integer> colCategoryID) {
		this.colCategoryID = colCategoryID;
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

	public Image getRefM() {
		return refM;
	}

	public void setRefM(Image refM) {
		this.refM = refM;
	}

	public ImageView getRefVM() {
		return refVM;
	}

	public void setRefVM(ImageView refVM) {
		this.refVM = refVM;
	}

	public Button getRef() {
		return ref;
	}

	public void setRef(Button ref) {
		this.ref = ref;
	}

	public Image getDelM() {
		return delM;
	}

	public void setDelM(Image delM) {
		this.delM = delM;
	}

	public ImageView getDelVM() {
		return delVM;
	}

	public void setDelVM(ImageView delVM) {
		this.delVM = delVM;
	}

	public Button getDeleteB() {
		return deleteB;
	}

	public void setDeleteB(Button deleteB) {
		this.deleteB = deleteB;
	}

	public Image getUpM() {
		return upM;
	}

	public void setUpM(Image upM) {
		this.upM = upM;
	}

	public ImageView getUpVM() {
		return upVM;
	}

	public void setUpVM(ImageView upVM) {
		this.upVM = upVM;
	}

	public Button getUpdateB() {
		return updateB;
	}

	public void setUpdateB(Button updateB) {
		this.updateB = updateB;
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
