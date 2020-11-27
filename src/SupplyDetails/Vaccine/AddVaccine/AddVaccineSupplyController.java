package SupplyDetails.Vaccine.AddVaccine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddVaccineSupplyController {

    @FXML
    private AnchorPane addNewVaccinePane;

    @FXML
    private TextField vaccineName;

    @FXML
    private TextField vaccineSupplier;

    @FXML
    private TextField vaccineQuantity;

    @FXML
    private TextField vaccinePrice;

    @FXML
    private DatePicker vaccinePurchaseDate;

    @FXML
    private DatePicker vaccineExpiryDate;

    @FXML
    private TextField vaccineManufacturer;

    @FXML
    void handleConfirmAddVaccine(ActionEvent event) {

    }

}

