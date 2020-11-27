package SupplyDetails.Medicine;

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

public class MedicineController implements Initializable {

    @FXML
    private Pane medicineDetailsPane;

    @FXML
    private TableView<Medicine> medicineTable;

    @FXML
    private TableColumn<Medicine, String> colMedicineItemID;

    @FXML
    private TableColumn<Medicine, String> colMedicineName;

    @FXML
    private TableColumn<Medicine, Integer> colMedicineQuantity;

    @FXML
    private TableColumn<Medicine, Integer> colMedicineBuyingPrice;

    @FXML
    private TextField searchMedicineTextField;

    @FXML
    private Label searchMedicineLabel;

    MedicineModel medicineModel = new MedicineModel();

    @FXML
    private void handleAddMedicine(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddMedicine/addMedicineSupply.fxml"));
        medicineDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    void handleDeleteMedicine(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTableView();
    }

    private void populateTableView(){
        colMedicineItemID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMedicineName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMedicineQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colMedicineBuyingPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            medicineTable.setItems(medicineModel.getMedicineTableRecords());
        } catch (SQLException e) {
            System.out.println("medicineController: initialize");
            e.printStackTrace();
        }
    }
}

