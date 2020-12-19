package Accounts.Summary.SalaryBarchart;

import Utilities.OracleConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class SalarychartController implements Initializable {
    @FXML
    private BarChart<String, Double> SalaryChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String sql = "select id,designation_name,amount,num_of_employee(designation_name,id)*amount from designation order by id";
        XYChart.Series<String, Double> set1 = new XYChart.Series<>();
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                set1.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(4)));
            }
            SalaryChart.getData().addAll(set1);
        } catch (Exception e) {
            System.out.println("SalaryBarchart");
            e.printStackTrace();
        }
    }
}