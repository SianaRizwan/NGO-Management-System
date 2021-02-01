package EventDetails;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EventsModel {
    protected int setTotalCurrentEvent(){
        try {
            OracleConnection oc=new OracleConnection();
            String  sql="select count(id) from event_details where EXTRACT(month FROM sysdate)=EXTRACT(month FROM event_date) and EXTRACT(year FROM sysdate)=EXTRACT(year FROM event_date)";
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    protected int setTotalFutureEvent(){
        try {
            OracleConnection oc=new OracleConnection();
            String  sql="select count(id) from event_details where " +
                            "(EXTRACT(month FROM sysdate)<EXTRACT(month FROM event_date) and " +
                                        "EXTRACT(year FROM sysdate)=EXTRACT(year FROM event_date)) " +
                            "or (EXTRACT(year FROM sysdate)<EXTRACT(year FROM event_date))";
            PreparedStatement ps=oc.conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
