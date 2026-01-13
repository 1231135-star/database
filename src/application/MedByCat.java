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

public class MedByCat {
	
	private Label mt=new Label("Medicins");
	private Label ct=new Label("But Category Search :");
	private TextField serT=new TextField();
	private Image searchM=new Image("icons8-search-100.png");
	private ImageView searchVM=new ImageView(searchM);
	private Button search=new Button("Search", searchVM);
	private HBox ser=new HBox();
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
    public MedByCat() {
    	ct.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
    	ser.getChildren().addAll(ct,serT,search);
    	ser.setAlignment(Pos.CENTER);
    	ser.setSpacing(20);
    	ser.setStyle("-fx-background-color: #a2c4c9;");

        colID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colStrength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        colReqPres.setCellValueFactory(new PropertyValueFactory<>("requiresPrescription"));
        colCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        table.getColumns().addAll(colID, colName, colStrength, colReqPres, colCategoryID);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(mt,ser,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getCt() {
		return ct;
	}

	public void setCt(Label ct) {
		this.ct = ct;
	}

	public TextField getSerT() {
		return serT;
	}

	public void setSerT(TextField serT) {
		this.serT = serT;
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

	public Button getSearch() {
		return search;
	}

	public void setSearch(Button search) {
		this.search = search;
	}

	public HBox getSer() {
		return ser;
	}

	public void setSer(HBox ser) {
		this.ser = ser;
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
