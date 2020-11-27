package SupplyDetails.Medicine.AddMedicine;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddMedicineSupplyController {

    @FXML
    private AnchorPane addNewMedicinePane;

    @FXML
    private TextField medicineName;

    @FXML
    private TextField medicineSupplier;

    @FXML
    private TextField medicineQuantity;

    @FXML
    private TextField medicinePrice;

    @FXML
    private DatePicker medicinePurchaseDate;

    @FXML
    private DatePicker medicineExpiryDate;

    @FXML
    private TextField medicineManufacturer;

    @FXML
    void handleConfirmAddMedicine(MouseEvent event) {

    }

}

