package application;
import java.time.LocalDate;

public class Purchase {
	
	    private int purchaseID;
	    private LocalDate purchaseDate;
	    private double totalCost;
	    private int supplierID;
	    private int branchID;

	    public Purchase() {}

	    public Purchase(int purchaseID, LocalDate purchaseDate,
	                    double totalCost, int supplierID, int branchID) {
	        this.purchaseID = purchaseID;
	        this.purchaseDate = purchaseDate;
	        this.totalCost = totalCost;
	        this.supplierID = supplierID;
	        this.branchID = branchID;
	    }

	    public int getPurchaseID() {
	        return purchaseID;
	    }

	    public void setPurchaseID(int purchaseID) {
	        this.purchaseID = purchaseID;
	    }

	    public LocalDate getPurchaseDate() {
	        return purchaseDate;
	    }

	    public void setPurchaseDate(LocalDate purchaseDate) {
	        this.purchaseDate = purchaseDate;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }

	    public void setTotalCost(double totalCost) {
	        this.totalCost = totalCost;
	    }

	    public int getSupplierID() {
	        return supplierID;
	    }

	    public void setSupplierID(int supplierID) {
	        this.supplierID = supplierID;
	    }

	    public int getBranchID() {
	        return branchID;
	    }

	    public void setBranchID(int branchID) {
	        this.branchID = branchID;
	    }
	}


