package org.example.gameone.implementation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    private GraphicsContext graphics;
    private Group root;
    private Scene scene;
    private Canvas canvas;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws IOException {
        initializeComponents();
        manageEvent();
        paint();
        window.setTitle("Game");
        window.setScene(scene);
        window.show();
    }

    public void initializeComponents(){
        //FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/org/example/gameone/hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        root = new Group();
        scene = new Scene(root, 700, 500);
        canvas = new Canvas(700, 500);
        root.getChildren().add(canvas);

        // Is a special object to be able to paint.
        graphics = canvas.getGraphicsContext2D();
    }

    // Here is all the logic to paint.
    public void paint(){
        graphics.fillRect(0, 0, 300, 300);
        // The rout must be used with Game.class.getResourse
        graphics.drawImage(new Image(Game.class.getResource("/org/example/gameone/character.png").toExternalForm()),100,100 );
    }

    /**
     * Un evento es identificar o escuchar las acciones que está realizando
     * el usuario sobre nuestro aplicativo. Un evento es una acciond el usuario.
     * Por ejemplo que presione una tecla, o un click con el mausa
     */
    public void manageEvent(){
        // Los eventos se registran a la escena, porque captura las entradas del usuario.

        // scene.setOnKeyPressed(); -> Identificar cuando se presiona una tecla.
        //scene.setOnKeyReleased(); -> Identificar cuando se suelta la tecla.
        //scene.setOnKeyTyped(); -> Identificar independientemente si se presiona, o se suelta.


        //scene.setOnKeyPressed(new Event());

        // EventHandler no la podemos instanciar, porque es una interfaz.
// Podemos simular que la estamos instanciando,
// y al cerrar paréntesis, abrimos llaves para definir los metodos abstractos.
        scene.setOnKeyPressed(keyEvent -> {
            System.out.println("Se presiono la tecla: " + keyEvent.getCode());
        });
    }
}