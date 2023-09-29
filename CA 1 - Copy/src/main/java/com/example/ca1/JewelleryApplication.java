package com.example.ca1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.DisplayCase;
import utils.GenericLinkedList;

import java.io.IOException;

public class JewelleryApplication extends Application {

    public static Scene scene;
    public static Stage stage;
    public static DisplayCase firstCase;
    public static GenericLinkedList<DisplayCase> allCases = new GenericLinkedList<>();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("CA1 - Whole Project 1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 470);
        stage.setTitle("Jewellery Store");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
