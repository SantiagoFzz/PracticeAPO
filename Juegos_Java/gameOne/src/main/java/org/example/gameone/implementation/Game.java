package org.example.gameone.implementation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.example.gameone.entities.Player;

import java.io.IOException;

public class Game extends Application {
    private GraphicsContext graphics;
    private Group root;
    public static Scene scene;
    private Canvas canvas;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    private Player player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws IOException {
        initializeComponents();

        manageEvent();
        window.setTitle("Game");
        window.setScene(scene);
        window.show();
        gameLoop();
    }

    public void gameLoop(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long tiempoActual) {
                // Este metodo se ejecuta aproximadamente 60 veces por segundo.
                updateState();
                paint();
            }
        };

        animationTimer.start(); // Empieza el ciclo de juego.
    }

    public void updateState(){
        player.move();
    }

    public void initializeComponents(){
        //FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/org/example/gameone/hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        player = new Player(20, 40, 3, new Image(Game.class.getResource("/org/example/gameone/Juegos/FREE/characters/Anim_Robot_Jump1_v1.1_frames/1.png").toExternalForm()));
        root = new Group();
        scene = new Scene(root, 692, 628);
        canvas = new Canvas(692, 628);
        root.getChildren().add(canvas);

        // Is a special object to be able to paint.
        graphics = canvas.getGraphicsContext2D();
    }

    // Here is all the logic to paint.
    public void paint(){
        graphics.drawImage(new Image(Game.class.getResource("/org/example/gameone/Juegos/FREE/scenas/good.jpg").toExternalForm()), 0, 0, 692, 628);
        // The rout must be used with Game.class.getResourse
        player.paint(graphics);
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

        // EventHandler no la podemos instanciar, porque es una interfaz. Podemos simular que la estamos instanciando, y al cerrar paréntesis, abrimos llaves para definir los metodos abstractos.
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode().toString()) {
                    case "D":
                    case "RIGHT":
                        right = true;
                        break;

                    case "A":
                    case "LEFT":
                        left = true;
                        break;

                    case "S":
                    case "DOWN":
                        down = true;
                        break;

                    case "W":
                    case "UP":
                        up = true;
                        break;

                    case "SPACE":
                        player.setImage(new Image(Game.class.getResource("/org/example/gameone/Juegos/FREE/characters/Anim_Robot_Jump1_v1.1_frames/1.png").toExternalForm(), 45, 45, false, false));
                        player.setSpeed(20);
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            // Se ejecuta cuando se suelta una tecla.
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode().toString()) {
                    case "D":
                    case "RIGHT":
                        right = false;
                        break;

                    case "A":
                    case "LEFT":
                        left = false;
                        break;

                    case "S":
                    case "DOWN":
                        down = false;
                        break;

                    case "W":
                    case "UP":
                        up = false;
                        break;

                    case "SPACE":
                        player.setImage(new Image(Game.class.getResource("/org/example/gameone/Juegos/FREE/characters/Anim_Robot_Jump1_v1.1_frames/1.png").toExternalForm()));
                        player.setSpeed(5);
                        break;
                }
            }
        });


    }
}