package application;

public class Doctor {
    private int doctorID;
    private String fullName,licenseNumber,phoneNumber,email,clinicAddress;


    public Doctor(int doctorID, String fullName, String licenseNumber,
                  String phoneNumber, String email, String clinicAddress) {
        this.doctorID = doctorID;
        this.fullName = fullName;
        this.licenseNumber = licenseNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clinicAddress = clinicAddress;
    }


	public int getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
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


	public String getClinicAddress() {
		return clinicAddress;
	}


	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

}
