package SupplyDetails.Vaccine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class VaccineController {

    @FXML
    private Pane vaccineDetailsPane;

    @FXML
    private TableView<?> vaccineTable;

    @FXML
    private TableColumn<?, ?> colVaccineItemID;

    @FXML
    private TableColumn<?, ?> colVaccineName;

    @FXML
    private TableColumn<?, ?> colVaccineQuantity;

    @FXML
    private TableColumn<?, ?> colVaccineBuyingPrice;

    @FXML
    private TextField searchVaccineTextField;

    @FXML
    private Label searchVaccineLabel;

    @FXML
    void handleAddVaccine(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../HealthProducts/AddHealthProd/addHealthProd.fxml"));
        vaccineDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    void handleDeleteVaccine(ActionEvent event) {

    }

    @FXML
    void handleUpdateVaccine(ActionEvent event) {

    }

}

