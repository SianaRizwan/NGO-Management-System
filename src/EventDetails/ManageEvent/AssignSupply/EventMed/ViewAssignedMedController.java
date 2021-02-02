package EventDetails.ManageEvent.AssignSupply.EventMed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ViewAssignedMedController {
    @FXML
    private AnchorPane viewDetails;

    @FXML
    private TableView<?> informationTable;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colExpDate;

    @FXML
    private TableColumn<?, ?> colManufacturer;

    @FXML
    void handleBackButton(ActionEvent event) {

    }
}
