package org.example.gameone.implementation;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Event implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        // Se ejecuta cada vez que se presiona una tecla.
        System.out.println("Se presiono la tecla: " + event.getCode()); // Obtener la tecla
    }
}
