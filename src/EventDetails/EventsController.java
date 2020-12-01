package EventDetails;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventsController implements Initializable {
    @FXML
    private Pane eventDetailsPane;
    @FXML
    private void handleCreateEvent(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CreateEvent/CreateEvent.fxml"));
        eventDetailsPane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
