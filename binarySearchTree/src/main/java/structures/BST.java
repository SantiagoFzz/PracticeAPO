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

    // Delete
    public boolean delete(T data){
        boolean isDeleted = false;
        if(root != null){
            // Si el nodo a eliminar es la raiz.
            if(root.getValue().compareTo(data) == 0){
                // Si la raiz es el unicio nodo del arbol.
                if(root.getRight() == null && root.getLeft() == null){
                    root = null;
                }
                // La raiz tiene un unico hijo
                if(root.getRight() != null && root.getLeft() == null){
                    root = root.getRight();
                }
                else if(root.getRight() == null && root.getLeft() != null){
                    root = root.getLeft();
                }
                else if(root.getLeft() == null && root.getRight() != null){
                    Node<T> predecessor = getMax(root.getLeft());
                    root.setValue(predecessor.getValue());
                    delete(root, root.getLeft(), predecessor.getValue());
                }
            }
            delete(null, root, data);
        }
        return isDeleted;
    }

    private boolean delete(Node<T> parent, Node<T> current, T goal){
        boolean isDeleted = false;

        // CASO BASE 1: Encontramos el nodo.
        if(current.getValue().compareTo(goal) == 0){
            // CASO BASE 1.1: es un nodo hoja.
            if(current.getRight() == null && current.getLeft() == null){
                // Evaluamos si es un hijo derecho y lo eliminamos.
                if(parent.getRight() == current){
                    parent.setRight(null);
                }
                // Es un hijo izquierdo, entonces lo eliminamos.
                else{
                    parent.setLeft(null);
                }
            }
            // CASO BASE 1.1¿2.
            // CASO BASE 1.2.1. Tiene unico hijo derecho
            if(current.getRight() != null && current.getLeft() == null){
                // Evaluamos si es un hijo derecho y lo eliminamos.
                if(parent.getRight() == current){
                    parent.setRight(current.getRight());
                    current.setRight(null);
                }
                // Es un hijo izquierdo, entonces lo eliminamos.
                else{
                    parent.setLeft(current.getRight());
                    current.setRight(null);
                }
            }
            // CASO BASE 1.2.2. Tiene unico hijo izquierdo
            else if(current.getRight() == null && current.getLeft() != null){
                // Evaluamos si es un hijo izquierdo y lo eliminamos.
                if(parent.getRight() == current){
                    parent.setRight(current.getLeft());
                    current.setLeft(null);
                }
                // Es un hijo derecho, entonces lo eliminamos.
                else{
                    parent.setLeft(current.getLeft());
                    current.setLeft(null);
                }
            }
            else if(current.getLeft() != null && current.getRight() != null){
                Node<T> predecessor = getMax(current.getLeft());
                // Evaluamos si es un hijo derecho y lo eliminamos.
                if(parent.getRight() == current){
                    parent.getRight().setValue(predecessor.getValue());
                }
                // Es un hijo izquierdo, entonces lo eliminamos.
                else{
                    parent.getLeft().setValue(predecessor.getValue());
                }
                delete(current, current.getLeft(), predecessor.getValue());
            }
        }
        // CASO RECURSIVO
        else if(current.getValue().compareTo(goal) > 0){
            delete(current, current.getLeft(), goal);
        }
        else if(current.getValue().compareTo(goal) < 0){
            delete(current, current.getRight(), goal);
        }

        return isDeleted;
    }

    // Get the max node.
    public Node<T> getMax(){
        Node<T> current = null;
        if(root != null){
            current = root;
            while(current.getRight() != null){
                current = current.getRight();
            }
        }
        return current;
    }

    // Get the max node.
    private Node<T> getMax(Node<T> current){
        if(current.getRight() != null){
            getMax(current.getRight());
        }
        return current;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
