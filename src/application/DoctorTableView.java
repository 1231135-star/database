package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class DoctorTableView {

    private Label title = new Label("Doctors");
    private TableView<Doctor> table = new TableView<>();

    private TableColumn<Doctor, Integer> colID = new TableColumn<>("ID");
    private TableColumn<Doctor, String> colName = new TableColumn<>("Name");
    private TableColumn<Doctor, String> colSpec = new TableColumn<>("Specialization");
    private TableColumn<Doctor, String> colPhone = new TableColumn<>("Phone");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();
    public DoctorTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colSpec.setCellValueFactory(new PropertyValueFactory<>("specialization"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        table.getColumns().addAll(colID, colName, colSpec, colPhone);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        title.setStyle("-fx-font-size:40px;-fx-font-weight:bold;");
        all.getChildren().addAll(title, table, back);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color:#a2c4c9;");
    }
	public Label getTitle() {
		return title;
	}
	public void setTitle(Label title) {
		this.title = title;
	}
	public TableView<Doctor> getTable() {
		return table;
	}
	public void setTable(TableView<Doctor> table) {
		this.table = table;
	}
	public TableColumn<Doctor, Integer> getColID() {
		return colID;
	}
	public void setColID(TableColumn<Doctor, Integer> colID) {
		this.colID = colID;
	}
	public TableColumn<Doctor, String> getColName() {
		return colName;
	}
	public void setColName(TableColumn<Doctor, String> colName) {
		this.colName = colName;
	}
	public TableColumn<Doctor, String> getColSpec() {
		return colSpec;
	}
	public void setColSpec(TableColumn<Doctor, String> colSpec) {
		this.colSpec = colSpec;
	}
	public TableColumn<Doctor, String> getColPhone() {
		return colPhone;
	}
	public void setColPhone(TableColumn<Doctor, String> colPhone) {
		this.colPhone = colPhone;
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

   
}
