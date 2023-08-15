package com.fpt_management.service;

import com.fpt_management.model.Branch;
import com.fpt_management.model.Staff;
import com.fpt_management.service.connect.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffService {

    Connection connection = ConnectionToMySQL.getConnection();

    public List<Staff> findAll(){
        List<Staff> staffList = new ArrayList<>();
        String sql = "select staff.*, branch.branchName from staff inner join branch on staff.branchId = branch.branchId order by staff.staffID;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int staffId = resultSet.getInt("staffId");
                String staffCode = resultSet.getString("staffCode");
                String staffName = resultSet.getString("staffName");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                int branchId = resultSet.getInt("branchId");
                String branchName = resultSet.getString("branchName");
                String image = resultSet.getString("img");
                Branch branch = new Branch(branchId, branchName);

                Staff staff = new Staff(staffId, staffCode, staffName, age, salary, branch, image);
                staffList.add(staff);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffList;
    }

    public void add(Staff staff){
        String sql = "insert into staff(staffCode, staffName, age, salary, branchId, img) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getStaffCode());
            preparedStatement.setString(2, staff.getStaffName());
            preparedStatement.setInt(3, staff.getAge());
            preparedStatement.setInt(4, staff.getSalary());
            preparedStatement.setInt(5, staff.getBranch().getBranchId());
            preparedStatement.setString(6, staff.getImg());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        String sql = "delete from staff where staffId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Staff findById(int id) {
        for (Staff staff : findAll()) {
            if (staff.getStaffId() == id) {
                return staff;
            }
        }
        return null;
    }

    public void edit (Staff staff){
        String sql = "update staff set staffCode, staffName=?, age=?, salary=?, branchId=?, img=? where staffId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getStaffCode());
            preparedStatement.setString(2, staff.getStaffName());
            preparedStatement.setInt(3, staff.getAge());
            preparedStatement.setInt(4, staff.getSalary());
            preparedStatement.setInt(5, staff.getBranch().getBranchId());
            preparedStatement.setString(6, staff.getImg());
            preparedStatement.setInt(7, staff.getStaffId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Staff> searchByName(String name){
        List<Staff> staffList = new ArrayList<>();
        for (Staff staff : findAll()) {
            if (staff.getStaffName().toLowerCase().contains(name.toLowerCase())) {
                staffList.add(staff);
            }
        }
        return staffList;
    }
}
