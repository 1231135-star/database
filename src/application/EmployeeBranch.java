package application;

public class EmployeeBranch {
	    private String fName,qual,bName;
	    private double salary;

	    public EmployeeBranch(String fName, String qual, double salary, String bName) {
	        this.fName = fName;
	        this.qual = qual;
	        this.salary = salary;
	        this.bName = bName;
	    }

		public String getFName() {
			return fName;
		}

		public void setFName(String fName) {
			this.fName = fName;
		}

		public String getQual() {
			return qual;
		}

		public void setQual(String qual) {
			this.qual = qual;
		}

		public String getBName() {
			return bName;
		}

		public void setBName(String bName) {
			this.bName = bName;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

	  
}
