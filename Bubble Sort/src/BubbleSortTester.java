import java.util.ArrayList;

public class BubbleSortTester
{
    public static void main(String[] args) {
        ArrayList<Fraction> fracts = randomFractions(10, 10);
        System.out.println(fracts);
        FractionBubbleWest.sort(fracts);
        System.out.println(fracts);
    }

    public static ArrayList<Fraction> randomFractions(int length, int highest)
    {
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        for (int i = 0; i < length; i++)
        {
            int num = (int)(Math.random() * highest);
            int deNum = (int)(Math.random() * highest);
            fractions.add(new Fraction(num, deNum));
        }
        return fractions;
    }
}