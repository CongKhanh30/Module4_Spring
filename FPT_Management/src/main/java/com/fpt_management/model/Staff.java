package com.fpt_management.model;

public class Staff {
    private int staffId;
    private String staffCode;
    private String staffName;
    private int age;
    private int salary;
    private Branch branch;
    private String img;

    public Staff(){

    }

    public Staff(int staffId, String staffCode, String staffName, int age, int salary, Branch branch, String img) {
        this.staffId = staffId;
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
        this.img = img;
    }

    public Staff(String staffCode, String staffName, int age, int salary, Branch branch, String img) {
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
        this.img = img;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
