package Main;

import Login.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    String eventDetails = "../EventDetails/Events.fxml";
    @FXML
    private BorderPane employeeDetailsBorderPane;

    @FXML
    private  AnchorPane mainPane;
    @FXML
    private Circle Logo;
    @FXML
    private HBox dashboardAccounts;
    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private void viewEmployeeDetails() throws IOException{
        label1.setVisible(false);
        label2.setVisible(false);
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
        Logo.setStroke(Color.FLORALWHITE);
        Image image = new Image("images/Peace.jpg",false);
        Logo.setFill(new ImagePattern(image));
        Logo.setEffect(new DropShadow(+20d,0d,2d,Color.CRIMSON));
        if (!(new LoginModel().getDesignation().contains("Admin"))){
            dashboardAccounts.setVisible(false);
            eventDetails="../EventDetails/EventsEmployee.fxml";
        }
    }

    public void viewDoctorDetails() throws IOException {
        label1.setVisible(false);
        label2.setVisible(false);
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/DoctorDetails/DoctorDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    public void viewDonorDetails() throws IOException {
        label1.setVisible(false);
        label2.setVisible(false);
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/DonorDetails/donorDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    public void viewVolunteerDetails() throws IOException {
        label1.setVisible(false);
        label2.setVisible(false);
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Person/VolunteerDetails/volunteerDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }

    public void viewSupplyDetails() throws IOException {
        label1.setVisible(false);
        label2.setVisible(false);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../SupplyDetails/supplyDetails.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }

    @FXML
    public void viewAccountsDetails() throws IOException {
        label1.setVisible(false);
        label2.setVisible(false);
        AnchorPane pane=FXMLLoader.load(getClass().getResource("../Accounts/Accounts.fxml"));
        employeeDetailsBorderPane.setCenter(pane);
    }
    @FXML
    public void viewEventsDetails() throws IOException {
        label1.setVisible(false);
        label2.setVisible(false);
        AnchorPane pane = FXMLLoader.load(getClass().getResource(eventDetails));
        employeeDetailsBorderPane.setCenter(pane);
    }
}