package structures;

public class SimpleList {
    private Node first;
    private Node last;

    public SimpleList(){ first = null;last = null; }

    public boolean add(String data){
        // Crear el nodo a agregar.
        Node node = new Node(data);

        boolean isAdded = false;

        // 1. Caso Base -> Empty list
        if(first == null){
            first = node;
            first.setIndex(0);
            last = first;
            isAdded = true;
        }
        // 2. Caso Base -> La lista tiene un elemento.
        else{
            if(first.getNext() == null){
                first.setNext(node);
                isAdded = true;
                first.getNext().setIndex(1);
                last = first.getNext();
            }
            else {
                // elemento de referencia
                Node current = first.getNext();

                // ir al final de la lista
                while(current.getNext() != null){

                    current = current.getNext();
                }

                // agregar al final de la lista
                current.setNext(node);
                current.getNext().setIndex(current.getIndex() + 1);
                last = current.getNext();
                isAdded = true;
            }
        }

        return isAdded;
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
