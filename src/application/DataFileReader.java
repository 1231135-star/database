package application;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import javafx.scene.control.Alert;

public class DataFileReader {


	 private boolean checknull(String x, String msg) {
	        
	    	try{if (x == null || x.trim().isEmpty() || x.trim().equalsIgnoreCase("null")) {
	            throw new Exception("Missing value: " + msg);
	        }
	        return true;
	    }catch(Exception e) {
	    	  Alert a = new Alert(Alert.AlertType.ERROR);
	          a.setTitle(e.getMessage());
	          a.setContentText(e.getMessage());
	          a.showAndWait();
	        return false;

	    }}

    private String get(String[] parts, int idx) {
        if (idx >= parts.length) {
        	return null;
        }
        if(parts[idx] == null) {
        	return null;
        }
        else {
        	return parts[idx].trim();
        }
    }

    private boolean isNull(String x) {
    	if(x == null || x.trim().isEmpty() || x.trim().equalsIgnoreCase("null")) {
            return true ;
    	}
    	else {
        return false ;
    }}

    private Integer parseIntOrNull(String x) {
        if (isNull(x)) {
        	return null;
        }
        return Integer.parseInt(x.trim());
    }

    private BigDecimal parseDecOrNull(String x) {
        if (isNull(x)) {
        	return null;
        }
        return new BigDecimal(x.trim());
    }

    private Date parseDateOrNull(String x) {
        if (isNull(x)) {
        	return null;
        }
        return Date.valueOf(LocalDate.parse(x.trim()));
    }

    private Time parseTimeOrNull(String x) {
        if (isNull(x)) {
        	return null;
        }
        return Time.valueOf(x.trim()); 
    }

    private Boolean parseBoolOrNull(String x) {
        try{if (isNull(x)) {
        	return null;
        }
        x = x.trim().toLowerCase();
        if (x.equals("1") || x.equals("true") || x.equals("yes")) {
        	return true;
        }
        if (x.equals("0") || x.equals("false") || x.equals("no")) {
        	return false;
        }
        throw new Exception("Invalid boolean: " + x);}
        catch(Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
        	return false;

        }
    }

   

  
    public int readBranch(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into branch
                (branchid, branchname, address, phonenumber, email, managerid, whstart, whend, weeklyholiday)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "branchid in line " + lineNo);
                checknull(get(parts, 1), "branchname in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));

                setVarchar(ps, 3, get(parts, 2));
                setVarchar(ps, 4, get(parts, 3));
                setVarchar(ps, 5, get(parts, 4));

                setInt(ps, 6, parseIntOrNull(get(parts, 5)));
                setTime(ps, 7, parseTimeOrNull(get(parts, 6)));
                setTime(ps, 8, parseTimeOrNull(get(parts, 7)));

                setVarchar(ps, 9, get(parts, 8));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
              return 0;
        }

