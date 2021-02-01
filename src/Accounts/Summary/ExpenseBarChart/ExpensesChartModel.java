package Accounts.Summary.ExpenseBarChart;

import Utilities.OracleConnection;
import javafx.scene.chart.XYChart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpensesChartModel {
    public void setTheBarChart(XYChart.Series<String, Double> set1) {
        String sql = "select type,sum(amount) from expenses group by type";
        try {
            OracleConnection oc = new OracleConnection();
            PreparedStatement ps = oc.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                set1.getData().add(new XYChart.Data<>(rs.getString(1),rs.getDouble(2)));
            }
        } catch (Exception e) {
            System.out.println("ExpensesBarchart");
            e.printStackTrace();
        }
    }

}
