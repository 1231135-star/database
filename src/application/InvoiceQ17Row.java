package application;

public class InvoiceQ17Row {
    private int invoiceID;
    private String invoiceDate;
    private double totalAmount;
    private String employeeName;

    public InvoiceQ17Row(int invoiceID, String invoiceDate, double totalAmount, String employeeName) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.employeeName = employeeName;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

  
}
