package application;
import java.time.LocalDate;

public class Prescription {
	    private int prescriptionID;
	    private LocalDate issueDate;
	    private String notes;
	    private int doctorID;
	    private int customerID;

	    public Prescription() {}

	    public Prescription(int prescriptionID, LocalDate issueDate,
	                        String notes, int doctorID, int customerID) {
	        this.prescriptionID = prescriptionID;
	        this.issueDate = issueDate;
	        this.notes = notes;
	        this.doctorID = doctorID;
	        this.customerID = customerID;
	    }

	    public int getPrescriptionID() {
	        return prescriptionID;
	    }

	    public void setPrescriptionID(int prescriptionID) {
	        this.prescriptionID = prescriptionID;
	    }

	    public LocalDate getIssueDate() {
	        return issueDate;
	    }

	    public void setIssueDate(LocalDate issueDate) {
	        this.issueDate = issueDate;
	    }

	    public String getNotes() {
	        return notes;
	    }

	    public void setNotes(String notes) {
	        this.notes = notes;
	    }

	    public int getDoctorID() {
	        return doctorID;
	    }

	    public void setDoctorID(int doctorID) {
	        this.doctorID = doctorID;
	    }

	    public int getCustomerID() {
	        return customerID;
	    }

	    public void setCustomerID(int customerID) {
	        this.customerID = customerID;
	    }
	}


