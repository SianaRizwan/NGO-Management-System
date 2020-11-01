package Registration;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    @FXML
    private AnchorPane registerPane;
    @FXML
    private TextField userNameTextfield, emailTextfield, passwordTextfield, retypePasswordTextfield;
    @FXML
    private Button backToLoginPageButton, confirmButton;

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

    @FXML
    private void handleRegister() {
        try {
            if (registerModel.validateEmail(getEmailTextfield())) {
                if (getPasswordTextfield().equals(getRetypePasswordTextfield())) {
                    if (registerModel.isRegistrationSuccessful(getUserNameTextfield(), getEmailTextfield(), getPasswordTextfield())) {
                        infoBox("registration Successful!", null, "Failed");
                    } else
                        infoBox("registration unsuccessful!", null, "Failed");
                }
                else
                    infoBox("pass doesn't mathch!", null, "Failed");

            }
            else
                infoBox("input valid email!", null, "Failed");


        } catch (Exception e) {
            System.out.println(e + "  registerControllerView");
        }

    }

    private void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
