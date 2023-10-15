package com.test;

import com.test.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();

//        Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
//
//        Scene scene = new Scene(parent);
//        primaryStage.setX(-1150);A
//        primaryStage.setY(300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
}
