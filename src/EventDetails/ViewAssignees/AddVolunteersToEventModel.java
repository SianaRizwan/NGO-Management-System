package EventDetails.ViewAssignees;

import Utilities.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddVolunteersToEventModel {
    public int count;

    protected String[] getSearchedList(String[] info,String text){
        List<String> list = new ArrayList<>();

        try {

            String sql = "select name from volunteer where volunteer_id like ? or name like ?";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ps.setString(1, "%" + text + "%");
            ps.setString(2, "%" + text + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }

            info = list.toArray(info);
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected int getTotalID() {
        try {
            String sql = "select count(volunteer_id) from volunteer ";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected String[] getVolunteerList(String[] info) {
        List<String> list = new ArrayList<>();

        try {

            String sql = "select name from volunteer ";
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }

            info = list.toArray(info);
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isAssignVolunteerSuccessful(ArrayList<String> names){
        int arraySize = names.size();
        System.out.println(arraySize);
        return true;
    }

//    public static void main(String[] args) {
//        ArrayList<String> names = new ArrayList<String>();
//        names.add("ab");
//        names.add("bc");
//        isAssignVolunteerSuccessful(names);
//    }
}