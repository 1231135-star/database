package application;

public class InsuranceCompany {

	    private int insuranceCompanyID;
	    private String companyName;
	    private String contactNumber;
	    private String email;
	    private String address;

	    public InsuranceCompany() {}

	    public InsuranceCompany(int insuranceCompanyID, String companyName,
	                            String contactNumber, String email, String address) {
	        this.insuranceCompanyID = insuranceCompanyID;
	        this.companyName = companyName;
	        this.contactNumber = contactNumber;
	        this.email = email;
	        this.address = address;
	    }

	    public int getInsuranceCompanyID() {
	        return insuranceCompanyID;
	    }

	    public void setInsuranceCompanyID(int insuranceCompanyID) {
	        this.insuranceCompanyID = insuranceCompanyID;
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    public String getContactNumber() {
	        return contactNumber;
	    }

	    public void setContactNumber(String contactNumber) {
	        this.contactNumber = contactNumber;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	}


