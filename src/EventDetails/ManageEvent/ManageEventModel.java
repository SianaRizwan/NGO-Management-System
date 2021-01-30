package EventDetails.ManageEvent;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManageEventModel {
    protected List<String> getItemNameList(String sql) {
        List<String> list = new ArrayList<>();

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
            System.out.println("getItemNameList");
        }
        return list;
    }

}
