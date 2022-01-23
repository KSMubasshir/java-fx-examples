/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java_street_fighter;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


    



public class JFXSquare extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Square");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);

        Rectangle r = new Rectangle(100, 280, 120, 150);
        r.setFill(Color.CADETBLUE);
        root.getChildren().add(r);

        Circle c = new Circle(160, 240, 50);
        c.setFill(Color.BLUEVIOLET);
        root.getChildren().add(c);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
