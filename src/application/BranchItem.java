package application;

public class BranchItem {
    private int branchID;
    private String branchName;

    public BranchItem(int branchID, String branchName) {
        this.branchID = branchID;
        this.branchName = branchName;
    }

    public int getBranchID() {
        return branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    @Override
    public String toString() {
        return branchName + " (ID: " + branchID + ")";
    }
}
