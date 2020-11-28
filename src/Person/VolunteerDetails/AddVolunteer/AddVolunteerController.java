package Person.VolunteerDetails.AddVolunteer;

import Utilities.ShowAlertDialogue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddVolunteerController {
   @FXML
   public AnchorPane addVolunteerPane;
    @FXML
    private TextField VolunteerName;

    @FXML
    private TextField VolunteerEmailID;

    @FXML
    private TextField VolunteerPhoneNumber;

    @FXML
    private ComboBox VolunteerGender;

    @FXML
    private TextField VolunteerAddress;


    @FXML
    private TextField VolunteerOccupation;
    private ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Others");
    public void initialize() {
        VolunteerGender.setItems(gender);

    }

@FXML
    public void handleConfirmVolunteerAddBtn() {
        if(new AddVolunteerModel().isAddVolunteerSuccessful(VolunteerName.getText(),VolunteerGender.getSelectionModel().getSelectedItem().toString(),
                VolunteerAddress.getText(),VolunteerPhoneNumber.getText(),VolunteerOccupation.getText(),VolunteerEmailID.getText())){
            new ShowAlertDialogue().infoBox("Volunteer Add Successful!", null, "Add Volunteer");
            refreshTextField();

        }
    }

    private void refreshTextField() {
        VolunteerName.setText("");
        VolunteerEmailID.setText("");
        VolunteerAddress.setText("");
        VolunteerOccupation.setText("");
        VolunteerPhoneNumber.setText("");
    }

}
