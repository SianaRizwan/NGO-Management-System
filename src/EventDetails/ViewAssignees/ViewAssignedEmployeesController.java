package EventDetails.ViewAssignees;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewAssignedEmployeesController  {

    @FXML
    private AnchorPane viewDetails;

    @FXML
    void handleBackButton() throws IOException {
        FXMLLoader.load(getClass().getResource("../CreateEvent/CreateEvent.fxml"));
        Stage stage = (Stage) viewDetails.getScene().getWindow();
        stage.close();
    }
}
