package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private BorderPane employeeDetailsBorderPane;

    @FXML
    private  AnchorPane mainPane;
    @FXML
    private void viewEmployeeDetails() throws IOException{
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/EmployeeDet/employeeDetails.fxml"));
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
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/DoctorDetails/DoctorDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    public void viewDonorDetails() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/DonorDetails/donorDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    public void viewVolunteerDetails() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/VolunteerDetails/volunteerDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }

    public void viewSupplyDetails() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../SupplyDetails/supplyDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }

    @FXML
    public void viewAccountsDetails(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Accounts/Accounts.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
}