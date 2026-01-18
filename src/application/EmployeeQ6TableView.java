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

public class EmployeeQ6TableView {

	private Label mt = new Label("Q6 - Employees Per Branch");

	private Label branchL = new Label("Branch:");
	private ComboBox<BranchItem> branchC = new ComboBox<>();

	private Image searchM = new Image("icons8-search-100.png");
	private ImageView searchVM = new ImageView(searchM);
	private Button searchB = new Button("Search", searchVM);

	private Image clearM = new Image("icons8-refresh-100.png");
	private ImageView clearVM = new ImageView(clearM);
	private Button clearB = new Button("Clear", clearVM);

	private Image backM = new Image("icons8-back-100(2).png");
	private ImageView backVM = new ImageView(backM);
	private Button back = new Button("Back", backVM);

	 private Image refM=new Image("icons8-refresh-100.png");
	   	private ImageView refVM=new ImageView(refM);
	   	private Button ref=new Button("Refresh", refVM);
	   	
	private HBox filtersH = new HBox();
	private HBox buttons = new HBox();

	private TableView<Q6EmployeeRow> table = new TableView<>();
	private TableColumn<Q6EmployeeRow, Integer> colID = new TableColumn<>("EmpID");
	private TableColumn<Q6EmployeeRow, String> colName = new TableColumn<>("FullName");
	private TableColumn<Q6EmployeeRow, String> colPos = new TableColumn<>("Position");
	private TableColumn<Q6EmployeeRow, Double> colSalary = new TableColumn<>("Salary");
	private TableColumn<Q6EmployeeRow, String> colBranch = new TableColumn<>("Branch");

	private VBox all = new VBox();

	public EmployeeQ6TableView() {

		mt.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:40px;");
		mt.setFont(Font.font(null, FontWeight.BOLD, 40));

		branchL.setStyle("-fx-text-fill: #0c343d; -fx-font-weight: bold;-fx-font-size:20px;");
		branchL.setFont(Font.font(null, FontWeight.BOLD, 20));

		branchC.setPrefWidth(300);
		branchC.setPromptText("select branch");
		branchC.setItems(loadBranches());

		searchVM.setFitWidth(42);
		searchVM.setFitHeight(42);

		clearVM.setFitWidth(42);
		clearVM.setFitHeight(42);

		backVM.setFitWidth(42);
		backVM.setFitHeight(42);

		searchB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		clearB.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		back.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");
		ref.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:20px;-fx-background-radius: 25;-fx-border-radius: 25;");

		filtersH.getChildren().addAll(branchL, branchC, searchB, clearB);
		filtersH.setSpacing(10);
		filtersH.setAlignment(Pos.CENTER);

		colID.setCellValueFactory(new PropertyValueFactory<>("empID"));
		colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		colPos.setCellValueFactory(new PropertyValueFactory<>("position"));
		colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
		colBranch.setCellValueFactory(new PropertyValueFactory<>("branchName"));

		table.getColumns().addAll(colID, colName, colPos, colSalary, colBranch);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefHeight(420);

		buttons.getChildren().addAll(back,ref);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);

		all.getChildren().addAll(mt, filtersH, table, buttons);
		all.setAlignment(Pos.CENTER);
		all.setSpacing(20);
		all.setStyle("-fx-background-color: #a2c4c9;");

		searchB.setOnAction(e -> doSearch());
		clearB.setOnAction(e -> clear());
	}

	private void doSearch() {

		BranchItem selectedBranch = branchC.getValue();

		if (selectedBranch == null) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setTitle("select branch");
			a.setHeaderText("select branch");
			a.showAndWait();
			return;
		}

		String sql = """
		        select e.empid, e.fullname, e.qualification, e.salary, b.branchname
		        from employee e
		        join branch b on e.branchid = b.branchid
		        where b.branchid = ?
		        """;


		ObservableList<Q6EmployeeRow> list = FXCollections.observableArrayList();

		try (Connection con = DatabaseConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, selectedBranch.getBranchID());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Q6EmployeeRow(
						rs.getInt("EmpID"),
						rs.getString("FullName"),
						rs.getString("Position"),
						rs.getDouble("Salary"),
						rs.getString("BranchName")
				));
			}

			table.setItems(list);

			if (list.isEmpty()) {
				Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setTitle("no results");
				a.setHeaderText("no results");
				a.showAndWait();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setTitle(ex.getMessage());
			a.setHeaderText(ex.getMessage());
			a.showAndWait();
		}
	}

	private void clear() {
		branchC.setValue(null);
		table.setItems(FXCollections.observableArrayList());
	}

	private ObservableList<BranchItem> loadBranches() {
		ObservableList<BranchItem> list = FXCollections.observableArrayList();

		String sql = "select branchid, branchname from branch";

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

	public TableView<Q6EmployeeRow> getTable() {
		return table;
	}

	public void setTable(TableView<Q6EmployeeRow> table) {
		this.table = table;
	}

	public TableColumn<Q6EmployeeRow, Integer> getColID() {
		return colID;
	}

	public void setColID(TableColumn<Q6EmployeeRow, Integer> colID) {
		this.colID = colID;
	}

	public TableColumn<Q6EmployeeRow, String> getColName() {
		return colName;
	}

	public void setColName(TableColumn<Q6EmployeeRow, String> colName) {
		this.colName = colName;
	}

	public TableColumn<Q6EmployeeRow, String> getColPos() {
		return colPos;
	}

	public void setColPos(TableColumn<Q6EmployeeRow, String> colPos) {
		this.colPos = colPos;
	}

	public TableColumn<Q6EmployeeRow, Double> getColSalary() {
		return colSalary;
	}

	public void setColSalary(TableColumn<Q6EmployeeRow, Double> colSalary) {
		this.colSalary = colSalary;
	}

	public TableColumn<Q6EmployeeRow, String> getColBranch() {
		return colBranch;
	}

	public void setColBranch(TableColumn<Q6EmployeeRow, String> colBranch) {
		this.colBranch = colBranch;
	}

	public VBox getAll() {
		return all;
	}

	public void setAll(VBox all) {
		this.all = all;
	}

}
