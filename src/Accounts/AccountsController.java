package Accounts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AccountsController {
    @FXML
    private Pane AccountsPane;

    public void handleAccountsDesig() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Designation/DesignationDetails.fxml"));
        AccountsPane.getChildren().setAll(pane); }

    public void handleAccountsExpenses() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Expenses/ExpensesDetails.fxml"));
        AccountsPane.getChildren().setAll(pane);
    }

    public void handleAccountsSummary() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Summary/summary.fxml"));
        AccountsPane.getChildren().setAll(pane);
    }

    public void handleAccountsDonation(ActionEvent actionEvent) {
    }
}
