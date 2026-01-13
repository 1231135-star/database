package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class PaymentTableView {

    private Label title = new Label("Payments");
    private TableView<Payment> table = new TableView<>();

    private TableColumn<Payment, Integer> colID =new TableColumn<>("ID");
    private TableColumn<Payment, String> colType =new TableColumn<>("Type");
    private TableColumn<Payment, Double> colAmount =new TableColumn<>("Amount");
    private TableColumn<Payment, LocalDate> colDate =new TableColumn<>("Date");
    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();

    public PaymentTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        table.getColumns().addAll(colID, colType, colAmount, colDate);
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

	public TableView<Payment> getTable() {
		return table;
	}

	public void setTable(TableView<Payment> table) {
		this.table = table;
	}

	public TableColumn<Payment, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Payment, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Payment, String> getColType() {
		return colType;
	}

	public void setColType(TableColumn<Payment, String> colType) {
		this.colType = colType;
	}

	public TableColumn<Payment, Double> getColAmount() {
		return colAmount;
	}

	public void setColAmount(TableColumn<Payment, Double> colAmount) {
		this.colAmount = colAmount;
	}

	public TableColumn<Payment, LocalDate> getColDate() {
		return colDate;
	}

	public void setColDate(TableColumn<Payment, LocalDate> colDate) {
		this.colDate = colDate;
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
