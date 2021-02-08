package Login;

import Utilities.ShowAlertDialogue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController {
    @FXML
    private AnchorPane loginPane;
    @FXML
    private Circle Logo;
    @FXML
    private TextField usernameTextfield, passwordTextfield;


    public String getUsernameTextfield() {
        return usernameTextfield.getText().trim();
    }

    public String getPasswordTextfield() {
        return passwordTextfield.getText();
    }


    LoginModel loginModel = new LoginModel();


    ShowAlertDialogue alert = new ShowAlertDialogue();

    public void initialize(){
        Logo.setStroke(Color.FLORALWHITE);
        Image image = new Image("images/Peace.jpg",false);
        Logo.setFill(new ImagePattern(image));
        Logo.setEffect(new DropShadow(+20d,0d,2d,Color.CRIMSON));
    }
    @FXML
    public void handleLogin() throws IOException {


        if (usernameTextfield.getText().isEmpty() || passwordTextfield.getText().isEmpty()) {

            alert.infoBox("Please enter your username or password", null, "Form Error!");

            return;
        }

        if (loginModel.isLoginSuccessful(getUsernameTextfield(), getPasswordTextfield())) {
            AnchorPane EmployeeDetailsPane = FXMLLoader.load(getClass().getResource("../Main/Dashboard.fxml"));
            loginPane.getChildren().setAll(EmployeeDetailsPane);
        } else {
            alert.infoBox("Please enter correct username and Password", null, "Login");
            usernameTextfield.setText("");
            passwordTextfield.setText("");
            usernameTextfield.requestFocus();
        }
    }


    public void handleChangePassword() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ChangePassword/ChangePassword.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("ChangePassword");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public void handleSignUp() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Registration/register.fxml"));
        loginPane.getChildren().setAll(pane);

    }
}
