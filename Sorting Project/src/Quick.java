public class Quick extends Sorts
{
    public Quick(int size)
    {
        super(size);
    }

    public void quickSort(int from, int to)
    {
        if (from < to)
        {
            int p = split(from, to);
            quickSort(from, p - 1);
            quickSort(p + 1, to);
        }
    }
    
    private int split(int from, int to)
    {
        int pivot = getVali(from);
        int first = from;
        int last = to;
        while (first < last)
        {
            first++;
            while ((first < getSize()) && (getVali(first) <= pivot))
            {
                first++;
            }
            while (getVali(last) > pivot)
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

