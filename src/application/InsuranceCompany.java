package application;

public class InsuranceCompany {

    private int insuranceCompanyID;
    private String companyName;
    private String licenseNo;
    private String phoneNumber;
    private String email;
    private String address;

    public InsuranceCompany(int insuranceCompanyID, String companyName, String licenseNo,
                            String phoneNumber, String email, String address) {
        this.insuranceCompanyID = insuranceCompanyID;
        this.companyName = companyName;
        this.licenseNo = licenseNo;
        this.phoneNumber = phoneNumber;
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

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
