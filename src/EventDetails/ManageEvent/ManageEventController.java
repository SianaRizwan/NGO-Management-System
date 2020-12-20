package EventDetails.ManageEvent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;

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
    void handleConfirmBtn() {

    }

    @FXML
    void handleViewAssignedDoctor() {

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


    @FXML
    void handleConfirmEmpBtn(ActionEvent event) {

    }

    @FXML
    void handleConfirmVolBtn(ActionEvent event) {

    }

    private static String eventID;


    public void handleEventID() {
        setEventID(eventName.getText().trim());
        makeDoctorVisible();
    }

    private void setEventID(String trim) {
        eventID=trim;
    }

    public static String getEventID() {
        return eventID;
    }

    private void makeDoctorVisible(){
        if (eventID.contains("H")){
            setVisibility();
        }
    }

    public void handleAddDoctor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Doctors/AddDoctorToEvent.fxml"));
        showList(loader, "Assign Volunteers");
    }
}
