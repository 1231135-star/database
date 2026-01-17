package application;

public class InvoiceQ32Row {
    private int medicineID;
    private String medicineName;
    private int totalQtySold;
    private double totalSales;

    public InvoiceQ32Row(int medicineID, String medicineName, int totalQtySold, double totalSales) {
        this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.totalQtySold = totalQtySold;
        this.totalSales = totalSales;
    }

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getTotalQtySold() {
		return totalQtySold;
	}

	public void setTotalQtySold(int totalQtySold) {
		this.totalQtySold = totalQtySold;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

 
}
