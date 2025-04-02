package ui;

import structures.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tree= new BST<>();

        tree.add(50);
        tree.add(40);
        tree.add(60);
        tree.add(30);
        tree.add(20);
        tree.add(55);

        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.getRoot().getLeft().getValue());
        System.out.println(tree.getRoot().getLeft().getLeft().getValue());
        System.out.println(tree.getRoot().getLeft().getLeft().getLeft().getValue());

        System.out.println(tree.getRoot().getRight().getLeft().getValue());

    }
}
