package Registration;

import Utilities.EmailValidator;
import Utilities.OracleConnection;

import java.sql.PreparedStatement;

public class RegisterModel {
    OracleConnection oc = new OracleConnection();
    private int empID;

    public boolean isRegistrationSuccessful(String name, String email, String password) {
        setDesignation();
        try {
            String sql = "insert into employee(name,email,password,designation) values(?,?,?,?)";

            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4,"Admin");
            int x = ps.executeUpdate();

            if (x > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e + " registration fail");
            return false;
        }
        return false;
    }

    EmailValidator emailValidator = new EmailValidator();

    public boolean validateEmail(String email) {
        return emailValidator.validate(email);
    }
    private  void setDesignation(){
        try{
            String  sql="insert into designation(designation_name,type) values (?,?)";
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ps.setString(1,"Admin");
            ps.setString(2,"Employee");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
