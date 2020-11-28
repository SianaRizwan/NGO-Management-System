package SupplyDetails.HealthProducts;

import SupplyDetails.Medicine.Medicine;
import SupplyDetails.SupplyInformation;
import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HealthProdModel {

    public String getSQLForTableRecords(String type){
        if(type.equals("Medicine")){
            String sql = "select distinct name,sum(qty) qty,sum(unit_price*qty) price from HEALTH_PRODUCT where id LIKE 'M%' group by name order by name";
            return sql;
        }else if(type.equals("Vaccine")){
            String sql = "select distinct name,sum(qty) qty,sum(unit_price*qty) price from HEALTH_PRODUCT where id LIKE 'V%' group by name order by name";
            return sql;
        } else if (type.equals("Emergency")){
            String sql = "select distinct name,sum(qty) qty,sum(unit_price*qty) price from HEALTH_PRODUCT where id LIKE 'E%' group by name order by name";
            return sql;
        }
        return null;
    }

    protected ObservableList<Medicine> getMedicineTableRecords() throws SQLException {
        String sql = getSQLForTableRecords("Medicine");
        ObservableList<Medicine> medicineList = FXCollections.observableArrayList();

        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int qty = rs.getInt(2);
                int price = rs.getInt(3);

                Medicine medicine = new Medicine(price,qty,name);
                medicineList.add(medicine);
            }

            return medicineList;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getTableRecords : medModel");
            throw e;
        }

    }

    protected boolean isDeleteSelectedHealthProdSuccessful(String name) {
        String sql = "delete from HEALTH_PRODUCT where name=?";
        return new SupplyInformation().isDeleteSelectedItemSuccessful(name,sql);

    }
    protected  boolean isMatchSuccessful(String newValue, Medicine medicine) {
        if (newValue == null || newValue.isEmpty()) {
            return true;
        }
        return String.valueOf(medicine.getName()).contains(newValue);
    }
}
