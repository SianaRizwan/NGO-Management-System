package EventDetails.ManageEvent.AssignSupply;

import EventDetails.ManageEvent.ManageEventController;
import SupplyDetails.Food.Food;
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

public class ViewAssignedFoodController {
    @FXML
    private AnchorPane viewDetails;

    @FXML
    private TableView<Food> informationTable;

    @FXML
    private TableColumn<Food, String> colId;

    @FXML
    private TableColumn<Food, String> colName;

    @FXML
    private TableColumn<Food, Integer> colQuantity;

    @FXML
    private TableColumn<Food, Integer> colPrice;

    @FXML
    private TableColumn<Food, Date> colExpDate;

    @FXML
    private TableColumn<Food, String> colSupplier;

    @FXML
    void handleBackButton() throws IOException {
        FXMLLoader.load(getClass().getResource("../../../ManageEvent/ManageEventEmployees.fxml"));
        Stage stage = (Stage) viewDetails.getScene().getWindow();
        stage.close();
    }

    private void populateTableView(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<>("edate"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));

        try {
            informationTable.setItems(new ViewAssignedFoodModel().getTableRecords(new ManageEventController().getEventID()));
        } catch (SQLException e) {
            System.out.println("viewFoodController: initialize");
            e.printStackTrace();
        }
    }

    public void initialize() {
        populateTableView();
    }
}
