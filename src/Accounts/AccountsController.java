package Accounts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountsController implements Initializable {

    @FXML
    private Pane AccountsPane;

    @FXML
    private void handleAccountsDesig(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Designation/DesignationDetails.fxml"));
        AccountsPane.getChildren().setAll(pane);
    }

    @FXML
    void handleAccountsDonation(ActionEvent event) {

    }

    @FXML
    void handleAccountsEvent(ActionEvent event) {

    }

    @FXML
    void handleAccountsExpenses(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

