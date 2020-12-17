package EventDetails.CreateEvent;

import SupplyDetails.Food.ViewFoodDetails.ViewFoodInformationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateEventController  implements Initializable {
    @FXML
    private Pane createEventPane;
    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Events.fxml"));
        createEventPane.getChildren().setAll(pane);
    }
    @FXML
    private void handleViewAssignedEmployees(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/viewAssignedEmployees.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Assigned Employees");
        stage.setScene(new Scene(pane));
        stage.show();
    }
    @FXML
    private void handleViewAssignedVolunteers(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewAssignees/viewAssignedVolunteers.fxml"));
        AnchorPane pane = loader.load();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Assigned Volunteers");
        stage.setScene(new Scene(pane));
        stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
