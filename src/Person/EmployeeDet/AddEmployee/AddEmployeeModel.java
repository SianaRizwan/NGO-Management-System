package Person.EmployeeDet.AddEmployee;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.util.Date;

public class AddEmployeeModel {
    public boolean isAddEmployeeSuccessful(String name,Date dobDate, String gender, String address, String phone, String designation,
                                           String email, String password) {

        try {
            java.sql.Date sqlDate = new java.sql.Date(dobDate.getTime());

            String sql="insert into employee(name,email,password,gender,phone,dob,designation,address) values(?,?,?,?,?,?,?,?)";
            OracleConnection oc=new OracleConnection();
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,gender);
            ps.setString(5,phone);
            ps.setDate(6,sqlDate);
            ps.setString(7,designation);
            ps.setString(8,address);

            int x=ps.executeUpdate();
            if(x>0){
                return true;
            }
        } catch (Exception e) {
            System.out.println("isAddEmployeeSuccessful\n\n");
            e.printStackTrace();
            return false;
        }


        return false;
    }
}
