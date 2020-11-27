package SupplyDetails;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

    @FXML
    private Pane foodDetailsPane;

    @FXML
    private TableView<?> foodTable;

    @FXML
    private TableColumn<?, ?> colFoodItemID;

    @FXML
    private TableColumn<?, ?> colFoodName;

    @FXML
    private TableColumn<?, ?> colFoodQuantity;

    @FXML
    private TableColumn<?, ?> colFoodBuyingPrice;

    @FXML
    private TextField searchFoodTextField;

    @FXML
    private Label searchFoodLabel;

    @FXML
    private void handleAddFood(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("addFoodSupply.fxml"));
        foodDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleDeleteFood(ActionEvent event) {

    }

    @FXML
    private void handleUpdateFood(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
