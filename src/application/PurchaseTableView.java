package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class PurchaseTableView {

    private Label title = new Label("Purchases");
    private TableView<Purchase> table = new TableView<>();

    private TableColumn<Purchase, Integer> colID =new TableColumn<>("ID");
    private TableColumn<Purchase, LocalDate> colDate =new TableColumn<>("Date");
    private TableColumn<Purchase, Double> colCost =new TableColumn<>("Total Cost");

    private Image backM=new Image("icons8-back-100(2).png");
   	private ImageView backVM=new ImageView(backM);
   	private Button back=new Button("Back", backVM);
   	private VBox all=new VBox();

    public PurchaseTableView() {

        colID.setCellValueFactory(new PropertyValueFactory<>("purchaseID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

        table.getColumns().addAll(colID, colDate, colCost);
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

	public TableView<Purchase> getTable() {
		return table;
	}

	public void setTable(TableView<Purchase> table) {
		this.table = table;
	}

	public TableColumn<Purchase, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Purchase, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Purchase, LocalDate> getColDate() {
		return colDate;
	}

	public void setColDate(TableColumn<Purchase, LocalDate> colDate) {
		this.colDate = colDate;
	}

	public TableColumn<Purchase, Double> getColCost() {
		return colCost;
	}

	public void setColCost(TableColumn<Purchase, Double> colCost) {
		this.colCost = colCost;
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
