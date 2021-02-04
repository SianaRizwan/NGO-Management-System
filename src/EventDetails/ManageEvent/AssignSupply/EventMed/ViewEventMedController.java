package EventDetails.ManageEvent.AssignSupply.EventMed;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.SQLException;

public class ViewEventMedController {
    @FXML
    private AnchorPane viewDetails;

    @FXML
    private TableView<EventMed> informationTable;

    @FXML
    private TableColumn<EventMed, String> colName;

    @FXML
    private TableColumn<EventMed, Integer> colAvailableQty;

    @FXML
    private TableColumn<EventMed, String> colRequiredQty;



    @FXML
    void handleBackButton() {
        Stage stage = (Stage) viewDetails.getScene().getWindow();
        stage.close();
    }

    public void populateTableView(String id) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAvailableQty.setCellValueFactory(new PropertyValueFactory<>("availableQty"));
        {
            Callback<TableColumn<EventMed, String>, TableCell<EventMed, String>> cellFactory1 = (param) -> {
//tablecell button
                final TableCell<EventMed, String> cell = new TableCell<EventMed, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //cell is created only on non-empty rows
                        if (empty) {
                            setGraphic(null);
                        } else {
                            final TextField details = new TextField();
                            ViewEventMedModel view=new ViewEventMedModel();
                            details.getStyleClass().clear();
                            details.getStyleClass().add("second-text-field");
                            System.out.println(new ViewEventMedModel().getRequiredAmount());
                            view.setId(id);

                            details.setText(new ViewEventMedModel().getRequiredAmount());

                            details.setOnAction(event -> {
                                EventMed h = getTableView().getItems().get(getIndex());
                                //write code
                                details.setEditable(true);
                                details.setText(details.getText());
                                view.isAmountAddSuccessful(Integer.parseInt(details.getText()), id, h.getName());
                            });
                            setGraphic(details);

                        }
                        setText(null);
                    }
                };

                return cell;
            };
            colRequiredQty.setCellFactory(cellFactory1);

        }

        try {
            informationTable.setItems(new ViewEventMedModel().getTableRecords(id));
        } catch (SQLException throwables) {
            System.out.println("ViewEventMedController: initialize");
            throwables.printStackTrace();
        }
    }
}
