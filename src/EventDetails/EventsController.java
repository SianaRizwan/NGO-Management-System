package EventDetails;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventsController {
    @FXML
    private Pane eventDetailsPane;
    @FXML
    private JFXTextField currentEvent;

    @FXML
    private JFXTextField upcomingEvent;

    @FXML
    private void handleCreateEvent(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CreateEvent/CreateEvent.fxml"));
        eventDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    void handleManageEvent(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ManageEvent/ManageEvent.fxml"));
        eventDetailsPane.getChildren().setAll(pane);
    }

    EventsModel eventsModel = new EventsModel();

    public void initialize() {
        currentEvent.setText(String.valueOf(eventsModel.setTotalCurrentEvent()));
        upcomingEvent.setText(String.valueOf(eventsModel.setTotalFutureEvent()));
    }
}
