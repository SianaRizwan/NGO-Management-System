package Person.DoctorDetails.AddDoctor;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.util.Date;

public class AddDoctorModel {
    protected boolean isAddDoctorSuccessful(String name, Date dobDate, String gender, String address, String phone, String speciality,
                                         String email, String qualification, String hr) {

        try {
            java.sql.Date sqlDate = new java.sql.Date(dobDate.getTime());

            String sql = "insert into doctor(name,email,qualification,gender,phone,dob,speciality,address,Available_hr) values(?,?,?,?,?,?,?,?,?)";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, qualification);
            ps.setString(4, gender);
            ps.setString(5, phone);
            ps.setDate(6, sqlDate);
            ps.setString(7, speciality);
            ps.setString(8, address);
            ps.setString(9, hr);
            int x = ps.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("isAddDoctorSuccessful\n\n");
            e.printStackTrace();
            return false;
        }


        return false;
    }
}
