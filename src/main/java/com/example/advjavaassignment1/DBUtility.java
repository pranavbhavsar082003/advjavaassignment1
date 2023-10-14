//package com.example.advjavaassignment1;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class DBUtility {
//
//    private static final String JDBC_URL = "jdbc:mysql://172.31.22.43:3306/Pranav200545944";
//    private static final String USER = "Pranav200545944";
//    private static final String PASSWORD = "tK7pwBPi0L";
//
//    public static ObservableList<LaunchData> fetchData() {
//        ObservableList<LaunchData> data = FXCollections.observableArrayList();
//
//        try (
//                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
//                PreparedStatement ps = connection.prepareStatement("SELECT * FROM orbital_launches");
//                ResultSet resultSet = ps.executeQuery()
//        ) {
//            while (resultSet.next()) {
//                int year = resultSet.getInt("year");
//                String country = resultSet.getString("country");
//                int launchCount = resultSet.getInt("launch_count");
//                data.add(new LaunchData(year, country, launchCount));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//
//    public static ObservableList<LaunchData> fetchDataForYear(int year) {
//        ObservableList<LaunchData> data = FXCollections.observableArrayList();
//
//        try (
//                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
//                PreparedStatement ps = connection.prepareStatement("SELECT * FROM orbital_launches WHERE year = ?")
//        ) {
//            ps.setInt(1, year);
//            try (ResultSet resultSet = ps.executeQuery()) {
//                while (resultSet.next()) {
//                    String country = resultSet.getString("country");
//                    int launchCount = resultSet.getInt("launch_count");
//                    data.add(new LaunchData(year, country, launchCount));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//}
package com.example.advjavaassignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBUtility {

    private static final String JDBC_URL = "jdbc:mysql://172.31.22.43:3306/Pranav200545944";
    private static final String USER = "Pranav200545944";
    private static final String PASSWORD = "tK7pwBPi0L";

    /**
     * @person pranav
     * method to read data for database.
     * */
    public static ObservableList<LaunchData> fetchData() {
        ObservableList<LaunchData> data = FXCollections.observableArrayList();

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM orbital_launches");
                ResultSet resultSet = ps.executeQuery()
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

    /**
     * @person pranav
     * method to grab data from database for selected year.
     * */
    public static ObservableList<LaunchData> fetchDataForYear(int year) {
        ObservableList<LaunchData> data = FXCollections.observableArrayList();

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM orbital_launches WHERE year = ?")
        ) {
            ps.setInt(1, year);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
