package DoctorDetails;


import EmployeeDet.EmployeeDetailsModel;
import Utilities.ShowAlertDialogue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

public class DoctorDetailsController {
    @FXML
    public Pane DoctorDetailsPane;

    @FXML
    private TableView<Doctor> DoctorTable;

    @FXML
    private TableColumn<Doctor, Integer> colDoctorID;

    @FXML
    private TableColumn<Doctor, String> colDoctorName;

    @FXML
    private TableColumn<Doctor, String> colDoctorPhone;

    @FXML
    private TableColumn<Doctor, String> colDoctorEmail;

    @FXML
    private TableColumn<Doctor, String> colDoctorSpeciality;

    @FXML
    private TextField searchDoctorTextField;


    public void handleAddNew(ActionEvent actionEvent) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("AddDoctor.fxml"));
        DoctorDetailsPane.getChildren().setAll(pane);
    }


    public void handleUpdate(MouseEvent mouseEvent) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("UpdateDoctorDetails.fxml"));
        DoctorDetailsPane.getChildren().setAll(pane);
    }

    public void initialize() {
        populateTableView();
        searchFilterData(searchDoctorTextField, DoctorTable);
    }

    private void searchFilterData(TextField searchField, TableView<Doctor> table) {
        try {
            FilteredList<Doctor> filteredList = new FilteredList<>(DoctorDetailsModel.getDoctorTableRecords(), b -> true);

            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(doctor -> DoctorDetailsModel.isMatchSuccessful(newValue, doctor));
                sortFilteredData(filteredList, table);
            });
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController : search box");
            throwables.printStackTrace();
        }
    }

    private void sortFilteredData(FilteredList<Doctor> filteredList, TableView<Doctor> doctorTable) {
        SortedList<Doctor> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(doctorTable.comparatorProperty());
        doctorTable.setItems(sortedList);
    }


    private void populateTableView() {
        colDoctorID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDoctorName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDoctorEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDoctorPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colDoctorSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        try {
            DoctorTable.setItems(DoctorDetailsModel.getDoctorTableRecords());
        } catch (SQLException throwables) {
            System.out.println("employeeDetailsController: initialize");
            throwables.printStackTrace();
        }
    }

    public void deleteDoctor(ActionEvent actionEvent) {
        int ans = new ShowAlertDialogue().confirmationBox("Do you want to remove this Doctor?", null, "remove Doctor");
        if (ans == 1) {
            String doctorId = DoctorTable.getSelectionModel().getSelectedItem().id;

            DoctorTable.getItems().removeAll(DoctorTable.getSelectionModel().getSelectedItem());
            new DoctorDetailsModel().isDeleteDoctorSuccessful(doctorId) ;

        }
    }


}