import javax.naming.directory.InvalidAttributesException;

public class MatrixMath
{
    /*
     * Overides the <code>Object</code> class's constructor and makes it private. This prevents this
     * class from ever being instantiated, allowing it to behave like a static class
     */
    private MatrixMath() {} // A handy little trick to prevent initialization of a class

    /*
     * Calculates the determinant of any matrix passed into the method
     * @param mtr matrix
     * @return determinant
     */
    public static int calculateDeterminant(Matrix mtr)
    {
        if (mtr.getCols() != mtr.getRows())
        {
            
            throw new RuntimeException("Can\'t calculate determinant of a non-square 2d array");
        }

        if (mtr.getCols() == 2 && mtr.getRows() == 2)
        {
            return mtr.get(0,0) * mtr.get(1,1) - mtr.get(1,0) * mtr.get(0,1);
        }

        // System.out.println("Calculating determinant of");
        // System.out.println(mtr);
        // System.out.println("------");

        int[] minors = new int[mtr.getCols()];

        for (int c = 0; c < mtr.getCols(); c++)
        {
            Matrix subMtr = new Matrix(mtr.getNotAligned(c));
            int subDet = calculateDeterminant(subMtr);
            int scalar = mtr.get(0, c) * subDet;

            minors[c] = scalar;

            // System.out.println("- Submatrix of id-" + c + " (" + mtr.get(0,c) + "):");
            // System.out.println(subMtr);
            // System.out.println("- Determinant: " + subDet);
            // System.out.println("- Scalar: (" + mtr.get(0, c) + " x " + subDet + ") = " + scalar);
            // System.out.println("- Sign: " + ((minus)? "plus" : "minus"));
            // System.out.println();
        }

        int determinant = 0;
        boolean minus = false;

        for (int i : minors)
        {
            determinant += (minus)? (-1 * i) : i;
            // System.out.println("Det" + ((minus)? " - " : " + ") + i + " = " + determinant);
            minus = !minus;
        }

        // System.out.println();
        // System.out.println("Determinant: " + determinant);
        // System.out.println("------");
        return determinant;   
    }

    public static Matrix add(Matrix mtrA, Matrix mtrB)
    {
        if (mtrA.getCols() != mtrB.getCols() || mtrA.getRows() != mtrB.getRows())
        {
            trow new InvalidAttributesException("null");
        }
        Matrix output = new Matrix(0, 0)
    }

    // public static Matrix subtract(Matrix mtrA, Matrix mtrB)
    // {

    // }

    // public static Matrix multiply(Matrix mtrA, Matrix mtrB)
    // {

    // }

    // public static Matrix scalarMultiply(Matrix mtrA, int scalar)
    // {

    // }
}