package Person.EmployeeDet.AddEmployee;

import Person.EmployeeDet.EmployeeDetailsModel;
import Person.PersonalInformation;
import Utilities.PhoneValidator;
import Utilities.ShowAlertDialogue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEmployeeController {
    @FXML
    private AnchorPane AddEmployeePane;

    @FXML
    private TextField employeeName;

    @FXML
    private TextField employeeEmailID;

    @FXML
    private TextField employeePhoneNumber;

    @FXML
    private DatePicker employeeDOB;

    @FXML
    private ComboBox employeeDesignation;

    @FXML
    private ComboBox employeeGender;

    @FXML
    private TextField employeeAddress;


    @FXML
    private PasswordField employeePassword;

    private ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Others");
    private ObservableList<String> designation = FXCollections.observableArrayList();

    @FXML
    void handleConfirmButton(MouseEvent event) throws ParseException {
        Date dobDate = new SimpleDateFormat("MM/dd/yyyy").parse(employeeDOB.getEditor().getText());
        if (new PersonalInformation().checkValidation(employeeEmailID.getText())&& new PhoneValidator().validate(employeePhoneNumber.getText())){
            if (new AddEmployeeModel().isAddEmployeeSuccessful(employeeName.getText(),dobDate, employeeGender.getSelectionModel().getSelectedItem().toString(),
                employeeAddress.getText(), employeePhoneNumber.getText(), employeeDesignation.getSelectionModel().getSelectedItem().toString(),
                employeeEmailID.getText(), employeePassword.getText())) {
            new ShowAlertDialogue().infoBox("Employee Add Successful!", null, "Add Employee" );
            refreshTextField();
        }
        }else {
            new ShowAlertDialogue().infoBox("Insert Valid Email or Phone Number", null, "Add Employee" );
        }
    }



    private void refreshTextField() {
        employeeDOB.getEditor().setText("");
        employeeAddress.setText("");
        employeePhoneNumber.setText("");
        employeeEmailID.setText("");
        employeePassword.setText("");
        employeeName.setText("");
    }
    public void initialize() {

        employeeGender.setItems(gender);
        new EmployeeDetailsModel().getDesignation(designation);
        employeeDesignation.setItems(designation);


    }


}
