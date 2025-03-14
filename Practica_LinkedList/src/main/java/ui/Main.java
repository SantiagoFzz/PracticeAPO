package ui;

import structures.SimpleList;
import java.util.Scanner;

public class Main {
    static SimpleList list;
    static Scanner scanner;
    public static void main(String[] args){
        list = new SimpleList();
        scanner = new Scanner(System.in);

        list.add("A1");
        list.add("A8");
        list.add("A2");
        list.add("A3");
        list.add("A4");
        list.add("A5");


        for (int i = 0; i < 6; i++) {
            System.out.println(list.getByIndex(i));
        }


        System.out.println("The last is: " + list.getLast().toString());
        System.out.println("*********************************************************");
        System.out.println("Escribe el íncice del nodo a eliminar: ");
        delete(scanner.nextInt());
    }

    public static void delete(int index){
        String message = "ERROR IN DELETE";

        boolean delete = list.deleteWithIndex(index);

        if(delete){
            message = "DELETED: " + index;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.getByIndex(i));
        }


        System.out.println(message);
    }
}
