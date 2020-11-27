package SupplyDetails.Medicine.AddMedicine;

import SupplyDetails.SupplyInformation;
import Utilities.ShowAlertDialogue;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private void handleConfirmAddMedicine(MouseEvent event) throws ParseException {
        Date purDate = new SimpleDateFormat("MM/DD/YYYY").parse(medicinePurchaseDate.getEditor().getText());
        Date expDate = new SimpleDateFormat("MM/DD/YYYY").parse(medicineExpiryDate.getEditor().getText());

        if(new AddMedicineSupplyModel().isAddMedicineSuccessful(medicineName.getText(), purDate, expDate, Integer.parseInt(medicineQuantity.getText()), Integer.parseInt(medicinePrice.getText()), medicineSupplier.getText(),medicineManufacturer.getText())){
            new ShowAlertDialogue().infoBox("Medicine Item Added Successfully", null, "Add Medicine Supply");
            refreshTextField();
        }
    }

    private void refreshTextField() {
        medicineExpiryDate.getEditor().setText("");
        medicinePurchaseDate.getEditor().setText("");
        medicineName.setText("");
        medicinePrice.setText("");
        medicineManufacturer.setText("");
        medicineQuantity.setText("");
        medicineSupplier.setText("");
    }

    public void initialize(){
        TextFields.bindAutoCompletion(medicineName, new SupplyInformation().getItemNameList("select distinct name from HEALTH_PRODUCT"));
        System.out.println("ll");
    }
}

