package ui;

import structures.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tree= new BST<>();

        tree.add(50);
        tree.add(30);
        tree.add(40);
        tree.add(45);
        tree.add(70);
        tree.add(60);
        tree.add(75);
        tree.add(65);
        tree.add(73);
        tree.add(80);

        tree.delete(70);
        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.getRoot().getRight().getValue());
    }
}
