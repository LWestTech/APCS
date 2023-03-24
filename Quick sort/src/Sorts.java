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
        int prev = 0;
        for (int current : values)
        {
            if (prev > current) return false;
            prev = current;
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

    public static void quickSort(int from, int to)
    {
        if (from < to)
        {
            int p = split(from, to);
            quickSort(from, p - 1);
            quickSort(p + 1, to);
        }
    }

    public static int split(int from, int to)
    {
        int pivot = values[from];
        int indexFirst = from;
        int indexLast = to;
        while (indexFirst < indexLast)
        {
            indexFirst++;
            while (indexFirst < SIZE && values[indexFirst] <= pivot) {indexFirst++;}
            while (values[indexLast] > pivot) {
                indexLast--;
            }
            if (indexFirst < indexLast) {swap(indexFirst, indexLast);}
        }
        swap(from, indexLast);
        return indexLast;
    }

    // public static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
    // {
    //     int l = leftFirst;
    //     int r = rightFirst;

    //     if (rightLast - leftFirst <= 0) return;
    //     if (rightLast - leftFirst == 1) 
    //     {
    //         if (values[rightLast] < values[leftFirst]) swap(rightLast, leftFirst);
    //         return;
    //     }

    //     int leftCenter = leftFirst + div(leftLast - leftFirst + 1, 2);
    //     int rightCenter = rightFirst + div(rightLast - rightFirst + 1, 2);
    //     merge(leftFirst, leftCenter, leftCenter + 1, leftLast);
    //     merge(rightFirst, rightCenter, rightCenter + 1, rightLast);

    //     int[] temp = new int[rightLast - leftFirst + 1];
    //     for (int i = 0; i < temp.length; i++)
    //     {
    //         if (l <= leftLast && r <= rightLast)
    //         {
    //             if (values[l] > values[r])
    //             {
    //                 temp[i] = values[r];
    //                 r++;
    //             }
    //             else
    //             {
    //                 temp[i] = values[l];
    //                 l++;
    //             }
    //         }
    //         else if (l > leftLast)
    //         {
    //             temp[i] = values[r];
    //             r++;
    //         }
    //         else if (r > rightLast)
    //         {
    //             temp[i] = values[l];
    //             l++;
    //         }
    //     }

    //     for (int i = 0; i < temp.length; i++)
    //     {
    //         values[i + leftFirst] = temp[i];
    //     }
    // }

    // public static int div(int a, int b)
    // {
    //     double decimalForm = a / b;
    //     return (int)(decimalForm + 0.5);
    // }

    // public static void mergeSort()
    // {
    //     int split = div(SIZE, 2);
    //     merge(0, split, split + 1, SIZE - 1);
    // }
    
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
        quickSort(0, SIZE - 1);
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
    }   
}
