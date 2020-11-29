package Person.DoctorDetails.ViewDoctorInformation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewDoctorInformationController {
    @FXML
    private AnchorPane viewDetails;

    @FXML
    private TextField showDoctorID;

    @FXML
    private TextField showDoctorName;

    @FXML
    private TextField showDoctorSpeciality;

    @FXML
    private TextField showDoctorEmail;

    @FXML
    private TextField showDoctorContact;

    @FXML
    private TextField showDoctorDOB;

    @FXML
    private TextField showDoctorGender;

    @FXML
    private TextField showDoctorAddress;

    @FXML
    private TextField showDoctorAvailableTime;

    @FXML
    private TextField showDoctorQualification;
    ViewDoctorInformationModel viewDoctorInformationModel = new ViewDoctorInformationModel();

    public void displayInformation(String id) {
        String[] list = new String[8];
        String[] info = viewDoctorInformationModel.showDoctorDetails(list, id);
        showDoctorID.setText(info[0]);
        showDoctorName.setText(info[1]);
        showDoctorEmail.setText(info[2]);
        showDoctorDOB.setText(info[3]);
        showDoctorGender.setText(info[4]);
        showDoctorAddress.setText(info[5]);
        showDoctorContact.setText(info[6]);
        showDoctorSpeciality.setText(info[7]);
        showDoctorAvailableTime.setText(info[8]);
        showDoctorQualification.setText(info[9]);

    }

   @FXML
    void handleBackButton() throws IOException {
        FXMLLoader.load(getClass().getResource("../DoctorDetails.fxml"));
        Stage stage = (Stage) viewDetails.getScene().getWindow();
        stage.close();
    }

   }
