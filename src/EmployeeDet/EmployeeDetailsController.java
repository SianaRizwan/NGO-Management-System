package EmployeeDet;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeDetailsController implements Initializable {
    @FXML
    private Label searchEmployeeLabel;
    @FXML
    private TextField searchEmployeeTextField;

    @FXML
    private Pane employeeDetailsPane;
    @FXML
    private TableColumn<Employee,Integer>colEmpID;
    @FXML
    private TableColumn<Employee,String>colEmpName;
    @FXML
    private TableColumn<Employee,String>colEmpEmail;
    @FXML
    private TableColumn<Employee,String>colEmpPhone;
    @FXML
    private TableColumn<Employee,String>colEmpDesignation;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private void handleUpdate() throws IOException {
        Pane pane  = FXMLLoader.load(getClass().getResource("updateEmployee.fxml"));
        employeeDetailsPane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colEmpID.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        colEmpEmail.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));
        colEmpPhone.setCellValueFactory(new PropertyValueFactory<Employee,String>("phone"));
        colEmpDesignation.setCellValueFactory(new PropertyValueFactory<Employee,String>("designation"));
        try {
            employeeTable.setItems(EmployeeModel.getTableRecords());
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController: initialize");
            throwables.printStackTrace();
        }
    }
}