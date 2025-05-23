package org.icesi.semaphore.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Semaphore implements Runnable{
    private StateSemaphore stateSemaphore;
    private Canvas canvas;
    private GraphicsContext gc;


    private HashMap<StateSemaphore, Image> images;

    public Semaphore(Canvas canvas, StateSemaphore stateSemaphore) {
        this.stateSemaphore = stateSemaphore;
        this.canvas = canvas;
        gc =  this.canvas.getGraphicsContext2D();

        images = new HashMap<>();

        images.put(StateSemaphore.ROJO, new Image(getClass().getResourceAsStream("/org/icesi/semaphore/images/red.png")));
        images.put(StateSemaphore.VERDE, new Image(getClass().getResourceAsStream("/org/icesi/semaphore/images/green.png")));
        images.put(StateSemaphore.AMARILLO, new Image(getClass().getResourceAsStream("/org/icesi/semaphore/images/yellow.png")));

    }


    public void paint(){
        if(stateSemaphore.compareTo(StateSemaphore.ROJO) == 0){
            gc.drawImage(images.get(StateSemaphore.ROJO), 0, 0);
        }
        else if(stateSemaphore.compareTo(StateSemaphore.VERDE) == 0){
            gc.drawImage(images.get(StateSemaphore.VERDE), 0, 0);
        }
        else if(stateSemaphore.compareTo(StateSemaphore.AMARILLO) == 0){
            gc.drawImage(images.get(StateSemaphore.AMARILLO), 0, 0);
        }
    }


    @Override
    public void run() {
        while(true){
            paint();
            changeImage();

            System.out.println(stateSemaphore.toString());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void changeImage(){
        if(stateSemaphore.equals(StateSemaphore.ROJO)){
            stateSemaphore = StateSemaphore.VERDE;
        }
        else if(stateSemaphore.equals(StateSemaphore.VERDE)){
            stateSemaphore = StateSemaphore.AMARILLO;
        }
        else if(stateSemaphore.equals(StateSemaphore.AMARILLO)){
            stateSemaphore = StateSemaphore.ROJO;
        }
    }


    public StateSemaphore getStateSemaphore() {
        return stateSemaphore;
    }

    public void setStateSemaphore(StateSemaphore stateSemaphore) {
        this.stateSemaphore = stateSemaphore;
    }

}
