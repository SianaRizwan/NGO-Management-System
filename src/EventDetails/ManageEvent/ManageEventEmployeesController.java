package EventDetails.ManageEvent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ManageEventEmployeesController {
    @FXML
    private Pane createEventPane;

    @FXML
    private JFXTextField eventName;

    @FXML
    private JFXTextField estimatedBudget;

    @FXML
    private FontAwesomeIconView docIcon;

    @FXML
    private FontAwesomeIconView supplyList;

    @FXML
    private Label eventSupplyName;

    @FXML
    private FontAwesomeIconView addSupply;

    @FXML
    private JFXDatePicker eventDate;

    @FXML
    void handleAddSupply(MouseEvent event) {

    }

    @FXML
    void handleAddVol(MouseEvent event) {

    }

    @FXML
    void handleBackBtn(MouseEvent event) {

    }

    @FXML
    void handleConfirmBtn(ActionEvent event) {

    }

    @FXML
    void handleEventID(InputMethodEvent event) {

    }

    @FXML
    void handleViewAssignedSupply(MouseEvent event) {

    }

    @FXML
    void handleViewAssignedVolunteers(MouseEvent event) {

    }
}
