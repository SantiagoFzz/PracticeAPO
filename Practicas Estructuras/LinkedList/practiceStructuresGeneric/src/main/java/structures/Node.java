package structures;

public class Node<T extends Comparable<T>>{
    Node<T> next;
    Node<T> previous;
    T data;

    public Node(T data){
        this.next = null;
        this.previous = null;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
