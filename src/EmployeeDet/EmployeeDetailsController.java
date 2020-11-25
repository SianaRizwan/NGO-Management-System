package EmployeeDet;

import Utilities.ShowAlertDialogue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeDetailsController implements Initializable {

    @FXML
    private TextField searchEmployeeTextField;

    @FXML
    private Pane employeeDetailsPane;
    @FXML
    private TableColumn<Employee, Integer> colEmpID;
    @FXML
    private TableColumn<Employee, String> colEmpName;
    @FXML
    private TableColumn<Employee, String> colEmpEmail;
    @FXML
    private TableColumn<Employee, String> colEmpPhone;
    @FXML
    private TableColumn<Employee, String> colEmpDesignation;
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private void handleUpdate() throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("updateEmployee.fxml"));
        employeeDetailsPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleAddNew() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        employeeDetailsPane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTableView();

        searchFilterData(searchEmployeeTextField, employeeTable);

    }

    private void searchFilterData(TextField searchField, TableView<Employee> table) {
        try {
            FilteredList<Employee> filteredList = new FilteredList<>(EmployeeDetailsModel.getEmployeeTableRecords(), b -> true);

            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(employee -> EmployeeDetailsModel.isMatchSuccessful(newValue, employee));
                sortFilteredData(filteredList,table);
            });
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController : search box");
            throwables.printStackTrace();
        }
    }

    private void sortFilteredData(FilteredList<Employee> filteredList, TableView<Employee> employeeTable) {
        SortedList<Employee> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(employeeTable.comparatorProperty());
        employeeTable.setItems(sortedList);
    }


    private void populateTableView() {
        colEmpID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmpEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEmpPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmpDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        try {
            employeeTable.setItems(EmployeeDetailsModel.getEmployeeTableRecords());
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController: initialize");
            throwables.printStackTrace();
        }
    }


    public void deleteEmployee(ActionEvent actionEvent) {
        int ans = new ShowAlertDialogue().confirmationBox("Do you want to remove this Employee?", null, "remove employee");
        if (ans == 1) {
            int employeeId = employeeTable.getSelectionModel().getSelectedItem().id;

            employeeTable.getItems().removeAll(employeeTable.getSelectionModel().getSelectedItem());
            if (new EmployeeDetailsModel().isDeleteEmployeeSuccessful(employeeId)) {
                //            new ShowAlertDialogue().infoBox("delete Successful!", null, "delete Employee");
            }

        }
    }
}