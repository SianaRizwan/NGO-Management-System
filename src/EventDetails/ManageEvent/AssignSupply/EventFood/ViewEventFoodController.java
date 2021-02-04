package EventDetails.ManageEvent.AssignSupply.EventFood;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
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


        //problem
        {
          /*  Callback<TableColumn<EventFood, String>, TableCell<EventFood, String>> cellFactory1 = (param) -> {
//tablecell button
                final TableCell<EventFood, String> cell = new TableCell<EventFood, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //cell is created only on non-empty rows
                        if (empty) {
                            setGraphic(null);
                        } else {
                            final TextField details = new TextField();
                            details.getStyleClass().clear();
                            details.getStyleClass().add("second-text-field");
                            details.setOnAction(event -> {
                                EventFood h = getTableView().getItems().get(getIndex());
                                //write code
                                details.setText(String.valueOf(h.reqQty));
                                details.setEditable(true);
                                new ViewEventFoodModel().isAmountAddSuccessful(h.getReqQty(), id, h.getName());
                                System.out.println("ooooooooooooooooooo");
                            });
                            setGraphic(details);
                        }
                        setText(null);
                    }


                };

                return cell;
            };
            colRequiredQty.setCellFactory(cellFactory1);
*/

       colRequiredQty.setCellFactory(TextFieldTableCell.forTableColumn());
       colRequiredQty.setOnEditCommit(
               new EventHandler<TableColumn.CellEditEvent<EventFood, String>>() {
                   @Override
                   public void handle(TableColumn.CellEditEvent<EventFood, String> event) {
                       ((EventFood) event.getTableView().getItems().get(event.getTablePosition().getRow())).setReqQty(Integer.parseInt(event.getNewValue()));
                   }
    });
       informationTable.setEditable(true);

        }


        try {
            informationTable.setItems(new ViewEventFoodModel().getTableRecords(id));
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController: initialize");
            throwables.printStackTrace();
        }
    }


}
