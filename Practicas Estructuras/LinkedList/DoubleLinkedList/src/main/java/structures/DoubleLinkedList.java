package structures;

public class DoubleLinkedList {
    private Node first;
    private Node last;

    private int size;

    public DoubleLinkedList(){ first = null;last = null; size = 0;}
    public boolean add(String data){
        // Crear el nodo a agregar.
        Node node = new Node(data);

        boolean isAdded = false;

        // 1. Caso Base -> Empty list
        if(first == null && last == null){
            first = node;
            last = node;
            first.setIndex(0);
            isAdded = true;
        }
        // 2. Caso Base -> La lista tiene un elemento.
        else{
            if(first.getNext() == null){
                first.setNext(node);
                node.setIndex(1);
                node.setPrevious(first);
                last = first.getNext();
                isAdded = true;
            }
            else {
                last.setNext(node);
                node.setPrevious(last);
                node.setIndex(last.getIndex()+1);
                last = node;
                isAdded = true;
            }
        }

        return isAdded;
    }

    public boolean addToFirst(String data){
        // Crear el nodo a agregar.
        Node node = new Node(data);

        boolean isAdded = false;

        // 1. Caso Base -> Empty list
        if(first.getPrevious() == null && last == null){
            first = node;
            last = node;
            first.setIndex(0);
            size = 1;
            isAdded = true;
        }
        // 2. Caso Base -> La lista tiene un elemento.
        else{
            if(first.getPrevious() == null){
                first.setPrevious(node);
                first.getPrevious().setIndex(0);
                // pos incremento
                size++;
                first.setIndex(size-1);
                node.setNext(first);
                first = node;
                isAdded = true;
            }
            else {
                first.setPrevious(node);
                node.setNext(first);
                // pre incremento
                ++size;
                node.setIndex(size);
                first = node;

                isAdded = true;
            }
        }

        return isAdded;
    }

    public String inverseOrder(){
        String msj = "";

        Node current = last;
        while(current.getPrevious() != null){
            msj += current.getData() + " ";
            current = current.getPrevious();
        }

        msj += current.getData();

        return msj;
    }


    public String getByIndex(int index){
        Node current = first.getNext();
        String response = "NO DATA FOUND";

        if(index == 0){
            response = first.getData();
        }
        else{
            while (current != null && current.getIndex() != index){
                current = current.getNext();
            }
            if(current != null){
                response = current.getData();
            }

        }


        return response;
    }

    public boolean deleteWithIndex(int index){
        boolean isDeleted = false;

        Node current = first;

        // 1. Caso base : lista vacia
        if(first != null){
            // 2. caso base, la lista tiene UN elemento.
            if(first.getIndex() == index) {
                first.setPrevious(null);
                first.setNext(first.getNext());

                first.setIndex(first.getNext().getIndex());
                first = first.getNext();

                current.setNext(null);
                isDeleted = true;
            }else{
                while(current.getNext() != null && current.getNext().getIndex() != index  ){
                    current = current.getNext();
                }
                if(current.getNext() != null){
                    Node toDelete = current.getNext();
                    int indexTemporal = toDelete.getIndex();
                    current.getNext().setIndex(indexTemporal);

                    current.setNext(toDelete.getNext());
                    toDelete.getNext().setPrevious(current);


                    toDelete.setNext(null);

                    toDelete.setPrevious(null);
                    isDeleted = true;
                }

            }
        }

        return isDeleted;

    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }




}
