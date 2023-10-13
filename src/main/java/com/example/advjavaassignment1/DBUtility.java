package com.example.advjavaassignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static final String JDBC_URL = "jdbc:mysql://172.31.22.43:3306/Pranav200545944";
    private static final String USER = "Pranav200545944";
    private static final String PASSWORD = "tK7pwBPi0L";

    public static ObservableList<LaunchData> fetchData() {
        ObservableList<LaunchData> data = FXCollections.observableArrayList();

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orbital_launches")
        ) {
            while (resultSet.next()) {
                int year = resultSet.getInt("year");
                String country = resultSet.getString("country");
                int launchCount = resultSet.getInt("launch_count");
                data.add(new LaunchData(year, country, launchCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}