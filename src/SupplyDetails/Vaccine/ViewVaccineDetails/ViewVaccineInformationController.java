package SupplyDetails.Vaccine.ViewVaccineDetails;

import SupplyDetails.Vaccine.Vaccine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class ViewVaccineInformationController {

    @FXML
    private AnchorPane vaccineDetailsPane;

    @FXML
    private TableView<Vaccine> informationTableVaccine;

    @FXML
    private TableColumn<Vaccine, String> colID;

    @FXML
    private TableColumn<Vaccine, String> colName;

    @FXML
    private TableColumn<Vaccine, Date> colPurchaseDate;

    @FXML
    private TableColumn<Vaccine, Date> colExpireDate;

    @FXML
    private TableColumn<Vaccine, Integer> colQuantity;

    @FXML
    private TableColumn<Vaccine, String> colSupplier;

    @FXML
    private TableColumn<Vaccine, String> colManufacturer;

    @FXML
    private TableColumn<Vaccine, Integer> colPrice;

    @FXML
    private TableColumn<Vaccine, Integer> colType;

    ViewVaccineInformationModel view = new ViewVaccineInformationModel();

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader.load(getClass().getResource("../vaccine.fxml"));
        Stage stage = (Stage) vaccineDetailsPane.getScene().getWindow();
        stage.close();
    }

    public void displayInformation(String name) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPurchaseDate.setCellValueFactory(new PropertyValueFactory<>("pdate"));
        colExpireDate.setCellValueFactory(new PropertyValueFactory<>("edate"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        colManufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));

        try {
            informationTableVaccine.setItems(view.getVaccineTableRecords(name));
        } catch (SQLException throwables) {
            System.out.println("medController: initialize");
            throwables.printStackTrace();
        }

    }

}
