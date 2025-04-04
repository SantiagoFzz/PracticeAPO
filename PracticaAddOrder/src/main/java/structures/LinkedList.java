package structures;

public class LinkedList<T extends Comparable<T>> {
    Node<T> head;
    Node<T> tail;

    public LinkedList(){
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);

        // Caso base 1. La lista esta vacia.
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            // Caso base 2. La cabeza es mayor que el elemento a insertar.
            if(head.getData().compareTo(data) > 0){
                head.setPrevious(newNode);
                newNode.setNext(head);
                head = newNode;
            }
            else{
                // Caso general. Insertarlo en el medio de la lista.
                Node current = head;
                while((current != null) && (current.getData().compareTo(data) < 0)){
                    current = current.getNext();
                }
                if(current != null){
                    current.getPrevious().setNext(newNode);
                    newNode.setPrevious(current.getPrevious());
                    newNode.setNext(current);
                    current.setPrevious(newNode);
                }
                else{
                    current.getPrevious().setNext(newNode);
                    newNode.setPrevious(current.getPrevious());
                }
            }
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
