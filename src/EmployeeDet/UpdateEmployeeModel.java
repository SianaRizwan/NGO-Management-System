package EmployeeDet;

import Utilities.OracleConnection;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateEmployeeModel {
    private Date dob;
    private String gender, address, phone, designation, email, password;
    private int emp_id;


    public boolean isUpdateEmployeeSuccessful(Date dob, String gender, String address, String phone, String designation, String email, String password, int emp_id) {
        OracleConnection oc = new OracleConnection();
        try {
            java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
            String sql = "update Employee set dob=?,gender=?,address=?,phone=?,designation=?,email=?,password=? where emp_id=? ";
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            ps.setString(2, gender);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, designation);
            ps.setString(6, email);
            ps.setString(7, password);
            ps.setInt(8, emp_id);
            int x = ps.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("  employeeModel /// isUpdateEmployeeSuccessful\n\n");
            e.printStackTrace();

            return false;
        }
        return false;
    }

    public List<String> getEmployeeIDList() {
        List<String> list = new ArrayList<>();

        String sql = "select emp_id from employee";
        OracleConnection oc = new OracleConnection();
        try {
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(String.valueOf(rs.getInt(1)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getEmployeeIDList");
        }

        return list;
    }

    public String[] setEmployeeInformation(String info[], int emp_id) {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select name,password,email from employee where emp_id=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, emp_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
            info = list.toArray(info);
            return info;
        } catch (SQLException throwables) {
            System.out.println("setEmployeeInformation-> updateEmployeeModel");
            throwables.printStackTrace();
        }
        return null;
    }



}