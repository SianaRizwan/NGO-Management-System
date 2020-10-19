package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;
    @FXML
    private void handleRegister() throws IOException {
        AnchorPane pane  = FXMLLoader.load(getClass().getResource("../View/register.fxml"));
        loginPane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
