package application;

public class InvoiceQ15Row {

	private int invoiceID;
	private String invoiceDate;
	private double totalAmount;
	private String branchName;

	public InvoiceQ15Row(int invoiceID, String invoiceDate, double totalAmount, String branchName) {
		this.invoiceID = invoiceID;
		this.invoiceDate = invoiceDate;
		this.totalAmount = totalAmount;
		this.branchName = branchName;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