        return loaded;
    }

  
    public int readCategory(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into category (categoryid, categoryname, description)
                values (?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "categoryid in line " + lineNo);
                checknull(get(parts, 1), "categoryname in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));
                setVarchar(ps, 3, get(parts, 2));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }
        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }

        return loaded;
    }


    public int readSupplier(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into supplier (supplierid, suppliername, licenseno, phonenumber, email, address)
                values (?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "supplierid in line " + lineNo);
                checknull(get(parts, 1), "suppliername in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));

                setVarchar(ps, 3, get(parts, 2));
                setVarchar(ps, 4, get(parts, 3));
                setVarchar(ps, 5, get(parts, 4));
                setVarchar(ps, 6, get(parts, 5));

                if (ps.executeUpdate() > 0) loaded++;
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();       
              return 0;
        }

        return loaded;
    }

    
    public int readCustomer(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into customer (customerid, fullname, phonenumber, email, address, dateofbirth, gender)
                values (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);
                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "customerid in line " + lineNo);
                checknull(get(parts, 1), "fullname in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));
                setVarchar(ps, 3, get(parts, 2));
                setVarchar(ps, 4, get(parts, 3));
                setVarchar(ps, 5, get(parts, 4));
                setDate(ps, 6, parseDateOrNull(get(parts, 5)));
                setVarchar(ps, 7, get(parts, 6));

                if (ps.executeUpdate() > 0) loaded++;
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();         
              return 0;
        }

        return loaded;
    }
    public int readInsuranceCompany(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into insurance_company
                (insurancecompanyid, companyname, licenseno, phonenumber, email, address)
                values (?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "insurancecompanyid in line " + lineNo);
                checknull(get(parts, 1), "companyname in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));
                setVarchar(ps, 3, get(parts, 2));
                setVarchar(ps, 4, get(parts, 3));
                setVarchar(ps, 5, get(parts, 4));
                setVarchar(ps, 6, get(parts, 5));

                if (ps.executeUpdate() > 0) loaded++;
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }
        return loaded;
    }

   
    public int readDoctor(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into doctor (doctorid, fullname, licensenumber, phonenumber, email, clinicaddress)
                values (?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);
                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "doctorid in line " + lineNo);
                checknull(get(parts, 1), "fullname in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));
                setVarchar(ps, 3, get(parts, 2));
                setVarchar(ps, 4, get(parts, 3));
                setVarchar(ps, 5, get(parts, 4));
                setVarchar(ps, 6, get(parts, 5));

                if (ps.executeUpdate() > 0) loaded++;
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
              return 0;
        }

        return loaded;
    }

    
    public int readMedicine(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into medicine (medicineid, medicinename, strength, requirespre, description, categoryid)
                values (?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);
                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "medicineid in line " + lineNo);
                checknull(get(parts, 1), "medicinename in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));
                setVarchar(ps, 3, get(parts, 2));

                Boolean req = parseBoolOrNull(get(parts, 3));
                if (req == null) ps.setNull(4, Types.BOOLEAN);
                else ps.setBoolean(4, req);

                setVarchar(ps, 5, get(parts, 4));
                setInt(ps, 6, parseIntOrNull(get(parts, 5)));

                if (ps.executeUpdate() > 0) loaded++;
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
              return 0;
        }

        return loaded;
    }


    public int readEmployee(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into employee
                (empid, fullname, qualification, licenseno, address, nationalid, phonenumber, email, salary, branchid)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "empid in line " + lineNo);
                checknull(get(parts, 1), "fullname in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setString(2, get(parts, 1));

                setVarchar(ps, 3, get(parts, 2)); 
                setVarchar(ps, 4, get(parts, 3)); 
                setVarchar(ps, 5, get(parts, 4)); 
                setVarchar(ps, 6, get(parts, 5));
                setVarchar(ps, 7, get(parts, 6)); 
                setVarchar(ps, 8, get(parts, 7));
                setDec(ps, 9, parseDecOrNull(get(parts, 8)));
                setInt(ps, 10, parseIntOrNull(get(parts, 9)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
              return 0;
        }
        return loaded;
    }

 
    public int readInsurancePolicy(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into insurance_policy
                (policyid, policynumber, issuedate, expirydate, coveragepercentage, customerid, insurancecompanyid)
                values (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "policyid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                setVarchar(ps, 2, get(parts, 1));
                setDate(ps, 3, parseDateOrNull(get(parts, 2)));
                setDate(ps, 4, parseDateOrNull(get(parts, 3)));
                setInt(ps, 5, parseIntOrNull(get(parts, 4)));
                setInt(ps, 6, parseIntOrNull(get(parts, 5)));
                setInt(ps, 7, parseIntOrNull(get(parts, 6)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
              return 0;
        }
        return loaded;
    }

   
    public int readInventoryItem(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into inventory_item
                (inventoryitemid, batchnumber, quantityavailable, expirydate, receiveddate, purchaseprice,
                 medicineid, supplierid, branchid)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "inventoryitemid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                setVarchar(ps, 2, get(parts, 1));
                setInt(ps, 3, parseIntOrNull(get(parts, 2)));
                setDate(ps, 4, parseDateOrNull(get(parts, 3)));
                setDate(ps, 5, parseDateOrNull(get(parts, 4)));
                setDec(ps, 6, parseDecOrNull(get(parts, 5)));
                setInt(ps, 7, parseIntOrNull(get(parts, 6)));
                setInt(ps, 8, parseIntOrNull(get(parts, 7)));
                setInt(ps, 9, parseIntOrNull(get(parts, 8)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }

        return loaded;
    }

    
    public int readInvoice(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into invoice
                (invoiceid, invoicedate, invoicetime, subtotal, discount, tax, totalamount,
                 paymentstatus, customerid, empid, branchid)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                	throw new Exception("empty line in line number: " + lineNo);
                }

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "invoiceid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                setDate(ps, 2, parseDateOrNull(get(parts, 1)));
                setTime(ps, 3, parseTimeOrNull(get(parts, 2)));
                setDec(ps, 4, parseDecOrNull(get(parts, 3)));
                setDec(ps, 5, parseDecOrNull(get(parts, 4)));
                setDec(ps, 6, parseDecOrNull(get(parts, 5)));
                setDec(ps, 7, parseDecOrNull(get(parts, 6)));
                setVarchar(ps, 8, get(parts, 7));
                setInt(ps, 9, parseIntOrNull(get(parts, 8)));
                setInt(ps, 10, parseIntOrNull(get(parts, 9)));
                setInt(ps, 11, parseIntOrNull(get(parts, 10)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }
        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
              return 0;
        }

        return loaded;
    }

  
    public int readInvoiceItem(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into invoice_item
                (invoiceid, inventoryitemid, quantity, unitprice, linetotal)
                values (?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                	throw new Exception("empty line in line number: " + lineNo);
                }

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "invoiceid in line " + lineNo);
                checknull(get(parts, 1), "inventoryitemid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setInt(2, Integer.parseInt(get(parts, 1)));
                setInt(ps, 3, parseIntOrNull(get(parts, 2)));
                setDec(ps, 4, parseDecOrNull(get(parts, 3)));
                setDec(ps, 5, parseDecOrNull(get(parts, 4)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }

        return loaded;
    }

    
    public int readPayment(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into payment
                (paymentid, paymentdate, paymenttype, amount, referencenumber, invoiceid, policyid)
                values (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                	throw new Exception("empty line in line number: " + lineNo);
                }

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "paymentid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                setDate(ps, 2, parseDateOrNull(get(parts, 1)));
                setVarchar(ps, 3, get(parts, 2));
                setDec(ps, 4, parseDecOrNull(get(parts, 3)));
                setVarchar(ps, 5, get(parts, 4));
                setInt(ps, 6, parseIntOrNull(get(parts, 5)));
                setInt(ps, 7, parseIntOrNull(get(parts, 6)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait(); 
              return 0;
        }
        return loaded;
    }

   
    public int readPrescription(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) {
        	return 0;
        }

        String sql = """
                insert into prescription (prescriptionid, issuedate, notes, doctorid, invoiceid)
                values (?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                	throw new Exception("empty line in line number: " + lineNo);
                }

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "prescriptionid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                setDate(ps, 2, parseDateOrNull(get(parts, 1)));
                setVarchar(ps, 3, get(parts, 2));
                setInt(ps, 4, parseIntOrNull(get(parts, 3)));
                setInt(ps, 5, parseIntOrNull(get(parts, 4)));

                if (ps.executeUpdate() > 0) {
                	loaded++;
                }
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }

        return loaded;
    }

    
    public int readPrescriptionMedicine(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) return 0;

        String sql = """
                insert into prescription_medicine (prescriptionid, medicineid, dosage)
                values (?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "prescriptionid in line " + lineNo);
                checknull(get(parts, 1), "medicineid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setInt(2, Integer.parseInt(get(parts, 1)));
                setVarchar(ps, 3, get(parts, 2));

                if (ps.executeUpdate() > 0) loaded++;
            }
        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();            return 0;
        }

        return loaded;
    }

    
    public int readPurchase(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) return 0;

        String sql = """
                insert into purchase
                (purchaseid, purchasedate, totalcost, paymentstatus, supplierid, branchid)
                values (?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;
            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "purchaseid in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                setDate(ps, 2, parseDateOrNull(get(parts, 1)));
                setDec(ps, 3, parseDecOrNull(get(parts, 2)));
                setVarchar(ps, 4, get(parts, 3));
                setInt(ps, 5, parseIntOrNull(get(parts, 4)));
                setInt(ps, 6, parseIntOrNull(get(parts, 5)));

                if (ps.executeUpdate() > 0) loaded++;
            }
        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }

        return loaded;
    }

   
    public int readDamagedWithdrawn(File file) {
        int loaded = 0;
        if (file == null || !file.exists()) return 0;

        String sql = """
                insert into damagedwithdrawn
                (dwid, inventoryitemid, branchid, quantity, actiontype, lossamount, dwdate, notes)
                values (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
             Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int lineNo = 0;

            while (sc.hasNextLine()) {
                lineNo++;
                String line = sc.nextLine().trim();
                if (line.isEmpty()) throw new Exception("empty line in line number: " + lineNo);

                String[] parts = line.split(";", -1);

                checknull(get(parts, 0), "dwid in line " + lineNo);
                checknull(get(parts, 1), "inventoryitemid in line " + lineNo);
                checknull(get(parts, 2), "branchid in line " + lineNo);
                checknull(get(parts, 3), "quantity in line " + lineNo);

                checknull(get(parts, 4), "actiontype in line " + lineNo);
                checknull(get(parts, 5), "lossamount in line " + lineNo);
                checknull(get(parts, 6), "dwdate in line " + lineNo);

                ps.setInt(1, Integer.parseInt(get(parts, 0)));
                ps.setInt(2, Integer.parseInt(get(parts, 1)));
                ps.setInt(3, Integer.parseInt(get(parts, 2)));
                ps.setInt(4, Integer.parseInt(get(parts, 3)));

                ps.setString(5, get(parts, 4));
                ps.setBigDecimal(6, parseDecOrNull(get(parts, 5))); 
                ps.setDate(7, parseDateOrNull(get(parts, 6)));      
                setVarchar(ps, 8, get(parts, 7));

                if (ps.executeUpdate() > 0) loaded++;
            }

        } catch (Exception e) {
        	  Alert a = new Alert(Alert.AlertType.ERROR);
              a.setTitle(e.getMessage());
              a.setContentText(e.getMessage());
              a.showAndWait();
            return 0;
        }

        return loaded;
    }
    public int readAll(
            File branchFile,
            File categoryFile,
            File supplierFile,
            File customerFile,
            File insuranceCompanyFile,
            File doctorFile,
            File medicineFile,
            File employeeFile,
            File insurancePolicyFile,
            File inventoryItemFile,
            File invoiceFile,
            File invoiceItemFile,
            File paymentFile,
            File prescriptionFile,
            File prescriptionMedicineFile,
            File purchaseFile,
            File damagedWithdrawnFile
    ) {
        int totalLoaded = 0;

        try {
            int b = readBranch(branchFile); 
            totalLoaded += b;
            int cat = readCategory(categoryFile);
            totalLoaded += cat;
            int sup = readSupplier(supplierFile);
            totalLoaded += sup;
            int cus = readCustomer(customerFile);
            totalLoaded += cus;
            int ic = readInsuranceCompany(insuranceCompanyFile);
            totalLoaded += ic;
            int doc = readDoctor(doctorFile); 
            totalLoaded += doc;
            int med = readMedicine(medicineFile);
            totalLoaded += med;
            int emp = readEmployee(employeeFile);
            totalLoaded += emp;
            int pol = readInsurancePolicy(insurancePolicyFile);
            totalLoaded += pol;
            int invItem = readInventoryItem(inventoryItemFile);
            totalLoaded += invItem;
            int inv = readInvoice(invoiceFile); 
            totalLoaded += inv;
            int invI = readInvoiceItem(invoiceItemFile);  
            totalLoaded += invI;
            int pay = readPayment(paymentFile);  
            totalLoaded += pay;
            int pres = readPrescription(prescriptionFile); 
            totalLoaded += pres;
            int presMed = readPrescriptionMedicine(prescriptionMedicineFile);
            totalLoaded += presMed;
            int pur = readPurchase(purchaseFile);  
            totalLoaded += pur;
            int dw = readDamagedWithdrawn(damagedWithdrawnFile); 
            totalLoaded += dw;

            String report =
                    "Data Load Finished!\n\n" +
                    "Branch: " + b + "\n" +
                    "Category: " + cat + "\n" +
                    "Supplier: " + sup + "\n" +
                    "Customer: " + cus + "\n" +
                    "Insurance Company: " + ic + "\n" +
                    "Doctor: " + doc + "\n" +
                    "Medicine: " + med + "\n" +
                    "Employee: " + emp + "\n" +
                    "Insurance Policy: " + pol + "\n" +
                    "Inventory Item: " + invItem + "\n" +
                    "Invoice: " + inv + "\n" +
                    "Invoice Item: " + invI + "\n" +
                    "Payment: " + pay + "\n" +
                    "Prescription: " + pres + "\n" +
                    "Prescription Medicine: " + presMed + "\n" +
                    "Purchase: " + pur + "\n" +
                    "DamagedWithdrawn: " + dw + "\n\n" +
                    "TOTAL LOADED = " + totalLoaded;

            Alert done = new Alert(Alert.AlertType.INFORMATION);
            done.setTitle("Load Report");
            done.setHeaderText("Database loaded successfully");
            done.setContentText(report);
            done.showAndWait();

        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("readAll Failed");
            a.setHeaderText("Error while loading files ❌");
            a.setContentText(e.getMessage());
            a.showAndWait();
            return 0;
        }

        return totalLoaded;
    }


    private void setVarchar(PreparedStatement ps, int idx, String v) throws SQLException {
        if (isNull(v)) ps.setNull(idx, Types.VARCHAR);
        else ps.setString(idx, v);
    }

    private void setInt(PreparedStatement ps, int idx, Integer v) throws SQLException {
        if (v == null) ps.setNull(idx, Types.INTEGER);
        else ps.setInt(idx, v);
    }

    private void setDec(PreparedStatement ps, int idx, BigDecimal v) throws SQLException {
        if (v == null) ps.setNull(idx, Types.DECIMAL);
        else ps.setBigDecimal(idx, v);
    }

    private void setDate(PreparedStatement ps, int idx, Date v) throws SQLException {
        if (v == null) ps.setNull(idx, Types.DATE);
        else ps.setDate(idx, v);
    }

    private void setTime(PreparedStatement ps, int idx, Time v) throws SQLException {
        if (v == null) ps.setNull(idx, Types.TIME);
        else ps.setTime(idx, v);
    }
}
