package Registration;

import Person.PersonalInformation;
import Person.Validation;
import Utilities.ShowAlertDialogue;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    @FXML
    private AnchorPane registerPane;


    @FXML
    private Button confirmButton;

    @FXML
    private Button backToLoginPageButton;

    @FXML
    private JFXTextField userNameTextfield;

    @FXML
    private JFXTextField emailTextfield;

    @FXML
    private JFXPasswordField passwordTextfield;

    @FXML
    private JFXTextField employeePhoneNumber;

    @FXML
    private JFXComboBox employeeGender;

    @FXML
    private JFXDatePicker employeeDOB;

    @FXML
    private JFXTextField employeeAddress;

    @FXML
    private JFXPasswordField retypePasswordTextfield;

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

    private ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Others");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeGender.setItems(gender);

    }

    ShowAlertDialogue showAlertDialogue = new ShowAlertDialogue();

    @FXML
    public void confirmRegistration() {
        try {
            Date dobDate = new SimpleDateFormat("MM/dd/yyyy").parse(employeeDOB.getEditor().getText());

            if (new Validation().checkEmailAndPhoneValidation(getEmailTextfield(), employeePhoneNumber.getText())) {
                if (new Validation().checkPasswordValidation(getPasswordTextfield())) {
                    if (getPasswordTextfield().equals(getRetypePasswordTextfield())) {
                        if (registerModel.isRegistrationSuccessful(getUserNameTextfield(), dobDate, employeeGender.getSelectionModel().getSelectedItem().toString(),
                                employeeAddress.getText(), employeePhoneNumber.getText(), getEmailTextfield(), getPasswordTextfield())) {
                            showAlertDialogue.infoBox("registration Successful!", null, "Failed");
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
                            registerPane.getChildren().setAll(pane);
                        } else
                            showAlertDialogue.infoBox("registration unsuccessful!", null, "Failed");
                    } else
                        showAlertDialogue.infoBox("pass doesn't mathch!", null, "Failed");

                } else
                    showAlertDialogue.infoBox("input valid password!", null, "Failed");
            } else
                showAlertDialogue.infoBox("input valid email and contact number!", null, "Failed");


        } catch (Exception e) {
            System.out.println(e + "  registerControllerView");
        }

    }


}