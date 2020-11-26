package DoctorDetails;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateDoctorDetailsModel {
    protected boolean isUpdateDoctorSuccessful(String address, String phone, String qualification, String email, String hr, String Doctor_id) {
        OracleConnection oc = new OracleConnection();
        try {
            String sql = "update doctor set address=?,phone=?,Qualification=?,email=?,Available_hr=? where doctor_id=? ";
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, address);
            ps.setString(2, phone);
            ps.setString(3, qualification);
            ps.setString(4, email);
            ps.setString(5, hr);
            ps.setString(6, Doctor_id);
            int x = ps.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("  doctorModel /// isUpdatedoctorSuccessful\n\n");
            e.printStackTrace();

            return false;
        }
        return false;
    }

    protected List<String> getDoctorIDList() {
        List<String> list = new ArrayList<>();

        String sql = "select Doctor_id from Doctor";
        OracleConnection oc = new OracleConnection();
        try {
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(String.valueOf(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getDoctorIDList");
        }

        return list;
    }

    protected String[] setDoctorInformation(String info[], String Doctor_id) {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select name,email,phone,qualification,address,Available_hr from Doctor where Doctor_id=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, Doctor_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                for (int i = 1; i < 7; i++) {
                    list.add(rs.getString(i));
                }
            }
            info = list.toArray(info);
            return info;
        } catch (SQLException throwables) {
            System.out.println("setDoctorInformation-> updateDoctorModel");
            throwables.printStackTrace();
        }
        return null;
    }


}