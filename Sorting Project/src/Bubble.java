public class Bubble extends Sorts 
{
    public Bubble(int size)
    {
        super(size);
    }

    public void bubbleSort()
    {
        int current = 0;
        while(current < getSize())
        {
            bubbleUp(getSize() - 1, current); 
            current++;
        }
    }
    
    public void bubbleUp(int endIndex, int startIndex)
    {
        for (int i = endIndex; i > startIndex; i--)
        {
            if(getVali(i) - getVali(i - 1) < 0)
            {
                swap(i, i - 1);
            }
        }
    }
}