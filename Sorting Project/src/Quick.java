public class Quick extends Sorts
{
    public static void quickSort(int from, int to)
    {
        if (from < to)
        {
            int p = split(from, to);
            quickSort(from, p - 1);
            quickSort(p + 1, to);
        }
    }
    private static int split(int from, int to)
    {
        int pivot = values[from];
        int first = from;
        int last = to;
        while (first < last)
        {
            first++;
            while (first < SIZE && values[first] <= pivot)
            {
                first++;
            }
            while (values[last] > pivot)
            {
                last--;
            }
            if (first < last)
            {
                swap(first, last);
            }
        }
        swap(from, last);
        return last;
    }
}

