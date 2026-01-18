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

    public int getInvoiceID() { return invoiceID; }
    public int getMedicineID() { return medicineID; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    public double getLineTotal() { return lineTotal; }
}
