package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EmployeeQ7TableView {

	private Label mt = new Label("Q7 - Employees Filter (Salary OR Branch)");

	private Label salaryL = new Label("Salary >");
	private TextField salaryT = new TextField();

	private Label branchL = new Label("Branch:");
	private ComboBox<BranchItem> branchC = new ComboBox<>();

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);

	private Image clearM = new Image("icons8-erase-100.png"); 
	private ImageView clearVM = new ImageView(clearM);
	private Button clearB = new Button("Clear", clearVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	private HBox filtersH = new HBox();
	private HBox buttons = new HBox();

	private TableView<Q7EmployeeRow> table = new TableView<>();
	private TableColumn<Q7EmployeeRow, Integer> colID = new TableColumn<>("EmpID");
	private TableColumn<Q7EmployeeRow, String> colName = new TableColumn<>("FullName");
	private TableColumn<Q7EmployeeRow, String> colPos = new TableColumn<>("Position");
	private TableColumn<Q7EmployeeRow, Double> colSalary = new TableColumn<>("Salary");
	private TableColumn<Q7EmployeeRow, String> colBranch = new TableColumn<>("Branch");


	private VBox all = new VBox();

	public EmployeeQ7TableView() {

		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:35px;");
		mt.setFont(Font.font(null, FontWeight.BOLD, 35));

		salaryL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		branchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");

		salaryL.setFont(Font.font(null, FontWeight.BOLD, 20));
		branchL.setFont(Font.font(null, FontWeight.BOLD, 20));

		salaryT.setPromptText("example: 3000");
		salaryT.setPrefWidth(170);

		branchC.setPrefWidth(250);
		branchC.setPromptText("select branch (optional)");
		branchC.setItems(loadB());

		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);

		clearVM.setFitWidth(42);
		clearVM.setFitHeight(42);

		backVM.setFitWidth(42);
		backVM.setFitHeight(42);

		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		clearB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		filtersH.getChildren().addAll(salaryL, salaryT, branchL, branchC);
		filtersH.setSpacing(15);
		filtersH.setAlignment(Pos.CENTER);

		colID.setCellValueFactory(new PropertyValueFactory<>("empID"));
		colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		colPos.setCellValueFactory(new PropertyValueFactory<>("position"));
		colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
		colBranch.setCellValueFactory(new PropertyValueFactory<>("branchName"));

		table.getColumns().addAll(colID, colName, colPos, colSalary, colBranch);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefHeight(420);

		buttons.getChildren().addAll(back, searchB, clearB);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(mt, filtersH, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");

		searchB.setOnAction(e ->{
			doSearch();
		});
		clearB.setOnAction(e -> {
			clear();
		});
	}

	private void doSearch() {

		String salaryText = salaryT.getText().trim();
		BranchItem selectedBranch = branchC.getValue();

		if (salaryText.isEmpty() && selectedBranch == null) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setTitle("you must enter salary or select an branch");
			a.setHeaderText("you must enter salary or select an branch");
			a.showAndWait();
			return;
		}

		Double salary = null;
		if (!salaryText.isEmpty()) {
			try {
				salary = Double.parseDouble(salaryText);
			} catch (Exception ex) {
				Alert a = new Alert(Alert.AlertType.ERROR);
				a.setTitle(ex.getMessage());
				a.setHeaderText(ex.getMessage());
				a.showAndWait();
				return;
			}
		}

		StringBuilder sql = new StringBuilder();
		sql.append("""
				SELECT e.EmpID, e.FullName, e.Position, e.Salary, b.BranchName
				FROM Employee e
				JOIN Branch b ON e.BranchID = b.BranchID
				WHERE
				""");

		if (!salaryText.isEmpty() && selectedBranch != null) {
			sql.append(" e.Salary > ? OR b.BranchID = ? ");
		} else if (!salaryText.isEmpty()) {
			sql.append(" e.Salary > ? ");
		} else {
			sql.append(" b.BranchID = ? ");
		}

		ObservableList<Q7EmployeeRow> list = FXCollections.observableArrayList();

		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql.toString())) {

			int idx = 1;

			if (!salaryText.isEmpty()) {
				ps.setDouble(idx++, salary);
			}
			if (selectedBranch != null) {
				ps.setInt(idx++, selectedBranch.getBranchID());
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Q7EmployeeRow(
						rs.getInt("EmpID"),
						rs.getString("FullName"),
						rs.getString("Position"),
						rs.getDouble("Salary"),
						rs.getString("BranchName")));
			}

			table.setItems(list);

		} catch (Exception ex) {
			ex.printStackTrace();
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setTitle("Error");
			a.setHeaderText(ex.getMessage());
			a.showAndWait();
		}
	}

	private void clear() {
		salaryT.clear();
		branchC.setValue(null);
		table.setItems(FXCollections.observableArrayList());
	}

	private ObservableList<BranchItem> loadB() {
		ObservableList<BranchItem> list = FXCollections.observableArrayList();

		String sql = "SELECT BranchID, BranchName FROM Branch";

		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(new BranchItem(rs.getInt("BranchID"), rs.getString("BranchName")));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public Label getMt() {
		return mt;
	}

	public void setMt(Label mt) {
		this.mt = mt;
	}

	public Label getSalaryL() {
		return salaryL;
	}

	public void setSalaryL(Label salaryL) {
		this.salaryL = salaryL;
	}

	public TextField getSalaryT() {
		return salaryT;
	}

	public void setSalaryT(TextField salaryT) {
		this.salaryT = salaryT;
	}

	public Label getBranchL() {
		return branchL;
	}

	public void setBranchL(Label branchL) {
		this.branchL = branchL;
	}

	public ComboBox<BranchItem> getBranchC() {
		return branchC;
	}

	public void setBranchC(ComboBox<BranchItem> branchC) {
		this.branchC = branchC;
	}

	public Image getSearchM() {
		return searchM;
	}

	public void setSearchM(Image searchM) {
		this.searchM = searchM;
	}

	public ImageView getSearchVM() {
		return searchVM;
	}

	public void setSearchVM(ImageView searchVM) {
		this.searchVM = searchVM;
	}

	public Button getSearchB() {
		return searchB;
	}

	public void setSearchB(Button searchB) {
		this.searchB = searchB;
	}

	public Image getClearM() {
		return clearM;
	}

	public void setClearM(Image clearM) {
		this.clearM = clearM;
	}

	public ImageView getClearVM() {
		return clearVM;
	}

	public void setClearVM(ImageView clearVM) {
		this.clearVM = clearVM;
	}

	public Button getClearB() {
		return clearB;
	}

	public void setClearB(Button clearB) {
		this.clearB = clearB;
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

	public HBox getFiltersH() {
		return filtersH;
	}

	public void setFiltersH(HBox filtersH) {
		this.filtersH = filtersH;
	}

	public HBox getButtons() {
		return buttons;
	}

	public void setButtons(HBox buttons) {
		this.buttons = buttons;
	}

	public TableView<Q7EmployeeRow> getTable() {
		return table;
	}

	public void setTable(TableView<Q7EmployeeRow> table) {
		this.table = table;
	}

	public TableColumn<Q7EmployeeRow, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Q7EmployeeRow, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Q7EmployeeRow, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Q7EmployeeRow, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Q7EmployeeRow, String> getColPos() {
		return colPos;
	}

	public void setColPos(TableColumn<Q7EmployeeRow, String> colPos) {
		this.colPos = colPos;
	}

	public TableColumn<Q7EmployeeRow, Double> getColSalary() {
		return colSalary;
	}

	public void setColSalary(TableColumn<Q7EmployeeRow, Double> colSalary) {
		this.colSalary = colSalary;
	}

	public TableColumn<Q7EmployeeRow, String> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<Q7EmployeeRow, String> colBranch) {
		this.colBranch = colBranch;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

	
	
}
