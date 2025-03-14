package ui;

import structures.SimpleList;

public class Main {
    public static void main(String[] args){
        SimpleList list = new SimpleList();

        list.add("A1");
        list.add("A8");
        list.add("A2");
        list.add("A3");
        list.add("A4");
        list.add("A5");


        for (int i = 0; i < 5; i++) {
            System.out.println(list.getByIndex(i));
        }

        System.out.println("The last is: " + list.getLast().toString());
    }
}
