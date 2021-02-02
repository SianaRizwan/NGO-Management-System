package EventDetails.ManageEvent.AssignSupply.EventMed;

import SupplyDetails.Medicine.Medicine;
import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ViewAssignedMedModel {
    protected ObservableList<Medicine> getTableRecords(String eventID) throws SQLException {
        String sql = "select v.ID,v.name,v.QTY,v.UNIT_PRICE,v.EXPIRE_DATE,v.MANUFACTURER from event_health ev,HEALTH_PRODUCT v where ev.health_id=v.ID and ev.event_id=?";
        javafx.collections.ObservableList<SupplyDetails.Medicine.Medicine> medList = FXCollections.observableArrayList();
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
                java.util.Date date = rs.getDate(5);
                String manufacturer = rs.getString(6);

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String expDate = df.format(date);

                Medicine medicine = new Medicine(price,qty,expDate,name,manufacturer,id);

                medList.add(medicine);
            }
            return medList;
        } catch (Exception e) {
            System.out.println("getTableRecords : EmployeeModel");
            e.printStackTrace();
            throw e;
        }
    }
}
