package EventDetails.ViewAssignees.Volunteers;

import Utilities.ShowAlertDialogue;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddVolunteersToEventController {
    @FXML
    private AnchorPane viewDetails;
    @FXML
    private AnchorPane viewIDs;
    @FXML
    private JFXTextField searchOption;
    @FXML
    private GridPane gridPane1;
    @FXML
    private GridPane gridPane2;

    @FXML
    private GridPane gridPane3;

    AddVolunteersToEventModel addVolunteersToEventModel = new AddVolunteersToEventModel();
    JFXCheckBox[] checkBox = new JFXCheckBox[addVolunteersToEventModel.getTotalID()];
    String[] list = new String[addVolunteersToEventModel.getTotalID()];
    ArrayList<String> selectedID = new ArrayList<String>();

    private void setName() {
        String[] id = addVolunteersToEventModel.getVolunteerList(list);
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
                selectedID.add(checkBox[i].getText());
            }
        }
    }

    private void setSearchedName(String text) {

        String[] id = addVolunteersToEventModel.getSearchedList(list,text);
        int k = 0, j = 0;
        gridPane1.getChildren().clear();
        gridPane2.getChildren().clear();
        gridPane3.getChildren().clear();

        for (int i = 0; i < 28; i++) {

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

    public void initialize() {
        setName();
    }

    @FXML
    void handleBackButton() throws IOException {
        FXMLLoader.load(getClass().getResource("../../ManageEvent/ManageEvent.fxml"));
        Stage stage = (Stage) viewDetails.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleConfirmButton(ActionEvent event) {
        getSelectedVolunteers();
        //System.out.println(selectedID);
        if(addVolunteersToEventModel.isAssignVolunteerSuccessful(selectedID,"F_Ev201210001")){
            new ShowAlertDialogue().infoBox("Volunteers Assigned!",null,"Assign Volunteer");
        }
        else {
            new ShowAlertDialogue().infoBox("Volunteers Assigning Failed!",null,"Assign Volunteer");
        }
    }

    @FXML
    public void handleSearch() {
        setSearchedName(searchOption.getText());
    }
}