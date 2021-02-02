package Accounts.Summary.DonationSummary;

import Person.DonorDetails.Donor;
import SupplyDetails.Food.Food;
import Utilities.OracleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class donationSummaryModel {
    protected ObservableList<Donation> getDonationTableRecords(int month, int year) throws SQLException {
        String sql = "select dt.id,dt.don_date,TO_number(To_CHAR(dt.don_date,'MM')) As month=?,TO_number(To_CHAR(dt.don_date,'YY')) As year=?,dt.amount,dt.donor_id,d.name FROM donation_history dt,DOnor d where d.DOnor_id=dt.donor_id";
                ;
        ObservableList<Donation> donationList = FXCollections.observableArrayList();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setInt(3,month);
            ps.setInt(4,year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                Date date=rs.getDate(2);
                int amount=rs.getInt(3);
                String donorId=rs.getString(4);
                String donorName=rs.getString(5);

                Donation donation = new Donation(id,date,amount,donorId,donorName);
                donationList.add(donation);
            }
            return donationList;
        } catch (Exception e) {
            System.out.println("getTableRecords : DonationHistoryModel");
            e.printStackTrace();
            throw e;
        }
    }
}
