package application;

import java.time.LocalDate;

public class InvQ {

    private int invID,quant;
    private String bnum,medName,suppName,bName;
    private LocalDate exDate,recDate;
    private double purchasPrice;

    public InvQ(int invID, String bnum, String medName,String suppName, String bName, int quant,LocalDate exDate, LocalDate recDate, double purchasPrice) {
        this.invID = invID;
        this.bnum = bnum;
        this.medName = medName;
        this.suppName = suppName;
        this.bName = bName;
        this.quant = quant;
        this.exDate = exDate;
        this.recDate = recDate;
        this.purchasPrice = purchasPrice;
    }

	public int getInvID() {
		return invID;
	}

	public void setInvID(int invID) {
		this.invID = invID;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public LocalDate getExDate() {
		return exDate;
	}

	public void setExDate(LocalDate exDate) {
		this.exDate = exDate;
	}

	public LocalDate getRecDate() {
		return recDate;
	}

	public void setRecDate(LocalDate recDate) {
		this.recDate = recDate;
	}

	public double getPurchasPrice() {
		return purchasPrice;
	}

	public void setPurchasPrice(double purchasPrice) {
		this.purchasPrice = purchasPrice;
	}

}
