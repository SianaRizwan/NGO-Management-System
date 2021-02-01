package EventDetails.ManageEvent;

import Person.Validation;
import Utilities.ShowAlertDialogue;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageEventController {
    @FXML
    private Pane createEventPane;

    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXTextField estimatedBudget;

    @FXML
    private JFXDatePicker eventDate;


    @FXML
    private FontAwesomeIconView docIcon;

    @FXML
    private FontAwesomeIconView docList;

    @FXML
    private Label eventDoctorName;

    @FXML
    private FontAwesomeIconView addDoctor;

    @FXML
    void handleAddEmp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Employee/addEmployees.fxml"));
        showList(loader, "Assign Employees");
    }

    @FXML
    void handleAddVol() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Volunteers/addVolunteers.fxml"));
        showList(loader, "Assign Volunteers");
    }

    @FXML
    void handleBackBtn() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Events.fxml"));
        createEventPane.getChildren().setAll(pane);

    }

    @FXML
    void handleConfirmBtn() throws ParseException {
        Date dateOfTheEvent = new SimpleDateFormat("yyyy-dd-MM").parse(eventDate.getEditor().getText());
        if (new ManageEventModel().saveEventInformation(eventName.getText().trim(),dateOfTheEvent, Integer.parseInt(estimatedBudget.getText())))
            {
                new ShowAlertDialogue().infoBox("Update Successful!", null, "Manage Event");
                refresehFields();
            }
         else {
            new ShowAlertDialogue().infoBox("Update Unsuccessful", null, "Manage Event");
        }
    }

    private void refresehFields() {
        eventName.setText("");
        estimatedBudget.setText("");
        eventDate.getEditor().setText("");
    }

    @FXML
    void handleViewAssignedDoctor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Doctors/viewAssignedDoctors.fxml"));
        showList(loader, "Assigned Employees");
    }

    @FXML
    void handleViewAssignedEmployees() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Employee/viewAssignedEmployees.fxml"));
        showList(loader, "Assigned Employees");
    }

    @FXML
    void handleViewAssignedVolunteers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Volunteers/viewAssignedVolunteers.fxml"));
        showList(loader, "Assigned Volunteers");
    }

    private void showList(FXMLLoader loader, String s) throws IOException {
        AnchorPane pane = loader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(s);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void initialize() {
        TextFields.bindAutoCompletion(eventName, new ManageEventModel().getItemNameList("select id from event_details"));
    }

    private void setVisibility() {
        eventDoctorName.setVisible(true);
        docIcon.setVisible(true);
        docList.setVisible(true);
        addDoctor.setVisible(true);

    }




    private static String eventID;


    public void handleEventID() {
        setEventID(eventName.getText().trim());
        eventDate.getEditor().setText(new ManageEventModel().getEventDate(eventName.getText()));
        makeDoctorVisible();
    }

    private void setEventID(String id) {
        eventID = id;
    }

    public static String getEventID() {
        return eventID;
    }

    private void makeDoctorVisible() {
        if (eventID.contains("H")) {
            setVisibility();
        }
    }

    public void handleAddDoctor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Doctors/AddDoctorToEvent.fxml"));
        showList(loader, "Assign Volunteers");
    }
}
