package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class InsurancePolicyTableView {

    private Label title = new Label("Insurance Policies");
    private TableView<InsurancePolicy> table = new TableView<>();

    private TableColumn<InsurancePolicy, Integer> colID =new TableColumn<>("Policy ID");
    private TableColumn<InsurancePolicy, String> colNumber =new TableColumn<>("Policy Number");
    private TableColumn<InsurancePolicy, LocalDate> colStart =new TableColumn<>("Start Date");
    private TableColumn<InsurancePolicy, LocalDate> colEnd =new TableColumn<>("Expiry Date");
    private TableColumn<InsurancePolicy, Double> colCoverage =new TableColumn<>("Coverage");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();

    public InsurancePolicyTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("policyID"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("policyNumber"));
        colStart.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEnd.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        colCoverage.setCellValueFactory(new PropertyValueFactory<>("coveragePercentage"));
        table.getColumns().addAll(colID, colNumber, colStart, colEnd, colCoverage);
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

	public TableView<InsurancePolicy> getTable() {
		return table;
	}

	public void setTable(TableView<InsurancePolicy> table) {
		this.table = table;
	}

	public TableColumn<InsurancePolicy, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<InsurancePolicy, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<InsurancePolicy, String> getColNumber() {
		return colNumber;
	}

	public void setColNumber(TableColumn<InsurancePolicy, String> colNumber) {
		this.colNumber = colNumber;
	}

	public TableColumn<InsurancePolicy, LocalDate> getColStart() {
		return colStart;
	}

	public void setColStart(TableColumn<InsurancePolicy, LocalDate> colStart) {
		this.colStart = colStart;
	}

	public TableColumn<InsurancePolicy, LocalDate> getColEnd() {
		return colEnd;
	}

	public void setColEnd(TableColumn<InsurancePolicy, LocalDate> colEnd) {
		this.colEnd = colEnd;
	}

	public TableColumn<InsurancePolicy, Double> getColCoverage() {
		return colCoverage;
	}

	public void setColCoverage(TableColumn<InsurancePolicy, Double> colCoverage) {
		this.colCoverage = colCoverage;
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