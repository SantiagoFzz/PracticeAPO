package ui;
import structures.*;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.add("A1");
        System.out.println("primero: " + list.getFirst());
        System.out.println("Ultimo: " + list.getLast());

        list.add("A2");
        System.out.println("primero: " + list.getFirst());
        System.out.println("Ultimo: " + list.getLast());

        list.add("A3");
        System.out.println("primero: " + list.getFirst());
        System.out.println("Ultimo: " + list.getLast());

        list.add("A4");
        System.out.println("primero: " + list.getFirst());
        System.out.println("Ultimo: " + list.getLast());

        list.add("A5");
        System.out.println("primero: " + list.getFirst());
        System.out.println("Ultimo: " + list.getLast());

        list.addToFirst("A0");
        System.out.println("primero: " + list.getFirst());
        System.out.println("Ultimo: " + list.getLast());

        System.out.println(list.inverseOrder());
    }
}
