package Main;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainModel {
    protected int checkEmployeeNumber(){
        try {
            String sql="select count(emp_id) from employee";
            OracleConnection oc=new OracleConnection();
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
