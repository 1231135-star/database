package application;

public class InvoiceItemQ1Row {

    private int invoiceID;
    private int medicineID;
    private int quantity;
    private double unitPrice;
    private double lineTotal;

    public InvoiceItemQ1Row(int invoiceID, int medicineID, int quantity,
                            double unitPrice, double lineTotal) {
        this.invoiceID = invoiceID;
        this.medicineID = medicineID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.lineTotal = lineTotal;
    }

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

  
}
