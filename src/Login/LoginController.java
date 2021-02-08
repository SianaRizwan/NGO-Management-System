package Login;

import Main.Main;
import Utilities.ShowAlertDialogue;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!Main.isSplashLoaded) {
            try {
                loadSplash();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void loadSplash() throws IOException {
        try {
            Main.isSplashLoaded=true;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../Main/Splash.fxml"));
            loginPane.getChildren().setAll(pane);

            FadeTransition fade = new FadeTransition(Duration.seconds(2.5),pane);
            fade.setFromValue(1);
            fade.setToValue(0.2);
            fade.setCycleCount(1);

            fade.play();
            fade.setOnFinished(event -> {
                try {
                    AnchorPane lPane = FXMLLoader.load(getClass().getResource("../Login/login.fxml"));
                    loginPane.getChildren().setAll(lPane);
                } catch (IOException e) {
                    System.out.println("Splash Screen to login");
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.out.println("Splash Screen");
            e.printStackTrace();
        }
    }
}
