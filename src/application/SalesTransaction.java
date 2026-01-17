package application;

import java.time.LocalDate;

public class SalesTransaction {
    private int invoiceID;
    private LocalDate invoiceDate;
    private String employeeName;
    private double totalAmount;

    public SalesTransaction(int invoiceID, LocalDate invoiceDate, String employeeName, double totalAmount) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.employeeName = employeeName;
        this.totalAmount = totalAmount;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

   
}
