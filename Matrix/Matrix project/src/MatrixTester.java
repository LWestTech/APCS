public class MatrixTester
{
    static Matrix mtrA;
    static Matrix mtrB;
    public static void main(String[] args)
    {
        System.out.println();
        mtrA = new Matrix(new int[][]{{1,2}, {4,2}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println("2 x 2 determinant: " + MatrixMath.calculateDeterminant(mtrA));

        System.out.println();
        mtrA = new Matrix(new int[][]{{1,2,3}, {4,2,6}, {7,8,9}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println("3 x 3 determinant: " + MatrixMath.calculateDeterminant(mtrA));

        System.out.println();
        mtrA = new Matrix(new int[][]{{1,3,5,9}, {1,3,1,7}, {4,3,9,7}, {5,2,0,9}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println("n x n determinant: " + MatrixMath.calculateDeterminant(mtrA));

        System.out.println();
        mtrA = new Matrix(new int[][]{{1,2,3}, {4,2,6}, {7,8,9}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println(" +");
        System.out.println("B:\n" + mtrA + "\n");
        System.out.println("Matrix addition: \n" + MatrixMath.add(mtrA, mtrA));

        System.out.println();
        mtrA = new Matrix(new int[][]{{1,2,3}, {4,2,6}, {7,8,9}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println(" -");
        System.out.println("B:\n" + mtrA + "\n");
        System.out.println("Matrix subtraction: \n" + MatrixMath.subtract(mtrA, mtrA));

        System.out.println();
        mtrA = new Matrix(new int[][]{{3,4,2}});
        mtrB = new Matrix(new int[][]{{13,9,7,15},{8,7,4,6},{6,4,0,3}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println("B:\n" + mtrB + "\n");
        System.out.println("Matrix multiplication: \n" + MatrixMath.multiply(mtrA, mtrB));

        System.out.println();
        mtrA = new Matrix(new int[][]{{1,2,3}, {4,2,6}, {7,8,9}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println("Scalar of 2");
        System.out.println("Matrix scalar multiplication: \n" + MatrixMath.scalarMultiply(mtrA, 2));

        System.out.println("--- Misc methods ---");

        System.out.println();
        mtrA = new Matrix(new int[][]{{13,9,7,15},{6,4,0,3},{8,7,4,6}});
        mtrB = new Matrix(new int[][]{{13,9,7,15},{8,7,4,6},{6,4,0,3}});
        System.out.println("A:\n" + mtrA + "\n");
        System.out.println("B:\n" + mtrB + "\n");
        System.out.println("Test equality A = B: \n" + mtrA.equals(mtrB));
        System.out.println("Test equality A = A: \n" + mtrA.equals(mtrA));

        /*
         * Hi deppe, just so you know, there are a bunch of helper methods in <code>Matrix.java</code> that arent tested here
         */
    }
}