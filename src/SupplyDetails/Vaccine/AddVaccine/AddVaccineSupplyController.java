package SupplyDetails.Vaccine.AddVaccine;

import SupplyDetails.Medicine.AddMedicine.AddMedicineSupplyModel;
import SupplyDetails.SupplyInformation;
import Utilities.ShowAlertDialogue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private void handleConfirmAddVaccine(ActionEvent event) throws ParseException {
        Date purDate = new SimpleDateFormat("MM/DD/YYYY").parse(vaccinePurchaseDate.getEditor().getText());
        Date expDate = new SimpleDateFormat("MM/DD/YYYY").parse(vaccineExpiryDate.getEditor().getText());

        if(new AddMedicineSupplyModel().isAddMedicineSuccessful(vaccineName.getText(), purDate, expDate, Integer.parseInt(vaccineQuantity.getText()), Integer.parseInt(vaccinePrice.getText()), vaccineSupplier.getText(),vaccineManufacturer.getText())){
            new ShowAlertDialogue().infoBox("Vaccine Item Added Successfully", null, "Add Vaccine Supply");
            refreshTextField();
        }
    }

    private void refreshTextField() {
        vaccineExpiryDate.getEditor().setText("");
        vaccinePurchaseDate.getEditor().setText("");
        vaccineName.setText("");
        vaccinePrice.setText("");
        vaccineManufacturer.setText("");
        vaccineQuantity.setText("");
        vaccineSupplier.setText("");
    }

    public void initialize(){
        TextFields.bindAutoCompletion(vaccineName, new SupplyInformation().getItemNameList("select distinct name from HEALTH_PRODUCT"));
        System.out.println("ll");
    }

}

