package com.example.advjavaassignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("bar-view.fxml"));
        primaryStage.setTitle("Orbital Launches by Country");

        primaryStage.getIcons().add(new Image(MainApp.class.getResourceAsStream("Images/setelite.jpg")));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}