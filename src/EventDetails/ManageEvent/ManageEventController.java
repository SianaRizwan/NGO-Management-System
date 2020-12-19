package EventDetails.ManageEvent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private JFXTextField eventDoctorName;

    @FXML
    private FontAwesomeIconView docIcon;

    @FXML
    private FontAwesomeIconView docList;

    @FXML
    void handleAddEmp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/Employee/addEmployees.fxml"));
        showList(loader, "Assign Employees");
    }

    @FXML
    void handleAddVol() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/Volunteers/addVolunteers.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/Employee/viewAssignedEmployees.fxml"));
        showList(loader, "Assigned Employees");
    }

    @FXML
    void handleViewAssignedVolunteers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/Volunteers/viewAssignedVolunteers.fxml"));
        showList(loader, "Assigned Volunteers");
    }

    private void showList(FXMLLoader loader, String s) throws IOException {
        AnchorPane pane = loader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(s);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    private void setVisibility() {

        eventDoctorName.setVisible(true);
        docIcon.setVisible(true);
        docList.setVisible(true);

    }
}
