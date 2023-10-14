package com.example.advjavaassignment1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class BarViewController {

    @FXML
    private RadioButton btn2015, btn2016, btn2017, btn2018, btn2019, btn2020, btn2021, btn2022, btn2023;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    public void initialize() {
        btn2015.setOnAction(e -> loadDataForYear(2015));
        btn2016.setOnAction(e -> loadDataForYear(2016));
        btn2017.setOnAction(e -> loadDataForYear(2017));
        btn2018.setOnAction(e -> loadDataForYear(2018));
        btn2019.setOnAction(e -> loadDataForYear(2019));
        btn2020.setOnAction(e -> loadDataForYear(2020));
        btn2021.setOnAction(e -> loadDataForYear(2021));
        btn2022.setOnAction(e -> loadDataForYear(2022));
        btn2023.setOnAction(e -> loadDataForYear(2023));

        barChart.setTitle("Launch Data Visualization");
        xAxis.setLabel("Country");
        yAxis.setLabel("Number of Launches");
    }

    private void loadDataForYear(int year) {
        ObservableList<LaunchData> launchDataForYear = DBUtility.fetchDataForYear(year);
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();

        for (LaunchData data : launchDataForYear) {
            dataSeries.getData().add(new XYChart.Data<>(data.getCountry(), data.getLaunchCount()));
        }

        barChart.getData().clear();
        dataSeries.setName("Year " + year);
        barChart.getData().add(dataSeries);
    }

    @FXML
    void viewTable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "table-view.fxml");
    }
}
