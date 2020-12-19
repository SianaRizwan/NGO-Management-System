package Accounts.Summary.SalaryBarchart;

import javafx.fxml.FXML;
import javafx.scene.chart.*;


public class SalaryChartController {
    @FXML
    private BarChart<String, Double> SalaryChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    public void initialize() {
        XYChart.Series<String, Double> set1 = new XYChart.Series<>();
        new SalaryChartModel().setTheBarChart(set1);
        SalaryChart.getData().addAll(set1);

    }

}