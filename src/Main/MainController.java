package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane employeeDetailsBorderPane;
    @FXML
    private  AnchorPane mainPane;
    @FXML
    private void viewEmployeeDetails() throws IOException{
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../EmployeeDet/employeeDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    @FXML
    private void handleLogOut() throws IOException{
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
        mainPane.getChildren().setAll(pane2);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void viewDoctorDetails() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../DoctorDetails/DoctorDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    public void viewDonorDetails() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../DonorDetails/donorDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    public void viewVolunteerDetails() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../VolunteerDetails/volunteerDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }

    public void viewSupplyDetails() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../SupplyDetails/supplyDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }


}