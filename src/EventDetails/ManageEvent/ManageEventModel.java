package EventDetails.ManageEvent;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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

    protected String getEventDate(String eventID){
        try {
            OracleConnection oc=new OracleConnection();
            String sql="select event_date from event_details where id=?";
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ps.setString(1,eventID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return String.valueOf(rs.getDate(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    protected boolean saveEventInformation(String eventID, Date eventDate, int budget){
        try {
            java.sql.Date sqlDate = new java.sql.Date(eventDate.getTime());

            OracleConnection oc=new OracleConnection();
            String sql="update event_details set event_date=?, est_budget=est_budget+? where id=?";
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ps.setDate(1,sqlDate);
            ps.setInt(2,budget);
            ps.setString(3,eventID);
            int x=ps.executeUpdate();
            if(x>0){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
