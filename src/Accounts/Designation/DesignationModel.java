package Accounts.Designation;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;

public class DesignationModel {
    public boolean isDesignationAddedSuccessful(String type, String name, int salary){
        try {
            String sql = "insert into designation (designation_name,type,amount) values(?,?,?)";

            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,type);
            ps.setInt(3,salary);

            int x= ps.executeUpdate();
            if(x>0){
                return true;
            }
        } catch (Exception e) {
            System.out.println("isDesignationAddedSuccessful\n\n");
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
