package Accounts.Designation;

import Utilities.ShowAlertDialogue;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class DesignationController implements Initializable {

    @FXML
    private AnchorPane designationDetailsAnchorPane;

    @FXML
    private Pane designationDetailsPane;

    @FXML
    private TableView<?> designationTable;

    @FXML
    private TableColumn<?, ?> colDesigID;

    @FXML
    private TableColumn<?, ?> colDesigType;

    @FXML
    private TableColumn<?, ?> colDesigName;

    @FXML
    private TableColumn<?, ?> colDesigSalary;

    @FXML
    private JFXTextField searchDesigTextField;

    @FXML
    private JFXTextField desigNameTextField;

    @FXML
    private JFXTextField desigSalaryTextField;

    @FXML
    private JFXComboBox desigTypeComboBox;

    private ObservableList<String> desigTypeList = FXCollections.observableArrayList("Doctor","Employee");

    DesignationModel designationModel = new DesignationModel();

    @FXML
    void desigConfirmBtn(ActionEvent event) {
        if(designationModel.isDesignationAddedSuccessful(String.valueOf(desigTypeComboBox.getValue()),desigNameTextField.getText(),Integer.parseInt(desigSalaryTextField.getText()))){
            new ShowAlertDialogue().infoBox("Designation Added Successful!",null,"Add Designation");
        }else {
            new ShowAlertDialogue().infoBox("Designation Added Faild!",null,"Add Designation");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desigTypeComboBox.setItems(desigTypeList);
    }
}

