package Person.DonorDetails.UpdateDonor;


import Person.PersonalInformation;
import Utilities.PhoneValidator;
import Utilities.ShowAlertDialogue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;

public class UpdateDonorDetailsController {
    @FXML
    private AnchorPane updateDonorPane;
    @FXML
    private TextField DonorID;

    @FXML
    private TextField DonorName;

    @FXML
    private TextField DonorEmailID;

    @FXML
    private TextField DonorPhoneNumber;

    @FXML
    private TextField DonorAddress;

    @FXML
    private TextField DonorOccupation;

    UpdateDonorModel updateDonorModel = new UpdateDonorModel();

    @FXML
    void handleConfirmUpdateBtn() {
        if (new PersonalInformation().checkValidation(DonorEmailID.getText())&& new PhoneValidator().validate(DonorPhoneNumber.getText())){
            if (updateDonorModel.isUpdateDonorSuccessful(DonorAddress.getText(), DonorPhoneNumber.getText(), DonorOccupation.getText(),
                DonorEmailID.getText(), DonorID.getText())) {
            new ShowAlertDialogue().infoBox("update Successful!", null, "update Doctor");
            refreshTextField();

        } }else {
            new ShowAlertDialogue().infoBox("Insert Valid Email or Phone Number", null, "Update Donor" );
        }
    }

    private void refreshTextField() {
        DonorID.setText("");
        DonorName.setText("");
        DonorEmailID.setText("");
        DonorAddress.setText("");
        DonorOccupation.setText("");
        DonorPhoneNumber.setText("");
    }

    public void IDOnEnter() {
        String[] list = new String[4];
        String[] info = updateDonorModel.setDonorInformation(list, DonorID.getText());
        DonorEmailID.setText(info[0]);
        DonorOccupation.setText(info[2]);
        DonorPhoneNumber.setText(info[1]);
        DonorAddress.setText(info[3]);
        DonorName.setText(info[4]);

    }

    public void initialize() {
        TextFields.bindAutoCompletion(DonorID, new PersonalInformation().getIDList("select Donor_id from Donor"));
    }

}
