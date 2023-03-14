import java.util.ArrayList;

public class BubbleSortTester
{
    public static void main(String[] args) {
        ArrayList<Fraction> fracts = randomFractions(10, 10);
        System.out.println(fracts);
        FractionBubbleWest.sort(fracts);
        ArrayList<Double> out = new ArrayList<Double>();
        fracts.forEach((n) -> out.add(n.getDecimalForm()));
        System.out.println(fracts);
        System.out.println(out);
    }

    public static ArrayList<Fraction> randomFractions(int length, int highest)
    {
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        highest--;
        for (int i = 0; i < length; i++)
        {
            int num = (int)(Math.random() * highest);
            num++;
            int deNum = (int)(Math.random() * highest);
            deNum++;
            fractions.add(new Fraction(num, deNum));
        }
        return fractions;
    }
}