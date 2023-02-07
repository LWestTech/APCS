enum Operation
{
    ADD, SUBTRACT, MULTIPLY
}

/**
 * Perform mathmatical operations with <code>Matrix</code> objects
 */
public class MatrixMath
{
    /**
     * Overides the <code>Object</code> class's constructor and makes it private. This prevents this
     * class from ever being instantiated, allowing it to behave like a static class
     */
    private MatrixMath() {} // A handy little trick to prevent initialization of a class

    
    /**
     * Calculates the determinant of any matrix passed into the method
     * @param mtr matrix
     * @return determinant
     */
    public static int calculateDeterminant(Matrix mtr)
    {
        if (mtr.getCols() != mtr.getRows())
        {
            throw new IllegalArgumentException("Can\'t calculate determinant of a non-square 2d array");
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

    /**
     * Applies a certain matrix manipulation to two matrices to create a new matrix
     * @param mtrA left matrix
     * @param mtrB right matrix
     * @param operation what matrix manipulation operation to apply
     * @return the resulting matrix
     */
    private static Matrix calculate(Matrix mtrA, Matrix mtrB, Operation operation)
    {
        if (operation != Operation.MULTIPLY)
        {
            if (mtrA.getCols() != mtrB.getCols() || mtrA.getRows() != mtrB.getRows())
            {
                throw new IllegalArgumentException("Can\'t add or subtract matrices of different sizes");
            }
        } else if (mtrA.getCols() != mtrB.getRows())
        {
            throw new IllegalArgumentException("Can\'t multiply matrices of non-corresponding sizes");
        }
        
        int rows = mtrA.getRows();
        int cols = mtrB.getCols();

        Matrix output = new Matrix(rows, cols);

        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                int newData = 0;
                /*
                 * I know you hate switch statements, but you've gotta admit, this is a really clean way to do this
                 * Switches just work so nicely with enums that its hard to resist. If you really hate it, I can
                 * re-do it.
                 * Oh, also, having a <code>calculate()</code> method using the enum prevents a lot of copy/pasting
                 */
                switch (operation)
                {
                    case ADD:
                        newData = mtrA.get(r, c) + mtrB.get(r, c);
                        break;
                    case SUBTRACT:
                        newData = mtrA.get(r, c) - mtrB.get(r, c);
                        break;
                    case MULTIPLY:
                        for (int i = 0; i < mtrA.getCols(); i++)
                        {
                            newData += mtrA.get(r, i) * mtrB.get(i, c);
                        };
                        break;
                }

                output.set(r, c, newData);
            }
        }
        return output;
    }

    /**
     * Adds two matrices
     * @param mtrA matrix a
     * @param mtrB matrix b
     * @return the resulting matrix
     */
    public static Matrix add(Matrix mtrA, Matrix mtrB)
    {
        return calculate(mtrA, mtrB, Operation.ADD);
    }

    /**
     * Subtracts two matrices
     * @param mtrA matrix a
     * @param mtrB matrix b
     * @return the resulting matrix
     */
    public static Matrix subtract(Matrix mtrA, Matrix mtrB)
    {
        return calculate(mtrA, mtrB, Operation.SUBTRACT);
    }

    /**
     * Multiplies two matrices
     * @param mtrA left matrix
     * @param mtrB right matrix
     * @return the resulting matrix
     */
    public static Matrix multiply(Matrix mtrA, Matrix mtrB)
    {
        return calculate(mtrA, mtrB, Operation.MULTIPLY);
    }

    /**
     * Multiplies a matrix by a scalar
     * @param mtrA matrix
     * @param scalar integer scalar to scale the matrix
     * @return the resulting matrix
     */
    public static Matrix scalarMultiply(Matrix mtrA, int scalar)
    {
        int rows = mtrA.getRows();
        int cols = mtrA.getCols();

        Matrix output = new Matrix(rows, cols);

        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                output.set(r, c, mtrA.get(r, c) * scalar);
            }
        }

        return output;
    }
}