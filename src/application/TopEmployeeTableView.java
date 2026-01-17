package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TopEmployeeTableView {

    private Label title = new Label("Top Selling Employees");
    private TableView<TopEmployee> table = new TableView<>();

    private TableColumn<TopEmployee, Integer> colID = new TableColumn<>("EmpID");
    private TableColumn<TopEmployee, String> colName = new TableColumn<>("FullName");
    private TableColumn<TopEmployee, Double> colSales = new TableColumn<>("TotalSales");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
	private HBox buttons=new HBox();
	
    private VBox all = new VBox();

    public TopEmployeeTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));

        table.getColumns().addAll(colID, colName, colSales);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        title.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        buttons.getChildren().addAll(back,ref);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
        all.getChildren().addAll(title, table, buttons);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TableView<TopEmployee> getTable() {
		return table;
	}

	public void setTable(TableView<TopEmployee> table) {
		this.table = table;
	}

	public TableColumn<TopEmployee, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<TopEmployee, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<TopEmployee, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<TopEmployee, String> colName) {
		this.colName = colName;
	}

	public TableColumn<TopEmployee, Double> getColSales() {
		return colSales;
	}

	public void setColSales(TableColumn<TopEmployee, Double> colSales) {
		this.colSales = colSales;
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
