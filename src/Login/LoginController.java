package Login;

import Utilities.ShowAlertDialogue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField usernameTextfield,passwordTextfield;



    public String getUsernameTextfield() {
        return usernameTextfield.getText().trim();
    }

    public String getPasswordTextfield() {
        return passwordTextfield.getText();
    }


    LoginModel loginModel = new LoginModel();


ShowAlertDialogue alert=new ShowAlertDialogue();


    @FXML
    public void handleLogin() throws IOException {


        if (usernameTextfield.getText().isEmpty()||passwordTextfield.getText().isEmpty()) {

            alert.infoBox("Please enter your username", null, "Form Error!" );

            return;
        }

        if (loginModel.isLoginSuccessful(getUsernameTextfield(), getPasswordTextfield())) {
            alert.infoBox("Login Successful!", null, "Login" );

            AnchorPane EmployeeDetailsPane  = FXMLLoader.load(getClass().getResource("../Main/Dashboard.fxml"));
            loginPane.getChildren().setAll(EmployeeDetailsPane);
        } else {
            alert.infoBox("Please enter correct username and Password", null, "Login" );
            usernameTextfield.setText("");
            passwordTextfield.setText("");
            usernameTextfield.requestFocus();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
