package application;

public class InvoiceQ18Row {
    private double totalSales;
    private double totalPurchases;

    public InvoiceQ18Row(double totalSales, double totalPurchases) {
        this.totalSales = totalSales;
        this.totalPurchases = totalPurchases;
    }

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

	public double getTotalPurchases() {
		return totalPurchases;
	}

	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases = totalPurchases;
	}

}
