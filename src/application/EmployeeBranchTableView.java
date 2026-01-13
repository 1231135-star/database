package application;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;

public class EmployeeBranchTableView {
    private Label bt = new Label("Employees");
    private TableView<EmployeeBranch> table = new TableView<>();

    private TableColumn<EmployeeBranch, String> colName = new TableColumn<>("FullName");
    private TableColumn<EmployeeBranch, String> colQual = new TableColumn<>("Qualification");
    private TableColumn<EmployeeBranch, Double> colSalary = new TableColumn<>("Salary");
    private TableColumn<EmployeeBranch, String> colBranch = new TableColumn<>("Branch");

    private Image backM = new Image("icons8-back-100(2).png");
    private ImageView backVM = new ImageView(backM);
    private Button back = new Button("Back", backVM);

    private VBox all = new VBox();

    public EmployeeBranchTableView() {
    	//private String fName,qual,bName;private double salary;
        colName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        colQual.setCellValueFactory(new PropertyValueFactory<>("qual"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("bName"));

        table.getColumns().addAll(colName, colQual, colSalary, colBranch);

        back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
        bt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");

        all.getChildren().addAll(bt, table, back);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(20);
        all.setStyle("-fx-background-color: #a2c4c9;");
    }

    public VBox getAll() { return all; }
    public Button getBack() { return back; }
    public TableView<EmployeeBranch> getTable() { return table; }
}
