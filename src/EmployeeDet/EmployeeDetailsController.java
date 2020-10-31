package EmployeeDet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeDetailsController implements Initializable {
    @FXML
    private Pane employeeDetailsPane;
    @FXML
    private void handleUpdate() throws IOException {
        Pane pane  = FXMLLoader.load(getClass().getResource("updateEmployee.fxml"));
        employeeDetailsPane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
