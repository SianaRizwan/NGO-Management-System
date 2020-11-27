package SupplyDetails.Medicine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MedicineController {

    @FXML
    private Pane medicineDetailsPane;

    @FXML
    private TableView<?> medicineTable;

    @FXML
    private TableColumn<?, ?> colMedicineItemID;

    @FXML
    private TableColumn<?, ?> colMedicineName;

    @FXML
    private TableColumn<?, ?> colMedicineQuantity;

    @FXML
    private TableColumn<?, ?> colMedicineBuyingPrice;

    @FXML
    private TextField searchMedicineTextField;

    @FXML
    private Label searchMedicineLabel;

    @FXML
    void handleAddMedicine(MouseEvent event) {

    }

    @FXML
    void handleDeleteMedicine(ActionEvent event) {

    }

    @FXML
    void handleUpdateMedicine(ActionEvent event) {

    }

}

