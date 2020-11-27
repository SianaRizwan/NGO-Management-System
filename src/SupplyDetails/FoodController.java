package SupplyDetails;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

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
    public void handleAddFood(ActionEvent event) {

    }

    @FXML
    public void handleDeleteFood(ActionEvent event) {

    }

    @FXML
    public void handleUpdateFood(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
