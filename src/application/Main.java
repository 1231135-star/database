package application;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import javafx.application.Application;
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
			DeleteBranch db=new DeleteBranch();
			UpdateBranch ub=new UpdateBranch(); 
			BranchTableView bt=new BranchTableView();
			BranchNAPTable napt=new BranchNAPTable();

			Scene abscene = new Scene(ab.getAll(),400,400);
			Scene dbscene = new Scene(db.getAll(),400,400);
			Scene ubscene = new Scene(ub.getAll(),400,400);
			Scene btscene = new Scene(bt.getAll(),400,400);
			Scene naptscene = new Scene(napt.getAll(),400,400);

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
			mb.getNapt().setOnAction(e->{
				primaryStage.setScene(naptscene);
			});
			
			AddCategory ac=new AddCategory();
			DeleteCategory dc=new DeleteCategory();
			UpdateCategory uc=new UpdateCategory();
			CategoryTableView catt=new CategoryTableView();
			
			Scene acscene = new Scene(ac.getAll(),400,400);
			Scene dcscene = new Scene(dc.getAll(),400,400);
			Scene ucscene = new Scene(uc.getAll(),400,400);
			Scene cattscene = new Scene(catt.getAll(),400,400);

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
			DeleteCustomer dcs=new DeleteCustomer();
			UpdateCustomer ucs=new UpdateCustomer();
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
			        SELECT EmpID, FullName, Qualification, Professionalേഴ്LicenseNumber, Address,
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

			            if (val instanceof Integer) ps.setInt(i + 1, (Integer) val);
			            else if (val instanceof Double) ps.setDouble(i + 1, (Double) val);
			            else ps.setString(i + 1, val.toString());
			        }

			        int rows = ps.executeUpdate();

			        if (rows > 0) {
			            Alert a = new Alert(Alert.AlertType.INFORMATION);
			            a.setTitle("Updated");
			            a.setHeaderText(null);
			            a.setContentText("employee updated successfuly!");
			            a.showAndWait();

			            ue.getEmpIDT().clear();
			            ue.getEmpNT().clear();
			            ue.getPnT().clear();
			            ue.getsT().clear();
			            ue.getBidT().clear();
			        } else {
			            Alert a = new Alert(Alert.AlertType.ERROR);
			            a.setTitle("Not Found");
			            a.setHeaderText(null);
			            a.setContentText("Employee ID not found!");
			            a.showAndWait();
			        }

			    } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Update Failed");
			        a.setHeaderText(null);
			        a.setContentText("BranchID not found OR constraint error!");
			        a.showAndWait();
			    } catch (Exception ex) {
			        ex.printStackTrace();
			        Alert a = new Alert(Alert.AlertType.ERROR);
			        a.setTitle("Database Error");
			        a.setHeaderText(null);
			        a.setContentText("Error while updating employee!");
			        a.showAndWait();
			    }
			});

			
			EmployeeTableView et=new EmployeeTableView();
			EmployeeBranchTableView ebt=new EmployeeBranchTableView();
			
			Scene aescene = new Scene(ae.getAll(),400,400);
			Scene descene = new Scene(de.getAll(),400,400);
			Scene uescene = new Scene(ue.getAll(),400,400);
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
				primaryStage.setScene(etscene);
			});
			mb.getEbt().setOnAction(e->{
				primaryStage.setScene(ebtscene);
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
			MedQTable mebt=new MedQTable();
			MedQTable mebt2=new MedQTable();
			MedStockTable medStock=new MedStockTable();
			SupMedInvTable supMedInv=new SupMedInvTable();
			MedByCat medByCat=new MedByCat();
			MostSoldMedTable most=new MostSoldMedTable();
			
			Scene amedscene = new Scene(amed.getAll(),400,400);
			Scene dmedscene = new Scene(dmed.getAll(),400,400);
			Scene umedscene = new Scene(umed.getAll(),400,400);
			Scene mtscene = new Scene(mt.getAll(),400,400);
			Scene mebtscene = new Scene(mebt.getAll(),400,400);
			Scene mebt2scene = new Scene(mebt2.getAll(),400,400);
			Scene medStockscene = new Scene(medStock.getAll(),400,400);
			Scene supMedInvscene = new Scene(supMedInv.getAll(),400,400);
			Scene medByCatscene = new Scene(medByCat.getAll(),400,400);
			Scene mostscene = new Scene(most.getAll(),400,400);

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
			mb.getMebt().setOnAction(e->{
				primaryStage.setScene(mebtscene);
			});
			mb.getMebt2().setOnAction(e->{
				primaryStage.setScene(mebt2scene);
			});
			mb.getMedStock().setOnAction(e->{
				primaryStage.setScene(medStockscene);
			});
			mb.getSupMedInv().setOnAction(e->{
				primaryStage.setScene(supMedInvscene);
			});
			mb.getMedByCat().setOnAction(e->{
				primaryStage.setScene(medByCatscene);
			});
			mb.getMostSold().setOnAction(e->{
				primaryStage.setScene(mostscene);
			});
			
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

			AddInventoryItem ain=new AddInventoryItem();
			DeleteInventoryItem din=new DeleteInventoryItem();
			UpdateInventoryItem uin=new UpdateInventoryItem();
			InventoryItemTableView intt=new InventoryItemTableView();
			invQTable intqt=new invQTable();

			Scene ainscene = new Scene(ain.getAll(),400,400);
			Scene dinscene = new Scene(din.getAll(),400,400);
			Scene uinscene = new Scene(uin.getAll(),400,400);
			Scene inttscene = new Scene(intt.getAll(),400,400);
			Scene intqtscene = new Scene(intqt.getAll(),400,400);

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
			mb.getInnqt().setOnAction(e->{
				primaryStage.setScene(intqtscene);
			});
			mb.getExit().setOnAction(e->{
				primaryStage.close();
			});
			
			Scene scene = new Scene(login.getAll(),400,400);
			Scene mainScene = new Scene(mb.getAll(), 900, 600);
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
			napt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			ebt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			intqt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			mebt.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			mebt2.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			medStock.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			supMedInv.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			medByCat.getBack().setOnAction(e->{
				primaryStage.setScene(mainScene);
			});
			most.getBack().setOnAction(e->{
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
}
