package com.example.advjavaassignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.List;

public class TableViewController {
    @FXML
    private TableView<LaunchData> tableView;
    @FXML
    private TableColumn<LaunchData, Integer> yearColumn;
    @FXML
    private TableColumn<LaunchData, String> countryColumn;
    @FXML
    private TableColumn<LaunchData, Integer> numberOfLaunchesColumn;
    @FXML
    private Button viewChartButton;

    @FXML
    public void initialize() {
        // Set up columns
        yearColumn.setCellValueFactory(new PropertyValueFactory<LaunchData, Integer>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<LaunchData, String>("country"));
        numberOfLaunchesColumn.setCellValueFactory(new PropertyValueFactory<LaunchData, Integer>("launchCount"));

        // Fetch and display data
        List<LaunchData> dataList = DBUtility.fetchData();
        tableView.getItems().addAll(dataList);
    }

    @FXML
    void viewChart(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "bar-view.fxml");
    }
}
