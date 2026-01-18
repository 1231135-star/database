package application;

import java.time.LocalDate;
import java.time.LocalTime;

public class Invoice {

    private int invoiceID;
    private LocalDate invoiceDate;
    private LocalTime invoiceTime;

    private double subtotal;
    private double discount;
    private double tax;
    private double totalAmount;

    private String paymentStatus;

    private int customerID;
    private int empID;
    private int branchID;

    public Invoice(int invoiceID, LocalDate invoiceDate, LocalTime invoiceTime,
                   double subtotal, double discount, double tax, double totalAmount,
                   String paymentStatus, int customerID, int empID, int branchID) {

        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.invoiceTime = invoiceTime;
        this.subtotal = subtotal;
        this.discount = discount;
        this.tax = tax;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.customerID = customerID;
        this.empID = empID;
        this.branchID = branchID;
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

	public LocalTime getInvoiceTime() {
		return invoiceTime;
	}

	public void setInvoiceTime(LocalTime invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

    
}
