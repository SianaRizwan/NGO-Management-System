package SupplyDetails.Vaccine;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class VaccineController implements Initializable {

    @FXML
    private Pane vaccineDetailsPane;

    @FXML
    private TableView<SupplyDetails.Vaccine.Vaccine> vaccineTable;

    @FXML
    private TableColumn<?, ?> colVaccineItemID;

    @FXML
    private TableColumn<SupplyDetails.Vaccine.Vaccine, String> colVaccineName;

    @FXML
    private TableColumn<SupplyDetails.Vaccine.Vaccine, Integer> colVaccineQuantity;

    @FXML
    private TableColumn<SupplyDetails.Vaccine.Vaccine, Integer> colVaccineBuyingPrice;

    @FXML
    private TextField searchVaccineTextField;

    @FXML
    private Label searchVaccineLabel;

    VaccineModel vaccineModel = new VaccineModel();

    @FXML
    void handleAddVaccine(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../HealthProducts/AddHealthProd/addHealthProd.fxml"));
        vaccineDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    void handleDeleteVaccine(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTableView();
        searchFilterData(searchVaccineTextField, vaccineTable);
    }

    private void populateTableView(){
        colVaccineName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colVaccineQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colVaccineBuyingPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            vaccineTable.setItems(vaccineModel.getVaccineTableRecords());
        } catch (SQLException e) {
            System.out.println("vaccineController: initialize");
            e.printStackTrace();
        }
    }

    private void searchFilterData(TextField searchField, TableView<Vaccine> table) {
        try {
            FilteredList<Vaccine> filteredList = new FilteredList<>(vaccineModel.getVaccineTableRecords(), b -> true);

            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(vaccine -> vaccineModel.isMatchSuccessful(newValue, vaccine));
                sortFilteredData(filteredList, table);
            });
        } catch (SQLException throwables) {
            System.out.println("vacDetailsController : search box");
            throwables.printStackTrace();
        }
    }

    private void sortFilteredData(FilteredList<Vaccine> filteredList, TableView<Vaccine> vaccineTable) {
        SortedList<Vaccine> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(vaccineTable.comparatorProperty());
        vaccineTable.setItems(sortedList);
    }

}

