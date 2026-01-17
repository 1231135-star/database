package application;

public class BranchQ5Row {

	private int branchID;
	private String branchName;
	private String address;
	private String phoneNumber;

	public BranchQ5Row(int branchID, String branchName, String address, String phoneNumber) {
		this.branchID = branchID;
		this.branchName = branchName;
		this.address = address;
		this.phoneNumber = phoneNumber;
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

	
}
