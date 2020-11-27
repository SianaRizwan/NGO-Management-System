package SupplyDetails;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplyDetailsController implements Initializable {

    @FXML
    private Pane supplyDetailsPane;

    @FXML
    public void handleSupplyEmergency(ActionEvent event) {

    }

    @FXML
    private void handleSupplyFood(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Food/food.fxml"));
        supplyDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    public void handleSupplyMedicine(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Medicine/medicine.fxml"));
        supplyDetailsPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}

