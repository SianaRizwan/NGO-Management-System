package VolunteerDetails;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VolunteerDetailsController {
    @FXML
    private Pane VolunteerDetailsPane;

    @FXML
    private void handleUpdate() throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("updateVolunteerDetails.fxml"));
        VolunteerDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleAddNew() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("addVolunteer.fxml"));
        VolunteerDetailsPane.getChildren().setAll(pane);
    }
}
