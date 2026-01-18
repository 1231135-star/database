package application;

import java.time.LocalDate;

public class Payment {

    private int paymentID;
    private LocalDate paymentDate;
    private String paymentType;
    private double amount;
    private String referenceNumber; 
    private int invoiceID;
    private int policyID; 

    public Payment() {}

    public Payment(int paymentID, LocalDate paymentDate, String paymentType,double amount, String referenceNumber, int invoiceID, int policyID) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.invoiceID = invoiceID;
        this.policyID = policyID;
    }

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public int getPolicyID() {
		return policyID;
	}

	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

  
}
