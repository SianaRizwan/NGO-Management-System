package EventDetails.ManageEvent.ViewAssignees.Employee;

import EventDetails.ManageEvent.ManageEventController;
import Utilities.ShowAlertDialogue;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddEmployeesToEventController {
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

    AddEmployeesToEventModel addEmployeesToEventModel = new AddEmployeesToEventModel();
    JFXCheckBox[] checkBox = new JFXCheckBox[addEmployeesToEventModel.getTotalID()];
    String[] list = new String[addEmployeesToEventModel.getTotalID()];
    ArrayList<String> selectedId = new ArrayList<String>();

    private void setName() {
        String[] id = addEmployeesToEventModel.getEmployeeList(list);
        setCheckBoxValues(id);

    }

    private void setCheckBoxValues(String[] id) {
        int k = 0, j = 0;

        for (int i = 0; i < addEmployeesToEventModel.getTotalID(); i++) {

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

    private void getSelectedEmployees(){
        for(int i = 0; i< addEmployeesToEventModel.getTotalID(); i++){
            if(checkBox[i].isSelected()){
                selectedId.add(checkBox[i].getText());
            }
        }
    }

    private void setSearchedName(String text)  {
        Arrays.fill(list, null);
        String[] id = addEmployeesToEventModel.getSearchedList(list,text);
        refreshGridPane();
        setCheckBoxValues(id);

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
    void handleConfirmButton() {
        getSelectedEmployees();
        //System.out.println(names);
        if(addEmployeesToEventModel.isAssignEmployeeSuccessful(selectedId,new ManageEventController().getEventID())){
            new ShowAlertDialogue().infoBox("Employees Assigned!",null,"Assign Employees");
        }
        else {
            new ShowAlertDialogue().infoBox("Employees Assigning Failed!",null,"Assign Employees");
        }
    }

    @FXML
    public void handleSearch() {
        setSearchedName(searchOption.getText());
    }
    private void refreshGridPane() {
        gridPane1.getChildren().clear();
        gridPane2.getChildren().clear();
        gridPane3.getChildren().clear();
    }


}
