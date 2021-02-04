package Accounts.Summary.ExpenseBarChart;



import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.TextField;


public class ExpensesChartController {
    @FXML
    private BarChart<String, Double> ExpensesChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private TextField monthNumber;
    @FXML
    private TextField yearNumber;
    @FXML
    private JFXTextField totalExpensesTextfield;

    public void initialize() {
       XYChart.Series<String, Double> set1 = new XYChart.Series<>();
        new ExpensesChartModel().setTheBarChart(set1);
        ExpensesChart.getData().add(set1);
    }
    public void monthOnEnter(){
        totalExpense();
        XYChart.Series<String, Double> set1 = new XYChart.Series<>();
        ExpensesChart.getData().clear();
        ExpensesChart.layout();
        int y =Integer.parseInt(yearNumber.getText()) ;
        int m = Integer.parseInt(monthNumber.getText());
        new ExpensesChartModel().setChartAccordingToInput(set1,m,y);
        ExpensesChart.getData().add(set1);
       }
    public void totalExpense() {
        totalExpensesTextfield.setText(Integer.toString(new ExpensesChartModel().getTotalExpense(Integer.parseInt(monthNumber.getText()), Integer.parseInt(yearNumber.getText()))));
    }
}