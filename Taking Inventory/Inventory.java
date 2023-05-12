import java.text.DecimalFormat;
import java.util.ArrayList;

public class Inventory
{
    private ArrayList<Purchase> data;

    public Inventory(ArrayList<Purchase> p)
    {
        data = p;
    }

    public String toString()
    {
        String s = new String();
        for (Purchase p : data)
        {
            s += p + "\n";
        }
        return s;
    }

    public double getValueRemaining(int sold)
    {
        double out = 0;
        int r = data.size() - 1;
        while (sold > 0)
        {
            Purchase p = data.get(r);
            if (sold > p.count())
            {
                out += p.count() * p.price();
                r--;
                sold -= p.count();
            }
            else
            {
                out += sold * p.price();
                sold = 0;
            }
        }

        out = out += 0.005;
        return out;
    }
}