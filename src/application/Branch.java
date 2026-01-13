package application;

public class Branch {
	private int branchID;
    private String branchName, address,phoneNumber,email;
    
	public Branch(int branchID, String branchName, String address, String phoneNumber, String email) {
		super();
		this.branchID = branchID;
		this.branchName = branchName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
    
}
