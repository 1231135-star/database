package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class PrescriptionTableView {

    private Label title = new Label("Prescriptions");
    private TableView<Prescription> table = new TableView<>();

    private TableColumn<Prescription, Integer> colID =new TableColumn<>("ID");
    private TableColumn<Prescription, LocalDate> colDate =new TableColumn<>("Issue Date");
    private TableColumn<Prescription, String> colNotes =new TableColumn<>("Notes");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();

    public PrescriptionTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("prescriptionID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        table.getColumns().addAll(colID, colDate, colNotes);
        title.setStyle("-fx-font-size:40px;-fx-font-weight:bold;");
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
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

	public TableView<Prescription> getTable() {
		return table;
	}

	public void setTable(TableView<Prescription> table) {
		this.table = table;
	}

	public TableColumn<Prescription, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Prescription, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Prescription, LocalDate> getColDate() {
		return colDate;
	}

	public void setColDate(TableColumn<Prescription, LocalDate> colDate) {
		this.colDate = colDate;
	}

	public TableColumn<Prescription, String> getColNotes() {
		return colNotes;
	}

	public void setColNotes(TableColumn<Prescription, String> colNotes) {
		this.colNotes = colNotes;
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
