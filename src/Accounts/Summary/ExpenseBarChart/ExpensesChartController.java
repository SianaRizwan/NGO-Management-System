package Accounts.Summary.ExpenseBarChart;


import javafx.fxml.FXML;
import javafx.scene.chart.*;


public class ExpensesChartController {
    @FXML
    private BarChart<String, Double> ExpensesChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    public void initialize() {
        XYChart.Series<String, Double> set1 = new XYChart.Series<>();
        new ExpensesChartModel().setTheBarChart(set1);
        ExpensesChart.getData().addAll(set1);

    }

}