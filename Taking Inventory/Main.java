import java.math.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int purchases = sc.nextInt();
        ArrayList<Purchase> data = new ArrayList<Purchase>();
        while (purchases > 0)
        {
            data.add(new Purchase(sc.nextInt(), sc.nextDouble()));
            purchases--;
        }

        Inventory inventory = new Inventory(data);
        System.out.println(inventory);
        System.out.println();

        DecimalFormat dc = new DecimalFormat("0.00");
        double valRemaining = inventory.getValueRemaining(count);
        System.out.println(dc.format(valRemaining));
    }

    // private static void runTest()
    // {
    //     ArrayList<Purchase> sampleInput = new ArrayList<Purchase>(Arrays.asList(getSample(10,20, 400, 0.5, 1)));
    //     Inventory inventory = new Inventory(sampleInput);

    //     System.out.println(inventory);
    //     System.out.println();
    //     int count = 200;
    //     System.out.println(count);
    //     System.out.println(inventory.getValueRemaining(count));
    // }

    // private static Purchase[] getSample(int entries, int minCount, int maxCount, double minPrice, double maxPrice) {
    //     Purchase[] purchases = new Purchase[entries];
    //     for (int i = 0; i < purchases.length; i++) {
    //         purchases[i] = new Purchase((int) (Math.random() * (maxCount - minCount) + minCount), Math.random() * (maxPrice - minPrice) + minPrice);
    //     }
    //     return purchases;
    // }
}