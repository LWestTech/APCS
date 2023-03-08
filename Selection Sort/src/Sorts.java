//----------------------------------------------------------------------------
// Sorts.java                  by Dale/Joyce/Weems                  Chapter 10
//
// Test harness used to run sorting algorithms
//
// Edited by F. Deppe 01-18-11
//----------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
    public static final int SIZE = 50;          // Size of array to be sorted
    private static int[] values = new int[SIZE];  // Values to be sorted
    
    // Initializes the values array with random integers from 0 to 99
    private static void initValues()
    {
        Random rand = new Random(560);
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
    }
    
    // Determine whether the array values are sorted
    public static boolean isSorted()
    {
        boolean wrong = false;
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] < values[i-1])
            {
                return false;
            }
        }
        return true;
    }
    
    public static int minIndex(int startIndex, int endIndex)
    {
        int least = startIndex;
        for (int i = startIndex; i <= endIndex; i++)
        {
            if (values[i] < values[least]) {least = i;}
        }
        return least;
    }
    
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    public static void swap(int index1, int index2)
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    public static void selectionSort()
    {
        for (int i = 0; i < values.length - 1; i++)
        {
            swap(i, minIndex(i, values.length-1));
        }
    }
    
    
    // Prints all the values integers
    public static void printValues()
    {
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("the values array is:");
        for (int index = 0; index < SIZE; index++)
        {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    // Tests the other methods of the Sorts class
    public static void main(String[] args) throws IOException
    {
        initValues();
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
        selectionSort();
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
    }   
}
