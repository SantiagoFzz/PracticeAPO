package ui;

import structures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);

        System.out.println(list.getHead().getData());
        System.out.println(list.getHead().getNext().getData());
        System.out.println(list.getHead().getNext().getNext().getData());
        System.out.println(list.getHead().getNext().getNext().getNext().getData());
        System.out.println(list.getHead().getNext().getNext().getNext().getNext().getData());
    }
}
