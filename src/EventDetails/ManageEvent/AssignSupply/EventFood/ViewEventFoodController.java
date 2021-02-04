package EventDetails.ManageEvent.AssignSupply.EventFood;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.SQLException;


public class ViewEventFoodController {
    @FXML
    private TableView<EventFood> informationTable;

    @FXML
    private TableColumn<EventFood, String> colName;

    @FXML
    private TableColumn<EventFood, Integer> colAvailableQty;

    @FXML
    private TableColumn<EventFood, String> colRequiredQty;




    @FXML
    void handleBackButton() {

    }



    public void populateTableView(String id) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAvailableQty.setCellValueFactory(new PropertyValueFactory<>("availableQty"));
        colRequiredQty.setCellValueFactory(new PropertyValueFactory<>("reqQty"));


        colRequiredQty.setCellFactory(TextFieldTableCell.forTableColumn());
       colRequiredQty.setOnEditCommit(event -> {
           event.getTableView().getItems().get(event.getTablePosition().getRow()).setReqQty(Integer.parseInt(event.getNewValue()));
       });
       colRequiredQty.setEditable(true);


        try {
            informationTable.setItems(new ViewEventFoodModel().getTableRecords(id));
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController: initialize");
            throwables.printStackTrace();
        }
    }


}
