package EventDetails.ManageEvent.AssignSupply.EventFood;

import EventDetails.ManageEvent.AssignSupply.EventSupply;
import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEventFoodModel {
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected ObservableList<EventSupply> getTableRecords(String id) throws SQLException {
        String sql = "select distinct f.name,f.total_qty,ev.amount from event_food ev,food f where ev.food_name=f.name and ev.event_id=?";
        ObservableList<EventSupply> foodlist = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                int availableQty = rs.getInt(2);
                int reqQty = rs.getInt(3);

                EventSupply history = new EventSupply(availableQty, reqQty, name);

                foodlist.add(history);
            }
            return foodlist;
        } catch (Exception e) {
            System.out.println("getTableRecords : EmployeeModel");
            e.printStackTrace();
            throw e;
        }
    }
    protected String getRequiredAmount(){
        try {
            System.out.println("p "+getId()+" lpl  "+getName());
            String sql = "select ev.amount from event_food ev where ev.food_name=? and ev.event_id=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2, getId());
           ResultSet rs=ps.executeQuery();
           while (rs.next()){

               return String.valueOf(rs.getInt(1));

           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void isAmountAddSuccessful(int amt, String eventID, String foodName) {
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
                    System.out.println(amt+"   "+eventID+"   "+foodName);
                    System.out.println("p");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
