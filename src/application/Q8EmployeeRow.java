package application;

public class Q8EmployeeRow {

	private int empID;
	private String fullName;
	private double totalSales;

	public Q8EmployeeRow(int empID, String fullName, double totalSales) {
		this.empID = empID;
		this.fullName = fullName;
		this.totalSales = totalSales;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

	
}
