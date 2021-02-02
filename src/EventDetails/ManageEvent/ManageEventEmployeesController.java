package EventDetails.ManageEvent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ManageEventEmployeesController {
    @FXML
    private Pane createEventPane;

    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXTextField estimatedBudget;

    @FXML
    private FontAwesomeIconView supplyList;

    @FXML
    private Label eventSupplyName;

    @FXML
    private FontAwesomeIconView addSupply;

    @FXML
    private JFXDatePicker eventDate;

    @FXML
    void handleAddSupply(MouseEvent event) {

    }

    private void showList(FXMLLoader loader, String s) throws IOException {
        AnchorPane pane = loader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(s);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    @FXML
    void handleAddVol() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Volunteers/addVolunteers.fxml"));
        showList(loader, "Assign Volunteers");
    }

    @FXML
    void handleViewAssignedVolunteers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignees/Volunteers/viewAssignedVolunteers.fxml"));
        showList(loader, "Assigned Volunteers");
    }

    private static String eventID;


    public void handleEventID() {
        setEventID(eventName.getText().trim());
        eventDate.getEditor().setText(new ManageEventModel().getEventDate(eventName.getText()));
    }

    private void setEventID(String id) {
        eventID = id;
    }

    public static String getEventID() {
        return eventID;
    }

    @FXML
    void handleBackBtn(MouseEvent event) {

    }

    @FXML
    void handleConfirmBtn(ActionEvent event) {

    }

    @FXML
    void handleEventID(InputMethodEvent event) {

    }

    @FXML
    void handleViewAssignedSupply(MouseEvent event) {

    }
}
