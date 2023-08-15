package com.fpt_management.service;

import com.fpt_management.model.Branch;
import com.fpt_management.service.connect.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchService {
    Connection connection = ConnectionToMySQL.getConnection();
    public List<Branch> getAll() {
        List<Branch> branchList = new ArrayList<>();
        String sql = "select * from branch order by branch.branchId;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int branchId = resultSet.getInt("branchId");
                String branchName = resultSet.getString("branchName");
                Branch branch = new Branch(branchId, branchName);
                branchList.add(branch);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return branchList;
    }

    public Branch findById(int id){
        Branch branch = null;
        String sql = "select * from branch where branchId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int branchId = resultSet.getInt("branchId");
                String branchName = resultSet.getString("branchName");
                branch = new Branch(branchId, branchName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return branch;
    }
}
