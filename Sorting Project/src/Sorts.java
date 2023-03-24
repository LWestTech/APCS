import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
    
    public static boolean isSorted()
    // Determine whether the array values are sorted
    {
        for (int i = 1; i < SIZE; i++)
        {
            if (values[i] < values[i - 1])
            {
                return false;
            }
        }
        return true;
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition: index1 and index2 are less than size
    {
        int store = values[index1];
        values[index1] = values[index2];
        values[index2] = store;
    }
    public static void printValues()
    // Prints all the values integers
    {
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("the values array is:");
        for (int index = 0; index < SIZE; index++)
        {
            value = values[index];
            if (((index + 1) % 10) == 0)
            {
            System.out.println(fmt.format(value));
            }
            else
            {
            System.out.print(fmt.format(value) + " ");
            }
        }
        System.out.println();
    }
}   
