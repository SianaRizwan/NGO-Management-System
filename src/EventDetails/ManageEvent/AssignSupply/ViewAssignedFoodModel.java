package EventDetails.ManageEvent.AssignSupply;

import SupplyDetails.Food.Food;
import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAssignedFoodModel {
    protected ObservableList<Food> getTableRecords(String eventID) throws SQLException {
        String sql = "select v.ID,v.name,v.QTY,v.UNIT_PRICE,v.EXPIRE_DATE,v.SUPPLIER from event_food ev,FOOD v where ev.food_id=v.ID and ev.event_id=?";
        ObservableList<Food> foodList = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, eventID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                int price = rs.getInt(4);
                java.util.Date expDate = rs.getDate(5);
                String supplier = rs.getString(6);

                Food food = new Food(price,qty,expDate,name,supplier,id);

                foodList.add(food);
            }
            return foodList;
        } catch (Exception e) {
            System.out.println("getTableRecords : FoodModel");
            e.printStackTrace();
            throw e;
        }
    }
}
