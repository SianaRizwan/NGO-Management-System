package EventDetails.ManageEvent.AssignSupply;

import EventDetails.ManageEvent.GetInformationForEvent;

import java.util.ArrayList;

public class AddFoodToEventModel {
    GetInformationForEvent ev = new GetInformationForEvent();

    protected String[] getSearchedList(String[] info, String text) {
        String sql = "select ID from FOOD where ID like ? or name like ?";

        return ev.getSearchedListForEvent(info, text, sql);
    }


    protected int getTotalID() {
        String sql = "select count(ID) from FOOD ";
        return ev.getTotalNumberOfIDs(sql);
    }


    protected String[] getFoodList(String[] info) {
        String sql = "select ID from FOOD ";
        return ev.getList(info, sql);
    }


    public boolean isAssignFoodSuccessful(ArrayList<String> id, String eventID) {
        String sql = "insert into event_food values(?,?)";
        return ev.isAssignSuccessful(id, eventID, sql);
    }
}
