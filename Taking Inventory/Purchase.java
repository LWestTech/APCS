public class Purchase
{
    private int count;
    private double price;

    public int count() {return count;}
    public double price() {return price;}

    public Purchase(int count, double price) {
        this.count = count;
        this.price = price;
    }

    public String toString()
    {
        return count + " " + price;
    }
}