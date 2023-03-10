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
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        Random rand = new Random(560);
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
    }
    
    public static boolean isSorted()
    // Determine whether the array values are sorted
    {
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] < values[i-1]) return false;
        }
        return true;
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    public static void insertItem(int startIndex, int endIndex)
    {
        for (int i = endIndex; i > startIndex; i--)
        {
            if (values[i] < values[i-1]) swap(i, i-1);
            else break;
        }
    }

    public static void insertionSort()
    {
        for (int i = 1; i < values.length; i++)
        {
            insertItem(0, i);
        }
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
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException
    // Tests the other methods of the Sorts class
    {
        initValues();
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();

        insertionSort();

        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
    }   
}
