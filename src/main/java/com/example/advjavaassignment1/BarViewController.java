package com.example.advjavaassignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class BarViewController {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private void initialize() {
        loadBarChartData();
    }

    private void loadBarChartData() {
        List<LaunchData> launchDataList = DBUtility.fetchData();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Launches of Countries");

        for (LaunchData data : launchDataList) {
            series.getData().add(new XYChart.Data<>(data.getCountry(), data.getLaunchCount()));
        }

        barChart.getData().add(series);
    }

    @FXML
    void viewTable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "table-view.fxml");
    }
}
