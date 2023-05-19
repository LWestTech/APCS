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
        System.out.println();
        tree.remove(2);
        tree.remove(1);
        tree.remove(1);
        System.out.println();
        tree.display();

        System.out.println();
        System.out.println(tree.search(5));
    }
}