package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeDetailsController implements Initializable {
    @FXML
    private Pane employeeDetailsPane;
    @FXML
    private BorderPane employeeDetailsBorderPane;
    @FXML
    private Button updateButton;
    @FXML
    private void handleUpdate() throws IOException{
        Pane pane  = FXMLLoader.load(getClass().getResource("../View/addNewEmployee.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
