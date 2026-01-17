package application;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			            INSERT INTO Branch (BranchID, BranchName, Address, PhoneNumber, Email)
			            VALUES (?, ?, ?, ?, ?)
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

		        String sql = "SELECT * FROM Branch WHERE BranchID = ?";
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
	            String sql = "DELETE FROM Branch WHERE BranchID = ?";

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

			    String sql = "DELETE FROM Branch WHERE BranchID=?";

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
		        String sql = "INSERT INTO Branch (BranchID, BranchName, Address, PhoneNumber, Email) VALUES (?, ?, ?, ?, ?)";

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
		        String sql = "SELECT * FROM Branch WHERE BranchID = ?";

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
		        String sql = "UPDATE Branch SET BranchName=?, Address=?, PhoneNumber=?, Email=? WHERE BranchID=?";

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

			    String sql = "INSERT INTO Category (CategoryID, CategoryName, Description) VALUES (?, ?, ?)";

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

			    String sql = "SELECT * FROM Category WHERE CategoryID=?";

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

			        String sql = "DELETE FROM Category WHERE CategoryID=?";

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

			    String sql = "SELECT * FROM Category WHERE CategoryID=?";

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

			    String sql = "UPDATE Category SET CategoryName=?, Description=? WHERE CategoryID=?";

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

			    String sql = "DELETE FROM Category WHERE CategoryID=?";

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
			});
			acs.getAdd().setOnAction(e -> {
		        String sql = "INSERT INTO Customer (CustomerID, FullName, PhoneNumber, Email, Address) VALUES (?, ?, ?, ?, ?)";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        if (acs.getCidT().getText().trim().isEmpty() ||acs.getNameT().getText().trim().isEmpty() ||acs.getPnT().getText().trim().isEmpty() ||acs.geteT().getText().trim().isEmpty() ||acs.getAddT().getText().trim().isEmpty()) {

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing Data");
			            a.setHeaderText("Missing Data");
			            a.setContentText("Please fill all fields.");
			            a.showAndWait();
			            return;
			        }

			     int id = Integer.parseInt(acs.getCidT().getText().trim());
			        String name = acs.getNameT().getText().trim();
			        String phone = acs.getPnT().getText().trim();
			        String email = acs.geteT().getText().trim();
			        String address = acs.getAddT().getText().trim();


			        ps.setInt(1, id);
			        ps.setString(2, name);
			        ps.setString(3, phone);
			        ps.setString(4, email);
			        ps.setString(5, address);

			        ps.executeUpdate();
			        ps.close();

			        Alert done = new Alert(Alert.AlertType.INFORMATION);
			        done.setTitle("Done");
			        done.setHeaderText("Customer Added Successfully");
			        done.setContentText("Customer ID: " + id);
			        done.showAndWait();

			        acs.getCidT().clear();
			        acs.getNameT().clear();
			        acs.getPnT().clear();
			        acs.geteT().clear();
			        acs.getAddT().clear();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
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
			    dcs.getDelete().setDisable(true);
			});

		
			dcs.getSearchB().setOnAction(e -> {
		        String sql = "SELECT * FROM Customer WHERE CustomerID = ?";

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
			        ps.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			
			dcs.getDelete().setOnAction(e -> {
	            String sql = "DELETE FROM Customer WHERE CustomerID = ?";

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
			            ps.close();

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
			        a.setTitle(ex.getMessage());
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
			    ucs.getEdit().setDisable(true);
			});

			
			ucs.getSearchB().setOnAction(e -> {
		        String sql = "SELECT * FROM Customer WHERE CustomerID = ?";

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
			        ps.close();

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			ucs.getEdit().setOnAction(e -> {
		        String sql = "UPDATE Customer SET FullName=?, PhoneNumber=?, Email=?, Address=? WHERE CustomerID=?";

				try (Connection con = DatabaseConnection.getConnection();
				         PreparedStatement ps = con.prepareStatement(sql)) {
			        int id = Integer.parseInt(ucs.getCidT().getText().trim());

			        if (ucs.getNameT().getText().trim().isEmpty() ||
			            ucs.getPnT().getText().trim().isEmpty() ||
			            ucs.geteT().getText().trim().isEmpty() ||
			            ucs.getAddT().getText().trim().isEmpty()) {

			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Missing Data");
			            a.setHeaderText("Missing Data");
			            a.setContentText("Please fill all fields.");
			            a.showAndWait();
			            return;
			        }


			        ps.setString(1, ucs.getNameT().getText().trim());
			        ps.setString(2, ucs.getPnT().getText().trim());
			        ps.setString(3, ucs.geteT().getText().trim());
			        ps.setString(4, ucs.getAddT().getText().trim());
			        ps.setInt(5, id);

			        int updated = ps.executeUpdate();
			        ps.close();

			        if (updated > 0) {
			            Alert done = new Alert(Alert.AlertType.INFORMATION);
			            done.setTitle("Done");
			            done.setHeaderText("Customer Updated Successfully");
			            done.setContentText("Customer ID: " + id);
			            done.showAndWait();
			        }

			    } catch (Exception ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle(ex.getMessage());
			        a.setContentText(ex.getMessage());
			        a.showAndWait();
			    }
			});

			CustomerTableView ct=new CustomerTableView();

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
			
			AddDoctor ad=new AddDoctor();
			DeleteDoctor dd=new DeleteDoctor();
			UpdateDoctor ud=new UpdateDoctor();
			DoctorTableView dt=new DoctorTableView();

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
				        INSERT INTO Employee (EmpID, FullName, Position, Salary, BranchID)
				        VALUES (?, ?, ?, ?, ?)
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
			        SELECT EmpID, FullName, Qualification, ProfessionalLicenseNumber, Address,
			               NationalID, PhoneNumber, Email, Salary, BranchID
			        FROM Employee
			        WHERE EmpID = ?
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


			        String sql = "DELETE FROM Employee WHERE EmpID=?";

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
			        SELECT EmpID, FullName, Qualification, ProfessionalLicenseNumber, Address,
			               NationalID, PhoneNumber, Email, Salary, BranchID
			        FROM Employee
			        WHERE EmpID = ?
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

			    StringBuilder sql = new StringBuilder("UPDATE Employee SET ");
			    java.util.ArrayList<Object> params = new java.util.ArrayList<>();

			    if (!name.isEmpty()) {
			        sql.append("FullName=?, ");
			        params.add(name);
			    }
			    if (!position.isEmpty()) {
			        sql.append("Position=?, ");
			        params.add(position);
			    }
			    if (!st.isEmpty()) {
			        try {
			            double salary = Double.parseDouble(st);
			            sql.append("Salary=?, ");
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
			            sql.append("BranchID=?, ");
			            params.add(branchID);
			        } catch (Exception ex) {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle(ex.getMessage());
			            a.setContentText(ex.getMessage());
			            a.showAndWait();
			            return;
			        }
			    }

			    sql.setLength(sql.length() - 2);
			    sql.append(" WHERE EmpID=?");
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

			    String sql = "DELETE FROM Employee WHERE EmpID=?";

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
			DeleteIC dic=new DeleteIC();
			UpdateIC uic=new UpdateIC();
			InsuranceCompanyTableView ict=new InsuranceCompanyTableView();

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
			DeleteInvoice div=new DeleteInvoice();
			UpdateInvoice uiv=new UpdateInvoice();
			InvoiceTableView it=new InvoiceTableView();
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
			Scene itscene = new Scene(it.getAll(),400,400);

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

			mb.getQ15().setOnAction(e ->{
				 primaryStage.setScene(ibtscene);
			});
			mb.getQ17().setOnAction(e -> {
				primaryStage.setScene(sttscene);
			});
			mb.getQ18().setOnAction(e -> primaryStage.setScene(itscene));
			mb.getQ19().setOnAction(e -> primaryStage.setScene(itscene));
			mb.getQ20().setOnAction(e -> primaryStage.setScene(itscene));
			mb.getQ32().setOnAction(e -> primaryStage.setScene(itscene));
			mb.getQ33().setOnAction(e -> primaryStage.setScene(itscene));
			
			AddInvoiceItem aivi=new AddInvoiceItem();
			DeleteInvoiceItem divi=new DeleteInvoiceItem();
			UpdateInvoiceItem uivi=new UpdateInvoiceItem();
			InvoiceItemTableView iit=new InvoiceItemTableView();

			Scene aiviscene = new Scene(aivi.getAll(),400,400);
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
			DeleteIP dip=new DeleteIP();
			UpdateIP uip=new UpdateIP();
			InsurancePolicyTableView ipt=new InsurancePolicyTableView();

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
			DeleteMedicine dmed=new DeleteMedicine();
			UpdateMedicine umed=new UpdateMedicine();
			MedicineTableView mt=new MedicineTableView();
			
			Scene amedscene = new Scene(amed.getAll(),400,400);
			Scene dmedscene = new Scene(dmed.getAll(),400,400);
			Scene umedscene = new Scene(umed.getAll(),400,400);
			Scene mtscene = new Scene(mt.getAll(),400,400);

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

			mb.getQ4().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ9().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ10().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ11().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ12().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ13().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ14().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ16().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ24().setOnAction(e -> primaryStage.setScene(mtscene));
			mb.getQ25().setOnAction(e -> primaryStage.setScene(mtscene));
			
			AddPayment apay=new AddPayment();
			DeletePayment dpay=new DeletePayment();
			UpdatePayment upay=new UpdatePayment();
			PaymentTableView payt=new PaymentTableView();

			Scene apayscene = new Scene(apay.getAll(),400,400);
			Scene dpayscene = new Scene(dpay.getAll(),400,400);
			Scene upayscene = new Scene(upay.getAll(),400,400);
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
			
			AddPerMed apermed=new AddPerMed();
			DeletePerMed dpermed=new DeletePerMed();
			UpdatePerMed upermed=new UpdatePerMed();

			Scene apermedscene = new Scene(apermed.getAll(),400,400);
			Scene dpermedscene = new Scene(dpermed.getAll(),400,400);
			Scene upermedscene = new Scene(upermed.getAll(),400,400);

			mb.getAperMed().setOnAction(e->{
				primaryStage.setScene(apermedscene);
			});
			mb.getDperMed().setOnAction(e->{
				primaryStage.setScene(dpermedscene);
			});
			mb.getUperMed().setOnAction(e->{
				primaryStage.setScene(upermedscene);
			});
			
			AddPre aper=new AddPre();
			DeletePre dper=new DeletePre();
			UpdatePre uper=new UpdatePre();
			PrescriptionTableView pert=new PrescriptionTableView();

			Scene aperscene = new Scene(aper.getAll(),400,400);
			Scene dperscene = new Scene(dper.getAll(),400,400);
			Scene uperscene = new Scene(uper.getAll(),400,400);
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
			
			AddPurchase apur=new AddPurchase();
			DeletePurchase dpur=new DeletePurchase();
			UpdatePurchase upur=new UpdatePurchase();
			PurchaseTableView purt=new PurchaseTableView();

			Scene apurscene = new Scene(apur.getAll(),400,400);
			Scene dpurscene = new Scene(dpur.getAll(),400,400);
			Scene upurscene = new Scene(upur.getAll(),400,400);
			Scene purtscene = new Scene(purt.getAll(),400,400);

			mb.getApur().setOnAction(e->{
				primaryStage.setScene(apurscene);
			});
			mb.getDpur().setOnAction(e->{
				primaryStage.setScene(dpurscene);
			});
			mb.getUpur().setOnAction(e->{
				primaryStage.setScene(upurscene);
			});
			mb.getPurt().setOnAction(e->{
				primaryStage.setScene(purtscene);
			});
			
			AddSupplier asup=new AddSupplier();
			DeleteSupplier dsup=new DeleteSupplier();
			UpdateSupplier usup=new UpdateSupplier();
			SupplierTableView st=new SupplierTableView();
			
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

			mb.getQ21().setOnAction(e -> primaryStage.setScene(stscene));
			mb.getQ22().setOnAction(e -> primaryStage.setScene(stscene));
			mb.getQ23().setOnAction(e -> primaryStage.setScene(stscene));

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
			
			aivi.getBack().setOnAction(e->{
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
			
			apur.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			dpur.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			upur.getBack().setOnAction(e->{
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
			iit.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			et.getBack().setOnAction(e->{
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
			purt.getBack().setOnAction(e->{
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
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	private ObservableList<Employee> loadAllEmployes() {
	    ObservableList<Employee> list = FXCollections.observableArrayList();

	    String sql = """
	        SELECT EmpID, FullName, Qualification, PhoneNumber, Salary, BranchID
	        FROM Employee
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
	        SELECT EmpID, FullName, Qualification, PhoneNumber, Salary, BranchID
	        FROM Employee
	        WHERE EmpID = ?
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
	            SELECT e.FullName, e.Qualification, e.Salary, b.BranchName
	            FROM Employee e
	            JOIN Branch b ON e.BranchID = b.BranchID
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
	            SELECT e.FullName, e.Qualification, e.Salary, b.BranchName
	            FROM Employee e
	            JOIN Branch b ON e.BranchID = b.BranchID
	            WHERE b.BranchID = ?
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
	            SELECT BranchID, BranchName, Address, PhoneNumber, Email
	            FROM Branch
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
	            SELECT BranchID, BranchName, Address, PhoneNumber, Email
	            FROM Branch
	            WHERE BranchID = ?
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
	        SELECT CategoryID, CategoryName, Description
	        FROM Category
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
	        SELECT CategoryID, CategoryName, Description
	        FROM Category
	        WHERE CategoryID = ?
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

}
