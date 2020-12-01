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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DesignationDetailsController implements Initializable {

    @FXML
    private AnchorPane designationDetailsAnchorPane;

    @FXML
    private Pane designationDetailsPane;

    @FXML
    private TableView<Designation> designationTable;

    @FXML
    private TableColumn<Designation, String> colDesigID;

    @FXML
    private TableColumn<Designation, String> colDesigType;

    @FXML
    private TableColumn<Designation, String> colDesigName;

    @FXML
    private TableColumn<Designation, Integer> colDesigSalary;
    @FXML
    private TableColumn<Designation, Integer> colEmpCount;

    @FXML
    private JFXTextField searchDesigTextField;

    @FXML
    private JFXTextField desigNameTextField;

    @FXML
    private JFXTextField desigSalaryTextField;

    @FXML
    private JFXComboBox desigTypeComboBox;

    private ObservableList<String> desigTypeList = FXCollections.observableArrayList("Doctor","Employee");

    DesignationDetailsModel designationDetailsModel = new DesignationDetailsModel();
    DesignationModel designationModel = new DesignationModel();

    @FXML
    void desigConfirmBtn() {
        if(designationDetailsModel.isDesignationAddedSuccessful(String.valueOf(desigTypeComboBox.getValue()),desigNameTextField.getText(),Integer.parseInt(desigSalaryTextField.getText()))){
            new ShowAlertDialogue().infoBox("Designation Added Successful!",null,"Add Designation");
            populateTableView();
            desigNameTextField.setText("");
            desigSalaryTextField.setText("");
        }else {
            new ShowAlertDialogue().infoBox("Designation Added Failed!",null,"Add Designation");
        }
    }

    void populateTableView(){
        colDesigID.setCellValueFactory(new PropertyValueFactory<>("desigID"));
        colDesigName.setCellValueFactory(new PropertyValueFactory<>("desigName"));
        colDesigType.setCellValueFactory(new PropertyValueFactory<>("desigType"));
        colDesigSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colEmpCount.setCellValueFactory(new PropertyValueFactory<>("numOfEmployee"));

        try {
            designationTable.setItems(designationModel.getDesignationTableRecords());
        } catch (SQLException throwables) {
            System.out.println("desigController: initialize");
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desigTypeComboBox.setItems(desigTypeList);
        populateTableView();
    }
}

