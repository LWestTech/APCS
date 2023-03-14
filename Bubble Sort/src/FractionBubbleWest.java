import java.util.ArrayList;

public class FractionBubbleWest
{
    private static ArrayList<Fraction> fracts;
    public static void sort(ArrayList<Fraction> in)
    {
        fracts = in;
        for (int p = 0; p < fracts.size() - 2; p++)
        {
            for (int i = fracts.size() - 1; i > p; i--)
            {
                if (fracts.get(i).getDecimalForm() < fracts.get(i - 1).getDecimalForm()) swap(i, i - 1);
            }
        }
    }

    public static void swap(int index1, int index2)
    {
        Fraction temp = fracts.get(index1);
        fracts.set(index1, fracts.get(index2));
        fracts.set(index2, temp);
    }
}