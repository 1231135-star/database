package application;

public class InvoiceQ20Row {
    private int branchID;
    private String branchName;
    private double totalSales;
    private double totalProfit;

    public InvoiceQ20Row(int branchID, String branchName, double totalSales, double totalProfit) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.totalSales = totalSales;
        this.totalProfit = totalProfit;
    }

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

	public double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}

}
