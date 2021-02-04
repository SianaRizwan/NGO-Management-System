package EventDetails.ManageEvent.AssignSupply.EventMed;

import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEventMedModel {
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

    protected ObservableList<EventMed> getTableRecords(String id) throws SQLException {
        String sql = "select distinct h.name,h.total_qty,ev.amount from event_health ev,HEALTH_PRODUCT h where ev.health_name=h.name and ev.event_id=?";
        ObservableList<EventMed> medlist = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                int availableQty = rs.getInt(2);
                int reqQty = rs.getInt(3);

                EventMed history = new EventMed(availableQty, reqQty, name);

                medlist.add(history);
            }
            return medlist;
        } catch (Exception e) {
            System.out.println("getTableRecords : HealthHistoryModel");
            e.printStackTrace();
            throw e;
        }
    }
    protected String getRequiredAmount(){
        try {
            System.out.println("p "+getId()+" lpl  "+getName());
            String sql = "select ev.amount from event_health ev where ev.health_name=? and ev.event_id=?";
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

    protected void isAmountAddSuccessful(int amt, String eventID, String medName) {
        try {
            String sql = "update event_health set amount=amount+? where event_id=? and health_name=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, amt);
            ps.setString(2, eventID);
            ps.setString(3, medName);
            int x = ps.executeUpdate();
            if (x > 0) {
                if (isAmountUpdateSuccessful(amt,medName)) {
                    System.out.println(amt+"   "+eventID+"   "+medName);
                    System.out.println("p");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isAmountUpdateSuccessful(int amt, String medName) {
        try {
            String sql = "update HEALTH_PRODUCT set total_qty=total_qty-? where name=?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(1, amt);
            ps.setString(2, medName);
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
