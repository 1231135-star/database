package application;

public class Q6EmployeeRow {
	private int empID;
	private String fullName;
	private String position;
	private double salary;
	private String branchName;

	public Q6EmployeeRow(int empID, String fullName, String position, double salary, String branchName) {
		this.empID = empID;
		this.fullName = fullName;
		this.position = position;
		this.salary = salary;
		this.branchName = branchName;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	
}
