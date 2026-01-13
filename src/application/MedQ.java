package application;

public class MedQ {
    private String medName,bNum,exDate,bName;
    private int quant;

    public MedQ(String medName, String bNum, String exDate,int quant, String bName) {
        this.medName = medName;
        this.bNum = bNum;
        this.exDate = exDate;
        this.quant = quant;
        this.bName = bName;
    }

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getExDate() {
		return exDate;
	}

	public void setExDate(String exDate) {
		this.exDate = exDate;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

}
