package application;

public class MedicineQ4Row {

    private int medicineID;
    private String medicineName;
    private String strength;
    private boolean requiresPrescription;
    private String description;

    public MedicineQ4Row(int medicineID, String medicineName,
                          String strength, boolean requiresPrescription,
                          String description) {
        this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.strength = strength;
        this.requiresPrescription = requiresPrescription;
        this.description = description;
    }

    public int getMedicineID() {
        return medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getStrength() {
        return strength;
    }

    public boolean isRequiresPrescription() {
        return requiresPrescription;
    }

    public String getDescription() {
        return description;
    }
}
