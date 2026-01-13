package application;
import java.time.LocalDate;

public class InventoryItem {
	
	    private int inventoryItemID;
	    private int medicineID;
	    private int supplierID;
	    private int branchID;
	    private int quantity;
	    private LocalDate expiryDate;
	    private double purchasePrice;

	    public InventoryItem() {}

	    public InventoryItem(int inventoryItemID, int medicineID, int supplierID,
	                         int branchID, int quantity,
	                         LocalDate expiryDate, double purchasePrice) {
	        this.inventoryItemID = inventoryItemID;
	        this.medicineID = medicineID;
	        this.supplierID = supplierID;
	        this.branchID = branchID;
	        this.quantity = quantity;
	        this.expiryDate = expiryDate;
	        this.purchasePrice = purchasePrice;
	    }

	    public int getInventoryItemID() {
	        return inventoryItemID;
	    }

	    public void setInventoryItemID(int inventoryItemID) {
	        this.inventoryItemID = inventoryItemID;
	    }

	    public int getMedicineID() {
	        return medicineID;
	    }

	    public void setMedicineID(int medicineID) {
	        this.medicineID = medicineID;
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

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public LocalDate getExpiryDate() {
	        return expiryDate;
	    }

	    public void setExpiryDate(LocalDate expiryDate) {
	        this.expiryDate = expiryDate;
	    }

	    public double getPurchasePrice() {
	        return purchasePrice;
	    }

	    public void setPurchasePrice(double purchasePrice) {
	        this.purchasePrice = purchasePrice;
	    }
	}


