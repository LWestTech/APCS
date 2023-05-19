import java.lang.Comparable;

import org.w3c.dom.Node;

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

    public void remove(Comparable<E> data) {
        if (search(data)) {removeHelper(root, data);}
        else {System.out.println(data + " could not be found");}
    }
    private Node removeHelper(Node root, Comparable<E> data) {
        if (root == null) {return root;}
        else if (root.element.compareTo(data) > 0) {
            root.left = removeHelper(root.left, data);
        } else if (root.element.compareTo(data) < 0) {
            root.right = removeHelper(root.right, data);
        } else { // node found
            if(root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.element = successor(root);
                root.right = removeHelper(root.right, data);
            } else {
                root.element = predecessor(root);
                root.left = removeHelper(root.left, data);
            }
        }
        return root;
    }
    private Comparable<E> successor(Node root) { // Find least value child
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.element;
    }
    private Comparable<E> predecessor(Node root) { // Find greatest value child
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.element;
    }

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
