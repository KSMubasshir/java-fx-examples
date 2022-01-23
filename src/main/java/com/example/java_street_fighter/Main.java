package com.example.java_street_fighter;
import static java.lang.Math.abs;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author RummanBUET
 */
public class Main extends Application {
    public double InitialX1 = 50, InitialX2 = 650;
    public double InitialY1 = 220, InitialY2 = 220;
    double PlayerWidth = 150, PlayerHeight = 200;
    long lastFrame = 0;
    long frameCount = 0;
    double ChangeX = 60, ChangeY = 120;
    XYComponent ChangeofPosition = new XYComponent(0, 10);
    Text fps = new Text(0, 30, "Y");
    Player1Body player1;
    Player2Body player2;

    private void updateGameState(long now) {
        double elapsedSec = (now - lastFrame) / 1000000000.0;
        if (frameCount % 10 == 0) {
            fps.setText(String.format("%.1f", 1 / elapsedSec));
        }
        lastFrame = now;
        frameCount++;
    }

    boolean Detect(Player1Body p1, Player2Body p2) {
        boolean t = false;
        if (abs(p2.Body.getX() - p1.Body.getX()) < 200) {
            t = true;
        }
        return t;
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Stage stg = new Stage(StageStyle.UTILITY);
        Scene scene = new Scene(root, 800, 450);
        player1 = new Player1Body(root, InitialX1, InitialY1, PlayerWidth, PlayerHeight, Color.BLUE);
        player2 = new Player2Body(root, InitialX2, InitialY2, PlayerWidth, PlayerHeight, Color.VIOLET);
        primaryStage.setTitle("Street Fighter");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            double x, y;

            switch (e.getCode()) {
                case LEFT:
                    System.out.println("left");
                    if (player1.Body.getX() - ChangeX > -20) {
                        x = (-1) * ChangeX;
                    } else {
                        x = 0;
                    }
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case RIGHT:
                    if (player1.Body.getX() + ChangeX < 1200 && Detect(player1, player2) == false) {
                        x = ChangeX;
                    } else {
                        x = 0;
                    }
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case UP:
                    x = 0;
                    if (player1.Body.getY() > 180) {
                        y = -1 * ChangeY;
                    } else {
                        y = 0;
                    }
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case DOWN:
                    x = 0;
                    if (player1.Body.getY() < 400) {
                        y = ChangeY;
                    } else {
                        y = 0;
                    }
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                default:
                    x = 0;
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;
            }
            player1.UpdatePosition(ChangeofPosition);
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            double x, y;
            switch (e.getCode()) {
                case A:
                    System.out.println("left");
                    if (player2.Body.getX() - ChangeX > -20 && Detect(player1, player2) == false) {
                        x = (-1) * ChangeX;
                    } else {
                        x = 0;
                    }
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case D:
                    if (player2.Body.getX() + ChangeX < 1200) {
                        x = ChangeX;
                    } else {
                        x = 0;
                    }
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case W:
                    x = 0;
                    if (player2.Body.getY() > 180) {
                        y = -1 * ChangeY;
                    } else {
                        y = 0;
                    }
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case S:
                    if (player2.Body.getY() < 400) {
                        x = 0;
                        y = ChangeY;
                    } else {
                        x = 0;
                        y = 0;
                    }
                    ChangeofPosition = new XYComponent(x, y);
                    break;

                default:
                    x = 0;
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;
            }
            player2.UpdatePosition(ChangeofPosition);
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateGameState(now);
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
