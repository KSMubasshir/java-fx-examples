/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java_street_fighter;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.File;


/**
 *
 * @author RummanBUET
 */
public class Player2Body {

    //public Rectangle Body;
    double dx;
    double dy;
    Image iv;
    ImageView Body;

    public Player2Body(Group root, double x, double y, double w, double h, Paint color) {
        iv = new Image(new File("com/example/java_street_fighter/Ken.gif").toURI().toString());
        Body = new ImageView();
        Body.setImage(iv);

        //Body = new Rectangle(x, y, w, h);
       // Body.setFill(color);

        Body.setX(x);
        Body.setY(y);

        Body.setFitWidth(100);
        System.out.println("ha");
        Body.setPreserveRatio(true);
        Body.setSmooth(true);
        Body.setCache(true);
        HBox box = new HBox();
        //box.getChildren().add(iv);
        root.getChildren().add(Body);
        root.getChildren().add(box);
    }

    public void UpdatePosition(XYComponent chng) {
        dx = chng.dx;
        dy = chng.dy;

        Body.setX(Body.getX() + dx);
        //Body.setX(Body.getX() + dx);
        Body.setY(Body.getY() + dy);
       // Body.setY(Body.getY() + dy);

    }
}
