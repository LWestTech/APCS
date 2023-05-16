public class BinarySearchTree<E>{
    Node<E> root;

    public BinarySearchTree() {}

    public void insert(E element) {
        Node node = new Node<E>(element);
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        E element = node.element;
        if (root == null) {
            root = node;
        } else if (element < root.element) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    // public void display() {}
    // private void displayHelper() {}

    // public boolean search(int data) {return null;}
    // private boolean searchHelper(Node root, int data) {return null;}

    // public void remove(int data) {}
    // private Node removeHelper(Node root, int data) {return null;}
    // private int successor(Node root) {return null;}
    // private int predecessor(Node root) {return null;}

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        public Node(E element)
        {
            this.element = element;
        }
    }
}
