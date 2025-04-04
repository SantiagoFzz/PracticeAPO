package structures;

import java.util.UUID;

public class Node {
    private String id;
    private int index;
    private String data;

    //Creamos una relación con él mismo
    private Node next;
    private Node previous;

    public Node(String data) {
        this.id = UUID.randomUUID().toString();
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", index=" + index +
                '}';
    }
}
