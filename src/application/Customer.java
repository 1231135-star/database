package application;

public class Customer {
	 private int customerID;
	 private String fullName,phoneNumber,email,address;
	 
	public Customer(int customerID, String fullName, String phoneNumber, String email, String address) {
		super();
		this.customerID = customerID;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
