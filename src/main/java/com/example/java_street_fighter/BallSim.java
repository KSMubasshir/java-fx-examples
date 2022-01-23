package com.example.java_street_fighter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;

public class BallSim extends Application {

    Text fps = new Text(0, 30, "X");

    long lastFrame = 0;
    long frameCount = 0;
    Ball ball;

    //static final int BALL_COUNT = 5;
    //Ball[] balls = new Ball[BALL_COUNT];
    private void updateGameState(long now) {
        double elapsedSec = (now - lastFrame) / 1000000000.0;
        if (frameCount % 10 == 0) {
            fps.setText(String.format("%.1f", 1 / elapsedSec));
        }
        lastFrame = now;
        if (frameCount > 0) {
//			for (Ball b : balls) {
            // ball.detectWallCollisions();
            ball.updatePosition(elapsedSec);
            //}
        }
        frameCount++;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        
        primaryStage.setTitle("Ball Sim");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);

        Rectangle r1 = new Rectangle(100, 280, 120, 150);
        r1.setFill(Color.CADETBLUE);
        root.getChildren().add(r1);

        Circle c1 = new Circle(160, 240, 50);
        c1.setFill(Color.BLUEVIOLET);
        root.getChildren().add(c1);

        Rectangle r2 = new Rectangle(100 + 450, 280, 120, 150);
        r2.setFill(Color.BROWN);
        root.getChildren().add(r2);

        Circle c2 = new Circle(160 + 450, 240, 50);
        c2.setFill(Color.INDIGO);
        root.getChildren().add(c2);

        fps.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        fps.setOpacity(0.4);
        root.getChildren().add(fps);
        
        Image image = new Image(new File("com/example/java_street_fighter/RYU.gif").toURI().toString());
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        root.getChildren().add(iv1);

        ball = new Ball(root, 150, 350, 5, Color.RED, 250, 250);
        //ball = new Ball(root, 150, 150, 5, Color.RED, 250);
//		for (int i = 0; i < BALL_COUNT; i++) {
//			balls[i] =  new Ball(root, 150, 150, 5, Color.RED, 250);
//		}
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateGameState(now);
            }

        }.start();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class image {

        public image() {
        }
    }

}
