package structures;

public class Node < T extends Comparable<T> >{
    private Node<T> next;
    private Node<T> previous;
    private int index;
    private T data;

    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}
