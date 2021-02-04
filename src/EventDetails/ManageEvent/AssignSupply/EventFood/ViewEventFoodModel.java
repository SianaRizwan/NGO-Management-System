package EventDetails.ManageEvent.AssignSupply.EventFood;

import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEventFoodModel {
    protected ObservableList<EventFood> getTableRecords(String id) throws SQLException {
        String sql = "select f.name,f.total_qty,ev.amount from event_food ev,food f where ev.food_name=f.name and ev.event_id=?";
        ObservableList<EventFood> foodlist = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                int availableQty = rs.getInt(2);
                int reqQty = rs.getInt(3);

                EventFood history = new EventFood(availableQty, reqQty, name);

                foodlist.add(history);
            }
            return foodlist;
        } catch (Exception e) {
            System.out.println("getTableRecords : EmployeeModel");
            e.printStackTrace();
            throw e;
        }
    }

    protected boolean isAmountAddSuccessful(int amt, String eventID, String foodName) {
        try {
            String sql = "update event_food set amount=amount+? where event_id=? and food_name=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, amt);
            ps.setString(2, eventID);
            ps.setString(3, foodName);
            int x = ps.executeUpdate();
            if (x > 0) {
                if (isAmountUpdateSuccessful(amt,foodName)) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private boolean isAmountUpdateSuccessful(int amt, String foodName) {
        try {
            String sql = "update food set total_qty=total_qty-? where name=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, amt);
            ps.setString(2, foodName);
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
