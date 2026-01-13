package application;

public class Employee {
	 private int empID;
	    private String fullName,qualification,phoneNumber;
	    private double salary;
	    private int branchID;
		public int getEmpID() {
			return empID;
		}
		
		public Employee(int empID, String fullName, String qualification, String phoneNumber, double salary,
				int branchID) {
			super();
			this.empID = empID;
			this.fullName = fullName;
			this.qualification = qualification;
			this.phoneNumber = phoneNumber;
			this.salary = salary;
			this.branchID = branchID;
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
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public int getBranchID() {
			return branchID;
		}
		public void setBranchID(int branchID) {
			this.branchID = branchID;
		}
	    
	    
}
