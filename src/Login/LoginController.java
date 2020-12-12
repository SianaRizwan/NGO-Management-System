package Login;

import Utilities.ShowAlertDialogue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField usernameTextfield,passwordTextfield;

    @FXML
    private Label changePassword;

    @FXML
    private Label signUp;

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

    public void handleChangePassword() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("ChangePassword/ChangePassword.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("ChangePassword");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void handleSignUp() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../Registration/register.fxml"));
        loginPane.getChildren().setAll(pane);

    }
}
