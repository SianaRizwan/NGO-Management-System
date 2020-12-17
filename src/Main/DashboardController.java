package Main;

import Login.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private BorderPane employeeDetailsBorderPane;

    @FXML
    private  AnchorPane mainPane;

    @FXML
    private HBox dashboardAccounts;

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
        if (!(new LoginModel().getDesignation().contains("Admin"))){
            dashboardAccounts.setVisible(false);
        }
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
    public void viewAccountsDetails() throws IOException {
       AnchorPane pane=FXMLLoader.load(getClass().getResource("../Accounts/Accounts.fxml"));
       employeeDetailsBorderPane.setCenter(pane);
    }
    @FXML
    public void viewEventsDetails() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../EventDetails/Events.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
}