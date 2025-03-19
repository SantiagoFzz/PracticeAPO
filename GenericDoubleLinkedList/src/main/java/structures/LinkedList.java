package structures;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public boolean add(String data){
        boolean isAddded = false;
        Node node = new Node(data);
        // caso 1. No existe ningun elemento.
        if(head == null){
            head = node;
            tail = node;
            node.setIndex(0);
            isAddded = true;
        }else{
            // caso 2. Existe UN elemento.
            if(head.getNext() == null){
                head.setNext(node);
                node.setPrevious(head);
                node.setIndex(1);
                tail = node;
                isAddded = true;
            }else{
                // caso 3. Existen mas de un elemento.
                tail.setNext(node);
                node.setPrevious(tail);
                node.setIndex(tail.getIndex() + 1);
                tail = node;
                isAddded = true;
            }
        }


        return isAddded;
    }

    public boolean deleteNode(String data){
        boolean isDeleted = false;
        Node current = head;

        // La lista NO esta vacia.
        if(head != null){
            // caso base 1. El nodo a eliminar es el PRIMERO.
            if(head.getData().compareTo(data) == 0){
                head = head.getNext();
                current.setNext(null);
                head.setPrevious(null);
                isDeleted = true;
            }else{
                // caso base 2. El nodo a eliminar es diferente del primero.
                while(current.getNext() == null && current.getNext().getData().compareTo(data) != 0){
                    current = current.getNext();
                }
                
            }
        }


        return isDeleted;
    }

    public String showNodes(){
        String msj = "";
        Node current = head;

        while(current.getNext() != null){
            msj += current.getData() +  " ";
            current = current.getNext();
        }

        msj += current.getData();

        return msj;
    }
}
