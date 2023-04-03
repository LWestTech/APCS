import java.util.*;
public class Sorts
{
    private int[] values;
    private int size;
     
    public Sorts(int nextSize) 
    {
        size = nextSize;
        values = new int[size];
        initValues();
    }

    public boolean isSorted()
    // Determine whether the array values are sorted
    {
        for(int i = 1; i < size; i++)
        {
            if(values[i] < values[i-1])
                return false;
        }
        return true;
    }

    /*
     * Initializes the values array with random integers from 0 to 99
     */
    public void initValues()
    {
        int randomSeed = (int)Math.random() * 1001;
        Random rand = new Random(randomSeed);
        for (int index = 0; index < size; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
    }


    public void swap(int a, int b) 
    {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int nextSize)
    {
        size = nextSize;
    }

    public void resizeArray(int newLength)
    {
        setSize(newLength);
        values = new int[newLength];
    }

    public int[] getValues()
    {
        return values;
    }

    public void setVali(int index, int value)
    {
        values[index] = value;
    }

    public int getVali(int index)
    {
        return values[index];
    }
}