package Person.DonorDetails.AddDonor;

import Utilities.ShowAlertDialogue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class AddDonorController {
    @FXML
    private AnchorPane addDonorPane;

    @FXML
    private TextField DonorName;

    @FXML
    private TextField DonorEmailID;

    @FXML
    private TextField DonorPhoneNumber;

    @FXML
    private ComboBox DonorGender;

    @FXML
    private TextField DonorAddress;

    @FXML
    private TextField DonorOccupation;

    private ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Others");
    public void initialize() {
        DonorGender.setItems(gender);

    }


    public void handleDonorAddConfirmBtn() {
        if(new AddDonorModel().isAddDonorSuccessful(DonorName.getText(),DonorGender.getSelectionModel().getSelectedItem().toString(),
                DonorAddress.getText(),DonorPhoneNumber.getText(),DonorOccupation.getText(),DonorEmailID.getText())){
            new ShowAlertDialogue().infoBox("Donor Add Successful!", null, "Add Donor");
            refreshTextField();

        }
    }

    private void refreshTextField() {
        DonorName.setText("");
        DonorEmailID.setText("");
        DonorAddress.setText("");
        DonorOccupation.setText("");
        DonorPhoneNumber.setText("");
    }
}
