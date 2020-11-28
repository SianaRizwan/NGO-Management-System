package SupplyDetails.HealthProducts.AddHealthProd;

import SupplyDetails.SupplyInformation;
import Utilities.ShowAlertDialogue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddHealthProdController {

    @FXML
    private AnchorPane addNewHealthProdPane;

    @FXML
    private TextField healthProdName;

    @FXML
    private TextField healthProdSupplier;

    @FXML
    private TextField healthProdQuantity;

    @FXML
    private TextField healthProdPrice;

    @FXML
    private DatePicker healthProdPurchaseDate;

    @FXML
    private DatePicker healthProdExpiryDate;

    @FXML
    private TextField healthProdManufacturer;

    @FXML
    private ComboBox healthprodTypeCombo;

    private ObservableList<String> type = FXCollections.observableArrayList("Medicine", "Vaccine", "Emergency");

    @FXML
    void handleConfirmAddHealthProd(ActionEvent event) throws ParseException {
        Date purDate = new SimpleDateFormat("MM/DD/YYYY").parse(healthProdPurchaseDate.getEditor().getText());
        Date expDate = new SimpleDateFormat("MM/DD/YYYY").parse(healthProdExpiryDate.getEditor().getText());

        if(new AddHealthProdModel().isAddHealthProdSuccessful(healthProdName.getText(), purDate, expDate, Integer.parseInt(healthProdQuantity.getText()), Integer.parseInt(healthProdPrice.getText()), healthProdSupplier.getText(),healthProdManufacturer.getText(),String.valueOf(healthprodTypeCombo.getValue()))){
            new ShowAlertDialogue().infoBox("Health Product Added Successfully", null, "Add Health Supply");
            refreshTextField();
        }
    }

    private void refreshTextField(){
        healthProdExpiryDate.getEditor().setText("");
        healthProdPurchaseDate.getEditor().setText("");
        healthProdName.setText("");
        healthProdPrice.setText("");
        healthProdManufacturer.setText("");
        healthProdQuantity.setText("");
        healthProdSupplier.setText("");
    }

    public void initialize(){
        healthprodTypeCombo.setItems(type);
        TextFields.bindAutoCompletion(healthProdName, new SupplyInformation().getItemNameList("select distinct name from HEALTH_PRODUCT"));
        System.out.println("ll");
    }

}
