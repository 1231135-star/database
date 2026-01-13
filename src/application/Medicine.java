package application;

public class Medicine {
	private int medicineID,categoryID;
    private String medicineName,strength;
    private boolean requiresPrescription;
    
	public Medicine(int medicineID, int categoryID, String medicineName, String strength,
			boolean requiresPrescription) {
		super();
		this.medicineID = medicineID;
		this.categoryID = categoryID;
		this.medicineName = medicineName;
		this.strength = strength;
		this.requiresPrescription = requiresPrescription;
	}
	public int getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public boolean isRequiresPrescription() {
		return requiresPrescription;
	}
	public void setRequiresPrescription(boolean requiresPrescription) {
		this.requiresPrescription = requiresPrescription;
	}
  
    
}
