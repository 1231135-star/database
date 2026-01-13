package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MedicineTableView {
	private Label mt=new Label("Medicins");
    private TableView<Medicine> table = new TableView<>();
    private TableColumn<Medicine, Integer> colID = new TableColumn<>("MedicineID");
    private TableColumn<Medicine, String> colName = new TableColumn<>("MedicineName");
    private TableColumn<Medicine, String> colStrength = new TableColumn<>("Strength");
    private TableColumn<Medicine, Boolean> colReqPres = new TableColumn<>("RequiresPrescription");
    private TableColumn<Medicine, Integer> colCategoryID = new TableColumn<>("CategoryID");
    private Image backM=new Image("icons8-back-100(2).png");
	private ImageView backVM=new ImageView(backM);
	private Button back=new Button("Back", backVM);
	private VBox all=new VBox();
    public MedicineTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colStrength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        colReqPres.setCellValueFactory(new PropertyValueFactory<>("requiresPrescription"));
        colCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        table.getColumns().addAll(colID, colName, colStrength, colReqPres, colCategoryID);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(mt,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
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

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
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

	public TableView<Medicine> getTable() {
		return table;
	}

}
