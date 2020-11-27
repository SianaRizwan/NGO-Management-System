package Person.EmployeeDet.ViewEmployeeInformation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewEmployeeInformationController {
    @FXML
    private AnchorPane viewDetails;
    @FXML
    private TextField showEmployeeID;

    @FXML
    private TextField showEmployeeName;

    @FXML
    private TextField showEmployeeDesignation;

    @FXML
    private TextField showEmployeeEmail;

    @FXML
    private TextField showEmployeeContact;

    @FXML
    private TextField showEmployeeDOB;

    @FXML
    private TextField showEmployeeGender;

    @FXML
    private TextField showEmployeeAddress;

    ViewEmployeeInformationModel viewEmployeeInformationModel = new ViewEmployeeInformationModel();

    public void displayInformation(int id) {
        String[] list = new String[8];
        String[] info = viewEmployeeInformationModel.showEmployeeDetails(list, id);
        showEmployeeID.setText(info[0]);
        showEmployeeName.setText(info[1]);
        showEmployeeEmail.setText(info[2]);
        showEmployeeDOB.setText(info[3]);
        showEmployeeGender.setText(info[4]);
        showEmployeeAddress.setText(info[5]);
        showEmployeeContact.setText(info[6]);
        showEmployeeDesignation.setText(info[7]);

    }

    @FXML
    void handleBackButton() throws IOException {
        FXMLLoader.load(getClass().getResource("../employeeDetails.fxml"));
        Stage stage = (Stage) viewDetails.getScene().getWindow();
        stage.close();
    }

   }
