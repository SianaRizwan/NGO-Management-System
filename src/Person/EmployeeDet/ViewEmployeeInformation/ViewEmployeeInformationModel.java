package Person.EmployeeDet.ViewEmployeeInformation;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewEmployeeInformationModel {
    protected String[] showEmployeeDetails(String[] info, int emp_id) {
        try {
            List<String> list = new ArrayList<>();
            String sql = "select * from employee where emp_id=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, emp_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(String.valueOf(rs.getInt(1)));
                list.add(rs.getString(2));
                list.add(rs.getString(4));
                list.add(String.valueOf(rs.getDate(5)));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(rs.getString(8));
                list.add(rs.getString(9));
            }
            info = list.toArray(info);
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
