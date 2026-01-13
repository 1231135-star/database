package application;

public class MostSoldMed {
    private String month,medName;
    private int totQuantitySold;

    public MostSoldMed(String month, String medName, int totQuantitySold) {
        this.month = month;
        this.medName = medName;
        this.totQuantitySold = totQuantitySold;
    }

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public int getTotQuantitySold() {
		return totQuantitySold;
	}

	public void setTotQuantitySold(int totQuantitySold) {
		this.totQuantitySold = totQuantitySold;
	}
}
