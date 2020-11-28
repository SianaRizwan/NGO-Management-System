package Registration;

import Registration.RegisterModel;
import Utilities.PhoneValidator;
import Utilities.ShowAlertDialogue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    @FXML
    private AnchorPane registerPane;
    @FXML
    private TextField userNameTextfield, emailTextfield, passwordTextfield, retypePasswordTextfield;

    @FXML
    private void handleBackToLoginPage() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
        registerPane.getChildren().setAll(pane);
    }

    RegisterModel registerModel = new RegisterModel();

    public String getUserNameTextfield() {
        return userNameTextfield.getText().trim();
    }

    public String getEmailTextfield() {
        return emailTextfield.getText().trim();
    }

    public String getPasswordTextfield() {
        return passwordTextfield.getText();
    }

    public String getRetypePasswordTextfield() {
        return retypePasswordTextfield.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
ShowAlertDialogue showAlertDialogue=new ShowAlertDialogue();
@FXML
    public void confirmRegistration(ActionEvent actionEvent) {
        try {
            if (registerModel.validateEmail(getEmailTextfield())) {
                if (getPasswordTextfield().equals(getRetypePasswordTextfield())) {
                    if (registerModel.isRegistrationSuccessful(getUserNameTextfield(), getEmailTextfield(), getPasswordTextfield())) {
                         showAlertDialogue.infoBox("registration Successful!", null, "Failed");
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
                        registerPane.getChildren().setAll(pane);
                    } else
                        showAlertDialogue.infoBox("registration unsuccessful!", null, "Failed");
                }
                else
                    showAlertDialogue.infoBox("pass doesn't mathch!", null, "Failed");

            }
            else
                showAlertDialogue.infoBox("input valid email!", null, "Failed");


        } catch (Exception e) {
            System.out.println(e + "  registerControllerView");
        }

    }



}