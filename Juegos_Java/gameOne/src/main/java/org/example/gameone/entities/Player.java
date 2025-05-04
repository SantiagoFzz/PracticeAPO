package org.example.gameone.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.example.gameone.implementation.Game;

public class Player {
    private int x;
    private int y;
    private int health;
    private int speed;
    private Image image;


    public Player(int x, int y, int health, Image image) {
        speed = 5;
        this.x = x;
        this.y = y;
        this.health = health;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void paint(GraphicsContext graphics){
        graphics.drawImage(image, x, y);
    }

    // Se ejecuta por cada iteracion del ciclo de juego.
    public void move(){
        if(x > Game.scene.getWidth()) {
            x = -80;
        }

        if (Game.right){
            //Mover hacia la derecha
            this.x += speed;
        }
        if (Game.left){
            this.x -= speed;
        }

        if (Game.down){
            this.y += speed;
        }

        if(Game.up){
            this.y -= speed;
        }
    }
}
