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

public class MostSoldMedTable{
    private Label bt = new Label("Most Sold Medicine (Monthly)");
    private TableView<MostSoldMed> table = new TableView<>();

    private TableColumn<MostSoldMed, String> colMonth = new TableColumn<>("Month");
    private TableColumn<MostSoldMed, String> colMed = new TableColumn<>("Medicine");
    private TableColumn<MostSoldMed, Integer> colQty = new TableColumn<>("TotalSoldQty");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private VBox all = new VBox();

    public MostSoldMedTable() {
    	/*
    	  private String month,medName;
    private int totQuantitySold;
    	 */
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colMed.setCellValueFactory(new PropertyValueFactory<>("medName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("totQuantitySold"));

        table.getColumns().addAll(colMonth, colMed, colQty);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        bt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");

        all.getChildren().addAll(bt, table, back);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getBt() {
		return bt;
	}

	public void setBt(Label bt) {
		this.bt = bt;
	}

	public TableView<MostSoldMed> getTable() {
		return table;
	}

	public void setTable(TableView<MostSoldMed> table) {
		this.table = table;
	}

	public TableColumn<MostSoldMed, String> getColMonth() {
		return colMonth;
	}

	public void setColMonth(TableColumn<MostSoldMed, String> colMonth) {
		this.colMonth = colMonth;
	}

	public TableColumn<MostSoldMed, String> getColMed() {
		return colMed;
	}

	public void setColMed(TableColumn<MostSoldMed, String> colMed) {
		this.colMed = colMed;
	}

	public TableColumn<MostSoldMed, Integer> getColQty() {
		return colQty;
	}

	public void setColQty(TableColumn<MostSoldMed, Integer> colQty) {
		this.colQty = colQty;
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
