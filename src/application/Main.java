package application;
	
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			MainPage mb=new MainPage();
			mb.getReadAll().setOnAction(e->{
				DataFileReader r = new DataFileReader();

				int total = r.readAll(
				    new File("branch.txt"),
				    new File("category.txt"),
				    new File("supplier.txt"),
				    new File("customer.txt"),
				    new File("insurance_company.txt"),
				    new File("doctor.txt"),
				    new File("medicine.txt"),
				    new File("employee.txt"),
				    new File("insurance_policy.txt"),
				    new File("inventory_item.txt"),
				    new File("invoice.txt"),
				    new File("invoice_item.txt"),
				    new File("payment.txt"),
				    new File("prescription.txt"),
				    new File("prescription_medicine.txt"),
				    new File("purchase.txt"),
				    new File("damagedwithdrawn.txt")
				);

				System.out.println("TOTAL INSERTED: " + total);

			});
			LoginPage login=new LoginPage();
			SignUpCustomer signupC = new SignUpCustomer();
			Scene signupScene = new Scene(signupC.getAll(), 450, 450);
			login.getSignup().setOnAction(e -> {
			    primaryStage.setScene(signupScene);
			});
			

			AddBranch ab=new AddBranch();
			
			ab.getAdd().setOnAction(e -> {

			    String idt = ab.getBidT().getText().trim();
			    String name = ab.getBnT().getText().trim();
			    String address = ab.getAddT().getText().trim();
			    String phone = ab.getPnT().getText().trim();
			    String email = ab.geteT().getText().trim();

			    if (idt.isEmpty() || name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("please fill all fields");
			        a.setContentText("please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idt);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("invalid branch ID");
			        a.setContentText("invalid branch ID");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            insert into branch (branchid, branchname, address, phonenumber, email)
			            values (?, ?, ?, ?, ?)
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ps.setString(2, name);
			        ps.setString(3, address);
			        ps.setString(4, phone);
			        ps.setString(5, email);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("done");
			            a.setContentText("done");
			            a.showAndWait();

			            ab.getBidT().clear();
			            ab.getBnT().clear();
			            ab.getAddT().clear();
			            ab.getPnT().clear();
			            ab.geteT().clear();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			

			
			DeleteBranch db=new DeleteBranch();
			db.getClear().setOnAction(e -> {
			    db.getSearchT().clear();

			    db.getBidT().clear();
			    db.getBnT().clear();
			    db.getAddT().clear();
			    db.getPnT().clear();
			    db.geteT().clear();

			    db.getDelete().setDisable(true);
			});
			db.getSearchB().setOnAction(e -> {

				String sql = "select * from branch where branchid = ?";
			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        if (db.getSearchT().getText().trim().isEmpty()) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing ID");
			            a.setHeaderText("Missing ID");
			            a.setContentText("Please enter Branch ID.");
			            a.showAndWait();
			            return;
			        }

			        int id = Integer.parseInt(db.getSearchT().getText().trim());
			        ps.setInt(1, id);

			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            db.getBidT().setText(rs.getString("BranchID"));
			            db.getBnT().setText(rs.getString("BranchName"));
			            db.getAddT().setText(rs.getString("Address"));
			            db.getPnT().setText(rs.getString("PhoneNumber"));
			            db.geteT().setText(rs.getString("Email"));

			            db.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText("Branch Not Found");
			            a.setContentText("No branch with ID = " + id);
			            a.showAndWait();

			            db.getDelete().setDisable(true);
			        }

			        rs.close();
			        ps.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			db.getDelete().setOnAction(e -> {
				String sql = "delete from branch where branchid = ?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(db.getBidT().getText().trim());

			        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			        confirm.setTitle("Confirm Delete");
			        confirm.setHeaderText("Are you sure?");
			        confirm.setContentText("Delete Branch ID: " + id);

			        if (confirm.showAndWait().get().getText().equals("OK")) {
			            ps.setInt(1, id);

			            int deleted = ps.executeUpdate();
			            ps.close();

			            if (deleted > 0) {
			                Alert done = new Alert(Alert.AlertType.INFORMATION);
			                done.setTitle("Done");
			                done.setHeaderText("Branch Deleted Successfully");
			                done.setContentText("Branch ID: " + id);
			                done.showAndWait();

			                db.getSearchT().clear();
			                db.getBidT().clear();
			                db.getBnT().clear();
			                db.getAddT().clear();
			                db.getPnT().clear();
			                db.geteT().clear();
			                db.getDelete().setDisable(true);
			            }
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			UpdateBranch ub=new UpdateBranch(); 
			BranchTableView bt=new BranchTableView();
			bt.getRef().setOnAction(e -> {
			    bt.getSearchT().clear();
			    bt.getTable().setItems(loadAllBranches());
			    bt.getTable().getSelectionModel().clearSelection();
			});

			bt.getSearchB().setOnAction(e -> {

			    String idT = bt.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        bt.getTable().setItems(loadAllBranches());
			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("All branches");
			        a.setContentText("All branches loaded");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Branch ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    var result = searchBranchById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Not found");
			        a.setContentText("No branch with this ID");
			        a.showAndWait();
			        bt.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    bt.getTable().setItems(result);
			});
			bt.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
			    if (newV != null) {
			        bt.getDeleteB().setDisable(false);
			        bt.getUpdateB().setDisable(false);
			    } else {
			        bt.getDeleteB().setDisable(true);
			        bt.getUpdateB().setDisable(true);
			    }
			});
			bt.getDeleteB().setOnAction(e -> {

			    Branch selected = bt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a branch first!");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm delete");
			    confirm.setContentText("Delete this branch?");
			    confirm.showAndWait();

			    if (confirm.getResult() != ButtonType.OK) return;

			    String sql = "delete from branch where branchid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getBranchID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Deleted");
			            a.setContentText("Branch deleted successfully!");
			            a.showAndWait();
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not found");
			            a.setContentText("Not found");
			            a.showAndWait();
			        }

			        bt.getTable().setItems(loadAllBranches());
			        bt.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			TopBranchTableView tbt = new TopBranchTableView();

			Scene tbtscene = new Scene(tbt.getAll(),400,400);
			Scene abscene = new Scene(ab.getAll(),400,400);
			ab.getClear().setOnAction(e -> {
			    ab.getBidT().clear();
			    ab.getBnT().clear();
			    ab.getAddT().clear();
			    ab.getPnT().clear();
			    ab.geteT().clear();
			});
			ab.getAdd().setOnAction(e -> {
				String sql = "insert into branch (branchid, branchname, address, phonenumber, email) values (?, ?, ?, ?, ?)";

				 try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
					 if (ab.getBidT().getText().trim().isEmpty() ||ab.getBnT().getText().trim().isEmpty() ||ab.getAddT().getText().trim().isEmpty() ||ab.getPnT().getText().trim().isEmpty() ||ab.geteT().getText().trim().isEmpty()) {

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing Data");
			            a.setHeaderText("Missing Data");
			            a.setContentText("Please fill all fields.");
			            a.showAndWait();
			            return;
			        }

			        int id = Integer.parseInt(ab.getBidT().getText().trim());
			        String name = ab.getBnT().getText().trim();
			        String address = ab.getAddT().getText().trim();
			        String phone = ab.getPnT().getText().trim();
			        String email = ab.geteT().getText().trim();

			        ps.setInt(1, id);
			        ps.setString(2, name);
			        ps.setString(3, address);
			        ps.setString(4, phone);
			        ps.setString(5, email);

			        ps.executeUpdate();
			        ps.close();

			        Alert done = new Alert(Alert.AlertType.INFORMATION);
			        done.setTitle("Done");
			        done.setHeaderText("Branch Added Successfully");
			        done.setContentText("Branch ID: " + id);
			        done.showAndWait();

			        ab.getBidT().clear();
			        ab.getBnT().clear();
			        ab.getAddT().clear();
			        ab.getPnT().clear();
			        ab.geteT().clear();

			    
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			Scene dbscene = new Scene(db.getAll(),400,400);
			Scene ubscene = new Scene(ub.getAll(),400,400);
			ub.getClear().setOnAction(e -> {
			    ub.getSearchT().clear();

			    ub.getBidT().clear();
			    ub.getBnT().clear();
			    ub.getAddT().clear();
			    ub.getPnT().clear();
			    ub.geteT().clear();

			    ub.getEdit().setDisable(true);
			});
			ub.getSearchB().setOnAction(e -> {
				String sql = "select * from branch where branchid = ?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        if (ub.getSearchT().getText().trim().isEmpty()) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing ID");
			            a.setHeaderText("Missing ID");
			            a.setContentText("Please enter Branch ID.");
			            a.showAndWait();
			            return;
			        }

			        int id = Integer.parseInt(ub.getSearchT().getText().trim());

			        ps.setInt(1, id);

			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            ub.getBidT().setText(rs.getString("BranchID"));
			            ub.getBnT().setText(rs.getString("BranchName"));
			            ub.getAddT().setText(rs.getString("Address"));
			            ub.getPnT().setText(rs.getString("PhoneNumber"));
			            ub.geteT().setText(rs.getString("Email"));

			            ub.getEdit().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText("Branch Not Found");
			            a.setContentText("No branch with ID = " + id);
			            a.showAndWait();

			            ub.getEdit().setDisable(true);
			        }

			        rs.close();
			        ps.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			ub.getEdit().setOnAction(e -> {
				String sql = "update branch set branchname=?, address=?, phonenumber=?, email=? where branchid=?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(ub.getBidT().getText().trim());

			        if (ub.getBnT().getText().trim().isEmpty() ||ub.getAddT().getText().trim().isEmpty() ||ub.getPnT().getText().trim().isEmpty() || ub.geteT().getText().trim().isEmpty()) {

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing Data");
			            a.setHeaderText("Missing Data");
			            a.setContentText("Please fill all fields.");
			            a.showAndWait();
			            return;
			        }


			        ps.setString(1, ub.getBnT().getText().trim());
			        ps.setString(2, ub.getAddT().getText().trim());
			        ps.setString(3, ub.getPnT().getText().trim());
			        ps.setString(4, ub.geteT().getText().trim());
			        ps.setInt(5, id);

			        int updated = ps.executeUpdate();
			        ps.close();

			        if (updated > 0) {
			            Alert done = new Alert(Alert.AlertType.INFORMATION);
			            done.setTitle("Done");
			            done.setHeaderText("Branch Updated Successfully");
			            done.setContentText("Branch ID: " + id);
			            done.showAndWait();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			bt.getUpdateB().setOnAction(e -> {

			    Branch selected = bt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a branch first!");
			        a.showAndWait();
			        return;
			    }

			    ub.getBidT().setText(selected.getBranchID() + "");
			    ub.getBnT().setText(selected.getBranchName());
			    ub.getAddT().setText(selected.getAddress());
			    ub.getPnT().setText(selected.getPhoneNumber());
			    ub.geteT().setText(selected.getEmail());

			    primaryStage.setScene(ubscene);
			});
			Scene btscene = new Scene(bt.getAll(),400,400);

			mb.getAb().setOnAction(e->{
				primaryStage.setScene(abscene);
			});
			mb.getDb().setOnAction(e->{
				primaryStage.setScene(dbscene);
			});
			mb.getUb().setOnAction(e->{
				primaryStage.setScene(ubscene);
			});
			mb.getBt().setOnAction(e->{
				primaryStage.setScene(btscene);
			});
			BranchQ5TableView q5 = new BranchQ5TableView();
			Scene bq5scene = new Scene(q5.getAll(), 400, 400);

			mb.getQ5().setOnAction(e ->{
				primaryStage.setScene(bq5scene);
			});
			
			mb.getQ20().setOnAction(e -> {
			    primaryStage.setScene(tbtscene);
			});
			AddCategory ac=new AddCategory();
			ac.getClear().setOnAction(e -> {
			    ac.getCatIDT().clear();
			    ac.getCatNT().clear();
			    ac.getdT().clear();
			});
			ac.getAdd().setOnAction(e -> {

			    String idT = ac.getCatIDT().getText().trim();
			    String name = ac.getCatNT().getText().trim();
			    String desc = ac.getdT().getText().trim();

			    if (idT.isEmpty() || name.isEmpty() || desc.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing");
			        a.setContentText("Fill all fields");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Category ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = "insert into category (categoryid, categoryname, description) values (?, ?, ?)";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ps.setString(2, name);
			        ps.setString(3, desc);

			        ps.executeUpdate();

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("Done");
			        a.setContentText("Category Added Successfully!");
			        a.showAndWait();

			        ac.getCatIDT().clear();
			        ac.getCatNT().clear();
			        ac.getdT().clear();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			DeleteCategory dc=new DeleteCategory();
			dc.getClear().setOnAction(e -> {
			    dc.getSearchT().clear();
			    dc.getCatIDT().clear();
			    dc.getCatNT().clear();
			    dc.getdT().clear();
			    dc.getDelete().setDisable(true);
			});
			dc.getSearchB().setOnAction(e -> {

			    String idT = dc.getSearchT().getText().trim();
			    if (idT.isEmpty()) return;

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        return;
			    }

			    String sql = "select * from category where categoryid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dc.getCatIDT().setText(rs.getInt("CategoryID") + "");
			            dc.getCatNT().setText(rs.getString("CategoryName"));
			            dc.getdT().setText(rs.getString("Description"));
			            dc.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No category with this ID");
			            a.showAndWait();

			            dc.getDelete().setDisable(true);
			        }

			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			});
			dc.getDelete().setOnAction(e -> {

			    String idT = dc.getCatIDT().getText().trim();
			    if (idT.isEmpty()) return;

			    int id = Integer.parseInt(idT);

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm Delete");
			    confirm.setHeaderText("Are you sure you want to delete this category?");
			    confirm.setContentText("Category ID: " + id);

			    if (confirm.showAndWait().get().getText().equals("OK")) {

			    	String sql = "delete from category where categoryid = ?";

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, id);
			            ps.executeUpdate();

			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Category Deleted Successfully!");
			            a.showAndWait();

			            dc.getSearchT().clear();
			            dc.getCatIDT().clear();
			            dc.getCatNT().clear();
			            dc.getdT().clear();
			            dc.getDelete().setDisable(true);

			        } catch (Exception ex) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Failed");
			            a.setContentText(ex.getMessage());
			            a.showAndWait();
			        }
			    }
			});

			UpdateCategory uc=new UpdateCategory();
			uc.getSearchB().setOnAction(e -> {

			    String idT = uc.getSearchT().getText().trim();
			    if (idT.isEmpty()) return;

			    int id;
			    try { id = Integer.parseInt(idT); }
			    catch (Exception ex) { return; }

			    String sql = "select * from category where categoryid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            uc.getCatIDT().setText(rs.getInt("CategoryID") + "");
			            uc.getCatNT().setText(rs.getString("CategoryName"));
			            uc.getdT().setText(rs.getString("Description"));
			            uc.getEdit().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No category with this ID");
			            a.showAndWait();
			            uc.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			});
			uc.getEdit().setOnAction(e -> {

			    String idT = uc.getCatIDT().getText().trim();
			    String name = uc.getCatNT().getText().trim();
			    String desc = uc.getdT().getText().trim();

			    if (name.isEmpty() || desc.isEmpty()) return;

			    int id = Integer.parseInt(idT);

			    String sql = "update category set categoryname=?, description=? where categoryid=?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setString(1, name);
			        ps.setString(2, desc);
			        ps.setInt(3, id);

			        ps.executeUpdate();

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("Done");
			        a.setContentText("Category Updated Successfully!");
			        a.showAndWait();

			        uc.getSearchT().clear();
			        uc.getCatIDT().clear();
			        uc.getCatNT().clear();
			        uc.getdT().clear();
			        uc.getEdit().setDisable(true);

			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			});

			CategoryTableView catt=new CategoryTableView();
			
			Scene acscene = new Scene(ac.getAll(),400,400);
			Scene dcscene = new Scene(dc.getAll(),400,400);
			Scene ucscene = new Scene(uc.getAll(),400,400);
			Scene cattscene = new Scene(catt.getAll(),400,400);
			
			catt.getRef().setOnAction(e -> {
			    catt.getSearchT().clear();
			    catt.getTable().setItems(loadAllCategories());
			    catt.getTable().getSelectionModel().clearSelection();
			});
			catt.getSearchB().setOnAction(e -> {

			    String idT = catt.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        catt.getTable().setItems(loadAllCategories());
			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("All Categories");
			        a.setContentText("All categories loaded");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Category ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    var result = searchCategoryById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Not found");
			        a.setContentText("No category with this ID");
			        a.showAndWait();
			        catt.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    catt.getTable().setItems(result);
			});
			catt.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
			    if (newV != null) {
			        catt.getDeleteB().setDisable(false);
			        catt.getUpdateB().setDisable(false);
			    } else {
			        catt.getDeleteB().setDisable(true);
			        catt.getUpdateB().setDisable(true);
			    }
			});
			catt.getDeleteB().setOnAction(e -> {

			    Category selected = catt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a category first!");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm delete");
			    confirm.setContentText("Delete this category?");
			    confirm.showAndWait();

			    if (confirm.getResult() != ButtonType.OK) return;

			    String sql = "delete from category where categoryid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getCategoryID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Deleted");
			            a.setContentText("Category deleted successfully!");
			            a.showAndWait();
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not found");
			            a.setContentText("Not found");
			            a.showAndWait();
			        }

			        catt.getTable().setItems(loadAllCategories());
			        catt.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			catt.getUpdateB().setOnAction(e -> {

			    Category selected = catt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a category first!");
			        a.showAndWait();
			        return;
			    }

			    uc.getCatIDT().setText(selected.getCategoryID() + "");
			    uc.getCatNT().setText(selected.getCategoryName());
			    uc.getdT().setText(selected.getDescription());

			    primaryStage.setScene(ucscene);
			});
			mb.getAc().setOnAction(e->{
				primaryStage.setScene(acscene);
			});
			mb.getDc().setOnAction(e->{
				primaryStage.setScene(dcscene);
			});
			mb.getUc().setOnAction(e->{
				primaryStage.setScene(ucscene);
			});
			mb.getCatt().setOnAction(e->{
				primaryStage.setScene(cattscene);
			});
			
			AddCustomer acs=new AddCustomer();
			acs.getClear().setOnAction(e -> {
			    acs.getCidT().clear();
			    acs.getNameT().clear();
			    acs.getPnT().clear();
			    acs.geteT().clear();
			    acs.getAddT().clear();
			    acs.getUserT().clear();
			    acs.getPassT().clear();
			    acs.getDobP().setValue(null);
			    acs.getGenderC().setValue(null);
			});

			acs.getAdd().setOnAction(e -> {

			    String insertSql = """
			        insert into customer
			        (customerid, fullname, phonenumber, email, address, dateofbirth, gender, username, password)
			        values (?, ?, ?, ?, ?, ?, ?, ?, ?)
			        """;

			    String checkUserSql = "select username from customer where username=?";

			    try (Connection con = DatabaseConnection.getConnection()) {

			        
			        if (acs.getCidT().getText().trim().isEmpty() ||
			            acs.getNameT().getText().trim().isEmpty() ||
			            acs.getPnT().getText().trim().isEmpty() ||
			            acs.geteT().getText().trim().isEmpty() ||
			            acs.getAddT().getText().trim().isEmpty() ||
			            acs.getDobP().getValue() == null ||
			            acs.getGenderC().getValue() == null ||
			            acs.getUserT().getText().trim().isEmpty() ||
			            acs.getPassT().getText().trim().isEmpty()) {

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing Data");
			            a.setHeaderText("Missing Data");
			            a.setContentText("Please fill all fields.");
			            a.showAndWait();
			            return;
			        }

			        String idText = acs.getCidT().getText().trim();
			        String phone = acs.getPnT().getText().trim();
			        String username = acs.getUserT().getText().trim();
			        String password = acs.getPassT().getText().trim();

			        if (!idText.matches("\\d+")) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Invalid ID");
			            a.setContentText("Customer ID must be digits only.");
			            a.showAndWait();
			            return;
			        }

			        if (!phone.matches("\\d+")) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Invalid Phone");
			            a.setContentText("Phone number must be digits only.");
			            a.showAndWait();
			            return;
			        }

			        try (PreparedStatement psCheck = con.prepareStatement(checkUserSql)) {
			            psCheck.setString(1, username);
			            ResultSet rs = psCheck.executeQuery();
			            if (rs.next()) {
			                Alert a = new Alert(Alert.AlertType.ERROR);
			                a.setTitle("Username Exists");
			                a.setContentText("This username is already used.");
			                a.showAndWait();
			                return;
			            }
			        }

			        
			        try (PreparedStatement ps = con.prepareStatement(insertSql)) {

			            int id = Integer.parseInt(idText);
			            String name = acs.getNameT().getText().trim();
			            String email = acs.geteT().getText().trim();
			            String address = acs.getAddT().getText().trim();
			            java.sql.Date dob = java.sql.Date.valueOf(acs.getDobP().getValue());
			            String gender = acs.getGenderC().getValue();

			            ps.setInt(1, id);
			            ps.setString(2, name);
			            ps.setString(3, phone);
			            ps.setString(4, email);
			            ps.setString(5, address);
			            ps.setDate(6, dob);
			            ps.setString(7, gender);
			            ps.setString(8, username);
			            ps.setString(9, password);

			            ps.executeUpdate();
			        }

			        Alert done = new Alert(Alert.AlertType.INFORMATION);
			        done.setTitle("Done");
			        done.setHeaderText("Account created successfully");
			        done.setContentText("Customer ID: " + acs.getCidT().getText().trim());
			        done.showAndWait();

			        acs.getClear().fire();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});


			DeleteCustomer dcs=new DeleteCustomer();
			dcs.getClear().setOnAction(e -> {
			    dcs.getSearchT().clear();
			    dcs.getCidT().clear();
			    dcs.getNameT().clear();
			    dcs.getPnT().clear();
			    dcs.geteT().clear();
			    dcs.getAddT().clear();
			    dcs.getDobP().setValue(null);
			    dcs.getGenderC().setValue(null);
			    dcs.getDelete().setDisable(true);
			});

			dcs.getSearchB().setOnAction(e -> {

				String sql = "select * from customer where customerid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        if (dcs.getSearchT().getText().trim().isEmpty()) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing ID");
			            a.setHeaderText("Missing ID");
			            a.setContentText("Please enter Customer ID.");
			            a.showAndWait();
			            return;
			        }

			        int id = Integer.parseInt(dcs.getSearchT().getText().trim());

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dcs.getCidT().setText(rs.getString("CustomerID"));
			            dcs.getNameT().setText(rs.getString("FullName"));
			            dcs.getPnT().setText(rs.getString("PhoneNumber"));
			            dcs.geteT().setText(rs.getString("Email"));
			            dcs.getAddT().setText(rs.getString("Address"));

			            java.sql.Date dob = rs.getDate("DateOfBirth");
			            if (dob != null)
			                dcs.getDobP().setValue(dob.toLocalDate());
			            else
			                dcs.getDobP().setValue(null);

			            dcs.getGenderC().setValue(rs.getString("Gender"));

			            dcs.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText("Customer Not Found");
			            a.setContentText("No customer with ID = " + id);
			            a.showAndWait();

			            dcs.getDelete().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			dcs.getDelete().setOnAction(e -> {

				String sql = "delete from customer where customerid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        int id = Integer.parseInt(dcs.getCidT().getText().trim());

			        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			        confirm.setTitle("Confirm Delete");
			        confirm.setHeaderText("Are you sure?");
			        confirm.setContentText("Delete Customer ID: " + id);

			        if (confirm.showAndWait().get().getText().equals("OK")) {

			            ps.setInt(1, id);

			            int deleted = ps.executeUpdate();

			            if (deleted > 0) {
			                Alert done = new Alert(Alert.AlertType.INFORMATION);
			                done.setTitle("Done");
			                done.setHeaderText("Customer Deleted Successfully");
			                done.setContentText("Customer ID: " + id);
			                done.showAndWait();

			                dcs.getClear().fire();
			            }
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			UpdateCustomer ucs=new UpdateCustomer();
			ucs.getClear().setOnAction(e -> {
			    ucs.getSearchT().clear();
			    ucs.getCidT().clear();
			    ucs.getNameT().clear();
			    ucs.getPnT().clear();
			    ucs.geteT().clear();
			    ucs.getAddT().clear();
			    ucs.getDobP().setValue(null);
			    ucs.getGenderC().setValue(null);
			    ucs.getEdit().setDisable(true);
			});

			ucs.getSearchB().setOnAction(e -> {

				String sql = "select * from customer where customerid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        if (ucs.getSearchT().getText().trim().isEmpty()) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing ID");
			            a.setHeaderText("Missing ID");
			            a.setContentText("Please enter Customer ID.");
			            a.showAndWait();
			            return;
			        }

			        int id = Integer.parseInt(ucs.getSearchT().getText().trim());

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {

			            ucs.getCidT().setText(rs.getString("CustomerID"));
			            ucs.getNameT().setText(rs.getString("FullName"));
			            ucs.getPnT().setText(rs.getString("PhoneNumber"));
			            ucs.geteT().setText(rs.getString("Email"));
			            ucs.getAddT().setText(rs.getString("Address"));

			            java.sql.Date dob = rs.getDate("DateOfBirth");
			            if (dob != null)
			                ucs.getDobP().setValue(dob.toLocalDate());
			            else
			                ucs.getDobP().setValue(null);

			            ucs.getGenderC().setValue(rs.getString("Gender"));

			            ucs.getEdit().setDisable(false);

			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText("Customer Not Found");
			            a.setContentText("No customer with ID = " + id);
			            a.showAndWait();

			            ucs.getEdit().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			ucs.getEdit().setOnAction(e -> {

				String sql = "update customer set fullname=?, phonenumber=?, email=?, address=?, dateofbirth=?, gender=? where customerid=?";


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        int id = Integer.parseInt(ucs.getCidT().getText().trim());

			        if (ucs.getNameT().getText().trim().isEmpty() ||
			            ucs.getPnT().getText().trim().isEmpty() ||
			            ucs.geteT().getText().trim().isEmpty() ||
			            ucs.getAddT().getText().trim().isEmpty() ||
			            ucs.getDobP().getValue() == null ||
			            ucs.getGenderC().getValue() == null) {

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing Data");
			            a.setHeaderText("Missing Data");
			            a.setContentText("Please fill all fields.");
			            a.showAndWait();
			            return;
			        }

			        String name = ucs.getNameT().getText().trim();
			        String phone = ucs.getPnT().getText().trim();
			        String email = ucs.geteT().getText().trim();
			        String address = ucs.getAddT().getText().trim();

			        java.sql.Date dob = java.sql.Date.valueOf(ucs.getDobP().getValue());
			        String gender = ucs.getGenderC().getValue();

			        ps.setString(1, name);
			        ps.setString(2, phone);
			        ps.setString(3, email);
			        ps.setString(4, address);
			        ps.setDate(5, dob);
			        ps.setString(6, gender);
			        ps.setInt(7, id);

			        int updated = ps.executeUpdate();

			        if (updated > 0) {
			            Alert done = new Alert(Alert.AlertType.INFORMATION);
			            done.setTitle("Done");
			            done.setHeaderText("Customer Updated Successfully");
			            done.setContentText("Customer ID: " + id);
			            done.showAndWait();

			            ucs.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			CustomerTableView ct=new CustomerTableView();

			ct.getRefresh().setOnAction(e->{
				ct.getTable().setItems(loadCustomers());
			});
			Scene acsscene = new Scene(acs.getAll(),400,400);
			Scene dcsscene = new Scene(dcs.getAll(),400,400);
			Scene ucsscene = new Scene(ucs.getAll(),400,400);
			Scene ctscene = new Scene(ct.getAll(),400,400);

			mb.getAcs().setOnAction(e->{
				primaryStage.setScene(acsscene);
			});
			mb.getDcs().setOnAction(e->{
				primaryStage.setScene(dcsscene);
			});
			mb.getUcs().setOnAction(e->{
				primaryStage.setScene(ucsscene);
			});
			mb.getCt().setOnAction(e->{
				primaryStage.setScene(ctscene);
			});
			
			AddDoctor ad = new AddDoctor();

			ad.getAdd().setOnAction(e -> {
				  String sql = """
				            insert into doctor (doctorid, fullname, licensenumber, phonenumber, email, clinicaddress)
				            values (?, ?, ?, ?, ?, ?)
				            """;
			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(ad.getdIDT().getText().trim());
			        String name = ad.getfNT().getText().trim();
			        String license = ad.getLN().getText().trim();
			        String phone = ad.getpNT().getText().trim();
			        String email = ad.getEmT().getText().trim();
			        String addr = ad.getAddT().getText().trim();

			        // validation بسيط
			        if (name.isEmpty() || license.isEmpty()) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Error");
			            a.setHeaderText(null);
			            a.setContentText("Full Name and License Number are required ❌");
			            a.showAndWait();
			            return;
			        }

			      

			        ps.setInt(1, id);
			        ps.setString(2, name);
			        ps.setString(3, license);
			        ps.setString(4, phone.isEmpty() ? null : phone);
			        ps.setString(5, email.isEmpty() ? null : email);
			        ps.setString(6, addr.isEmpty() ? null : addr);

			        ps.executeUpdate();
			        ps.close();

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("Success");
			        a.setHeaderText(null);
			        a.setContentText("Doctor Added Successfully");
			        a.showAndWait();

			        // clear fields
			        ad.getdIDT().clear();
			        ad.getfNT().clear();
			        ad.getLN().clear();
			        ad.getpNT().clear();
			        ad.getEmT().clear();
			        ad.getAddT().clear();

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText("Doctor ID must be a valid number ❌");
			        a.showAndWait();
			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText("Error Adding Doctor ❌\nCheck ID / License Number (must be unique).");
			        a.showAndWait();
			    }
			});



			DeleteDoctor dd=new DeleteDoctor();

			dd.getSearchB().setOnAction(e -> {
				 String sql = """
				            select doctorid, fullname, licensenumber, phonenumber, email, clinicaddress
				            from doctor
				            where doctorid = ?
				            """;
				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(dd.getSearchT().getText().trim());
			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dd.getDocIDT().setText(String.valueOf(rs.getInt("doctorid")));
			            dd.getDocNT().setText(rs.getString("fullname"));

			            dd.getLicT().setText(rs.getString("licensenumber"));

			            dd.getPnT().setText(rs.getString("phonenumber"));
			            dd.geteT().setText(rs.getString("email"));
			            dd.getCaT().setText(rs.getString("clinicaddress"));

			            dd.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.WARNING);
			            a.setTitle("Not Found");
			            a.setHeaderText(null);
			            a.setContentText("Doctor not found ❌");
			            a.showAndWait();

			            dd.getDelete().setDisable(true);
			        }

			        rs.close();
			        ps.close();

			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText("Invalid Doctor ID ❌");
			        a.showAndWait();
			    }
			});
			dd.getDelete().setOnAction(e -> {
		        String sql = "delete from doctor where doctorid = ?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(dd.getDocIDT().getText().trim());

			        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			        confirm.setTitle("Confirm Delete");
			        confirm.setHeaderText(null);
			        confirm.setContentText("Are you sure you want to delete this doctor?");
			        if (confirm.showAndWait().get() != ButtonType.OK) return;
			        ps.setInt(1, id);

			        int rows = ps.executeUpdate();
			        ps.close();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Success");
			            a.setHeaderText(null);
			            a.setContentText("Doctor deleted successfully");
			            a.showAndWait();

			            // clear fields
			            dd.getSearchT().clear();
			            dd.getDocIDT().clear();
			            dd.getDocNT().clear();
			            dd.getLicT().clear();
			            dd.getPnT().clear();
			            dd.geteT().clear();
			            dd.getCaT().clear();

			            dd.getDelete().setDisable(true);
			        }

			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText("Error deleting doctor ❌");
			        a.showAndWait();
			    }
			});
			dd.getClear().setOnAction(e -> {
			    dd.getSearchT().clear();
			    dd.getDocIDT().clear();
			    dd.getDocNT().clear();
			    dd.getLicT().clear();
			    dd.getPnT().clear();
			    dd.geteT().clear();
			    dd.getCaT().clear();

			    dd.getDelete().setDisable(true);
			});

			UpdateDoctor ud=new UpdateDoctor();
			ud.getSearchB().setOnAction(e -> {
				 String sql = """
				            select doctorid, fullname, licensenumber, phonenumber, email, clinicaddress
				            from doctor
				            where doctorid = ?
				            """;
				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(ud.getSearchT().getText().trim());
			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            ud.getDocIDT().setText(String.valueOf(rs.getInt("doctorid")));
			            ud.getDocNT().setText(rs.getString("fullname"));

			            ud.getLicT().setText(rs.getString("licensenumber"));

			            ud.getPnT().setText(rs.getString("phonenumber"));
			            ud.geteT().setText(rs.getString("email"));
			            ud.getCaT().setText(rs.getString("clinicaddress"));

			            ud.getDocNT().setEditable(true);
			            ud.getLicT().setEditable(true);
			            ud.getPnT().setEditable(true);
			            ud.geteT().setEditable(true);
			            ud.getCaT().setEditable(true);

			            ud.getEdit().setDisable(false);

			        } else {
			            Alert a = new Alert(Alert.AlertType.WARNING);
			            a.setTitle("Not Found");
			            a.setHeaderText(null);
			            a.setContentText("Doctor not found");
			            a.showAndWait();

			            ud.getEdit().setDisable(true);
			        }

			        rs.close();
			        ps.close();

			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText("Invalid Doctor ID");
			        a.showAndWait();
			    }
			});
			ud.getEdit().setOnAction(e -> {
				 String sql = """
				            update doctor
				            set fullname = ?,
				                licensenumber = ?,
				                phonenumber = ?,
				                email = ?,
				                clinicaddress = ?
				            where doctorid = ?
				            """;
				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(ud.getDocIDT().getText().trim());

			        String name = ud.getDocNT().getText().trim();
			        String license = ud.getLicT().getText().trim();
			        String phone = ud.getPnT().getText().trim();
			        String email = ud.geteT().getText().trim();
			        String addr = ud.getCaT().getText().trim();

			        if (name.isEmpty() || license.isEmpty()) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Error");
			            a.setHeaderText(null);
			            a.setContentText("Full Name and License Number are required");
			            a.showAndWait();
			            return;
			        }

			        ps.setString(1, name);
			        ps.setString(2, license);
			        ps.setString(3, phone.isEmpty() ? null : phone);
			        ps.setString(4, email.isEmpty() ? null : email);
			        ps.setString(5, addr.isEmpty() ? null : addr);
			        ps.setInt(6, id);

			        int rows = ps.executeUpdate();
			        ps.close();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Success");
			            a.setHeaderText(null);
			            a.setContentText("Doctor updated successfully");
			            a.showAndWait();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText("Error updating doctor\nCheck License Number unique.");
			        a.showAndWait();
			    }
			});
			ud.getClear().setOnAction(e -> {
			    ud.getSearchT().clear();
			    ud.getDocIDT().clear();
			    ud.getDocNT().clear();
			    ud.getLicT().clear();
			    ud.getPnT().clear();
			    ud.geteT().clear();
			    ud.getCaT().clear();

			    ud.getDocNT().setEditable(false);
			    ud.getLicT().setEditable(false);
			    ud.getPnT().setEditable(false);
			    ud.geteT().setEditable(false);
			    ud.getCaT().setEditable(false);

			    ud.getEdit().setDisable(true);
			});

			DoctorTableView dt=new DoctorTableView();

			dt.getRef().setOnAction(e->{
				try (Connection con = DatabaseConnection.getConnection()) {
					dt.loadDoctorsData(con);
					}
				catch(Exception ex) {
					 Alert a = new Alert(Alert.AlertType.ERROR);
				        a.setTitle(ex.getMessage());
				        a.setContentText(ex.getMessage());
				        a.showAndWait();
				}}
					);
				
			Scene adscene = new Scene(ad.getAll(),400,400);
			Scene ddscene = new Scene(dd.getAll(),400,400);
			Scene udscene = new Scene(ud.getAll(),400,400);
			Scene dtscene = new Scene(dt.getAll(),400,400);

			mb.getAd().setOnAction(e->{
				primaryStage.setScene(adscene);
			});
			mb.getDd().setOnAction(e->{
				primaryStage.setScene(ddscene);
			});
			mb.getUd().setOnAction(e->{
				primaryStage.setScene(udscene);
			});
			mb.getDt().setOnAction(e->{
				primaryStage.setScene(dtscene);
			});
			
			AddEmployee ae=new AddEmployee();
			ae.getAdd().setOnAction(e->{
				    String idt = ae.getEmpIDT().getText().trim();
				    String name = ae.getEmpNT().getText().trim();
				    String position = ae.getPnT().getText().trim();
				    String st = ae.getsT().getText().trim();
				    String bid = ae.getBidT().getText().trim();

				    if (idt.isEmpty() || name.isEmpty() || position.isEmpty() || st.isEmpty() || bid.isEmpty()) {
				        Alert a = new Alert(Alert.AlertType.ERROR);
				        a.setTitle("check null feilds and fill them");
				        a.setContentText("check null feilds and fill them");
				        a.showAndWait();
				        return;
				    }

				    int id, branchID;
				    double salary;

				    try {
				        id = Integer.parseInt(idt);
				        branchID = Integer.parseInt(bid);
				        salary = Double.parseDouble(st);
				    } catch (Exception ex) {
				        Alert a = new Alert(Alert.AlertType.ERROR);
				        a.setTitle("ID must be integer value");
				        a.setContentText("ID must be integer value");
				        a.showAndWait();
				        return;
				    }

				    String sql = """
				            insert into employee (empid, fullname, qualification, salary, branchid)
				            values (?, ?, ?, ?, ?)
				            """;

				    try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {

				        ps.setInt(1, id);
				        ps.setString(2, name);
				        ps.setString(3, position);
				        ps.setDouble(4, salary);
				        ps.setInt(5, branchID);

				        int rows = ps.executeUpdate();

				        if (rows > 0) {
				            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				            alert.setTitle("employee inserted succesfuly");
				            alert.setContentText("employee inserted succesfuly");
				            alert.showAndWait();
				            ae.getEmpIDT().clear();
				            ae.getEmpNT().clear();
				            ae.getPnT().clear();
				            ae.getsT().clear();
				            ae.getBidT().clear();
				        }

				    } catch (Exception ex) {
				        Alert alert = new Alert(Alert.AlertType.ERROR);
				        alert.setTitle(ex.getMessage());
				        alert.setContentText(ex.getMessage());
				        alert.showAndWait();
				    }
				});

			ae.getClear().setOnAction(e -> {
			    ae.getEmpIDT().clear();
			    ae.getEmpNT().clear();
			    ae.getqT().clear();
			    ae.getPlnT().clear();
			    ae.getAddT().clear();
			    ae.getNaT().clear();
			    ae.getPnT().clear();
			    ae.geteT().clear();
			    ae.getsT().clear();
			    ae.getBidT().clear();

			    ae.getAdd().setDisable(true);
			});
			DeleteEmployee de=new DeleteEmployee();
			de.getSearchB().setOnAction(e -> {

			    String idt = de.getSearchT().getText().trim();

			    if (idt.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("please enter employee id");
			        a.setContentText("please enter employee id");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idt);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("employee ID must be an integer");
			        a.setContentText("employee ID must be an integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select empid, fullname, qualification, licenseno, address,
			                   nationalid, phonenumber, email, salary, branchid
			            from employee
			            where empid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {

			            de.getEmpIDT().setText(rs.getString("EmpID"));
			            de.getEmpNT().setText(rs.getString("FullName"));
			            de.getqT().setText(rs.getString("Qualification"));
			            de.getPlnT().setText(rs.getString("ProfessionalLicenseNumber"));
			            de.getAddT().setText(rs.getString("Address"));
			            de.getNaT().setText(rs.getString("NationalID"));
			            de.getPnT().setText(rs.getString("PhoneNumber"));
			            de.geteT().setText(rs.getString("Email"));
			            de.getsT().setText(String.valueOf(rs.getDouble("Salary")));
			            de.getBidT().setText(String.valueOf(rs.getInt("BranchID")));

			            de.getDelete().setDisable(false);

			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("employee found succesfuly");
			            a.setContentText("employee found succesfuly");
			            a.showAndWait();

			        } else {

			            de.getEmpIDT().clear();
			            de.getEmpNT().clear();
			            de.getqT().clear();
			            de.getPlnT().clear();
			            de.getAddT().clear();
			            de.getNaT().clear();
			            de.getPnT().clear();
			            de.geteT().clear();
			            de.getsT().clear();
			            de.getBidT().clear();

			            de.getDelete().setDisable(true);

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("no employee found with this ID");
			            a.setContentText("no employee found with this ID ");
			            a.showAndWait();
			        }

			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			de.getDelete().setOnAction(e -> {
				 String idT = de.getEmpIDT().getText().trim();

				    if (idT.isEmpty()) {
				        Alert a = new Alert(Alert.AlertType.ERROR);
				        a.setTitle("please enter emplyee id");
				        a.setContentText("please enter emplyee id");
				        a.showAndWait();
				        return;
				    }
			        int id = Integer.parseInt(idT);

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("are you sure you want to delete this employee?");
			    confirm.setContentText("are you sure you want to delete this employee?");
			    Optional<ButtonType> result = confirm.showAndWait();
			    if (result.isEmpty() || result.get() != ButtonType.OK) {
			        return;
			    }


			    String sql = "delete from employee where empid = ?";

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, id);
			            int rows = ps.executeUpdate();

			            if (rows > 0) {
			                Alert a = new Alert(Alert.AlertType.INFORMATION);
			                a.setTitle("employee deleted succesfuly!");
			                a.setContentText("employee deleted succesfuly!");
			                a.showAndWait();
			                de.getSearchT().clear();
						    de.getEmpIDT().clear();
						    de.getEmpNT().clear();
						    de.getqT().clear();
						    de.getPlnT().clear();
						    de.getAddT().clear();
						    de.getNaT().clear();
						    de.getPnT().clear();
						    de.geteT().clear();
						    de.getsT().clear();
						    de.getBidT().clear();

						    de.getDelete().setDisable(true);
			            } else {
			                Alert a = new Alert(Alert.AlertType.ERROR);
			                a.setTitle("not found");
			                a.setContentText("not found");
			                a.showAndWait();
			            }

			        } catch (Exception ex) {
			            ex.printStackTrace();
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle(ex.getMessage());
			            a.setContentText(ex.getMessage());
			            a.showAndWait();
			        }
			});
			de.getClear().setOnAction(e -> {

			    de.getSearchT().clear();
			    de.getEmpIDT().clear();
			    de.getEmpNT().clear();
			    de.getqT().clear();
			    de.getPlnT().clear();
			    de.getAddT().clear();
			    de.getNaT().clear();
			    de.getPnT().clear();
			    de.geteT().clear();
			    de.getsT().clear();
			    de.getBidT().clear();

			    de.getDelete().setDisable(true);
			});

			UpdateEmployee ue=new UpdateEmployee();
			ue.getSearchB().setOnAction(e -> {

			    String idt = ue.getSearchT().getText().trim();

			    if (idt.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("please enter employee id");
			        a.setContentText("please enter employee id");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idt);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("employee ID must be an integer");
			        a.setContentText("employee ID must be an integer");
			        a.showAndWait();
			        return;
			    }
			    String sql = """
			            select empid, fullname, qualification, licenseno, address,
			                   nationalid, phonenumber, email, salary, branchid
			            from employee
			            where empid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {

			            ue.getEmpIDT().setText(rs.getString("EmpID"));
			            ue.getEmpNT().setText(rs.getString("FullName"));
			            ue.getqT().setText(rs.getString("Qualification"));
			            ue.getPlnT().setText(rs.getString("ProfessionalLicenseNumber"));
			            ue.getAddT().setText(rs.getString("Address"));
			            ue.getNaT().setText(rs.getString("NationalID"));
			            ue.getPnT().setText(rs.getString("PhoneNumber"));
			            ue.geteT().setText(rs.getString("Email"));
			            ue.getsT().setText(String.valueOf(rs.getDouble("Salary")));
			            ue.getBidT().setText(String.valueOf(rs.getInt("BranchID")));

			            ue.getEdit().setDisable(false);

			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("employee found succesfuly");
			            a.setContentText("employee found succesfuly");
			            a.showAndWait();

			        } else {

			            ue.getEmpIDT().clear();
			            ue.getEmpNT().clear();
			            ue.getqT().clear();
			            ue.getPlnT().clear();
			            ue.getAddT().clear();
			            ue.getNaT().clear();
			            ue.getPnT().clear();
			            ue.geteT().clear();
			            ue.getsT().clear();
			            ue.getBidT().clear();

			            ue.getEdit().setDisable(true);

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("no employee found with this ID");
			            a.setContentText("no employee found with this ID");
			            a.showAndWait();
			        }

			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			ue.getEdit().setOnAction(e -> {

			    String idt = ue.getEmpIDT().getText().trim();
			    int id = Integer.parseInt(idt);
			   

			    String name = ue.getEmpNT().getText().trim();
			    String position = ue.getPnT().getText().trim();
			    String st = ue.getsT().getText().trim();
			    String btt = ue.getBidT().getText().trim();
			    StringBuilder sql = new StringBuilder("update employee set ");
			    java.util.ArrayList<Object> params = new java.util.ArrayList<>();

			    if (!name.isEmpty()) {
			        sql.append("fullname=?, ");
			        params.add(name);
			    }

			    if (!position.isEmpty()) {
			        sql.append("qualification=?, ");
			        params.add(position);
			    }

			    if (!st.isEmpty()) {
			        try {
			            double salary = Double.parseDouble(st);
			            sql.append("salary=?, ");
			            params.add(salary);
			        } catch (Exception ex) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle(ex.getMessage());
			            a.setContentText(ex.getMessage());
			            a.showAndWait();
			            return;
			        }
			    }

			    if (!btt.isEmpty()) {
			        try {
			            int branchID = Integer.parseInt(btt);
			            sql.append("branchid=?, ");
			            params.add(branchID);
			        } catch (Exception ex) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle(ex.getMessage());
			            a.setContentText(ex.getMessage());
			            a.showAndWait();
			            return;
			        }
			    }

			    if (params.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.WARNING);
			        a.setTitle("No changes");
			        a.setContentText("Please enter at least one field to update.");
			        a.showAndWait();
			        return;
			    }

			    sql.setLength(sql.length() - 2); // remove last ", "
			    sql.append(" where empid=?");

			    params.add(id);

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql.toString())) {

			        for (int i = 0; i < params.size(); i++) {
			            Object val = params.get(i);
			            if (val instanceof Integer) {
			            	ps.setInt(i + 1, (Integer) val);
			            }
			            else if (val instanceof Double) {
			            	ps.setDouble(i + 1, (Double) val);
			            }
			            else {
			            	ps.setString(i + 1, val.toString());
			            }
			        }

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("employee updated succesfuly");
			            a.setContentText("employee updated succesfuly");
			            a.showAndWait();

			            ue.getEmpIDT().clear();
			            ue.getEmpNT().clear();
			            ue.getPnT().clear();
			            ue.getsT().clear();
			            ue.getBidT().clear();
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("employee not found");
			            a.setContentText("employee not found");
			            a.showAndWait();
			        }

			    } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("update failed");
			        a.setContentText("update failed");
			        a.showAndWait();
			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			ue.getClear().setOnAction(e -> {
			    ue.getSearchT().clear();
			    ue.getEmpIDT().clear();
			    ue.getEmpNT().clear();
			    ue.getqT().clear();
			    ue.getPlnT().clear();
			    ue.getAddT().clear();
			    ue.getNaT().clear();
			    ue.getPnT().clear();
			    ue.geteT().clear();
			    ue.getsT().clear();
			    ue.getBidT().clear();

			    ue.getEdit().setDisable(true);
			});

			EmployeeTableView et=new EmployeeTableView();
			et.getRef().setOnAction(e -> {
			    et.getTable().setItems(loadAllEmployes());
			    Alert a = new Alert(Alert.AlertType.INFORMATION);
			    a.setTitle("done");
			    a.setContentText("done");
			    a.showAndWait();
			});
			et.getSearchB().setOnAction(e -> {

			    String idT = et.getSearchT().getText().trim();
			    if (idT.isEmpty()) {
			        et.getTable().setItems(loadAllEmployes());

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("all employees");
			        a.setContentText("all employees");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("invalid input employee ID must be integer");
			        a.setContentText("invalid input employee ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    ObservableList<Employee> result = searchEmployeeById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("not found");
			        a.setContentText("not found");
			        a.showAndWait();

			        et.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    et.getTable().setItems(result);
			});
			et.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			    if (newVal != null) {
			        et.getDeleteB().setDisable(false);
			        et.getUpdateB().setDisable(false);
			    } else {
			        et.getDeleteB().setDisable(true);
			        et.getUpdateB().setDisable(true);
			    }
			});
			et.getDeleteB().setOnAction(e -> {

			    Employee selected = et.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("no selection employee");
			        a.setContentText("no selection employee");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("are you sure you want to delete this employee?");
			    confirm.setContentText("are you sure you want to delete this employee?");
			    confirm.showAndWait();

			    if (confirm.getResult() != javafx.scene.control.ButtonType.OK) {
			        return;
			    }

			    String sql = "delete from employee where empid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getEmpID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("employee deleted succesfuly!");
			            a.setContentText("employee deleted succesfuly!");
			            a.showAndWait();
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("not found");
			            a.setContentText("not found");
			            a.showAndWait();
			        }

			        et.getTable().setItems(loadAllEmployes());
			        et.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			Scene uescene = new Scene(ue.getAll(),400,400);

			et.getUpdateB().setOnAction(e -> {

			    Employee selected = et.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("no selection employee");
			        a.setContentText("no selection employee");
			        a.showAndWait();
			        return;
			    }

			    ue.getEmpIDT().setText(selected.getEmpID()+"");
			    ue.getEmpNT().setText(selected.getFullName());
			    ue.getqT().setText(selected.getQualification());
			    ue.getPnT().setText(selected.getPhoneNumber());
			    ue.getsT().setText(selected.getSalary()+"");
			    ue.getBidT().setText(selected.getBranchID()+"");

			    ue.getEdit().setDisable(false);

			    primaryStage.setScene(uescene);
			});

			EmployeeBranchTableView ebt=new EmployeeBranchTableView();
			ebt.getRef().setOnAction(e -> {
			    ebt.getSearchT().clear();
			    ebt.getTable().setItems(loadEmployeeBranchData());
			    ebt.getTable().getSelectionModel().clearSelection();
			});
			ebt.getSearchB().setOnAction(e -> {
			    String text = ebt.getSearchT().getText().trim();

			    if (text.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("please enter branch ID");
			        a.setContentText("please enter branch ID");
			        a.showAndWait();
			        return;
			    }

			    int branchID;
			    try {
			        branchID = Integer.parseInt(text);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("invalid");
			        a.setContentText("invalid");
			        a.showAndWait();
			        return;
			    }

			    ObservableList<EmployeeBranch> result = searchEmployeeBranchID(branchID);

			    ebt.getTable().setItems(result);
			});
			TopEmployeeTableView tet = new TopEmployeeTableView();
			EmployeeQ7TableView q7page = new EmployeeQ7TableView();
			Scene q7scene = new Scene(q7page.getAll(), 700, 550);

			Scene tetscene = new Scene(tet.getAll(), 500, 500);
			Scene aescene = new Scene(ae.getAll(),400,400);
			Scene descene = new Scene(de.getAll(),400,400);
			Scene etscene = new Scene(et.getAll(),400,400);
			Scene ebtscene = new Scene(ebt.getAll(),400,400);

			mb.getAe().setOnAction(e->{
				primaryStage.setScene(aescene);
			});
			mb.getDe().setOnAction(e->{
				primaryStage.setScene(descene);
			});
			mb.getUe().setOnAction(e->{
				primaryStage.setScene(uescene);
			});
			mb.getEt().setOnAction(e->{
				et.getTable().setItems(loadAllEmployes());
				primaryStage.setScene(etscene);
			});
			mb.getEbt().setOnAction(e->{
			    ebt.getTable().setItems(loadEmployeeBranchData());
				primaryStage.setScene(ebtscene);
			});

			EmployeeQ6TableView q6 = new EmployeeQ6TableView();
			EmployeeQ7TableView q7 = new EmployeeQ7TableView();
			EmployeeQ8TableView q8 = new EmployeeQ8TableView();

			Scene q6scene = new Scene(q6.getAll(), 400, 400);
			Scene q8scene = new Scene(q8.getAll(), 400, 400);

			mb.getQ6().setOnAction(e ->{
				primaryStage.setScene(q6scene);
			});
			mb.getQ7().setOnAction(e ->{
				primaryStage.setScene(q7scene);
			});
			mb.getQ8().setOnAction(e ->{
				primaryStage.setScene(q8scene);
			});

			
			AddIC aic=new AddIC();
			aic.getAdd().setOnAction(e -> {
				String sql = "insert into insurance_company values (?, ?, ?, ?, ?, ?)";


				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(aic.getIdT().getText().trim());
			        String name = aic.getNameT().getText().trim();
			        String lic = aic.getLicT().getText().trim();
			        String phone = aic.getPhoneT().getText().trim();
			        String email = aic.getEmailT().getText().trim();
			        String addr = aic.getAddressT().getText().trim();

			        ps.setInt(1, id);
			        ps.setString(2, name);
			        ps.setString(3, lic);
			        ps.setString(4, phone);
			        ps.setString(5, email);
			        ps.setString(6, addr);

			        ps.executeUpdate();
			        ps.close();

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("Done");
			        a.setHeaderText("Insurance company added successfully");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Cannot add insurance company");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});


			DeleteIC dic=new DeleteIC();
			dic.getSearchB().setOnAction(e -> {
				String sql = "select * from insurance_company where insurancecompanyid = ?";
				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(dic.getSearchT().getText().trim());
			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dic.getIdT().setText(rs.getInt("insurancecompanyid") + "");
			            dic.getNameT().setText(rs.getString("companyname"));
			            dic.getLicT().setText(rs.getString("licenseno"));
			            dic.getPhoneT().setText(rs.getString("phonenumber"));
			            dic.getEmailT().setText(rs.getString("email"));
			            dic.getAddressT().setText(rs.getString("address"));

			            dic.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setHeaderText("Not found");
			            a.showAndWait();
			            dic.getDelete().setDisable(true);
			        }

			        rs.close();
			        ps.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setHeaderText("Search erro");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			dic.getDelete().setOnAction(e -> {
				String sql = "delete from insurance_company where insurancecompanyid = ?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(dic.getIdT().getText().trim());

			        ps.setInt(1, id);
			        ps.executeUpdate();
			        ps.close();

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setHeaderText("Deleted successfully");
			        a.showAndWait();

			        dic.getDelete().setDisable(true);

			        dic.getIdT().clear();
			        dic.getNameT().clear();
			        dic.getLicT().clear();
			        dic.getPhoneT().clear();
			        dic.getEmailT().clear();
			        dic.getAddressT().clear();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setHeaderText("Cannot delete");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			aic.getClear().setOnAction(e -> {
			    aic.getIdT().clear();
			    aic.getNameT().clear();
			    aic.getLicT().clear();
			    aic.getPhoneT().clear();
			    aic.getEmailT().clear();
			    aic.getAddressT().clear();
			});
			dic.getClear().setOnAction(e -> {
				dic.getSearchT().clear();
			    dic.getIdT().clear();
			    dic.getNameT().clear();
			    dic.getLicT().clear();
			    dic.getPhoneT().clear();
			    dic.getEmailT().clear();
			    dic.getAddressT().clear();
			    dic.getDelete().setDisable(true);
			});
			
			UpdateIC uic=new UpdateIC();
			uic.getClear().setOnAction(e -> {
				uic.getSearchT().clear();
			    uic.getIdT().clear();
			    uic.getNameT().clear();
			    uic.getLicT().clear();
			    uic.getPhoneT().clear();
			    uic.getEmailT().clear();
			    uic.getAddressT().clear();
			    uic.getEdit().setDisable(true);
			});
			uic.getSearchB().setOnAction(e -> {
				String sql = "select * from insurance_company where insurancecompanyid = ?";
				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(uic.getSearchT().getText().trim());
			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            uic.getIdT().setText(rs.getInt("insurancecompanyid") + "");
			            uic.getNameT().setText(rs.getString("companyname"));
			            uic.getLicT().setText(rs.getString("licenseno"));
			            uic.getPhoneT().setText(rs.getString("phonenumber"));
			            uic.getEmailT().setText(rs.getString("email"));
			            uic.getAddressT().setText(rs.getString("address"));

			            uic.getEdit().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setHeaderText("Not found");
			            a.showAndWait();
			            uic.getEdit().setDisable(true);
			        }

			        rs.close();
			        ps.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText("Search error ❌");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			uic.getEdit().setOnAction(e -> {
				String sql = "update insurance_company set companyname=?, licenseno=?, phonenumber=?, email=?, address=? where insurancecompanyid=?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(uic.getIdT().getText().trim());
			        String name = uic.getNameT().getText().trim();
			        String lic = uic.getLicT().getText().trim();
			        String phone = uic.getPhoneT().getText().trim();
			        String email = uic.getEmailT().getText().trim();
			        String addr = uic.getAddressT().getText().trim();


			        
			        ps.setString(1, name);
			        ps.setString(2, lic);
			        ps.setString(3, phone);
			        ps.setString(4, email);
			        ps.setString(5, addr);
			        ps.setInt(6, id);

			        ps.executeUpdate();
			        ps.close();

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setHeaderText("Updated successfully");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setHeaderText("Cannot update");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			InsuranceCompanyTableView ict=new InsuranceCompanyTableView();

			ict.getRef().setOnAction(e->{
				try (Connection con = DatabaseConnection.getConnection()){
					ict.loadData(con);	
				 } catch (Exception ex) {
				        Alert a = new Alert(Alert.AlertType.ERROR);
				        a.setHeaderText("Cannot update");
				        a.setContentText(ex.getMessage());
				        a.showAndWait();
				    }
				
			});
			Scene aicscene = new Scene(aic.getAll(),400,400);
			Scene dicscene = new Scene(dic.getAll(),400,400);
			Scene uicscene = new Scene(uic.getAll(),400,400);
			Scene ictscene = new Scene(ict.getAll(),400,400);

			mb.getAic().setOnAction(e->{
				primaryStage.setScene(aicscene);
			});
			mb.getDic().setOnAction(e->{
				primaryStage.setScene(dicscene);
			});
			mb.getUic().setOnAction(e->{
				primaryStage.setScene(uicscene);
			});
			mb.getIct().setOnAction(e->{
				primaryStage.setScene(ictscene);
			});
			
			AddInvoice aiv=new AddInvoice();
			aiv.getClear().setOnAction(e -> {
			    aiv.getIdT().clear();
			    aiv.getDateT().clear();
			    aiv.getTimeT().clear();
			    aiv.getSubT().clear();
			    aiv.getDisT().clear();
			    aiv.getTaxT().clear();
			    aiv.getTotalT().clear();
			    aiv.getPayT().clear();
			    aiv.getCidT().clear();
			    aiv.getEidT().clear();
			    aiv.getBidT().clear();
			});

			aiv.getAdd().setOnAction(e -> {

			    if (aiv.getIdT().getText().trim().isEmpty()
			            || aiv.getDateT().getText().trim().isEmpty()
			            || aiv.getTimeT().getText().trim().isEmpty()
			            || aiv.getSubT().getText().trim().isEmpty()
			            || aiv.getDisT().getText().trim().isEmpty()
			            || aiv.getTaxT().getText().trim().isEmpty()
			            || aiv.getTotalT().getText().trim().isEmpty()
			            || aiv.getPayT().getText().trim().isEmpty()
			            || aiv.getCidT().getText().trim().isEmpty()
			            || aiv.getEidT().getText().trim().isEmpty()
			            || aiv.getBidT().getText().trim().isEmpty()) {

			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    int id, cid, eid, bid;
			    double sub, dis, tax, total;
			    java.sql.Date date;
			    java.sql.Time time;
			    String pay;

			    try {
			        id = Integer.parseInt(aiv.getIdT().getText().trim());
			        cid = Integer.parseInt(aiv.getCidT().getText().trim());
			        eid = Integer.parseInt(aiv.getEidT().getText().trim());
			        bid = Integer.parseInt(aiv.getBidT().getText().trim());

			        sub = Double.parseDouble(aiv.getSubT().getText().trim());
			        dis = Double.parseDouble(aiv.getDisT().getText().trim());
			        tax = Double.parseDouble(aiv.getTaxT().getText().trim());
			        total = Double.parseDouble(aiv.getTotalT().getText().trim());

			        date = java.sql.Date.valueOf(aiv.getDateT().getText().trim()); // YYYY-MM-DD
			        time = java.sql.Time.valueOf(aiv.getTimeT().getText().trim()); // HH:MM:SS

			        pay = aiv.getPayT().getText().trim();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid input");
			        a.setContentText("Check: IDs integer, numbers double, date/time format");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            insert into invoice
			            (invoiceid, invoicedate, invoicetime, subtotal, discount, tax, totalamount,
			             paymentstatus, customerid, empid, branchid)
			            values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			            """;

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ps.setDate(2, date);
			        ps.setTime(3, time);
			        ps.setDouble(4, sub);
			        ps.setDouble(5, dis);
			        ps.setDouble(6, tax);
			        ps.setDouble(7, total);
			        ps.setString(8, pay);
			        ps.setInt(9, cid);
			        ps.setInt(10, eid);
			        ps.setInt(11, bid);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Invoice inserted successfully!");
			            a.showAndWait();
			            aiv.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			DeleteInvoice div=new DeleteInvoice();
			div.getClear().setOnAction(e -> {
			    div.getSearchT().clear();
			    div.getIdT().clear();
			    div.getDateT().clear();
			    div.getTimeT().clear();
			    div.getSubT().clear();
			    div.getDisT().clear();
			    div.getTaxT().clear();
			    div.getTotalT().clear();
			    div.getPayT().clear();
			    div.getCidT().clear();
			    div.getEidT().clear();
			    div.getBidT().clear();
			    div.getDelete().setDisable(true);
			});

			div.getSearchB().setOnAction(e -> {

			    String idT = div.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setContentText("Please enter Invoice ID.");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(idT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Invoice ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select invoiceid, invoicedate, invoicetime, subtotal, discount, tax,
			                   totalamount, paymentstatus, customerid, empid, branchid
			            from invoice
			            where invoiceid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            div.getIdT().setText(rs.getInt("invoiceid") + "");
			            div.getDateT().setText(rs.getDate("invoicedate") + "");
			            div.getTimeT().setText(rs.getTime("invoicetime") + "");
			            div.getSubT().setText(rs.getDouble("subtotal") + "");
			            div.getDisT().setText(rs.getDouble("discount") + "");
			            div.getTaxT().setText(rs.getDouble("tax") + "");
			            div.getTotalT().setText(rs.getDouble("totalamount") + "");
			            div.getPayT().setText(rs.getString("paymentstatus"));
			            div.getCidT().setText(rs.getInt("customerid") + "");
			            div.getEidT().setText(rs.getInt("empid") + "");
			            div.getBidT().setText(rs.getInt("branchid") + "");

			            div.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No invoice with ID = " + id);
			            a.showAndWait();
			            div.getDelete().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			div.getDelete().setOnAction(e -> {

			    if (div.getIdT().getText().trim().isEmpty()) return;

			    int id = Integer.parseInt(div.getIdT().getText().trim());

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm Delete");
			    confirm.setHeaderText("Are you sure?");
			    confirm.setContentText("Delete Invoice ID: " + id);

			    if (confirm.showAndWait().get() != ButtonType.OK) return;

			    String sql = "delete from invoice where invoiceid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Invoice deleted successfully!");
			            a.showAndWait();
			            div.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			UpdateInvoice uiv=new UpdateInvoice();
			uiv.getClear().setOnAction(e -> {
			    uiv.getSearchT().clear();
			    uiv.getIdT().clear();
			    uiv.getDateT().clear();
			    uiv.getTimeT().clear();
			    uiv.getSubT().clear();
			    uiv.getDisT().clear();
			    uiv.getTaxT().clear();
			    uiv.getTotalT().clear();
			    uiv.getPayT().clear();
			    uiv.getCidT().clear();
			    uiv.getEidT().clear();
			    uiv.getBidT().clear();
			    uiv.getEdit().setDisable(true);
			});

			uiv.getSearchB().setOnAction(e -> {

			    String idT = uiv.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setContentText("Please enter Invoice ID.");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(idT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Invoice ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select invoiceid, invoicedate, invoicetime, subtotal, discount, tax,
			                   totalamount, paymentstatus, customerid, empid, branchid
			            from invoice
			            where invoiceid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            uiv.getIdT().setText(rs.getInt("invoiceid") + "");
			            uiv.getDateT().setText(rs.getDate("invoicedate") + "");
			            uiv.getTimeT().setText(rs.getTime("invoicetime") + "");
			            uiv.getSubT().setText(rs.getDouble("subtotal") + "");
			            uiv.getDisT().setText(rs.getDouble("discount") + "");
			            uiv.getTaxT().setText(rs.getDouble("tax") + "");
			            uiv.getTotalT().setText(rs.getDouble("totalamount") + "");
			            uiv.getPayT().setText(rs.getString("paymentstatus"));
			            uiv.getCidT().setText(rs.getInt("customerid") + "");
			            uiv.getEidT().setText(rs.getInt("empid") + "");
			            uiv.getBidT().setText(rs.getInt("branchid") + "");

			            uiv.getEdit().setDisable(false);

			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No invoice with ID = " + id);
			            a.showAndWait();
			            uiv.getEdit().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			uiv.getEdit().setOnAction(e -> {

			    if (uiv.getIdT().getText().trim().isEmpty()) return;

			    int id, cid, eid, bid;
			    double sub, dis, tax, total;
			    java.sql.Date date;
			    java.sql.Time time;
			    String pay;

			    try {
			        id = Integer.parseInt(uiv.getIdT().getText().trim());
			        cid = Integer.parseInt(uiv.getCidT().getText().trim());
			        eid = Integer.parseInt(uiv.getEidT().getText().trim());
			        bid = Integer.parseInt(uiv.getBidT().getText().trim());

			        sub = Double.parseDouble(uiv.getSubT().getText().trim());
			        dis = Double.parseDouble(uiv.getDisT().getText().trim());
			        tax = Double.parseDouble(uiv.getTaxT().getText().trim());
			        total = Double.parseDouble(uiv.getTotalT().getText().trim());

			        date = java.sql.Date.valueOf(uiv.getDateT().getText().trim());
			        time = java.sql.Time.valueOf(uiv.getTimeT().getText().trim());

			        pay = uiv.getPayT().getText().trim();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid input");
			        a.setContentText("Check all values and formats!");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            update invoice
			            set invoicedate=?, invoicetime=?, subtotal=?, discount=?, tax=?, totalamount=?,
			                paymentstatus=?, customerid=?, empid=?, branchid=?
			            where invoiceid=?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setDate(1, date);
			        ps.setTime(2, time);
			        ps.setDouble(3, sub);
			        ps.setDouble(4, dis);
			        ps.setDouble(5, tax);
			        ps.setDouble(6, total);
			        ps.setString(7, pay);
			        ps.setInt(8, cid);
			        ps.setInt(9, eid);
			        ps.setInt(10, bid);
			        ps.setInt(11, id);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Invoice updated successfully!");
			            a.showAndWait();
			            uiv.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			InvoiceTableView it=new InvoiceTableView();
	
			it.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
			    if (newV != null) {
			        it.getDeleteB().setDisable(false);
			        it.getUpdateB().setDisable(false);
			    } else {
			        it.getDeleteB().setDisable(true);
			        it.getUpdateB().setDisable(true);
			    }
			});

			it.getRef().setOnAction(e -> {
			    it.getSearchT().clear();
			    it.getTable().setItems(loadAllInvoices());
			    it.getTable().getSelectionModel().clearSelection();
			});
			it.getSearchB().setOnAction(e -> {

			    String idT = it.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        it.getTable().setItems(loadAllInvoices());

			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("All invoices");
			        a.setContentText("All invoices loaded");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Invoice ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    ObservableList<Invoice> result = searchInvoiceById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Not found");
			        a.setContentText("No invoice with this ID");
			        a.showAndWait();
			        it.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    it.getTable().setItems(result);
			});
			it.getDeleteB().setOnAction(e -> {

			    Invoice selected = it.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select an invoice first!");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm delete");
			    confirm.setContentText("Delete this invoice?");
			    confirm.showAndWait();

			    if (confirm.getResult() != ButtonType.OK) return;

			    String sql = "delete from invoice where invoiceid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getInvoiceID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Deleted");
			            a.setContentText("Invoice deleted successfully!");
			            a.showAndWait();
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not found");
			            a.setContentText("Invoice not found");
			            a.showAndWait();
			        }

			        it.getTable().setItems(loadAllInvoices());
			        it.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
	
			InvoiceBranchTableView ibt = new InvoiceBranchTableView();
			SalesTransactionTableView stt = new SalesTransactionTableView();
			InvoiceQ15TableView q15 = new InvoiceQ15TableView();
			InvoiceQ17TableView q17 = new InvoiceQ17TableView();
			InvoiceQ19TableView iq19 = new InvoiceQ19TableView();
			Scene iq19scene = new Scene(iq19.getAll(), 900, 600);

			InvoiceQ20TableView iq20 = new InvoiceQ20TableView();
			Scene iq20scene = new Scene(iq20.getAll(), 900, 600);

			InvoiceQ32TableView iq32 = new InvoiceQ32TableView();
			Scene iq32scene = new Scene(iq32.getAll(), 900, 600);

			InvoiceQ33TableView iq33 = new InvoiceQ33TableView();
			Scene iq33scene = new Scene(iq33.getAll(), 900, 600);

			Scene iq17scene = new Scene(q17.getAll(), 900, 600);

			InvoiceQ18TableView q18 = new InvoiceQ18TableView();
			Scene iq18scene = new Scene(q18.getAll(), 900, 600);

			Scene iq15scene = new Scene(q15.getAll(), 400, 400);

			mb.getQ15().setOnAction(e -> {
				primaryStage.setScene(iq15scene);
			});
			mb.getQ17().setOnAction(e -> {
				primaryStage.setScene(iq17scene);
			});
			mb.getQ18().setOnAction(e -> {
				primaryStage.setScene(iq18scene);
			});
			mb.getQ19().setOnAction(e -> {
				primaryStage.setScene(iq19scene);
			});
			mb.getQ20().setOnAction(e -> {
				primaryStage.setScene(iq20scene);
			});
			mb.getQ32().setOnAction(e ->{
				primaryStage.setScene(iq32scene);
			});
			mb.getQ33().setOnAction(e ->{
				primaryStage.setScene(iq33scene);
			});
			
			Scene sttscene = new Scene(stt.getAll(), 500, 500);
			Scene ibtscene = new Scene(ibt.getAll(), 500, 500);
			Scene aivscene = new Scene(aiv.getAll(),400,400);
			Scene divscene = new Scene(div.getAll(),400,400);
			Scene uivscene = new Scene(uiv.getAll(),400,400);
			it.getUpdateB().setOnAction(e -> {

			    Invoice selected = it.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select an invoice first!");
			        a.showAndWait();
			        return;
			    }

			    uiv.getIdT().setText(selected.getInvoiceID() + "");

			    if(selected.getInvoiceDate() == null) {
			    	uiv.getDateT().setText("");
			    } else {
			    	selected.getInvoiceDate().toString();
			    }
			    if(selected.getInvoiceTime() == null) {
			    	uiv.getTimeT().setText("");
			    }else {
			    	selected.getInvoiceTime().toString();
			    }

			    uiv.getSubT().setText(selected.getSubtotal() + "");
			    uiv.getDisT().setText(selected.getDiscount() + "");
			    uiv.getTaxT().setText(selected.getTax() + "");
			    uiv.getTotalT().setText(selected.getTotalAmount() + "");

			    uiv.getPayT().setText(selected.getPaymentStatus());

			    uiv.getCidT().setText(selected.getCustomerID() + "");
			    uiv.getEidT().setText(selected.getEmpID() + "");
			    uiv.getBidT().setText(selected.getBranchID() + "");

			    uiv.getEdit().setDisable(false);

			    primaryStage.setScene(uivscene);
			});

			Scene itscene = new Scene(it.getAll(),400,400);

			mb.getIt().setOnAction(e -> {
			    it.getTable().setItems(loadAllInvoices());
			    primaryStage.setScene(itscene);
			});

			mb.getAiv().setOnAction(e->{
				primaryStage.setScene(aivscene);
			});
			mb.getDiv().setOnAction(e->{
				primaryStage.setScene(divscene);
			});
			mb.getUiv().setOnAction(e->{
				primaryStage.setScene(uivscene);
			});
			mb.getIt().setOnAction(e->{
				primaryStage.setScene(itscene);
			});

			
			
			
			
		 //AddInvoiceItem aivi=new AddInvoiceItem();
			AddInvoiceItem aii = new AddInvoiceItem();

			aii.getAdd().setOnAction(e -> {

			    // 1️⃣ فحص الحقول الفارغة
			    if (
			        aii.getInvT().getText().trim().isEmpty() ||
			        aii.getInvTT().getText().trim().isEmpty() ||
			        aii.getQuanT().getText().trim().isEmpty() ||
			        aii.getUpriT().getText().trim().isEmpty()
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    try {
			        // 2️⃣ قراءة القيم
			        int invoiceId   = Integer.parseInt(aii.getInvT().getText().trim());
			        int inventoryId = Integer.parseInt(aii.getInvTT().getText().trim());
			        int quantity    = Integer.parseInt(aii.getQuanT().getText().trim());
			        double unitPrice = Double.parseDouble(aii.getUpriT().getText().trim());

			        // 3️⃣ حساب Line Total
			        double lineTotal = quantity * unitPrice;

			        // 4️⃣ SQL
			        String sql = """
			            INSERT INTO invoice_item
			            (invoiceid, inventoryid, quantity, unitprice, linetotal)
			            VALUES (?, ?, ?, ?, ?)
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, invoiceId);
			            ps.setInt(2, inventoryId);
			            ps.setInt(3, quantity);
			            ps.setDouble(4, unitPrice);
			            ps.setDouble(5, lineTotal);

			            ps.executeUpdate();

			            Alert ok = new Alert(Alert.AlertType.INFORMATION);
			            ok.setTitle("Done");
			            ok.setContentText("Invoice Item added successfully");
			            ok.showAndWait();

			            // 5️⃣ تفريغ الحقول
			            aii.clearFields();
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("Quantity and prices must be numeric values");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			DeleteInvoiceItem divi=new DeleteInvoiceItem();
			divi.getDelete().setOnAction(e -> {

			    // 1️⃣ فحص القيم الأساسية (Invoice ID + Inventory ID)
			    if (
			        divi.getInvT().getText().trim().isEmpty() ||
			        divi.getInvTT().getText().trim().isEmpty()
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Invoice ID and Inventory ID are required");
			        a.showAndWait();
			        return;
			    }

			    try {
			        int invoiceId   = Integer.parseInt(divi.getInvT().getText().trim());
			        int inventoryId = Integer.parseInt(divi.getInvTT().getText().trim());

			        // 2️⃣ تأكيد الحذف
			        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			        confirm.setTitle("Confirm Delete");
			        confirm.setContentText(
			            "Delete this invoice item?\n" +
			            "Invoice ID: " + invoiceId + "\n" +
			            "Inventory ID: " + inventoryId
			        );

			        if (confirm.showAndWait().get() != ButtonType.OK)
			            return;

			        
			        String sql = """
			            DELETE FROM invoice_item
			            WHERE invoiceid = ? AND inventoryitemid = ?
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, invoiceId);
			            ps.setInt(2, inventoryId);

			            int rows = ps.executeUpdate();

			            if (rows > 0) {
			                Alert ok = new Alert(Alert.AlertType.INFORMATION);
			                ok.setTitle("Done");
			                ok.setContentText("Invoice item deleted successfully");
			                ok.showAndWait();

			                // 4️⃣ تفريغ الحقول
			                divi.getInvT().clear();
			                divi.getInvTT().clear();
			                divi.getQuanT().clear();
			                divi.getUpriT().clear();
			                divi.getLineTotT().clear();

			            } else {
			                Alert a = new Alert(Alert.AlertType.ERROR);
			                a.setTitle("Not Found");
			                a.setContentText("No invoice item found with these IDs");
			                a.showAndWait();
			            }
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("IDs must be numeric values");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			UpdateInvoiceItem uivi=new UpdateInvoiceItem();
			uivi.getEdit().setOnAction(e -> {

			    if (
			        uivi.getInvT().getText().trim().isEmpty() ||
			        uivi.getInvTT().getText().trim().isEmpty() ||
			        uivi.getQuanT().getText().trim().isEmpty() ||
			        uivi.getUpriT().getText().trim().isEmpty()
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    try {
			        int invoiceId   = Integer.parseInt(uivi.getInvT().getText().trim());
			        int inventoryId = Integer.parseInt(uivi.getInvTT().getText().trim());
			        int quantity    = Integer.parseInt(uivi.getQuanT().getText().trim());
			        double unitPrice = Double.parseDouble(uivi.getUpriT().getText().trim());

			        double lineTotal = quantity * unitPrice;

			        String sql = """
			            UPDATE invoice_item
			            SET quantity = ?, unitprice = ?, linetotal = ?
			            WHERE invoiceid = ? AND inventoryitemid = ?
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, quantity);
			            ps.setDouble(2, unitPrice);
			            ps.setDouble(3, lineTotal);
			            ps.setInt(4, invoiceId);
			            ps.setInt(5, inventoryId);

			            int rows = ps.executeUpdate();

			            if (rows > 0) {
			                Alert ok = new Alert(Alert.AlertType.INFORMATION);
			                ok.setTitle("Done");
			                ok.setContentText("Invoice item updated successfully");
			                ok.showAndWait();

			                uivi.clearFields();
			            } else {
			                Alert a = new Alert(Alert.AlertType.ERROR);
			                a.setTitle("Not Found");
			                a.setContentText("Invoice item not found");
			                a.showAndWait();
			            }
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("Quantity and Unit Price must be numbers");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});


		InvoiceItemTableView iit=new InvoiceItemTableView();

			Scene aiviscene = new Scene(aii.getAll(),400,400);
			Scene diviscene = new Scene(divi.getAll(),400,400);
			Scene uiviscene = new Scene(uivi.getAll(),400,400);
			Scene iitscene = new Scene(iit.getAll(),400,400);

			

			mb.getAivi().setOnAction(e->{
				primaryStage.setScene(aiviscene);
			});
			mb.getDivi().setOnAction(e->{
				primaryStage.setScene(diviscene);
			});
			mb.getUivi().setOnAction(e->{
				primaryStage.setScene(uiviscene);
			});
		mb.getIit().setOnAction(e->{
			primaryStage.setScene(iitscene);
			});
			
			AddIP aip=new AddIP();
			aip.getAdd().setOnAction(e -> {

			    // 1️⃣ فحص الحقول
			    if (
			        aip.getpIDT().getText().trim().isEmpty() ||
			        aip.getpNT().getText().trim().isEmpty() ||
			        aip.getIssueDT().getValue() == null ||
			        aip.getExpiryDT().getValue() == null ||
			        aip.getCpT().getText().trim().isEmpty() ||
			        aip.getCustIDT().getText().trim().isEmpty() ||
			        aip.getIcT().getText().trim().isEmpty()
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    try {
			        // 2️⃣ قراءة القيم
			        int policyId = Integer.parseInt(aip.getpIDT().getText().trim());
			        String policyNumber = aip.getpNT().getText().trim();

			        int coverage = Integer.parseInt(aip.getCpT().getText().trim());
			        int customerId = Integer.parseInt(aip.getCustIDT().getText().trim());
			        int companyId  = Integer.parseInt(aip.getIcT().getText().trim());

			        // 3️⃣ SQL
			        String sql = """
			            INSERT INTO insurance_policy
			            (policyid, policynumber, issuedate, expirydate,
			             coveragepercentage, customerid, insurancecompanyid)
			            VALUES (?, ?, ?, ?, ?, ?, ?)
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, policyId);
			            ps.setString(2, policyNumber);
			            ps.setDate(3, java.sql.Date.valueOf(aip.getIssueDT().getValue()));
			            ps.setDate(4, java.sql.Date.valueOf(aip.getExpiryDT().getValue()));
			            ps.setInt(5, coverage);
			            ps.setInt(6, customerId);
			            ps.setInt(7, companyId);

			            ps.executeUpdate();

			            Alert ok = new Alert(Alert.AlertType.INFORMATION);
			            ok.setTitle("Done");
			            ok.setContentText("Insurance policy added successfully");
			            ok.showAndWait();

			            // 4️⃣ تفريغ الحقول
			            aip.getpIDT().clear();
			            aip.getpNT().clear();
			            aip.getCpT().clear();
			            aip.getCustIDT().clear();
			            aip.getIcT().clear();
			            aip.getIssueDT().setValue(null);
			            aip.getExpiryDT().setValue(null);
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("IDs and Coverage must be numeric values");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			aip.getClear().setOnAction(e -> {
			    aip.getpIDT().clear();
			    aip.getpNT().clear();
			    aip.getCpT().clear();
			    aip.getCustIDT().clear();
			    aip.getIcT().clear();
			    aip.getIssueDT().setValue(null);
			    aip.getExpiryDT().setValue(null);
			});

			DeleteIP dip=new DeleteIP();
			
		dip.getDelete().setOnAction(e -> {

			    // 1️⃣ فحص Policy ID
			    if (dip.getpIDT().getText().trim().isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please enter Policy ID");
			        a.showAndWait();
			        return;
			    }

			    try {
			        int policyId = Integer.parseInt(dip.getpIDT().getText().trim());

			        // 2️⃣ تأكيد الحذف
			        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			        confirm.setTitle("Confirm Delete");
			        confirm.setContentText("Delete this insurance policy?");
			        if (confirm.showAndWait().get() != ButtonType.OK)
			            return;

			        // 3️⃣ SQL الحذف
			        String sql = "DELETE FROM insurance_policy WHERE policyid = ?";

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, policyId);

			            int rows = ps.executeUpdate();

			            if (rows > 0) {
			                Alert ok = new Alert(Alert.AlertType.INFORMATION);
			                ok.setTitle("Done");
			                ok.setContentText("Insurance policy deleted successfully");
			                ok.showAndWait();

			                dip.getpIDT().clear();

			            } else {
			                Alert a = new Alert(Alert.AlertType.ERROR);
			                a.setTitle("Not Found");
			                a.setContentText("No policy found with this ID");
			                a.showAndWait();
			            }
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("Policy ID must be a number");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
		dip.getClear().setOnAction(e -> {
		    dip.getpIDT().clear();
		});

			UpdateIP uip=new UpdateIP();
			

			uip.getEdit().setOnAction(e -> {

			    // 1️⃣ فحص الحقول المطلوبة
			    if (
			        uip.getpIDT().getText().trim().isEmpty() ||
			        uip.getpNT().getText().trim().isEmpty() ||
			        uip.getCpT().getText().trim().isEmpty() ||
			        uip.getCustIDT().getText().trim().isEmpty() ||
			        uip.getIcT().getText().trim().isEmpty() ||
			        uip.getIssueDT().getValue() == null ||
			        uip.getExpiryDT().getValue() == null
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    try {
			        int policyId = Integer.parseInt(uip.getpIDT().getText().trim());
			        int coverage = Integer.parseInt(uip.getCpT().getText().trim());
			        int customerId = Integer.parseInt(uip.getCustIDT().getText().trim());
			        int insuranceCompanyId = Integer.parseInt(uip.getIcT().getText().trim());

			        // 2️⃣ SQL UPDATE
			        String sql = """
			            UPDATE insurance_policy
			            SET policynumber = ?,
			                issuedate = ?,
			                expirydate = ?,
			                coveragepercentage = ?,
			                customerid = ?,
			                insurancecompanyid = ?
			            WHERE policyid = ?
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setString(1, uip.getpNT().getText().trim());
			            ps.setDate(2, java.sql.Date.valueOf(uip.getIssueDT().getValue()));
			            ps.setDate(3, java.sql.Date.valueOf(uip.getExpiryDT().getValue()));
			            ps.setInt(4, coverage);
			            ps.setInt(5, customerId);
			            ps.setInt(6, insuranceCompanyId);
			            ps.setInt(7, policyId);

			            int rows = ps.executeUpdate();

			            if (rows > 0) {
			                Alert ok = new Alert(Alert.AlertType.INFORMATION);
			                ok.setTitle("Updated");
			                ok.setContentText("Insurance policy updated successfully");
			                ok.showAndWait();
			            } else {
			                Alert a = new Alert(Alert.AlertType.ERROR);
			                a.setTitle("Not Found");
			                a.setContentText("No policy found with this ID");
			                a.showAndWait();
			            }
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("Numeric fields must contain numbers only");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			uip.getClear().setOnAction(e -> {
			    uip.getpNT().clear();
			    uip.getCpT().clear();
			    uip.getCustIDT().clear();
			    uip.getIcT().clear();
			    uip.getIssueDT().setValue(null);
			    uip.getExpiryDT().setValue(null);
			});

			InsurancePolicyTableView ipt=new InsurancePolicyTableView();

			ipt.getTable().setOnMouseClicked(e -> {

			    InsurancePolicy selected =
			    		ipt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) return;

			    uip.getpIDT().setText(String.valueOf(selected.getPolicyID()));
			    uip.getpNT().setText(selected.getPolicyNumber());
			    uip.getIssueDT().setValue(selected.getIssueDate());
			    uip.getExpiryDT().setValue(selected.getExpiryDate());
			    uip.getCpT().setText(String.valueOf(selected.getCoveragePercentage()));
			    uip.getCustIDT().setText(String.valueOf(selected.getCustomerID()));
			    uip.getIcT().setText(String.valueOf(selected.getInsuranceCompanyID()));
			});

			Scene aipscene = new Scene(aip.getAll(),400,400);
			Scene dipscene = new Scene(dip.getAll(),400,400);
			Scene uipscene = new Scene(uip.getAll(),400,400);
			Scene iptscene = new Scene(ipt.getAll(),400,400);

			mb.getAip().setOnAction(e->{
				primaryStage.setScene(aipscene);
			});
			mb.getDip().setOnAction(e->{
				primaryStage.setScene(dipscene);
			});
			mb.getUip().setOnAction(e->{
				primaryStage.setScene(uipscene);
			});
			mb.getIpt().setOnAction(e->{
				primaryStage.setScene(iptscene);
			});
			
			AddMedicine amed=new AddMedicine();
		
			amed.getAdd().setOnAction(e -> {

			    if (
			        amed.getmIDT().getText().trim().isEmpty() ||
			        amed.getmNT().getText().trim().isEmpty() ||
			        amed.getStrT().getText().trim().isEmpty() ||
			        amed.getCatIDT().getText().trim().isEmpty()
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing data");
			        a.setContentText("Fill all required fields");
			        a.showAndWait();
			        return;
			    }

			    try {
			        int id = Integer.parseInt(amed.getmIDT().getText().trim());
			        int catId = Integer.parseInt(amed.getCatIDT().getText().trim());

			        // تحويل النص إلى boolean
			        boolean requiresPre =
			                amed.getReqT().getText().trim().equalsIgnoreCase("yes") ||
			                amed.getReqT().getText().trim().equalsIgnoreCase("true");

			        String sql = """
			            INSERT INTO medicine
			            (medicineid, medicinename, strength, requirespre, description, categoryid)
			            VALUES (?, ?, ?, ?, ?, ?)
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, id);
			            ps.setString(2, amed.getmNT().getText().trim());
			            ps.setString(3, amed.getStrT().getText().trim());
			            ps.setBoolean(4, requiresPre);
			            ps.setString(5, amed.getDescT().getText().trim());
			            ps.setInt(6, catId);

			            ps.executeUpdate();

			            Alert ok = new Alert(Alert.AlertType.INFORMATION);
			            ok.setTitle("Done");
			            ok.setContentText("Medicine added successfully");
			            ok.showAndWait();

			            amed.getmIDT().clear();
			            amed.getmNT().clear();
			            amed.getStrT().clear();
			            amed.getReqT().clear();
			            amed.getDescT().clear();
			            amed.getCatIDT().clear();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			DeleteMedicine dmed=new DeleteMedicine();
			

			
			UpdateMedicine umed=new UpdateMedicine();
			
			MedicineTableView mt=new MedicineTableView();
			StoredMedicinesTable smt = new StoredMedicinesTable();
			MedicinesList meds = new MedicinesList();
			Scene medsScene = new Scene(meds.getAll(), 400, 400);
			
			meds.addMedicine("M001", "Paracetamol");
			meds.addMedicine("M002", "Amoxicillin");
			Scene smtscene = new Scene(smt.getAll(), 400, 400);

			// بيانات تجريبية
			smt.addMedicine("M01", "Paracetamol", "Painkiller", 2.5);
			smt.addMedicine("M02", "Amoxicillin", "Antibiotic", 4.0);

			
			
			MedicinesDetailsList medsDetails = new MedicinesDetailsList();
			Scene medsDetailsScene = new Scene(medsDetails.getAll(), 700, 450);
			medsDetails.addMedicine(
			        "M001",
			        "Paracetamol",
			        "Painkillers",
			        "ABC Supplier",
			        "2026-03-15"
			);

			medsDetails.addMedicine(
			        "M002",
			        "Amoxicillin",
			        "Antibiotics",
			        "Health Pharma",
			        "2025-11-01"
			);

			MedicinesExpiryList medsExpiry =
			        new MedicinesExpiryList();

			Scene medsExpiryScene =
			        new Scene(medsExpiry.getAll(), 700, 450);

			mb.getQ10().setOnAction(e -> {
			    primaryStage.setScene(medsExpiryScene);
			});

			

			MedicinesLowStockTableView medsLowStock =
			        new MedicinesLowStockTableView();

			Scene medsLowStockScene =
			        new Scene(medsLowStock.getAll(), 700, 450);

			mb.getQ11().setOnAction(e -> {
			    primaryStage.setScene(medsLowStockScene);
			});

			MedicinesSuppliedBySupplierTableView medsBySupplier =
			        new MedicinesSuppliedBySupplierTableView();

			Scene medsBySupplierScene =
			        new Scene(medsBySupplier.getAll(), 750, 450);

			mb.getQ22().setOnAction(e -> {
			    primaryStage.setScene(medsBySupplierScene);
			});

			
			SupplierSummaryList supplierSummary =
			        new SupplierSummaryList();

			Scene supplierSummaryScene =
			        new Scene(supplierSummary.getAll(), 700, 450);

			// بيانات تجريبية
			supplierSummary.addSupplierSummary(
			        "ABC Supplier",
			        "12",
			        "15400"
			);

			supplierSummary.addSupplierSummary(
			        "Health Pharma",
			        "8",
			        "9200"
			);
			MedicinesByCategoryList medsByCategory =
			        new MedicinesByCategoryList();

			Scene medsByCategoryScene =
			        new Scene(medsByCategory.getAll(), 700, 450);

			// بيانات تجريبية
			medsByCategory.addMedicine(
			        "Antibiotics",
			        "M050",
			        "Amoxicillin"
			);

			medsByCategory.addMedicine(
			        "Painkillers",
			        "M051",
			        "Paracetamol"
			);
			MedicinesSalesList medsSales =
			        new MedicinesSalesList();

			Scene medsSalesScene =
			        new Scene(medsSales.getAll(), 700, 450);

			// بيانات تجريبية
			medsSales.addMedicine(
			        "M100",
			        "Paracetamol",
			        "5",
			        "320"
			);

			medsSales.addMedicine(
			        "M101",
			        "Amoxicillin",
			        "3",
			        "210"
			);
			MedicinesDamagedWithdrawnList medsDamaged =
			        new MedicinesDamagedWithdrawnList();

			Scene medsDamagedScene =
			        new Scene(medsDamaged.getAll(), 750, 450);

			// بيانات تجريبية
			medsDamaged.addMedicine(
			        "Main Branch",
			        "M200",
			        "Insulin",
			        "DAMAGED",
			        "4"
			);

			medsDamaged.addMedicine(
			        "East Branch",
			        "M201",
			        "Expired Syrup",
			        "WITHDRAWN",
			        "10"
			);
			MedicinesLossesList medsLosses =
			        new MedicinesLossesList();

			Scene medsLossesScene =
			        new Scene(medsLosses.getAll(), 850, 450);

			// بيانات تجريبية
			medsLosses.addLoss(
			        "Main Branch",
			        "M300",
			        "Expired Insulin",
			        "EXPIRED",
			        "5",
			        "12.5",
			        "62.5"
			);

			medsLosses.addLoss(
			        "East Branch",
			        "M301",
			        "Damaged Syrup",
			        "DAMAGED",
			        "3",
			        "8",
			        "24"
			);
			Scene amedscene = new Scene(amed.getAll(),400,400);
			Scene dmedscene = new Scene(dmed.getAll(),400,400);
			Scene umedscene = new Scene(umed.getAll(),400,400);
			Scene mtscene = new Scene(mt.getAll(),400,400);

			

			mb.getMt().setOnAction(e -> {
			    primaryStage.setScene(smtscene);
			});

			
			mb.getQ4().setOnAction(e -> {
			    MedicineQ4TableView view = new MedicineQ4TableView();
			    root.setCenter(view.getAll());

			    view.getBack().setOnAction(ev -> root.setCenter(null));
			});

		mb.getMt().setOnAction(e -> {   // أو MenuItem جديد: mb.getAllStoredMedicines()
			    primaryStage.setScene(medsScene);
			});
			mb.getAmed().setOnAction(e->{
				primaryStage.setScene(amedscene);
			});
			mb.getDmed().setOnAction(e->{
				primaryStage.setScene(dmedscene);
			});
			mb.getUmed().setOnAction(e->{
				primaryStage.setScene(umedscene);
			});
			mb.getMt().setOnAction(e->{
				primaryStage.setScene(mtscene);
			});

<<<<<<< HEAD
=======
			mb.getQ4().setOnAction(e -> primaryStage.setScene(medsScene));
			mb.getQ9().setOnAction(e -> primaryStage.setScene(medsDetailsScene));
			mb.getQ10().setOnAction(e -> primaryStage.setScene(medsExpiryScene));
			mb.getQ11().setOnAction(e -> primaryStage.setScene(medsLowStockScene));
			mb.getQ12().setOnAction(e -> primaryStage.setScene(medsBySupplierScene));
			mb.getQ13().setOnAction(e -> primaryStage.setScene(supplierSummaryScene));
			mb.getQ14().setOnAction(e -> primaryStage.setScene(medsByCategoryScene));
			mb.getQ16().setOnAction(e -> primaryStage.setScene(medsSalesScene ));
			mb.getQ24().setOnAction(e -> primaryStage.setScene(medsDamagedScene));
			mb.getQ25().setOnAction(e -> primaryStage.setScene(medsLossesScene));
>>>>>>> 9cf8d1f78b1783cbad79699a9fcae2157130e413
			
			AddPayment apay = new AddPayment();

			apay.getClear().setOnAction(e -> {
			    apay.getIdT().clear();
			    apay.getDateT().setText(null);  
			    apay.getTypeT().clear();
			    apay.getAmountT().clear();
			    apay.getRefT().clear();
			    apay.getInvT().clear();
			    apay.getPolT().clear();
			});

			apay.getAdd().setOnAction(e -> {

			    if (apay.getIdT().getText().trim().isEmpty()
			            || apay.getDateT().getText() == null
			            || apay.getTypeT().getText().trim().isEmpty()
			            || apay.getAmountT().getText().trim().isEmpty()
			            || apay.getInvT().getText().trim().isEmpty()) {

			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setHeaderText(null);
			        a.setContentText("Please fill all required fields ❌");
			        a.showAndWait();
			        return;
			    }

			    int pid, invoiceId;
			    double amount;
			    java.sql.Date date;
			    String type, ref;
			    Integer policyId = null;

			    try {
			        pid = Integer.parseInt(apay.getIdT().getText().trim());
			        invoiceId = Integer.parseInt(apay.getInvT().getText().trim());
			        amount = Double.parseDouble(apay.getAmountT().getText().trim());

			        date = java.sql.Date.valueOf(apay.getDateT().getText());
			        type = apay.getTypeT().getText().trim();
			        ref = apay.getRefT().getText().trim();

			        if (!apay.getPolT().getText().trim().isEmpty()) {
			            policyId = Integer.parseInt(apay.getPolT().getText().trim());
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setHeaderText(null);
			        a.setContentText("Check IDs/Amount inputs ❌");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            insert into payment (paymentid, paymentdate, paymenttype, amount, referencenumber, invoiceid, policyid)
			            values (?, ?, ?, ?, ?, ?, ?)
			            """;

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, pid);
			        ps.setDate(2, date);
			        ps.setString(3, type);
			        ps.setDouble(4, amount);

			        if (ref.isEmpty()) ps.setNull(5, java.sql.Types.VARCHAR);
			        else ps.setString(5, ref);

			        ps.setInt(6, invoiceId);

			        if (policyId == null) ps.setNull(7, java.sql.Types.INTEGER);
			        else ps.setInt(7, policyId);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setHeaderText(null);
			            a.setContentText("Payment added successfully");
			            a.showAndWait();
			            apay.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setHeaderText(null);
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			DeletePayment dpay = new DeletePayment();

			dpay.getClear().setOnAction(e -> {
			    dpay.getSearchT().clear();
			    dpay.getIdT().clear();
			    dpay.getDateT().clear();
			    dpay.getTypeT().clear();
			    dpay.getAmountT().clear();
			    dpay.getRefT().clear();
			    dpay.getInvT().clear();
			    dpay.getPolT().clear();
			    dpay.getDelete().setDisable(true);
			});

			dpay.getSearchB().setOnAction(e -> {

			    if (dpay.getSearchT().getText().trim().isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setHeaderText(null);
			        a.setContentText("Please enter Payment ID.");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(dpay.getSearchT().getText().trim());
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setHeaderText(null);
			        a.setContentText("Payment ID must be integer ❌");
			        a.showAndWait();
			        return;
			    }

			    String sql = "select * from payment where paymentid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dpay.getIdT().setText(rs.getInt("paymentid") + "");
			            dpay.getDateT().setText(rs.getDate("paymentdate") + "");
			            dpay.getTypeT().setText(rs.getString("paymenttype"));
			            dpay.getAmountT().setText(rs.getDouble("amount") + "");
			            dpay.getRefT().setText(rs.getString("referencenumber"));
			            dpay.getInvT().setText(rs.getInt("invoiceid") + "");

			            int pol = rs.getInt("policyid");
			            if (rs.wasNull()) dpay.getPolT().setText("");
			            else dpay.getPolT().setText(pol + "");

			            dpay.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText(null);
			            a.setContentText("No payment with ID = " + id);
			            a.showAndWait();
			            dpay.getDelete().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			dpay.getDelete().setOnAction(e -> {

			    if (dpay.getIdT().getText().trim().isEmpty()) return;

			    int id = Integer.parseInt(dpay.getIdT().getText().trim());

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm Delete");
			    confirm.setHeaderText("Are you sure?");
			    confirm.setContentText("Delete Payment ID: " + id);

			    if (confirm.showAndWait().get() != ButtonType.OK) return;

			    String sql = "delete from payment where paymentid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setHeaderText(null);
			            a.setContentText("Payment deleted successfully");
			            a.showAndWait();
			            dpay.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setHeaderText(null);
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			UpdatePayment upay = new UpdatePayment();

			upay.getClear().setOnAction(e -> {
			    upay.getSearchT().clear();
			    upay.getIdT().clear();
			    upay.getDateT().setText(null);
			    upay.getTypeT().clear();
			    upay.getAmountT().clear();
			    upay.getRefT().clear();
			    upay.getInvT().clear();
			    upay.getPolT().clear();
			    upay.getEdit().setDisable(true);
			});

			upay.getSearchB().setOnAction(e -> {

			    if (upay.getSearchT().getText().trim().isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setHeaderText(null);
			        a.setContentText("Please enter Payment ID.");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(upay.getSearchT().getText().trim()); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setHeaderText(null);
			        a.setContentText("Payment ID must be integer ❌");
			        a.showAndWait();
			        return;
			    }

			    String sql = "select * from payment where paymentid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            upay.getIdT().setText(rs.getInt("paymentid") + "");
			            java.sql.Date d = rs.getDate("paymentdate");
			            if (d != null) {
			            	upay.getDateT().setText(d.toLocalDate()+"");
			            }

			            upay.getTypeT().setText(rs.getString("paymenttype"));
			            upay.getAmountT().setText(rs.getDouble("amount") + "");
			            upay.getRefT().setText(rs.getString("referencenumber"));
			            upay.getInvT().setText(rs.getInt("invoiceid") + "");

			            int pol = rs.getInt("policyid");
			            if (rs.wasNull()) upay.getPolT().setText("");
			            else upay.getPolT().setText(pol + "");

			            upay.getEdit().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText(null);
			            a.setContentText("No payment with ID = " + id);
			            a.showAndWait();
			            upay.getEdit().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setHeaderText(null);
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			upay.getEdit().setOnAction(e -> {

			    if (upay.getIdT().getText().trim().isEmpty()) {
			    	return;
			    }

			    int pid, invoiceId;
			    double amount;
			    java.sql.Date date;
			    String type, ref;
			    Integer policyId = null;

			    try {
			        pid = Integer.parseInt(upay.getIdT().getText().trim());
			        invoiceId = Integer.parseInt(upay.getInvT().getText().trim());
			        amount = Double.parseDouble(upay.getAmountT().getText().trim());

			        date = java.sql.Date.valueOf(upay.getDateT().getText());
			        type = upay.getTypeT().getText().trim();
			        ref = upay.getRefT().getText().trim();

			        if (!upay.getPolT().getText().trim().isEmpty())
			            policyId = Integer.parseInt(upay.getPolT().getText().trim());

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid input");
			        a.setHeaderText(null);
			        a.setContentText("Check values again");
			        a.showAndWait();
			        return;
			    }
			    String sql = """
			            update payment
			            set paymentdate=?, paymenttype=?, amount=?, referencenumber=?, invoiceid=?, policyid=?
			            where paymentid=?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setDate(1, date);
			        ps.setString(2, type);
			        ps.setDouble(3, amount);

			        if (ref.isEmpty()) ps.setNull(4, java.sql.Types.VARCHAR);
			        else ps.setString(4, ref);

			        ps.setInt(5, invoiceId);

			        if (policyId == null) ps.setNull(6, java.sql.Types.INTEGER);
			        else ps.setInt(6, policyId);

			        ps.setInt(7, pid);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setHeaderText(null);
			            a.setContentText("Payment updated successfully");
			            a.showAndWait();
			            upay.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setHeaderText(null);
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			PaymentTableView payt = new PaymentTableView();
			Scene upayscene = new Scene(upay.getAll(),400,400);

			payt.getRef().setOnAction(e -> {
			    payt.getSearchT().clear();
			    payt.getTable().setItems(loadAllPayments());
			    payt.getTable().getSelectionModel().clearSelection();
			});

			payt.getSearchB().setOnAction(e -> {

			    String idT = payt.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        payt.getTable().setItems(loadAllPayments());
			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("All Payments");
			        a.setContentText("All payments loaded");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(idT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Payment ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    ObservableList<Payment> result = searchPaymentById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Not found");
			        a.setContentText("No payment with this ID");
			        a.showAndWait();
			        payt.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    payt.getTable().setItems(result);
			});

			payt.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
			    if (newV != null) {
			        payt.getDeleteB().setDisable(false);
			        payt.getUpdateB().setDisable(false);
			    } else {
			        payt.getDeleteB().setDisable(true);
			        payt.getUpdateB().setDisable(true);
			    }
			});

			payt.getDeleteB().setOnAction(e -> {

			    Payment selected = payt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a payment first!");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm delete");
			    confirm.setContentText("Delete this payment?");
			    confirm.showAndWait();

			    if (confirm.getResult() != ButtonType.OK) return;

			    String sql = "delete from payment where paymentid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getPaymentID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Deleted");
			            a.setContentText("Payment deleted successfully!");
			            a.showAndWait();
			        }

			        payt.getTable().setItems(loadAllPayments());
			        payt.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			payt.getUpdateB().setOnAction(e -> {

			    Payment selected = payt.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a payment first!");
			        a.showAndWait();
			        return;
			    }

			    upay.getIdT().setText(selected.getPaymentID() + "");
			    if (selected.getPaymentDate() != null) {
			        upay.getDateT().setText(selected.getPaymentDate()+"");
			    }
			    upay.getTypeT().setText(selected.getPaymentType());
			    upay.getAmountT().setText(selected.getAmount() + "");
			    upay.getRefT().setText(selected.getReferenceNumber());
			    upay.getInvT().setText(selected.getInvoiceID() + "");
			    if(String.valueOf(selected.getPolicyID()+"").isEmpty()) {
			    	upay.getPolT().setText("");
			    }else {
			    	upay.getPolT().setText(selected.getPolicyID() + "");
			    } 

			    upay.getEdit().setDisable(false);

			    primaryStage.setScene(upayscene);
			});

			Scene apayscene = new Scene(apay.getAll(),400,400);
			Scene dpayscene = new Scene(dpay.getAll(),400,400);
			Scene paytscene = new Scene(payt.getAll(),400,400);

			mb.getApay().setOnAction(e->{
				primaryStage.setScene(apayscene);
			});
			mb.getDpay().setOnAction(e->{
				primaryStage.setScene(dpayscene);
			});
			mb.getUpay().setOnAction(e->{
				primaryStage.setScene(upayscene);
			});
			mb.getPayt().setOnAction(e->{
				primaryStage.setScene(paytscene);
			});
			
			
			AddPre aper=new AddPre();
			aper.getClear().setOnAction(e -> {
			    aper.getIdT().clear();
			    aper.getDateT().setText(null);
			    aper.getNotesT().clear();
			    aper.getDocT().clear();
			    aper.getInvT().clear();
			});

			aper.getAdd().setOnAction(e -> {

			    String idT = aper.getIdT().getText().trim();
			    String notes = aper.getNotesT().getText().trim();
			    String docT = aper.getDocT().getText().trim();
			    String invT = aper.getInvT().getText().trim();

			    if (idT.isEmpty() || aper.getDateT().getText() == null || docT.isEmpty() || invT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all required fields");
			        a.showAndWait();
			        return;
			    }

			    int id, docID, invID;
			    try {
			        id = Integer.parseInt(idT);
			        docID = Integer.parseInt(docT);
			        invID = Integer.parseInt(invT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("IDs must be integers");
			        a.showAndWait();
			        return;
			    }

			    java.sql.Date issueDate = java.sql.Date.valueOf(aper.getDateT().getText());
			    String sql = """
			            insert into prescription (prescriptionid, issuedate, notes, doctorid, invoiceid)
			            values (?, ?, ?, ?, ?)
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ps.setDate(2, issueDate);
			        ps.setString(3, notes.isEmpty() ? null : notes);
			        ps.setInt(4, docID);
			        ps.setInt(5, invID);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Prescription inserted successfully!");
			            a.showAndWait();

			            aper.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			DeletePre dper=new DeletePre();
			dper.getClear().setOnAction(e -> {
			    dper.getSearchT().clear();
			    dper.getIdT().clear();
			    dper.getDateT().clear();
			    dper.getNotesT().clear();
			    dper.getDocT().clear();
			    dper.getInvT().clear();
			    dper.getDelete().setDisable(true);
			});

			dper.getSearchB().setOnAction(e -> {

			    String searchT = dper.getSearchT().getText().trim();
			    if (searchT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setContentText("Please enter Prescription ID");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try {
			        id = Integer.parseInt(searchT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Prescription ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select prescriptionid, issuedate, notes, doctorid, invoiceid
			            from prescription
			            where prescriptionid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dper.getIdT().setText(rs.getInt("prescriptionid") + "");
			            dper.getDateT().setText(rs.getDate("issuedate") + "");
			            dper.getNotesT().setText(rs.getString("notes"));
			            dper.getDocT().setText(rs.getInt("doctorid") + "");
			            dper.getInvT().setText(rs.getInt("invoiceid") + "");

			            dper.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No Prescription with ID = " + id);
			            a.showAndWait();
			            dper.getDelete().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			dper.getDelete().setOnAction(e -> {

			    if (dper.getIdT().getText().trim().isEmpty()) {
			    	return;
			    }

			    int id = Integer.parseInt(dper.getIdT().getText().trim());

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm Delete");
			    confirm.setHeaderText("Are you sure?");
			    confirm.setContentText("Delete Prescription ID: " + id);

			    if (confirm.showAndWait().get() != ButtonType.OK) return;

			    String sql = "delete from prescription where prescriptionid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);

			        int rows = ps.executeUpdate();
			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Prescription deleted successfully!");
			            a.showAndWait();

			            dper.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			UpdatePre uper=new UpdatePre();
			uper.getClear().setOnAction(e -> {
			    uper.getSearchT().clear();
			    uper.getIdT().clear();
			    uper.getDateT().setText(null);
			    uper.getNotesT().clear();
			    uper.getDocT().clear();
			    uper.getInvT().clear();
			    uper.getEdit().setDisable(true);
			});

			uper.getSearchB().setOnAction(e -> {

			    String searchT = uper.getSearchT().getText().trim();
			    if (searchT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setContentText("Enter Prescription ID");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(searchT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Prescription ID must be integer");
			        a.showAndWait();
			        return;
			    }
			    String sql = """
			            select prescriptionid, issuedate, notes, doctorid, invoiceid
			            from prescription
			            where prescriptionid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            uper.getIdT().setText(rs.getInt("prescriptionid") + "");

			            java.sql.Date d = rs.getDate("issuedate");
			            if (d != null) {
			            	uper.getDateT().setText(d.toLocalDate()+"");
			            }

			            uper.getNotesT().setText(rs.getString("notes"));
			            uper.getDocT().setText(rs.getInt("doctorid") + "");
			            uper.getInvT().setText(rs.getInt("invoiceid") + "");

			            uper.getEdit().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No Prescription with ID = " + id);
			            a.showAndWait();
			            uper.getEdit().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			uper.getEdit().setOnAction(e -> {

			    if (uper.getIdT().getText().trim().isEmpty()) {
			    	return;
			    }

			    int id, docID, invID;
			    try {
			        id = Integer.parseInt(uper.getIdT().getText().trim());
			        docID = Integer.parseInt(uper.getDocT().getText().trim());
			        invID = Integer.parseInt(uper.getInvT().getText().trim());
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("IDs must be integers");
			        a.showAndWait();
			        return;
			    }

			    if (uper.getDateT().getText() == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Date");
			        a.setContentText("Issue Date is required");
			        a.showAndWait();
			        return;
			    }

			    java.sql.Date issueDate = java.sql.Date.valueOf(uper.getDateT().getText());
			    String notes = uper.getNotesT().getText().trim();

			    String sql = """
			            update prescription
			            set issuedate=?, notes=?, doctorid=?, invoiceid=?
			            where prescriptionid=?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setDate(1, issueDate);
			        ps.setString(2, notes.isEmpty() ? null : notes);
			        ps.setInt(3, docID);
			        ps.setInt(4, invID);
			        ps.setInt(5, id);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Prescription updated successfully!");
			            a.showAndWait();

			            uper.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			PrescriptionTableView pert=new PrescriptionTableView();
			Scene uperscene = new Scene(uper.getAll(),400,400);

			pert.getRef().setOnAction(e -> {
			    pert.getSearchT().clear();
			    pert.getTable().setItems(loadAllPrescriptions());
			    pert.getTable().getSelectionModel().clearSelection();
			});

			pert.getSearchB().setOnAction(e -> {
			    String idT = pert.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        pert.getTable().setItems(loadAllPrescriptions());
			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("All Prescriptions");
			        a.setContentText("All prescriptions loaded");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(idT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Prescription ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    ObservableList<Prescription> result = searchPrescriptionById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Not found");
			        a.setContentText("No prescription with this ID");
			        a.showAndWait();
			        pert.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    pert.getTable().setItems(result);
			});

			pert.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
			    if (newV != null) {
			        pert.getDeleteB().setDisable(false);
			        pert.getUpdateB().setDisable(false);
			    } else {
			        pert.getDeleteB().setDisable(true);
			        pert.getUpdateB().setDisable(true);
			    }
			});

			pert.getDeleteB().setOnAction(e -> {
			    Prescription selected = pert.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a prescription first!");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm delete");
			    confirm.setContentText("Delete this prescription?");
			    confirm.showAndWait();

			    if (confirm.getResult() != ButtonType.OK) return;

			    String sql = "delete from prescription where prescriptionid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getPrescriptionID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Deleted");
			            a.setContentText("Prescription deleted successfully!");
			            a.showAndWait();
			        }

			        pert.getTable().setItems(loadAllPrescriptions());
			        pert.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			pert.getUpdateB().setOnAction(e -> {
			    Prescription selected = pert.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a prescription first!");
			        a.showAndWait();
			        return;
			    }

			    uper.getIdT().setText(selected.getPrescriptionID() + "");
			    if (selected.getIssueDate() != null)
			        uper.getDateT().setText(selected.getIssueDate()+"");

			    uper.getNotesT().setText(selected.getNotes());
			    uper.getDocT().setText(selected.getDoctorID() + "");
			    uper.getInvT().setText(selected.getInvoiceID() + "");

			    uper.getEdit().setDisable(false);
			    primaryStage.setScene(uperscene);
			});

			Scene aperscene = new Scene(aper.getAll(),400,400);
			Scene dperscene = new Scene(dper.getAll(),400,400);
			Scene pertscene = new Scene(pert.getAll(),400,400);

			mb.getAper().setOnAction(e->{
				primaryStage.setScene(aperscene);
			});
			mb.getDper().setOnAction(e->{
				primaryStage.setScene(dperscene);
			});
			mb.getUper().setOnAction(e->{
				primaryStage.setScene(uperscene);
			});
			mb.getPert().setOnAction(e->{
				primaryStage.setScene(pertscene);
			});
			
			AddPurchase apu = new AddPurchase();

			apu.getClear().setOnAction(e -> {
			    apu.getIdT().clear();
			    apu.getDateT().setText(null);
			    apu.getCostT().clear();
			    apu.getPayT().clear();
			    apu.getSidT().clear();
			    apu.getBidT().clear();
			});

			apu.getAdd().setOnAction(e -> {

			    String idT = apu.getIdT().getText().trim();
			    String dateT = apu.getDateT().getText();
			    String costT = apu.getCostT().getText().trim();
			    String payT = apu.getPayT().getText().trim();
			    String supT = apu.getSidT().getText().trim();
			    String branchT = apu.getBidT().getText().trim();

			    if (idT.isEmpty() || dateT == null || dateT.trim().isEmpty() || costT.isEmpty()
			            || payT.isEmpty() || supT.isEmpty() || branchT.isEmpty()) {

			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all required fields");
			        a.showAndWait();
			        return;
			    }

			    int id, supID, branchID;
			    double cost;

			    try {
			        id = Integer.parseInt(idT);
			        supID = Integer.parseInt(supT);
			        branchID = Integer.parseInt(branchT);
			        cost = Double.parseDouble(costT);
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("IDs must be integers and Total Cost must be numeric");
			        a.showAndWait();
			        return;
			    }

			    java.sql.Date purchaseDate;
			    try {
			        purchaseDate = java.sql.Date.valueOf(dateT.trim());
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Date");
			        a.setContentText("Date must be like YYYY-MM-DD");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            insert into purchase (purchaseid, purchasedate, totalcost, paymentstatus, supplierid, branchid)
			            values (?, ?, ?, ?, ?, ?)
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ps.setDate(2, purchaseDate);
			        ps.setDouble(3, cost);
			        ps.setString(4, payT);
			        ps.setInt(5, supID);
			        ps.setInt(6, branchID);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Purchase inserted successfully!");
			            a.showAndWait();

			            apu.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			DeletePurchase dpu = new DeletePurchase();

			dpu.getClear().setOnAction(e -> {
			    dpu.getSearchT().clear();
			    dpu.getIdT().clear();
			    dpu.getDateT().clear();
			    dpu.getCostT().clear();
			    dpu.getPayT().clear();
			    dpu.getSidT().clear();
			    dpu.getBidT().clear();
			    dpu.getDelete().setDisable(true);
			});

			dpu.getSearchB().setOnAction(e -> {

			    String searchT = dpu.getSearchT().getText().trim();

			    if (searchT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setContentText("Please enter Purchase ID");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(searchT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Purchase ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select purchaseid, purchasedate, totalcost, paymentstatus, supplierid, branchid
			            from purchase
			            where purchaseid = ?
			            """;

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dpu.getIdT().setText(rs.getInt("purchaseid") + "");
			            dpu.getDateT().setText(rs.getDate("purchasedate") + "");
			            dpu.getCostT().setText(rs.getDouble("totalcost") + "");
			            dpu.getPayT().setText(rs.getString("paymentstatus"));
			            dpu.getSidT().setText(rs.getInt("supplierid") + "");
			            dpu.getBidT().setText(rs.getInt("branchid") + "");

			            dpu.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No Purchase with ID = " + id);
			            a.showAndWait();
			            dpu.getDelete().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			dpu.getDelete().setOnAction(e -> {

			    if (dpu.getIdT().getText().trim().isEmpty()) return;

			    int id = Integer.parseInt(dpu.getIdT().getText().trim());

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm Delete");
			    confirm.setHeaderText("Are you sure?");
			    confirm.setContentText("Delete Purchase ID: " + id);

			    if (confirm.showAndWait().get() != ButtonType.OK) return;

			    String sql = "delete from purchase where purchaseid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Purchase deleted successfully!");
			            a.showAndWait();

			            dpu.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			UpdatePurchase upu = new UpdatePurchase();

			upu.getClear().setOnAction(e -> {
			    upu.getSearchT().clear();
			    upu.getIdT().clear();
			    upu.getDateT().setText(null);
			    upu.getCostT().clear();
			    upu.getPayT().clear();
			    upu.getSidT().clear();
			    upu.getBidT().clear();
			    upu.getEdit().setDisable(true);
			});

			upu.getSearchB().setOnAction(e -> {

			    String searchT = upu.getSearchT().getText().trim();
			    if (searchT.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing ID");
			        a.setContentText("Enter Purchase ID");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(searchT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Purchase ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select purchaseid, purchasedate, totalcost, paymentstatus, supplierid, branchid
			            from purchase
			            where purchaseid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, id);
			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            upu.getIdT().setText(rs.getInt("purchaseid") + "");

			            java.sql.Date d = rs.getDate("purchasedate");
			            if (d != null)
			                upu.getDateT().setText(d.toLocalDate() + "");

			            upu.getCostT().setText(rs.getDouble("totalcost") + "");
			            upu.getPayT().setText(rs.getString("paymentstatus"));
			            upu.getSidT().setText(rs.getInt("supplierid") + "");
			            upu.getBidT().setText(rs.getInt("branchid") + "");

			            upu.getEdit().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No Purchase with ID = " + id);
			            a.showAndWait();
			            upu.getEdit().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			upu.getEdit().setOnAction(e -> {

			    if (upu.getIdT().getText().trim().isEmpty()) return;

			    int id, supID, branchID;
			    double cost;

			    try {
			        id = Integer.parseInt(upu.getIdT().getText().trim());
			        supID = Integer.parseInt(upu.getSidT().getText().trim());
			        branchID = Integer.parseInt(upu.getBidT().getText().trim());
			        cost = Double.parseDouble(upu.getCostT().getText().trim());
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("IDs must be integers and Total Cost must be numeric");
			        a.showAndWait();
			        return;
			    }

			    if (upu.getDateT().getText() == null || upu.getDateT().getText().trim().isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Date");
			        a.setContentText("Purchase Date is required");
			        a.showAndWait();
			        return;
			    }

			    java.sql.Date purchaseDate;
			    try {
			        purchaseDate = java.sql.Date.valueOf(upu.getDateT().getText().trim());
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Date");
			        a.setContentText("Date must be like YYYY-MM-DD");
			        a.showAndWait();
			        return;
			    }

			    String pay = upu.getPayT().getText().trim();

			    String sql = """
			            update purchase
			            set purchasedate=?, totalcost=?, paymentstatus=?, supplierid=?, branchid=?
			            where purchaseid=?
			            """;

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setDate(1, purchaseDate);
			        ps.setDouble(2, cost);
			        ps.setString(3, pay);
			        ps.setInt(4, supID);
			        ps.setInt(5, branchID);
			        ps.setInt(6, id);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Purchase updated successfully!");
			            a.showAndWait();

			            upu.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			PurchaseTableView put = new PurchaseTableView();
			Scene upuscene = new Scene(upu.getAll(),400,400);

			put.getRefreshB().setOnAction(e -> {
			    put.getSearchT().clear();
			    put.getTable().setItems(loadAllPurchases());
			    put.getTable().getSelectionModel().clearSelection();
			});

			put.getSearchB().setOnAction(e -> {
			    String idT = put.getSearchT().getText().trim();

			    if (idT.isEmpty()) {
			        put.getTable().setItems(loadAllPurchases());
			        Alert a = new Alert(Alert.AlertType.INFORMATION);
			        a.setTitle("All Purchases");
			        a.setContentText("All purchases loaded");
			        a.showAndWait();
			        return;
			    }

			    int id;
			    try { id = Integer.parseInt(idT); }
			    catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("Purchase ID must be integer");
			        a.showAndWait();
			        return;
			    }

			    ObservableList<Purchase> result = searchPurchaseById(id);

			    if (result.isEmpty()) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Not found");
			        a.setContentText("No purchase with this ID");
			        a.showAndWait();
			        put.getTable().setItems(FXCollections.observableArrayList());
			        return;
			    }

			    put.getTable().setItems(result);
			});

			put.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
			    if (newV != null) {
			        put.getDeleteB().setDisable(false);
			        put.getUpdateB().setDisable(false);
			    } else {
			        put.getDeleteB().setDisable(true);
			        put.getUpdateB().setDisable(true);
			    }
			});

			put.getDeleteB().setOnAction(e -> {
			    Purchase selected = put.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a purchase first!");
			        a.showAndWait();
			        return;
			    }

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm delete");
			    confirm.setContentText("Delete this purchase?");
			    confirm.showAndWait();

			    if (confirm.getResult() != ButtonType.OK) return;

			    String sql = "delete from purchase where purchaseid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, selected.getPurchaseID());
			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Deleted");
			            a.setContentText("Purchase deleted successfully!");
			            a.showAndWait();
			        }

			        put.getTable().setItems(loadAllPurchases());
			        put.getTable().getSelectionModel().clearSelection();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			put.getUpdateB().setOnAction(e -> {
			    Purchase selected = put.getTable().getSelectionModel().getSelectedItem();

			    if (selected == null) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("No selection");
			        a.setContentText("Select a purchase first!");
			        a.showAndWait();
			        return;
			    }

			    upu.getIdT().setText(selected.getPurchaseID() + "");
			    if (selected.getPurchaseDate() != null)
			        upu.getDateT().setText(selected.getPurchaseDate() + "");

			    upu.getCostT().setText(selected.getTotalCost() + "");
			    upu.getPayT().setText(selected.getPaymentStatus());
			    upu.getSidT().setText(selected.getSupplierID() + "");
			    upu.getBidT().setText(selected.getBranchID() + "");

			    upu.getEdit().setDisable(false);
			    primaryStage.setScene(upuscene);
			});

			Scene apurscene = new Scene(apu.getAll(),400,400);
			Scene dpurscene = new Scene(dpu.getAll(),400,400);
			Scene purtscene = new Scene(put.getAll(),400,400);

			mb.getApur().setOnAction(e->{
				primaryStage.setScene(apurscene);
			});
			mb.getDpur().setOnAction(e->{
				primaryStage.setScene(dpurscene);
			});
			mb.getUpur().setOnAction(e->{
				primaryStage.setScene(upuscene);
			});
			mb.getPurt().setOnAction(e->{
				primaryStage.setScene(purtscene);
			});
			
			AddSupplier asup=new AddSupplier();
			asup.getAdd().setOnAction(e -> {

			    // 1️⃣ فحص الحقول
			    if (
			        asup.getsIDT().getText().trim().isEmpty() ||
			        asup.getsNT().getText().trim().isEmpty() ||
			        asup.getlNT().getText().trim().isEmpty() ||
			        asup.getPhNT().getText().trim().isEmpty()
			    ) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all required fields");
			        a.showAndWait();
			        return;
			    }

			    try {
			        int supplierId = Integer.parseInt(asup.getsIDT().getText().trim());

			        String sql = """
			            INSERT INTO supplier
			            (supplierid, suppliername, licenseno, phonenumber, email, address)
			            VALUES (?, ?, ?, ?, ?, ?)
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, supplierId);
			            ps.setString(2, asup.getsNT().getText().trim());
			            ps.setString(3, asup.getlNT().getText().trim());
			            ps.setString(4, asup.getPhNT().getText().trim());
			            ps.setString(5, asup.getEmT().getText().trim());
			            ps.setString(6, asup.getAddT().getText().trim());

			            ps.executeUpdate();

			            Alert ok = new Alert(Alert.AlertType.INFORMATION);
			            ok.setTitle("Done");
			            ok.setContentText("Supplier added successfully");
			            ok.showAndWait();

			            // تفريغ الحقول
			            asup.getsIDT().clear();
			            asup.getsNT().clear();
			            asup.getlNT().clear();
			            asup.getPhNT().clear();
			            asup.getEmT().clear();
			            asup.getAddT().clear();
			        }

			    } catch (NumberFormatException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("Supplier ID must be a number");
			        a.showAndWait();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			asup.getClear().setOnAction(e -> {
			    asup.getsIDT().clear();
			    asup.getsNT().clear();
			    asup.getlNT().clear();
			    asup.getPhNT().clear();
			    asup.getEmT().clear();
			    asup.getAddT().clear();
			});

			DeleteSupplier dsup=new DeleteSupplier();
			

			dsup.getDelete().setOnAction(e -> {
			    try {
			        String sql = "DELETE FROM supplier WHERE supplierID = ?";

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setInt(1, Integer.parseInt(dsup.getsIDT().getText()));
			            ps.executeUpdate();

			            new Alert(Alert.AlertType.INFORMATION, "Supplier Deleted").showAndWait();
			            dsup.getClear().fire();
			        }

			    } catch (Exception ex) {
			        new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
			    }
			});

			UpdateSupplier usup=new UpdateSupplier();
			usup.getEdit().setOnAction(e -> {
			    try {
			        String sql = """
			            UPDATE supplier
			            SET supplierName=?, licenseNo=?, phoneNumber=?, email=?, address=?
			            WHERE supplierID=?
			        """;

			        try (Connection con = DatabaseConnection.getConnection();
			             PreparedStatement ps = con.prepareStatement(sql)) {

			            ps.setString(1, usup.getsNT().getText());
			            ps.setString(2, usup.getlNT().getText());
			            ps.setString(3, usup.getPhNT().getText());
			            ps.setString(4, usup.getEmT().getText());
			            ps.setString(5, usup.getAddT().getText());
			            ps.setInt(6, Integer.parseInt(usup.getsIDT().getText()));

			            ps.executeUpdate();
			            new Alert(Alert.AlertType.INFORMATION, "Supplier Updated").showAndWait();
			        }

			    } catch (Exception ex) {
			        new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
			    }
			});

			SupplierTableView st=new SupplierTableView();
					mb.getSt().setOnAction(e -> {

			    st.getTable().getItems().clear();

			    String sql = "SELECT * FROM supplier";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql);
			         ResultSet rs = ps.executeQuery()) {

			        while (rs.next()) {
			            st.getTable().getItems().add(
			                new Supplier(
			                    rs.getInt("supplierID"),
			                    rs.getString("supplierName"),
			                    rs.getString("phoneNumber"),
			                    rs.getString("email"),
			                    rs.getString("address")
			                )
			            );
			        }

			        primaryStage.setScene(new Scene(st.getAll(), 700, 450));

			    } catch (Exception ex) {
			        new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
			    }
			});
					SuppliersSupplyList suppliersSupply =
					        new SuppliersSupplyList();

					Scene suppliersSupplyScene =
					        new Scene(suppliersSupply.getAll(), 700, 450);

					mb.getQ21().setOnAction(e -> {

					    // ✅ اسم الميثود الصحيح
					    suppliersSupply.clearSupplies();

					    String sql = """
					        SELECT s.supplierName,
					               COUNT(i.inventoryItemID) AS itemsCount,
					               p.purchaseDate
					        FROM supplier s
					        JOIN purchase p ON s.supplierID = p.supplierID
					        JOIN inventory_item i ON p.purchaseID = i.purchaseID
					        GROUP BY s.supplierName, p.purchaseDate
					    """;

					    try (Connection con = DatabaseConnection.getConnection();
					         PreparedStatement ps = con.prepareStatement(sql);
					         ResultSet rs = ps.executeQuery()) {

					        while (rs.next()) {
					            suppliersSupply.addSupplierSupply(
					                    rs.getString("supplierName"),
					                    rs.getString("itemsCount"),
					                    rs.getDate("purchaseDate").toString()
					            );
					        }

					        primaryStage.setScene(suppliersSupplyScene);

					    } catch (Exception ex) {
					        new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
					    }
					});

					SuppliersByMedicinePeriodList suppliersByPeriod =
					        new SuppliersByMedicinePeriodList();

					Scene suppliersByPeriodScene =
					        new Scene(suppliersByPeriod.getAll(), 700, 450);

					mb.getQ22().setOnAction(e -> {

					    // ✅ اسم الميثود الصحيح
					    suppliersByPeriod.clearSuppliers();

					    String sql = """
					        SELECT s.supplierName,
					               m.medicineName,
					               p.purchaseDate
					        FROM supplier s
					        JOIN purchase p ON s.supplierID = p.supplierID
					        JOIN inventory_item i ON p.purchaseID = i.purchaseID
					        JOIN medicine m ON i.medicineID = m.medicineID
					    """;

					    try (Connection con = DatabaseConnection.getConnection();
					         PreparedStatement ps = con.prepareStatement(sql);
					         ResultSet rs = ps.executeQuery()) {

					        while (rs.next()) {
					            suppliersByPeriod.addSupplier(
					                    rs.getString("supplierName"),
					                    rs.getString("medicineName"),
					                    rs.getDate("purchaseDate").toString()
					            );
					        }

					        primaryStage.setScene(suppliersByPeriodScene);

					    } catch (Exception ex) {
					        new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
					    }
					});

			
			SuppliersLargestOrdersList largestOrders =
			        new SuppliersLargestOrdersList();

			Scene largestOrdersScene =
			        new Scene(largestOrders.getAll(), 700, 450);

			mb.getQ23().setOnAction(e -> {
			    primaryStage.setScene(largestOrdersScene);
			});


			Scene asupscene = new Scene(asup.getAll(),400,400);
			Scene dsupscene = new Scene(dsup.getAll(),400,400);
			Scene usupscene = new Scene(usup.getAll(),400,400);
			Scene stscene = new Scene(st.getAll(),400,400);

			mb.getAsup().setOnAction(e->{
				primaryStage.setScene(asupscene);
			});
			mb.getDsup().setOnAction(e->{
				primaryStage.setScene(dsupscene);
			});
			mb.getUsup().setOnAction(e->{
				primaryStage.setScene(usupscene);
			});
			mb.getSt().setOnAction(e->{
				primaryStage.setScene(stscene);
			});

<<<<<<< HEAD
=======
			mb.getQ21().setOnAction(e -> primaryStage.setScene(suppliersSupplyScene));
			mb.getQ22().setOnAction(e -> primaryStage.setScene(suppliersByPeriodScene));
			mb.getQ23().setOnAction(e -> primaryStage.setScene(largestOrdersScene));

>>>>>>> 9cf8d1f78b1783cbad79699a9fcae2157130e413
			AddInventoryItem ain=new AddInventoryItem();
			DeleteInventoryItem din=new DeleteInventoryItem();
			UpdateInventoryItem uin=new UpdateInventoryItem();
			InventoryItemTableView intt=new InventoryItemTableView();

			Scene ainscene = new Scene(ain.getAll(),400,400);
			Scene dinscene = new Scene(din.getAll(),400,400);
			Scene uinscene = new Scene(uin.getAll(),400,400);
			Scene inttscene = new Scene(intt.getAll(),400,400);

			mb.getAin().setOnAction(e->{
				primaryStage.setScene(ainscene);
			});
			mb.getDin().setOnAction(e->{
				primaryStage.setScene(dinscene);
			});
			mb.getUin().setOnAction(e->{
				primaryStage.setScene(uinscene);
			});
			mb.getInnt().setOnAction(e->{
				primaryStage.setScene(inttscene);
			});

			mb.getExit().setOnAction(e->{
				primaryStage.close();
			});
			
			Scene scene = new Scene(login.getAll(),400,400);
			Scene mainScene = new Scene(mb.getAll(), 400, 400);
			login.getLogin().setOnAction(e -> {

			    if (!login.isValidLogin()) {
			        javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
			        a.setTitle("login failed");
			        a.setHeaderText("invalid username or password");
			        a.showAndWait();
			        return;
			    }

			    String role = login.getRoleC().getValue();
			    mb.applyRole(role);

			    primaryStage.setScene(mainScene);
			});
			mb.getLogout().setOnAction(e -> {

			    javafx.scene.control.Alert confirm = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Logout");
			    confirm.setHeaderText("are you sure you want to logout?");
			    confirm.setContentText("you will return to login page");

			    confirm.showAndWait().ifPresent(res -> {
			        if (res == javafx.scene.control.ButtonType.OK) {
			            primaryStage.setScene(scene);
			        }
			    });
			    login.getPassT().setText(null);
			    login.getUserT().setText(null);
			});
			AddPrescriptionMedicine apermed = new AddPrescriptionMedicine();

			apermed.getClear().setOnAction(e -> {
			    apermed.getPidT().clear();
			    apermed.getMidT().clear();
			    apermed.getDosT().clear();
			});

			apermed.getAdd().setOnAction(e -> {

			    if (apermed.getPidT().getText().trim().isEmpty()
			            || apermed.getMidT().getText().trim().isEmpty()
			            || apermed.getDosT().getText().trim().isEmpty()) {

			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing Data");
			        a.setContentText("Please fill all fields");
			        a.showAndWait();
			        return;
			    }

			    int preID, medID;
			    String dosage;

			    try {
			        preID = Integer.parseInt(apermed.getPidT().getText().trim());
			        medID = Integer.parseInt(apermed.getMidT().getText().trim());
			        dosage = apermed.getDosT().getText().trim();
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid Input");
			        a.setContentText("IDs must be integers");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            insert into prescription_medicine (prescriptionid, medicineid, dosage)
			            values (?, ?, ?)
			            """;

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, preID);
			        ps.setInt(2, medID);
			        ps.setString(3, dosage);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Inserted successfully!");
			            a.showAndWait();
			            apermed.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Insert Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			DeletePrescriptionMedicine dpermed = new DeletePrescriptionMedicine();

			dpermed.getClear().setOnAction(e -> {
			    dpermed.getSpidT().clear();
			    dpermed.getSmidT().clear();

			    dpermed.getPidT().clear();
			    dpermed.getMidT().clear();
			    dpermed.getDosT().clear();

			    dpermed.getDelete().setDisable(true);
			});

			dpermed.getSearchB().setOnAction(e -> {

			    if (dpermed.getSpidT().getText().trim().isEmpty()
			            || dpermed.getSmidT().getText().trim().isEmpty()) {

			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Missing IDs");
			        a.setContentText("Enter Prescription ID and Medicine ID");
			        a.showAndWait();
			        return;
			    }

			    int preID, medID;
			    try {
			        preID = Integer.parseInt(dpermed.getSpidT().getText().trim());
			        medID = Integer.parseInt(dpermed.getSmidT().getText().trim());
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid");
			        a.setContentText("IDs must be integers");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            select prescriptionid, medicineid, dosage
			            from prescription_medicine
			            where prescriptionid = ? and medicineid = ?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, preID);
			        ps.setInt(2, medID);

			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            dpermed.getPidT().setText(rs.getInt("prescriptionid") + "");
			            dpermed.getMidT().setText(rs.getInt("medicineid") + "");
			            dpermed.getDosT().setText(rs.getString("dosage"));

			            dpermed.getDelete().setDisable(false);
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setContentText("No record found!");
			            a.showAndWait();
			            dpermed.getDelete().setDisable(true);
			        }

			        rs.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Error");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			dpermed.getDelete().setOnAction(e -> {

			    if (dpermed.getPidT().getText().trim().isEmpty()
			            || dpermed.getMidT().getText().trim().isEmpty())
			        return;

			    int preID = Integer.parseInt(dpermed.getPidT().getText().trim());
			    int medID = Integer.parseInt(dpermed.getMidT().getText().trim());

			    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
			    confirm.setTitle("Confirm Delete");
			    confirm.setHeaderText("Are you sure?");
			    confirm.setContentText("Delete Prescription Medicine?");
			    if (confirm.showAndWait().get() != ButtonType.OK) return;

			    String sql = "delete from prescription_medicine where prescriptionid = ? and medicineid = ?";

			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setInt(1, preID);
			        ps.setInt(2, medID);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Deleted successfully!");
			            a.showAndWait();
			            dpermed.getClear().fire();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Delete Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			UpdatePrescriptionMedicine upermed = new UpdatePrescriptionMedicine();

			upermed.getEdit().setOnAction(e -> {

			    if (upermed.getPidT().getText().trim().isEmpty()
			            || upermed.getMidT().getText().trim().isEmpty())
			        return;

			    int preID, medID;
			    String dosage;

			    try {
			        preID = Integer.parseInt(upermed.getPidT().getText().trim());
			        medID = Integer.parseInt(upermed.getMidT().getText().trim());
			        dosage = upermed.getDosT().getText().trim();
			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Invalid input");
			        a.setContentText("Check values again");
			        a.showAndWait();
			        return;
			    }

			    String sql = """
			            update prescription_medicine
			            set dosage=?
			            where prescriptionid=? and medicineid=?
			            """;


			    try (Connection con = DatabaseConnection.getConnection();
			         PreparedStatement ps = con.prepareStatement(sql)) {

			        ps.setString(1, dosage);
			        ps.setInt(2, preID);
			        ps.setInt(3, medID);

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Done");
			            a.setContentText("Updated successfully!");
			            a.showAndWait();
			            upermed.getEdit().setDisable(true);
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});
			PrescriptionMedicineTableView premedt=new PrescriptionMedicineTableView();
			
			premedt.getRefresh().setOnAction(e -> {
			    premedt.getTable().setItems(loadPreMed());
			    premedt.getTable().getSelectionModel().clearSelection();
			});
			
			premedt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
		
			Scene apermedscene = new Scene(apermed.getAll(),400,400);
			Scene dpermedscene = new Scene(dpermed.getAll(),400,400);
			Scene upermedscene = new Scene(upermed.getAll(),400,400);

			mb.getAperMed().setOnAction(e-> primaryStage.setScene(apermedscene));
			mb.getDperMed().setOnAction(e-> primaryStage.setScene(dpermedscene));
			mb.getUperMed().setOnAction(e-> primaryStage.setScene(upermedscene));

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			signupC.getBack().setOnAction(e -> {
			    primaryStage.setScene(scene);
			});
			ab.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			db.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ub.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			ain.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			din.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uin.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			acs.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dcs.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ucs.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			ac.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dc.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uc.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			ad.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dd.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ud.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			ae.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			de.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ue.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			aic.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dic.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uic.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			aiv.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			div.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uiv.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			aii.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			divi.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uivi.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			aip.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dip.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uip.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			amed.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dmed.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			umed.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			apay.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dpay.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			upay.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			apermed.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dpermed.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			upermed.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			aper.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dper.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			uper.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			apu.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dpu.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			upu.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			asup.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dsup.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			usup.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			bt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			mt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			it.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			st.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			//iit.getBack().setOnAction(e->{
			//	primaryStage.setScene(mainScene);
		//	});
			et.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			
			meds.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			ct.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			catt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ict.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ipt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			payt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			pert.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			put.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			intt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ebt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			tbt.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			tet.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			ibt.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			stt.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			q7page.getBack().setOnAction(e -> {
				primaryStage.setScene(mainScene);
			});
			q6.getBack().setOnAction(e -> {
				primaryStage.setScene(mainScene);
			});
			q7.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			q8.getBack().setOnAction(e -> {
				primaryStage.setScene(mainScene);
			});
			q5.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			q15.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			q17.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			q18.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			iq19.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			iq20.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			iq32.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			iq33.getBack().setOnAction(e ->{
				primaryStage.setScene(mainScene);
			});
			smt.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsLosses.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsDamaged.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsSales.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsByCategory.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			supplierSummary.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsBySupplier.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsLowStock.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsExpiry.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			medsDetails.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			meds.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			largestOrders.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			suppliersByPeriod.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			suppliersSupply.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			suppliersSupply.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			iit.getBack().setOnAction(e -> {
			    primaryStage.setScene(mainScene);
			});
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private ObservableList<Employee> loadAllEmployes() {
	    ObservableList<Employee> list = FXCollections.observableArrayList();

	    String sql = """
	            select empid, fullname, qualification, phonenumber, salary, branchid
	            from employee
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Employee emp = new Employee(
	                    rs.getInt("EmpID"),
	                    rs.getString("FullName"),
	                    rs.getString("Qualification"),
	                    rs.getString("PhoneNumber"),
	                    rs.getDouble("Salary"),
	                    rs.getInt("BranchID")
	            );
	            list.add(emp);
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<Employee> searchEmployeeById(int id) {
	    ObservableList<Employee> list = FXCollections.observableArrayList();

	    String sql = """
	            select empid, fullname, qualification, phonenumber, salary, branchid
	            from employee
	            where empid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Employee emp = new Employee(
	                    rs.getInt("EmpID"),
	                    rs.getString("FullName"),
	                    rs.getString("Qualification"),
	                    rs.getString("PhoneNumber"),
	                    rs.getDouble("Salary"),
	                    rs.getInt("BranchID")
	            );
	            list.add(emp);
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<EmployeeBranch> loadEmployeeBranchData() {
	    ObservableList<EmployeeBranch> list = FXCollections.observableArrayList();

	    String sql = """
	            select e.fullname, e.qualification, e.salary, b.branchname
	            from employee e
	            join branch b on e.branchid = b.branchid
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new EmployeeBranch(
	                    rs.getString("FullName"),
	                    rs.getString("Qualification"),
	                    rs.getDouble("Salary"),
	                    rs.getString("BranchName")
	            ));
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return list;
	}
	private ObservableList<EmployeeBranch> searchEmployeeBranchID(int branchID) {
	    ObservableList<EmployeeBranch> list = FXCollections.observableArrayList();

	    String sql = """
	            select e.fullname, e.qualification, e.salary, b.branchname
	            from employee e
	            join branch b on e.branchid = b.branchid
	            where b.branchid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, branchID);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                list.add(new EmployeeBranch(
	                        rs.getString("FullName"),
	                        rs.getString("Qualification"),
	                        rs.getDouble("Salary"),
	                        rs.getString("BranchName")
	                ));
	            }
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return list;
	}
	private ObservableList<Branch> loadAllBranches() {
	    ObservableList<Branch> list = FXCollections.observableArrayList();

	    String sql = """
	            select branchid, branchname, address, phonenumber, email
	            from branch
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new Branch(
	                    rs.getInt("BranchID"),
	                    rs.getString("BranchName"),
	                    rs.getString("Address"),
	                    rs.getString("PhoneNumber"),
	                    rs.getString("Email")
	            ));
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return list;
	}

	private ObservableList<Branch> searchBranchById(int id) {
	    ObservableList<Branch> list = FXCollections.observableArrayList();
	    String sql = """
	            select branchid, branchname, address, phonenumber, email
	            from branch
	            where branchid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                list.add(new Branch(
	                        rs.getInt("BranchID"),
	                        rs.getString("BranchName"),
	                        rs.getString("Address"),
	                        rs.getString("PhoneNumber"),
	                        rs.getString("Email")
	                ));
	            }
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}

	private ObservableList<Branch> loadBranchNAP() {
	    return loadAllBranches();
	}
	private ObservableList<Category> loadAllCategories() {
	    ObservableList<Category> list = FXCollections.observableArrayList();

	    String sql = """
	            select categoryid, categoryname, description
	            from category
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new Category(
	                    rs.getInt("CategoryID"),
	                    rs.getString("CategoryName"),
	                    rs.getString("Description")
	            ));
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}

	private ObservableList<Category> searchCategoryById(int id) {
	    ObservableList<Category> list = FXCollections.observableArrayList();

	    String sql = """
	            select categoryid, categoryname, description
	            from category
	            where categoryid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                list.add(new Category(
	                        rs.getInt("CategoryID"),
	                        rs.getString("CategoryName"),
	                        rs.getString("Description")
	                ));
	            }
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<Invoice> loadAllInvoices() {
	    ObservableList<Invoice> list = FXCollections.observableArrayList();

	    String sql = """
	            select invoiceid, invoicedate, invoicetime, subtotal, discount, tax,
	                   totalamount, paymentstatus, customerid, empid, branchid
	            from invoice
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Invoice inv = new Invoice(
	                    rs.getInt("invoiceid"),
	                    rs.getDate("invoicedate") == null ? null : rs.getDate("invoicedate").toLocalDate(),
	                    rs.getTime("invoicetime") == null ? null : rs.getTime("invoicetime").toLocalTime(),
	                    rs.getDouble("subtotal"),
	                    rs.getDouble("discount"),
	                    rs.getDouble("tax"),
	                    rs.getDouble("totalamount"),
	                    rs.getString("paymentstatus"),
	                    rs.getInt("customerid"),
	                    rs.getInt("empid"),
	                    rs.getInt("branchid")
	            );
	            list.add(inv);
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<Invoice> searchInvoiceById(int id) {

	    ObservableList<Invoice> list = FXCollections.observableArrayList();

	    String sql = """
	            select invoiceid, invoicedate, invoicetime, subtotal, discount, tax,
	                   totalamount, paymentstatus, customerid, empid, branchid
	            from invoice
	            where invoiceid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Invoice inv = new Invoice(
	                    rs.getInt("invoiceid"),
	                    rs.getDate("invoicedate") == null ? null : rs.getDate("invoicedate").toLocalDate(),
	                    rs.getTime("invoicetime") == null ? null : rs.getTime("invoicetime").toLocalTime(),
	                    rs.getDouble("subtotal"),
	                    rs.getDouble("discount"),
	                    rs.getDouble("tax"),
	                    rs.getDouble("totalamount"),
	                    rs.getString("paymentstatus"),
	                    rs.getInt("customerid"),
	                    rs.getInt("empid"),
	                    rs.getInt("branchid")
	            );
	            list.add(inv);
	        }

	        rs.close();

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<Payment> loadAllPayments() {
	    ObservableList<Payment> list = FXCollections.observableArrayList();

	    String sql = """
	            select paymentid, paymentdate, paymenttype, amount, referencenumber, invoiceid, policyid
	            from payment
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {

	            Integer pol = rs.getInt("policyid");
	            if (rs.wasNull()) pol = null;

	            Payment p = new Payment(
	                    rs.getInt("paymentid"),
	                    rs.getDate("paymentdate") == null ? null : rs.getDate("paymentdate").toLocalDate(),
	                    rs.getString("paymenttype"),
	                    rs.getDouble("amount"),
	                    rs.getString("referencenumber"),
	                    rs.getInt("invoiceid"),
	                    pol
	            );

	            list.add(p);
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}

	private ObservableList<Payment> searchPaymentById(int id) {
	    ObservableList<Payment> list = FXCollections.observableArrayList();

	    String sql = """
	            select paymentid, paymentdate, paymenttype, amount, referencenumber, invoiceid, policyid
	            from payment
	            where paymentid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Integer pol = rs.getInt("policyid");
	            if (rs.wasNull()) pol = null;

	            Payment p = new Payment(
	                    rs.getInt("paymentid"),
	                    rs.getDate("paymentdate") == null ? null : rs.getDate("paymentdate").toLocalDate(),
	                    rs.getString("paymenttype"),
	                    rs.getDouble("amount"),
	                    rs.getString("referencenumber"),
	                    rs.getInt("invoiceid"),
	                    pol
	            );

	            list.add(p);
	        }

	        rs.close();

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<Prescription> loadAllPrescriptions() {
	    ObservableList<Prescription> list = FXCollections.observableArrayList();
	    String sql = """
	            select prescriptionid, issuedate, notes, doctorid, invoiceid
	            from prescription
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Prescription p = new Prescription(
	                rs.getInt("prescriptionid"),
	                rs.getDate("issuedate") == null ? null : rs.getDate("issuedate").toLocalDate(),
	                rs.getString("notes"),
	                rs.getInt("doctorid"),
	                rs.getInt("invoiceid")
	            );
	            list.add(p);
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return list;
	}

	private ObservableList<Prescription> searchPrescriptionById(int id) {
	    ObservableList<Prescription> list = FXCollections.observableArrayList();
	    String sql = """
	            select prescriptionid, issuedate, notes, doctorid, invoiceid
	            from prescription
	            where prescriptionid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Prescription p = new Prescription(
	                rs.getInt("prescriptionid"),
	                rs.getDate("issuedate") == null ? null : rs.getDate("issuedate").toLocalDate(),
	                rs.getString("notes"),
	                rs.getInt("doctorid"),
	                rs.getInt("invoiceid")
	            );
	            list.add(p);
	        }

	        rs.close();

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<PrescriptionMedicineRow> loadPreMed() {
	    ObservableList<PrescriptionMedicineRow> list = FXCollections.observableArrayList();

	    String sql = "select * from prescription_medicine";

	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new PrescriptionMedicineRow(
	                    rs.getInt("prescriptionid"),
	                    rs.getInt("medicineid"),
	                    rs.getString("dosage")
	            ));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	private ObservableList<Purchase> loadAllPurchases() {

	    ObservableList<Purchase> list = FXCollections.observableArrayList();
	    String sql = """
	            select purchaseid, purchasedate, totalcost, paymentstatus, supplierid, branchid
	            from purchase
	            order by purchaseid
	            """;

	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {

	            int id = rs.getInt("purchaseid");

	            java.sql.Date d = rs.getDate("purchasedate");
	            LocalDate date = (d != null) ? d.toLocalDate() : null;

	            double cost = rs.getDouble("totalcost");
	            String status = rs.getString("paymentstatus");

	            int supplierID = rs.getInt("supplierid");
	            int branchID = rs.getInt("branchid");

	            Purchase p = new Purchase(id, date, cost, status, supplierID, branchID);

	            list.add(p);
	        }

	    } catch (Exception ex) {
	        Alert a = new Alert(Alert.AlertType.ERROR);
	        a.setTitle("Load Failed");
	        a.setContentText(ex.getMessage());
	        a.showAndWait();
	    }

	    return list;
	}
	private ObservableList<Purchase> searchPurchaseById(int id) {

	    ObservableList<Purchase> list = FXCollections.observableArrayList();
	    String sql = """
	            select purchaseid, purchasedate, totalcost, paymentstatus, supplierid, branchid
	            from purchase
	            where purchaseid = ?
	            """;


	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            int pid = rs.getInt("purchaseid");

	            java.sql.Date d = rs.getDate("purchasedate");
	            LocalDate date; 
	            if(d != null) {
	            	date= d.toLocalDate(); }
	            else {
	            		date=null;
	            }

	            double cost = rs.getDouble("totalcost");
	            String status = rs.getString("paymentstatus");

	            int supplierID = rs.getInt("supplierid");
	            int branchID = rs.getInt("branchid");

	            Purchase p = new Purchase(pid, date, cost, status, supplierID, branchID);

	            list.add(p);
	        }

	        rs.close();

	    } catch (Exception ex) {
	        Alert a = new Alert(Alert.AlertType.ERROR);
	        a.setTitle("Search Failed");
	        a.setContentText(ex.getMessage());
	        a.showAndWait();
	    }

	    return list;
	}
	 public static ObservableList<Customer> loadCustomers() {

	        ObservableList<Customer> list = FXCollections.observableArrayList();

	        String sql = """
	                select customerid, fullname, phonenumber, email, address, dateofbirth, gender
	                from customer
	                order by customerid
	                """;

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {

	                int id = rs.getInt("customerid");
	                String name = rs.getString("fullname");
	                String phone = rs.getString("phonenumber");
	                String email = rs.getString("email");
	                String address = rs.getString("address");

	                java.sql.Date dob = rs.getDate("dateofbirth");
	                LocalDate dobL = (dob == null) ? null : dob.toLocalDate();

	                String gender = rs.getString("gender");

	                list.add(new Customer(id, name, phone, email, address, dobL, gender));
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        return list;
	    }
}
