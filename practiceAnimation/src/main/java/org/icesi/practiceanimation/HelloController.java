package org.icesi.practiceanimation;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    private int num;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateLabel();

        initializeAnimation();
    }

    public void initializeAnimation(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateLabel();
            }
        };es
    }

    public void setOnAction(){

    }


    public void updateLabel(){
        welcomeText.setText("Text " + num++);
    }



}