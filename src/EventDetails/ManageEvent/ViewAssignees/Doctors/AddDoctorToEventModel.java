package EventDetails.ManageEvent.ViewAssignees.Doctors;

import EventDetails.ManageEvent.ViewAssignees.GetPersonnelInformationForEvent;

import java.util.ArrayList;


public class AddDoctorToEventModel {
    GetPersonnelInformationForEvent ev = new GetPersonnelInformationForEvent();

    protected String[] getSearchedList(String[] info, String text) {
        String sql = "select doctor_ID from doctor where doctor_id like ? or name like ?";

        return ev.getSearchedListForEvent(info, text, sql);
    }


    protected int getTotalID() {
        String sql = "select count(doctor_id) from doctor ";
        return ev.getTotalNumberOfIDs(sql);
    }


    protected String[] getVolunteerList(String[] info) {
        String sql = "select doctor_ID from doctor ";
        return ev.getList(info, sql);
    }


    public boolean isAssignDoctorSuccessful(ArrayList<String> id, String eventID) {
        String sql = "insert into event_doctor values(?,?)";
        return ev.isAssignSuccessful(id, eventID, sql);
    }

}
