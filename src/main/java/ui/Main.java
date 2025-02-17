package ui;
import model.Controller;

import java.sql.SQLOutput;
import java.util.Scanner;



public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Controller controller;

    public static void main(String[] args) {
        createController();
        manageFileTxt();
        counterFileTxt();
    }

    public static void createController(){
        controller = new Controller();
    }

    public static void manageFileTxt(){
        System.out.println("Ingrese un mensaje para insertar en el archivo: ");
        String message = scanner.nextLine();

        System.out.println(controller.writeInFile(message));
    }

    public static void counterFileTxt(){
        System.out.println(controller.countCharacters());
    }

}
