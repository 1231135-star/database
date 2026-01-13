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

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getQual() {
			return qual;
		}

		public void setQual(String qual) {
			this.qual = qual;
		}

		public String getbName() {
			return bName;
		}

		public void setbName(String bName) {
			this.bName = bName;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

	  
}
