public class Cocktail extends Sorts
{
    public Cocktail(int size)
    {
        super(size);
    }

    public void cocktailSort()
    {
        int startInd = 0;
        int endInd = getSize() - 1;
        boolean swapped = true;       
        while (swapped == true && startInd < endInd)
        {
            swapped = false;
            for (int i = startInd; i < endInd; i++)
            {
                if (getVali(i) > getVali(i + 1))
                {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            if (swapped == false)
            {
                break;
            }
            endInd = endInd - 1;
            for (int i = endInd; i >= startInd; i--)
            {
                if (getVali(i) > getVali(i + 1))
                {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            startInd = startInd + 1;
        }
    }
}
