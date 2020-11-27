package SupplyDetails;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddFoodSupplyController {

    @FXML
    private AnchorPane addNewSupplyPane;

    @FXML
    private TextField foodName;

    @FXML
    private TextField foodSupplier;

    @FXML
    private TextField foodQuantity;

    @FXML
    private TextField foodPrice;

    @FXML
    private DatePicker foodPurchaseDate;

    @FXML
    private DatePicker foodExpiryDate;

    @FXML
    private Button confirmAddFoodBtn;

    @FXML
    void handleConfirmAddFood(MouseEvent event) {

    }

}
