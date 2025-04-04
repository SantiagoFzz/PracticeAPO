package structures;

public class LinkedList <T extends Comparable<T>>{
    private Node<T> head;
    private Node<T> tail;


    public boolean addOrder(T data){
        boolean isAdded = false;

        Node<T> newNode = new Node<>(data);

        // 1. Caso base -> Empty List.
        if(head == null){
            head = newNode;
            tail = newNode;
            isAdded = true;
        }
        // 2. Caso base -> La cabeza es mayor que el nuevo elemento.
        else{
            if(head.getData().compareTo(data) > 0){
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
                isAdded = true;
            }
            else{
                // 3. Caso base -> La cola es menor que el nuevo elemento.
                if(tail.getData().compareTo(data) < 0){
                    newNode.setPrevious(tail);
                    tail.setNext(newNode);
                    tail = newNode;
                    isAdded = true;
                }
                else{
                    // 4. Caso general -> El elemento se ubicará en el medio.
                    Node<T> current = head;
                    while(current != null && current.getData().compareTo(data) < 0){
                        current = current.getNext();
                    }

                    Node<T> previous = current.getPrevious();
                    previous.setNext(newNode);
                    newNode.setPrevious(previous);
                    newNode.setNext(current);
                    current.setPrevious(newNode);
                    isAdded = true;
                }
            }
        }

        return isAdded;
    }

    public boolean delete(T data){
        boolean isDeleted = false;
        Node<T> current = head;

        // Caso base. Lista no vacía.
        if(head != null){
            // Caso base -> El nodo a eliminar es el first.
            if (head.getData().compareTo(data) == 0) {
                head = head.getNext();
                current.setNext(null);
                isDeleted = true;
            }
            // Caso base -> El nodo a eliminar es diferente del first.
            while(current.getNext() != null && current.getNext().getData().compareTo(data) != 0){
                current = current.getNext();
            }
            if(current.getNext() != null){
                Node<T> toDelete = current.getNext();
                current.setNext(toDelete.getNext());
                toDelete.setPrevious(null);
                toDelete.setNext(null);
            }

        }

        return isDeleted;
    }

    public String printList(){
        StringBuilder message = new StringBuilder();

        Node<T> current = head;

        while(current != null){
            message.append(current.toString()).append("\n");
            current = current.getNext();
        }


        return message.toString();
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
