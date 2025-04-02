package structures;

public class BST<T extends Comparable<T>> {

    private Node<T> root;

    public BST(){
        root = null;
    }

    /**
     * Metodo Fachada. Es decir, recursividad en dos partes.
     * Es un metodo que soluciona sus metodos haciendo uso internamente de otro metodo.
     */
    public void add(T value){
        Node<T> node = new Node<>(value);

        // CASO BASE 1. El arbol está totalmente vacio.
        if(root == null){
            root = node;
        }

        // CASO RECURSIVO: (Llamado a un metodo recursivo).
        else{
            add(node, root);
        }
    }


    // Metodo recursivo
    private void add(Node<T> node, Node<T> current) {
        // CASO BASE 1: el nodo a agregar es menor que el current.
        if(current.getValue().compareTo(node.getValue()) > 0){
            // CASO BASE 1.1: la izquierda del el nodo current esta vacia.
            if(current.getLeft() == null){
                current.setLeft(node);
            }
            // CASO BASE 1.2: la izquierda del nodo current no esta vacia.
            else{
                add(node, current.getLeft());
            }
        }
        // CASO BASE 2: el nodo a agregar es mayor que el current.
        else if (current.getValue().compareTo(node.getValue()) < 0){
            // CASO BASE 2.1: la derecha del el nodo current esta vacia.
            if(current.getRight() == null){
                current.setRight(node);
            }
            // CASO BASE 2.2: la derecha del nodo current no esta vacia.
            else{
                add(node, current.getRight());
            }
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
