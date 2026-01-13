package application;

import java.time.LocalDate;
import java.time.LocalTime;

public class Invoice {
	 private int invoiceID;
	    private LocalDate invoiceDate;
	    private LocalTime invoiceTime;
	    private double totalAmount;
	    private int customerID,empID,branchID;
		public Invoice(int invoiceID, LocalDate invoiceDate, LocalTime invoiceTime, double totalAmount, int customerID,
				int empID, int branchID) {
			super();
			this.invoiceID = invoiceID;
			this.invoiceDate = invoiceDate;
			this.invoiceTime = invoiceTime;
			this.totalAmount = totalAmount;
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
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
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
