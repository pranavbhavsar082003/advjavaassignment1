package com.example.advjavaassignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;

public class TableViewController {
    @FXML
    private Button viewChartButton;

    @FXML
    private TableView<LaunchData> tableView;

    @FXML
    private TableColumn<LaunchData, Integer> yearColumn;

    @FXML
    private TableColumn<LaunchData, String> countryColumn;

    @FXML
    private TableColumn<LaunchData, Integer> numberOfLaunchesColumn;

    @FXML
    public void initialize() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        numberOfLaunchesColumn.setCellValueFactory(new PropertyValueFactory<>("launchCount"));

        tableView.setItems(DBUtility.fetchData());
    }

    @FXML
    void viewChart(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "bar-view.fxml");
    }
}
