package application;
import java.time.LocalDate;

public class InsurancePolicy {

	    private int policyID;
	    private String policyNumber;
	    private LocalDate startDate;
	    private LocalDate expiryDate;
	    private double coveragePercentage;
	    private int customerID;
	    private int insuranceCompanyID;

	    public InsurancePolicy() {}

	    public InsurancePolicy(int policyID, String policyNumber,
	                           LocalDate startDate, LocalDate expiryDate,
	                           double coveragePercentage, int customerID,
	                           int insuranceCompanyID) {
	        this.policyID = policyID;
	        this.policyNumber = policyNumber;
	        this.startDate = startDate;
	        this.expiryDate = expiryDate;
	        this.coveragePercentage = coveragePercentage;
	        this.customerID = customerID;
	        this.insuranceCompanyID = insuranceCompanyID;
	    }

	    public int getPolicyID() {
	        return policyID;
	    }

	    public void setPolicyID(int policyID) {
	        this.policyID = policyID;
	    }

	    public String getPolicyNumber() {
	        return policyNumber;
	    }

	    public void setPolicyNumber(String policyNumber) {
	        this.policyNumber = policyNumber;
	    }

	    public LocalDate getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(LocalDate startDate) {
	        this.startDate = startDate;
	    }

	    public LocalDate getExpiryDate() {
	        return expiryDate;
	    }

	    public void setExpiryDate(LocalDate expiryDate) {
	        this.expiryDate = expiryDate;
	    }

	    public double getCoveragePercentage() {
	        return coveragePercentage;
	    }

	    public void setCoveragePercentage(double coveragePercentage) {
	        this.coveragePercentage = coveragePercentage;
	    }

	    public int getCustomerID() {
	        return customerID;
	    }

	    public void setCustomerID(int customerID) {
	        this.customerID = customerID;
	    }

	    public int getInsuranceCompanyID() {
	        return insuranceCompanyID;
	    }

	    public void setInsuranceCompanyID(int insuranceCompanyID) {
	        this.insuranceCompanyID = insuranceCompanyID;
	    }

	    public LocalDate getIssueDate() {
	        return getIssueDate();
	    }
	}


