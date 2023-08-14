package com.fpt_management.model;

public class Branch {
    private int branchId;
    private String branchName;

    public Branch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Branch(int branchId) {
        this.branchId = branchId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
