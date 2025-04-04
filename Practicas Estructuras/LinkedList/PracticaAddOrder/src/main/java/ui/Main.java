package ui;

import structures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.addOrder(1);
        list.addOrder(3);
        list.addOrder(4);
        list.addOrder(5);
        list.addOrder(12);
        list.addOrder(2);

        System.out.println(list.printList());

    }
}
