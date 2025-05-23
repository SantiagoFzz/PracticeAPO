package org.icesi.animationv2.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


import java.awt.*;
import java.util.ArrayList;


public class Avatar extends Thread{
    private double x;
    private double y;
    private double w;
    private double h;
    private Canvas canvas;
    private GraphicsContext gc;

    private ArrayList<Image> images;

    private int frame;
    // 0 = idle || 1 = riun
    private int status;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private boolean a;
    private boolean s;

    public Avatar(Canvas canvas, double x, double y, double w, double h) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        gc = canvas.getGraphicsContext2D();
        images = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Image image = new Image(getClass().getResourceAsStream("/org/icesi/animationv2/Run Throwing/0_Dark_Oracle_Run Throwing_00" + i + ".png"));
            images.add(image);
        }

    }

    public void paint(){
        onMove();

        gc.setFill(Color.RED);

        for(int i = 0; i < images.size(); i++){
            gc.drawImage(images.get(i), x, y, 100, 100);
        }
        //gc.fillRect(x, y, w, h);
    }

    @Override
    public void run() {
        while (true){
            try{
                System.out.println("AVATAR:: RUN >> x " + x);
                System.out.println("AVATAR:: RUN >> y " + y);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setOnKeyPressed(KeyEvent e){
        switch (e.getCode()){
            case UP -> { up = true; }
            case DOWN -> { down = true; }
            case LEFT -> { left = true; }
            case RIGHT -> { right = true; }
        }
    }

    public void setOnkeyReleased(KeyEvent e){
        switch (e.getCode()){
            case UP -> { up = false; }
            case DOWN -> { down = false; }
            case LEFT -> { left = false; }
            case RIGHT -> { right = false; }
        }
    }

    public void onMove(){
        if(up){
            y-=10;
        }
        if(down){
            y+=10;
        }
        if(left){
            x-=10;
        }
        if(right){
            x+=10;

        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
