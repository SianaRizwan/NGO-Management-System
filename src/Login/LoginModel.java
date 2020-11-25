package Login;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {
    OracleConnection oracleConnection = new OracleConnection();
    private String uid;

    /* protected boolean isEmpAvailable(){
         int n=-1;
         try {
             String sql="select count(emp_id) from employee";
             OracleConnection oc=new OracleConnection();
             PreparedStatement ps=oc.conn.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             if(rs.next()){
                 n=rs.getInt(1);
             }
             if(n==0) {
                 return false;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return true;
     }*/
    protected boolean isLoginSuccessful(String username, String password) {
        try {
            String sql = "select name,password from employee where name=? and password=?";
            PreparedStatement ps=oracleConnection.conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet resultSet=ps.executeQuery();
            System.out.println(username.getClass().getSimpleName()+"     "+password.getClass().getSimpleName());
            if (resultSet.next()){
                uid=resultSet.getString(1);
                System.out.println(uid);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e + " isLoginSuccessful");
        }
        return false;

    }
    public String getUID() {
        System.out.println(uid+" login uid");
        return uid;

    }

}