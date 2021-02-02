package EventDetails.ManageEvent.ViewAssignees.Employee;

import EventDetails.ManageEvent.GetInformationForEvent;

import java.util.ArrayList;

public class AddEmployeesToEventModel {
    GetInformationForEvent ev = new GetInformationForEvent();

    protected String[] getSearchedList(String[] info, String text) {
        String sql = "select emp_id from EMPLOYEE where emp_id like ? or name like ?";

        return ev.getSearchedListForEvent(info, text, sql);
    }


    protected int getTotalID() {
        String sql = "select count(emp_id) from EMPLOYEE ";
        return ev.getTotalNumberOfIDs(sql);
    }


    protected String[] getEmployeeList(String[] info) {
        String sql = "select emp_id from EMPLOYEE ";
        return ev.getList(info, sql);
    }


    public boolean isAssignEmployeeSuccessful(ArrayList<String> id, String eventID) {
        String sql = "insert into event_employee values(?,?)";
        return ev.isAssignSuccessful(id, eventID, sql);
    }
}
