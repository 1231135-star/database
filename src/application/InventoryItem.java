package application;

import java.time.LocalDate;

public class InventoryItem {

    private int inventoryitemid;
    private String batchnumber;
    private int quantityavailable;
    private LocalDate expirydate;
    private LocalDate receiveddate;
    private double purchaseprice;

    private int medicineid;
    private int supplierid;
    private int branchid;

    public InventoryItem(int inventoryitemid, String batchnumber, int quantityavailable,
                         LocalDate expirydate, LocalDate receiveddate, double purchaseprice,
                         int medicineid, int supplierid, int branchid) {

        this.inventoryitemid = inventoryitemid;
        this.batchnumber = batchnumber;
        this.quantityavailable = quantityavailable;
        this.expirydate = expirydate;
        this.receiveddate = receiveddate;
        this.purchaseprice = purchaseprice;
        this.medicineid = medicineid;
        this.supplierid = supplierid;
        this.branchid = branchid;
    }

	public int getInventoryitemid() {
		return inventoryitemid;
	}

	public void setInventoryitemid(int inventoryitemid) {
		this.inventoryitemid = inventoryitemid;
	}

	public String getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}

	public int getQuantityavailable() {
		return quantityavailable;
	}

	public void setQuantityavailable(int quantityavailable) {
		this.quantityavailable = quantityavailable;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public LocalDate getReceiveddate() {
		return receiveddate;
	}

	public void setReceiveddate(LocalDate receiveddate) {
		this.receiveddate = receiveddate;
	}

	public double getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

}
