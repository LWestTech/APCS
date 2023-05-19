import java.util.PriorityQueue;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        System.out.println("wow");
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        tree.insert(5);
        tree.insert(1);
        tree.insert(9);
        tree.insert(2);
        tree.insert(7);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(1);
        tree.insert(4);
        tree.insert(8);

        tree.display();
    }
}