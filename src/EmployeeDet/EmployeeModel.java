package EmployeeDet;

import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmployeeModel {
    Date dob;
    String gender, address, phone, designation, email, password;
    int emp_id;

    public EmployeeModel(Date dob, String gender, String address, String phone, String designation, String email, String password, int emp_id) {
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.designation = designation;
        this.email = email;
        this.password = password;
        this.emp_id = emp_id;
    }

    OracleConnection oc = new OracleConnection();

    public boolean isEmployeeAddSuccessful() {
        return false;
    }

    public boolean isUpdateEmployeeSuccessful() {
        try {
            String sql = "update Employee set dob=?,gender=?,address=?,phone=?,designation=?,email=?,password=? where emp_id=?";
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) dob);
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
            System.out.println(e + "  employeeModel /// isUpdateEmployeeSuccessful");
            return false;
        }
        return false;
    }

    public boolean isDeleteEmployeeSuccessful() {
        try {
            String sql = "delete from Employee where emp_id=?";
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, emp_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e + "  EmployeeModel  /// isDeleteEmployeeSuccessful");
        }
        return false;
    }

    public static ObservableList<Employee> getTableRecords() throws SQLException {
        String sql = "select emp_id,name,email,nvl(phone,'N/A') phone,get_designation(emp_id) designation from employee order by emp_id";
        ObservableList<Employee> emplist = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String designation = rs.getString("designation");

                Employee employee = new Employee(name, email, phone, designation, id);

                emplist.add(employee);
            }
            return emplist;
        } catch (Exception e) {
            System.out.println("getTableRecords : EmployeeModel");
            e.printStackTrace();
            throw e;
        }
    }

}
