package EventDetails.CreateEvent;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CreateEventController  {
    @FXML
    private Pane createEventPane;


    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXTextField eventVolunteerName;

    @FXML
    private JFXTextField eventEmployeeName;

    @FXML
    private JFXTextField estimatedBudget;

    @FXML
    private JFXDatePicker eventDate;

    @FXML
    private FontAwesomeIconView docList;

    @FXML
    private JFXComboBox eventType;

    @FXML
    private JFXTextField eventDoctorName;
    @FXML
    private FontAwesomeIconView docIcon;




    private final ObservableList<String> eventTypeValue = FXCollections.observableArrayList("Food", "Health");

    @FXML
    void handleViewAssignedDoctor() {

    }

    @FXML
    private void handleBackBtn() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Events.fxml"));
        createEventPane.getChildren().setAll(pane);
    }
    @FXML
    private void handleViewAssignedEmployees() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/viewAssignedEmployees.fxml"));
        showList(loader, "Assigned Employees");
    }

      @FXML
    private void handleViewAssignedVolunteers() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/viewAssignedVolunteers.fxml"));
        showList(loader, "Assigned Volunteers");
    }
    public void initialize(){
        eventType.setItems(eventTypeValue);
//        setVisibility();
    }

    private void setVisibility() {

         eventDoctorName.setVisible(true);
         docIcon.setVisible(true);
         docList.setVisible(true);

    }

    private void showList(FXMLLoader loader, String s) throws IOException {
        AnchorPane pane = loader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(s);
        stage.setScene(new Scene(pane));
        stage.show();
    }
@FXML
    public void handleAddVol() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/addVolunteers.fxml"));
    showList(loader, "Assigned Volunteers");

}

    public void handleEventType() {
        if(eventType.getSelectionModel().getSelectedItem().equals("Health")){
           setVisibility();
        }
    }
}
