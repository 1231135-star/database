package application;

public class InvoiceQ33Row {
    private int branchID;
    private String branchName;
    private double totalSales;
    private double totalProfit;
    private String bestSellingMedicine;
    private int bestSellingQty;

    public InvoiceQ33Row(int branchID, String branchName, double totalSales, double totalProfit,
                         String bestSellingMedicine, int bestSellingQty) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.totalSales = totalSales;
        this.totalProfit = totalProfit;
        this.bestSellingMedicine = bestSellingMedicine;
        this.bestSellingQty = bestSellingQty;
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

	public String getBestSellingMedicine() {
		return bestSellingMedicine;
	}

	public void setBestSellingMedicine(String bestSellingMedicine) {
		this.bestSellingMedicine = bestSellingMedicine;
	}

	public int getBestSellingQty() {
		return bestSellingQty;
	}

	public void setBestSellingQty(int bestSellingQty) {
		this.bestSellingQty = bestSellingQty;
	}

    
}
