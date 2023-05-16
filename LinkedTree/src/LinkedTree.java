public class LinkedTree<E> {
    transient int cells;
    transient Node<E> root;
    public LinkedTree()
    {

    }

    private static class Node<E>
    {
        E item;
        Node<E> left;
        Node<E> right;
        Node<E> up;
        Node<E> down;

        Node(Node<E> up, E element, Node<E> left, Node<E> right, Node<E> down) {
            this.item = element;
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
        }
    }
}
