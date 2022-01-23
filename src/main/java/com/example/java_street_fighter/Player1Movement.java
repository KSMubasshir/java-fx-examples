/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java_street_fighter;

import java.awt.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author RummanBUET
 */
public class Player1Movement implements Runnable {

    public Thread th;
    Player1Body p1;
    Player2Body p2;
    XYComponent ChangeofPosition;
    Scene scene;
    double ChangeX, ChangeY;
    double x, y;

    double GravitationalChange(double dist) {
        double UpVelocity = 10;
        double g = 10;
        dist = (UpVelocity * UpVelocity) / (2 * g);
        return dist;
    }

    boolean IfPossible(double dx) {
        boolean T = true;

        if (p1.Body.getX() < p2.Body.getX()) {
            if (p1.Body.getX() + 150 + dx < p2.Body.getX()) {
                T = false;
            }
        } else if (p2.Body.getX() < p1.Body.getX()) {
            if (p2.Body.getX() + 150 + dx < p1.Body.getX()) {
                T = false;
            }
        }
        return T;
    }

    public Player1Movement(Scene scn, Player1Body pl1, Player2Body pl2) {
        p1 = pl1;
        p2 = pl2;
        scene = scn;
        ChangeX = 10;

        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        
        if(p1.Body.getY() >= 120 && p1.Body.getY() <= 400){
            x = 0 ;
            y = -120 ;
            ChangeofPosition = new XYComponent(x, y);
        }

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            while(true)
            switch (e.getCode()) {
                case LEFT:
                    System.out.println("left");
                    
                    if (p1.Body.getX() - ChangeX > -20) {
                        x = (-1) * ChangeX;
                    } else {
                        x = 0;
                    }
                    y = 0;

                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case RIGHT:

                    if (p1.Body.getX() + ChangeX < 1200) {
                        x = ChangeX;
                    } else {
                        x = 0;
                    }
                    y = 0;

                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case UP:

                    x = 0;
                    if (p1.Body.getY() > 180) {
                        y = -120;
                    } else {
                        y = 0;
                    }

                    ChangeofPosition = new XYComponent(x, y);
                    break;

                case DOWN:

                    break;

                default:

                    x = 0;
                    y = 0;
                    ChangeofPosition = new XYComponent(x, y);
                    break;
            }
             
        });

    }

    public XYComponent getChangeofPosition() {
        return ChangeofPosition;
    }

}
