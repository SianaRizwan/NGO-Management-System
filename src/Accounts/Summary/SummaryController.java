package Accounts.Summary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SummaryController implements Initializable {
    @FXML
    private Pane barChartpane;
    public void handlesalaryChart(ActionEvent actionEvent) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SalaryBarchart/salarychart.fxml"));
        barChartpane.getChildren().setAll(pane); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
