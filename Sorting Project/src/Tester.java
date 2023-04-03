import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Tester
{
    public static int j = 0;
    
    /* array sizes:
    100
    500
    2500
    12500
    62500
    */
    public static void main(String[] args) throws IOException
    {
        BufferedWriter quickWriter = new BufferedWriter(new FileWriter("BubbleTimes.txt"));
        // cAndF();
        Bubble b1 = new Bubble(100);
        for(; j < 5; j++)
        { 
            for(int i = 1; i < 31; i++)
            {
                if(j == 0)
                {
                    if(i == 1) 
                        quickWriter.write("size 100\n");
                    b1.initValues();
                }
                else if (j == 1)
                {
                    if(i == 1) 
                    {
                        b1.resizeArray(500);
                        quickWriter.write("size 500\n");
                    }
                    b1.initValues();
                }    
                else if(j == 2)
                {
                    if(i == 1)
                    {
                        b1.resizeArray(2500);
                        quickWriter.write("size 2500\n");
                    }
                    b1.initValues();
                }
                else if (j == 3)
                {
                    if(i == 1)
                    {
                        b1.resizeArray(12500);
                        quickWriter.write("size 12500\n");
                    }
                    b1.initValues();
                }
                else if (j == 4)
                {
                    if(i == 1)
                    {
                        b1.resizeArray(62500);
                        quickWriter.write("size 62500\n");
                    }
                    b1.initValues();
                }    
                System.out.println(i + " Bubble start:    " + b1.isSorted());
                long start = System.nanoTime();
                b1.bubbleSort();
                long end = System.nanoTime();
                System.out.println(i + " Bubble end:      " + b1.isSorted());
                quickWriter.write(((end - start)/1000) + "." + (end - start)%100 + ("\n"));
            }
        }
        quickWriter.close();
        
        // Bubble b1 = new Bubble(50);
        // System.out.println("Bubble start:   " + b1.isSorted());
        // b1.bubbleSort();
        // System.out.println("Bubble end:     " + b1.isSorted());

        // Cocktail c1 = new Cocktail(50);
        // System.out.println("Cocktail start: " + c1.isSorted());
        // c1.cocktailSort();
        // System.out.println("Cocktail end:   " + c1.isSorted());
    }

    /**
     * Create and fill arrays, and total time of operation
     */
    private static void cAndF()
    {
        int[] values = new int[(int)10E7];
        int size = (int) 10E7;
        for(int i  = 0; i < 30; i++)
        {
            long start = System.currentTimeMillis();
            Random rand = new Random(560);
            for (int index = 0; index < size; index++)
            {
                values[index] = Math.abs(rand.nextInt()) % 100;
            }
            long end = System.currentTimeMillis();
            System.out.println(((end - start)/1000) + "." + (end - start)%100);
        }
    }
}
