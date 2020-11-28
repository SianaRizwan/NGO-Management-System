package SupplyDetails.Vaccine.ViewVaccineDetails;

import SupplyDetails.Vaccine.Vaccine;
import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewVaccineInformationModel {
    protected String[] showMedicineDetails(String[] info, String name) {
        try {
            List<String> list = new ArrayList<>();
            String sql = "select * from HEALTH_PRODUCT where name=? and purchase_date > add_months(sysdate,-6)";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(String.valueOf(rs.getDate(3)));
                list.add(String.valueOf(rs.getDate(4)));
                list.add(String.valueOf(rs.getInt(5)));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(String.valueOf(rs.getInt(8)));
                list.add(String.valueOf(rs.getInt(9)));
            }
            info = list.toArray(info);
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected ObservableList<Vaccine> getVaccineTableRecords(String item) throws SQLException {
        String sql = "select * from HEALTH_PRODUCT where name=? and purchase_date > add_months(sysdate,-6) order by purchase_date";
        ObservableList<Vaccine> vacList = FXCollections.observableArrayList();

        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, item);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name=rs.getString(2);
                Date pdate=rs.getDate(3);
                Date edate=rs.getDate(4);
                int qty=rs.getInt(5);
                String sup=rs.getString(6);
                String manufacturer =rs.getString(7);
                int price=rs.getInt(8);
                int type=rs.getInt(9);

                Vaccine vaccine = new Vaccine(price,qty,pdate,edate,name,sup,manufacturer,id,type);

                vacList.add(vaccine);
            }
            return vacList;
        } catch (Exception e) {
            System.out.println("getTableRecords : vacModel");
            e.printStackTrace();
            throw e;
        }

    }
}
