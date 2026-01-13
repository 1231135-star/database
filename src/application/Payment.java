package application;
import java.time.LocalDate;

public class Payment {
	
	    private int paymentID;
	    private String paymentType;
	    private double amount;
	    private LocalDate paymentDate;
	    private int invoiceID;
	    private int insurancePolicyID;

	    public Payment() {}

	    public Payment(int paymentID, String paymentType, double amount,
	                   LocalDate paymentDate, int invoiceID, int insurancePolicyID) {
	        this.paymentID = paymentID;
	        this.paymentType = paymentType;
	        this.amount = amount;
	        this.paymentDate = paymentDate;
	        this.invoiceID = invoiceID;
	        this.insurancePolicyID = insurancePolicyID;
	    }

	    public int getPaymentID() {
	        return paymentID;
	    }

	    public void setPaymentID(int paymentID) {
	        this.paymentID = paymentID;
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

	    public LocalDate getPaymentDate() {
	        return paymentDate;
	    }

	    public void setPaymentDate(LocalDate paymentDate) {
	        this.paymentDate = paymentDate;
	    }

	    public int getInvoiceID() {
	        return invoiceID;
	    }

	    public void setInvoiceID(int invoiceID) {
	        this.invoiceID = invoiceID;
	    }

	    public int getInsurancePolicyID() {
	        return insurancePolicyID;
	    }

	    public void setInsurancePolicyID(int insurancePolicyID) {
	        this.insurancePolicyID = insurancePolicyID;
	    }
	}


