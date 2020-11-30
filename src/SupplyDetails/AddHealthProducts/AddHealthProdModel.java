package SupplyDetails.AddHealthProducts;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.util.Date;

public class AddHealthProdModel {
    public boolean isAddHealthProdSuccessful(String name, Date pDate, Date eDate, int qty, int price, String supplier, String manufacturer, int type){
        try {
            java.sql.Date pur_date = new java.sql.Date(pDate.getTime());
            java.sql.Date exp_date = new java.sql.Date(eDate.getTime());

            int type_int;

           /* if(type.equals("Medicine")){
                type_int=1;
            }else if(type.equals("Vaccine")){
                type_int=2;
            } else if (type.equals("Emergency")){
                type_int=3;
            } else type_int=-1;*/

            String sql = "insert into health_product(name,purchase_date,expire_date,qty,supplier,manufacturer,unit_price,type) values(?,?,?,?,?,?,?,?)";

            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDate(2, pur_date);
            ps.setDate(3, exp_date);
            ps.setInt(4, qty);
            ps.setString(5, supplier);
            ps.setString(6, manufacturer);
            ps.setInt(7, price);
            ps.setInt(8,type);

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
