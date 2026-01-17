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

public class TopBranchTableView {

    private Label title = new Label("Top Branch");
    private TableView<TopBranch> table = new TableView<>();

    private TableColumn<TopBranch, Integer> colID = new TableColumn<>("BranchID");
    private TableColumn<TopBranch, String> colName = new TableColumn<>("BranchName");
    private TableColumn<TopBranch, Double> colSales = new TableColumn<>("TotalSales");
    private TableColumn<TopBranch, Double> colProfit = new TableColumn<>("TotalProfit");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);
  
    private Image refM=new Image("icons8-refresh-100.png");
   	private ImageView refVM=new ImageView(refM);
   	private Button ref=new Button("Refresh", refVM);
	private HBox buttons=new HBox();

   	private VBox all = new VBox();

    public TopBranchTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("branchID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        colSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));
        colProfit.setCellValueFactory(new PropertyValueFactory<>("totalProfit"));

        table.getColumns().addAll(colID, colName, colSales, colProfit);

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

	public TableView<TopBranch> getTable() {
		return table;
	}

	public void setTable(TableView<TopBranch> table) {
		this.table = table;
	}

	public TableColumn<TopBranch, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<TopBranch, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<TopBranch, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<TopBranch, String> colName) {
		this.colName = colName;
	}

	public TableColumn<TopBranch, Double> getColSales() {
		return colSales;
	}

	public void setColSales(TableColumn<TopBranch, Double> colSales) {
		this.colSales = colSales;
	}

	public TableColumn<TopBranch, Double> getColProfit() {
		return colProfit;
	}

	public void setColProfit(TableColumn<TopBranch, Double> colProfit) {
		this.colProfit = colProfit;
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
