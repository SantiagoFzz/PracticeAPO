package structures;

public class SortedList <T extends Comparable<T>> implements ISortedList<T>{
    private Node<T> head;
    private Node<T> tail;

    public SortedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void insert(T elem) {
        if(elem != null){
            Node<T> newElement = new Node<>(elem);

            // caso base 1. Head es null.
            if(head == null){
                head = newElement;
            }
            // caso base 2. Head es mayor o igual que el nuevo elemento
            if(head.getData().compareTo(elem) >= 0){
                newElement.setNext(head);
                head.setPrevious(newElement);
                head = newElement;
            }else{
                // caso base 3. Head es menor que el nuevo elemento, pero el siguiente de head es
                Node<T> current = head.getNext();
                while(newElement.getData().compareTo(current.getData()) < )
            }
        }
    }

    @Override
    public boolean delete(T elem) {
        return false;
    }

    @Override
    public boolean search(T elem) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
