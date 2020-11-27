package SupplyDetails.Medicine;

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

public class MedicineController implements Initializable {

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
    private void handleAddMedicine(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddMedicine/addMedicineSupply.fxml"));
        medicineDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    void handleDeleteMedicine(ActionEvent event) {

    }

    @FXML
    void handleUpdateMedicine(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

