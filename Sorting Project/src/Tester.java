import java.util.*;
import java.util.concurrent.TimeUnit;

public class Tester 
{
    
    /* array sizes:
        10E2
        10E4
        10E5
        10E6
        10E7
    */
    public static void main(String[] args)
    {
        cAndF();
        Quick q1 = new Quick(50);
        System.out.println(q1.isSorted());
        q1.quickSort(0, q1.getSize() - 1);
        System.out.println(q1.isSorted());
        
    }

    /**
     * Create and fill arrays, and total time of operation
     */
    private static void cAndF()
    {
        int[] values = new int[(int)10E7];
        int size = (int) 10E7;
        long start = System.currentTimeMillis();
        Random rand = new Random(560);
        for (int index = 0; index < size; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
        long end = System.currentTimeMillis();
        long timeInSec = TimeUnit.MILLISECONDS.toSeconds(end - start);
        System.out.println(timeInSec);
    
    }
}
