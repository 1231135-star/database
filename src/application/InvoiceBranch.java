package application;

import java.time.LocalDate;

public class InvoiceBranch {
    private int invoiceID;
    private LocalDate invoiceDate;
    private double totalAmount;
    private String branchName;

    public InvoiceBranch(int invoiceID, LocalDate invoiceDate, double totalAmount, String branchName) {
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

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
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
