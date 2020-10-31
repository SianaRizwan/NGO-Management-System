package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField usernameTextfield,passwordTextfield;
    @FXML
    private Button loginButton,registerButton;
    @FXML
    private void handleRegister() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Registration/register.fxml"));
        loginPane.getChildren().setAll(pane);
    }
    @FXML
    private void handleLogin() throws IOException {
        AnchorPane EmployeeDetailsPane  = FXMLLoader.load(getClass().getResource("../Main/main.fxml"));
        loginPane.getChildren().setAll(EmployeeDetailsPane);
    }
    public String getUsernameTextfield() {
        return usernameTextfield.getText().trim();
    }

    public String getPasswordTextfield() {
        return passwordTextfield.getText();
    }


    LoginModel loginModel = new LoginModel();

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        Window owner = loginButton.getScene().getWindow();


        if (usernameTextfield.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your username");
            return;
        }
        if (passwordTextfield.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }
        if (loginModel.isLoginSuccessful(getUsernameTextfield(), getPasswordTextfield())) {
            infoBox("Login Successful!", null, "Failed");

            AnchorPane EmployeeDetailsPane  = FXMLLoader.load(getClass().getResource("../EmployeeInformation/employeeDetails.fxml"));
            loginPane.getChildren().setAll(EmployeeDetailsPane);
        } else {
            infoBox("Please enter correct username and Password", null, "Failed");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
