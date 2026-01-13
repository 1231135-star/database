package application;

public class MedStock {
    private int medID,totQuantity;
    private String medName;

    public MedStock(int medID, String medName, int totQuantity) {
        this.medID = medID;
        this.medName = medName;
        this.totQuantity = totQuantity;
    }

	public int getMedID() {
		return medID;
	}

	public void setMedID(int medID) {
		this.medID = medID;
	}

	public int getTotQuantity() {
		return totQuantity;
	}

	public void setTotQuantity(int totQuantity) {
		this.totQuantity = totQuantity;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

}
