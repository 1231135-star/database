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

public class CategoryTableView {
	private Label cat=new Label("Categories");
    private TableView<Category> table = new TableView<>();
    private TableColumn<Category, Integer> colID = new TableColumn<>("CategoryID");
    private TableColumn<Category, String> colName = new TableColumn<>("CategoryName");
    private TableColumn<Category, String> colDesc = new TableColumn<>("Description");
    private Image backM=new Image("icons8-back-100(2).png");
  	private ImageView backVM=new ImageView(backM);
  	private Button back=new Button("Back", backVM);
  	private VBox all=new VBox();
    public CategoryTableView() {
        colID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        table.getColumns().addAll(colID, colName, colDesc);
        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		cat.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
        all.getChildren().addAll(cat,table,back);
        all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");
    }

	public Label getCat() {
		return cat;
	}

	public void setCat(Label cat) {
		this.cat = cat;
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

	public void setTable(TableView<Category> table) {
		this.table = table;
	}

	public TableColumn<Category, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Category, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Category, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Category, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Category, String> getColDesc() {
		return colDesc;
	}

	public void setColDesc(TableColumn<Category, String> colDesc) {
		this.colDesc = colDesc;
	}

	public TableView<Category> getTable() {
		return table;
	}
    
}
