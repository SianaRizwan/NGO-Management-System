package EventDetails;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EventsEmployeeController implements Initializable {
    @FXML
    private Pane eventDetailsPane;

    @FXML
    private TableView<Events> eventTable;

    @FXML
    private TableColumn<Events, String> colEventID;

    @FXML
    private TableColumn<Events, String> colEventName;

    @FXML
    private TableColumn<Events, String> colEventDate;

    EventsModel eventsModel = new EventsModel();

    private void populateTableView(){
        colEventID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEventName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEventDate.setCellValueFactory(new PropertyValueFactory<>("eventDate"));

        try {
            eventTable.setItems(eventsModel.getEventsTableRecords());
        } catch (SQLException e) {
            System.out.println("eventEmployeeController: initialize(adding into table)");
            e.printStackTrace();
        }
    }

    @FXML
    void handleRemoveDoctorOption(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTableView();
    }
}
