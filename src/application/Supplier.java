package application;

public class Supplier {
	 private int supplierID;
	 private String supplierName,phoneNumber,email,address;
	 
	public Supplier(int supplierID, String supplierName, String phoneNumber, String email, String address) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
