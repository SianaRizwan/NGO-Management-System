package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private TextField userIdTextfield, userNameTextfield,emailTextfield,passwordTextfield, retypePasswordTextfield;
    @FXML
    private Button backToLoginPageButton,confirmButton;
   @FXML
   private  void handleBackToLoginPage() throws IOException {
       AnchorPane pane  = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
       registerPane.getChildren().setAll(pane);
   }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
