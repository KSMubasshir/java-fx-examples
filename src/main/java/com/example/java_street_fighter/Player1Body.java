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
import javafx.scene.paint.Paint;

/**
 *
 * @author RummanBUET
 */
public class Player1Body {

    //public Rectangle Body;
    double dx;
    double dy;
    Image iv;
    ImageView Body;

    public Player1Body(Group root, double x, double y, double w, double h, Paint color) {
        iv = new Image("file:RYU.gif");
        Body = new ImageView();
        Body.setImage(iv);
        Body.setX(x);
        Body.setY(y);
        Body.setFitWidth(100);
        Body.setPreserveRatio(true);
        Body.setSmooth(true);
        Body.setCache(true);
        HBox box = new HBox();
        root.getChildren().add(Body);
        root.getChildren().add(box);
    }

    public void UpdatePosition(XYComponent chng) {
        dx = chng.dx;
        dy = chng.dy;
        Body.setX(Body.getX() + dx);
        Body.setY(Body.getY() + dy);
    }
}
