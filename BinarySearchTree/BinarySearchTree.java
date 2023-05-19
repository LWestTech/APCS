import java.lang.Comparable;

public class BinarySearchTree<E extends Comparable<? super E>>{
    Node<E> root;

    public BinarySearchTree() {}

    public void insert(Comparable<E> element) {
        Node node = new Node<E>(element);
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        Comparable element = node.element;
        if (root == null) {
            root = node;
        } else if (element.compareTo(root.element) < 0) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }
    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.element);
            displayHelper(root.right);
        }
    }

    public boolean search(Comparable<E> data) {
        return searchHelper(root, data);
    }
    private boolean searchHelper(Node root, Comparable<E> data) {
        if (root == null) return false;
        else if (root.element == data) {
            return true;
        }
        else if (root.element.compareTo(data) > 0) {
            return searchHelper(root.left, data);
        }
        else {
            return searchHelper(root.right, data);
        }
    }

    // public void remove(int data) {}
    // private Node removeHelper(Node root, int data) {return null;}
    // private int successor(Node root) {return null;}
    // private int predecessor(Node root) {return null;}

    private static class Node<E> {
        Comparable<E> element;
        Node<E> left;
        Node<E> right;

        public Node(Comparable<E> element)
        {
            this.element = element;
        }
    }
}
