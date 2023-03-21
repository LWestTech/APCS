import java.util.ArrayList;

public class BubbleSort
{
    private static ArrayList<Integer> fracts;
    public static void sort(ArrayList<Integer> in)
    {
        fracts = in;
        for (int p = 0; p < fracts.size() - 2; p++)
        {
            for (int i = fracts.size() - 1; i > p; i--)
            {
                if (fracts.get(i) < fracts.get(i - 1)) swap(i, i - 1);
            }
        }
    }

    public static void swap(int index1, int index2)
    {
        Integer temp = fracts.get(index1);
        fracts.set(index1, fracts.get(index2));
        fracts.set(index2, temp);
    }
}