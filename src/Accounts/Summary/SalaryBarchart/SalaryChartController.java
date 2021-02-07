package Accounts.Summary.SalaryBarchart;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

class SalaryChartController {

        @FXML
        private BarChart<String, Double> SalaryChart;
        @FXML
        private CategoryAxis x;
        @FXML
        private NumberAxis y;
        @FXML
        private JFXTextField totalSalaryTextfield;

        public void initialize() {
            XYChart.Series<String, Double> set1 = new XYChart.Series<>();
            new SalaryChartModel().setTheBarChart(set1);
            SalaryChart.getData().addAll(set1);
            totalSalary();
        }

        public void totalSalary(){
            totalSalaryTextfield.setText(Integer.toString(new SalaryChartModel().getTotalSalary()));
        }
}
