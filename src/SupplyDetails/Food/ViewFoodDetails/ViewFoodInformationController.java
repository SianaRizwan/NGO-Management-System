package SupplyDetails.Food.ViewFoodDetails;

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

public class ViewFoodInformationController {
    @FXML
    private AnchorPane foodDetailsPane;

    @FXML
    private TableView<Food> informationTable;

    @FXML
    private TableColumn<Food, String> colID;

    @FXML
    private TableColumn<Food, String> colName;

    @FXML
    private TableColumn<Food, Date> colPurchaseDate;

    @FXML
    private TableColumn<Food, Date> colExpireDate;

    @FXML
    private TableColumn<Food, String> colSupplier;

    @FXML
    private TableColumn<Food, Integer> colQuantity;

    @FXML
    private TableColumn<Food, Integer> colPrice;

    ViewFoodInformationModel view=new ViewFoodInformationModel();

    @FXML
    void handleBackButton() throws IOException {
        FXMLLoader.load(getClass().getResource("../food.fxml"));
        Stage stage = (Stage) foodDetailsPane.getScene().getWindow();
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

        try {
            informationTable.setItems(view.getFoodTableRecords(name));
        } catch (SQLException throwables) {
            System.out.println("foodController: initialize");
            throwables.printStackTrace();
        }
    }
}
