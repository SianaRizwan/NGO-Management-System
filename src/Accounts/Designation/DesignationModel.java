package Accounts.Designation;

import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DesignationModel {
    public ObservableList<Designation> getDesignationTableRecords() throws SQLException {
        String sql = "select id, designation_name, type, amount,num_of_employee(designation_name,id) from designation order by id";
        ObservableList<Designation> designations = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                int salary = rs.getInt(4);
                int employeeCount=rs.getInt(5);

                Designation designation = new Designation(salary,name,type,id,employeeCount);

                designations.add(designation);
            }
            return designations;
        } catch (Exception e) {
            System.out.println("getTableRecords : desigModel");
            e.printStackTrace();
            throw e;
        }
    }
}
