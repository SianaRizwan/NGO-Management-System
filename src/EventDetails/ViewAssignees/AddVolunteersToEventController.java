package EventDetails.ViewAssignees;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
    JFXCheckBox[] checkBox = new JFXCheckBox[addVolunteersToEventModel.getTotalID()];
    String[] list = new String[addVolunteersToEventModel.getTotalID()];

    private void setID() {
        String[] id = addVolunteersToEventModel.getID(list);
        int k = 0, j = 0;

        for (int i = 0; i < addVolunteersToEventModel.getTotalID(); i++) {
            checkBox[i] = new JFXCheckBox(id[i]);
            checkBox[i].setAlignment(Pos.CENTER_LEFT);
            if (i < 9) {
                gridPane1.addRow(i, checkBox[i]);
            }
            if (i > 8 && i < 18) {
                gridPane2.addRow(k, checkBox[i]);
                k++;
            }
            if (i > 17 && i < 27) {
                gridPane3.addRow(j, checkBox[i]);
                j++;
            }
        }

    }

    private void getSelectedVolunteers(){

        for(int i=0; i<addVolunteersToEventModel.getTotalID(); i++){
            if(checkBox[i].isSelected()){
                list[i]=checkBox[i].getText();
                System.out.println(list[i]);
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
    void handleConfirmButton(ActionEvent event) {
        getSelectedVolunteers();
    }

    @FXML
    void handleBackButton() {

    }
}
