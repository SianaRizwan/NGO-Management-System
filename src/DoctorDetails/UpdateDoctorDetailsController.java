package DoctorDetails;

import EmployeeDet.EmployeeDetailsModel;
import Utilities.ShowAlertDialogue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateDoctorDetailsController {
    UpdateDoctorDetailsModel updateDoctorDetailsModel=new UpdateDoctorDetailsModel();
    @FXML
    private AnchorPane updateDoctorePane;

    @FXML
    private TextField DoctorID;

    @FXML
    private TextField DoctorName;

    @FXML
    private TextField DoctorEmailID;

    @FXML
    private TextField DoctorPhoneNumber;

    @FXML
    private Button confirmUpdateBtn;

    @FXML
    private TextField DoctorAvailableTime;

    @FXML
    private TextField DoctorAddress;

    @FXML
    private TextField DoctorQualification;


    public void IDOnEnter(ActionEvent actionEvent) {
        String[] list = new String[6];
        String info[] = updateDoctorDetailsModel.setDoctorInformation(list, DoctorID.getText());
        DoctorName.setText(info[0]);
        DoctorEmailID.setText(info[1]);
        DoctorPhoneNumber.setText(info[2]);
        DoctorQualification.setText(info[3]);
        DoctorAddress.setText(info[4]);
        DoctorAvailableTime.setText(info[5]);
    }

    public void handleConfirmButton(MouseEvent mouseEvent) {
        if (updateDoctorDetailsModel.isUpdateDoctorSuccessful(DoctorAddress.getText(),DoctorPhoneNumber.getText(),
                DoctorQualification.getText(),DoctorEmailID.getText(),DoctorAvailableTime.getText(),DoctorID.getText())){
            new ShowAlertDialogue().infoBox("update Successful!", null, "update Doctor");
            refreshTextField();

        }
    }

    private void refreshTextField() {
        DoctorAddress.setText("");
        DoctorPhoneNumber.setText("");
        DoctorQualification.setText("");
        DoctorEmailID.setText("");
        DoctorAvailableTime.setText("");
        DoctorID.setText("");
        DoctorName.setText("");
    }
    public void initialize() {
        TextFields.bindAutoCompletion(DoctorID, updateDoctorDetailsModel.getDoctorIDList());
    }
}