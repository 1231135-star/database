package application;

public class PrescriptionMedicineRow {

    private int prescriptionid;
    private int medicineid;
    private String dosage;

    public PrescriptionMedicineRow(int prescriptionid, int medicineid, String dosage) {
        this.prescriptionid = prescriptionid;
        this.medicineid = medicineid;
        this.dosage = dosage;
    }

	public int getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(int prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

 
}
