import java.math.*;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
    }

    public static class Purchase
    {
        private int count;
        private double price;

        public Purchase(int count, double price)
        {
            this.count = count;
            this.price = price;
        }

        public int c() {return count;}
        public double p() {return price;}
    }

    private static Purchase[] getSample(int entries, int minCount, int maxCount, int minPrice, int maxPrice)
    {
        Purchase[] purchases = new Purchase[entries];
        for (Purchase p : purchases)
        {
            p = new Purchase((int) (Math.random() * (maxCount - minCount) + minCount), Math.random() * (maxPrice - minPrice) + minPrice);
        }
        return purchases;
    }
}