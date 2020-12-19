package EventDetails.ViewAssignees;

import Person.VolunteerDetails.Volunteer;
import Person.VolunteerDetails.VolunteerDetailsModel;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;

public class AddVolunteersToEventController {
    @FXML
    private AnchorPane viewDetails;
    @FXML
    private AnchorPane viewIDs;
    @FXML
    private GridPane gridPane1;

    @FXML
    private GridPane gridPane2;

    @FXML
    private GridPane gridPane3;

    AddVolunteersToEventModel addVolunteersToEventModel = new AddVolunteersToEventModel();

    private void setID() {
        String[] list = new String[25];
        String[] id = addVolunteersToEventModel.getID(list);
        int k = 0, j = 0;

        for (int i = 0; i < addVolunteersToEventModel.getTotalID(); i++) {

            JFXCheckBox checkBox = new JFXCheckBox(id[i]);
            checkBox.setAlignment(Pos.CENTER_LEFT);
            if (i < 9) {
                gridPane1.addRow(i, checkBox);
            }
            if (i > 8 && i < 18) {
                gridPane2.addRow(k, checkBox);
                k++;
            }
            if (i > 17 && i < 27) {
                gridPane3.addRow(j, checkBox);
                j++;
            }
        }

    }

  /*  private void setSearchedID(FilteredList<Volunteer> filteredList) {
        String[] list = new String[25];
        String[] id = addVolunteersToEventModel.getID(list);
        int k = 0, j = 0;

        for (int i = 0; i < addVolunteersToEventModel.getTotalID(); i++) {

            JFXCheckBox checkBox = new JFXCheckBox(filteredList);
            checkBox.setAlignment(Pos.CENTER_LEFT);
            if (i < 9) {
                gridPane1.addRow(i, checkBox);
            }
            if (i > 8 && i < 18) {
                gridPane2.addRow(k, checkBox);
                k++;
            }
            if (i > 17 && i < 27) {
                gridPane3.addRow(j, checkBox);
                j++;
            }
        }

    }

    private void searchFilterData(TextField searchField) {
        try {
            FilteredList<Volunteer> filteredList = new FilteredList<>(VolunteerDetailsModel.getVolunteerTableRecords(), b -> true);

            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(volunteer -> VolunteerDetailsModel.isMatchSuccessful(newValue, volunteer));
                setSearchedID(filteredList);
            });
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController : search box");
            throwables.printStackTrace();
        }
    }
*/

    public void initialize() {
        setID();
    }

    @FXML
    void handleBackButton() {

    }
}
