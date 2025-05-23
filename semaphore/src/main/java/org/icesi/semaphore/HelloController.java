package org.icesi.semaphore;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import org.icesi.semaphore.model.Semaphore;
import org.icesi.semaphore.model.StateSemaphore;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    private int counter = 0;
    private Semaphore semaphore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        semaphore = new Semaphore(canvas, StateSemaphore.VERDE);
        gc = canvas.getGraphicsContext2D();

        Platform.runLater(() ->{
            //new Thread( () -> {
            //    gc.setFill(Color.BLUE);
            //    gc.fillRect(0,0,50, 50);
            //} ).start();

            new Thread(semaphore).start();
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}