package SupplyDetails.Food.AddFood;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.util.Date;

public class AddFoodSupplyModel {
    protected boolean isAddFoodSuccessful(String name, Date pDate, Date eDate, int qty, int price, String supplier) {
        try {
            java.sql.Date pur_Date = new java.sql.Date(pDate.getTime());
            java.sql.Date exp_Date = new java.sql.Date(eDate.getTime());

            String sql = "insert into food(name,purchase_date,expire_date,qty,supplier,unit_price) values(?,?,?,?,?,?)";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDate(2, pur_Date);
            ps.setDate(3, exp_Date);
            ps.setInt(4, qty);
            ps.setInt(6, price);
            ps.setString(5, supplier);

            int x = ps.executeUpdate();

            if (x > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
