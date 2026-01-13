package application;

public class PrescriptionMedicine {

	    private int prescriptionID;
	    private int medicineID;
	    private String dosage;

	    public PrescriptionMedicine() {}

	    public PrescriptionMedicine(int prescriptionID, int medicineID, String dosage) {
	        this.prescriptionID = prescriptionID;
	        this.medicineID = medicineID;
	        this.dosage = dosage;
	    }

	    public int getPrescriptionID() {
	        return prescriptionID;
	    }

	    public void setPrescriptionID(int prescriptionID) {
	        this.prescriptionID = prescriptionID;
	    }

	    public int getMedicineID() {
	        return medicineID;
	    }

	    public void setMedicineID(int medicineID) {
	        this.medicineID = medicineID;
	    }

	    public String getDosage() {
	        return dosage;
	    }

	    public void setDosage(String dosage) {
	        this.dosage = dosage;
	    }
	}


