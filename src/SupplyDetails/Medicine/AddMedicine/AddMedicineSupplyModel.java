package SupplyDetails.Medicine.AddMedicine;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.util.Date;

public class AddMedicineSupplyModel {
    public boolean isAddMedicineSuccessful(String name, Date pDate, Date eDate, int qty, int price, String supplier, String manufacturer){
        try {
            java.sql.Date pur_date = new java.sql.Date(pDate.getTime());
            java.sql.Date exp_date = new java.sql.Date(eDate.getTime());

            String sql = "insert into health_product(name,purchase_date,expire_date,qty,supplier,manufacturer,unit_price,type) values(?,?,?,?,?,?,?,2)";

            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDate(2, pur_date);
            ps.setDate(3, exp_date);
            ps.setInt(4, qty);
            ps.setString(5, supplier);
            ps.setString(6, manufacturer);
            ps.setInt(7, price);

            int x = ps.executeUpdate();

            if (x > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
