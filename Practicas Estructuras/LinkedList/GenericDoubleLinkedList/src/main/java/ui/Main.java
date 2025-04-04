package ui;

import structures.*;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("A1");
        list.add("A2");
        list.add("A3");
        list.add("A4");

        System.out.println(list.getHead().getIndex());
        System.out.println(list.getHead().getNext().getIndex());
        System.out.println(list.getHead().getNext().getNext().getIndex());
        System.out.println(list.getHead().getNext().getNext().getNext().getIndex());

        if(list.deleteNode("A2")){
            System.out.println("ELEMENT SUCCESSFULLY DELETED.");
        }else{
            System.out.println("NO FOUND ELEMENT.");
        }

        System.out.println(list.showNodes());
    }
}
