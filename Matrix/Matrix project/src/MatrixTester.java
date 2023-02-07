public class MatrixTester {
    public static void main(String[] args) {
        Matrix mtr = new Matrix(new int[][]{{1,2,3}, {4,2,6}, {7,8,9}});
        System.out.println();
        System.out.println("Final determinant: " + mtr.getDeterminant());

        System.out.println();

        Matrix mtr2 = new Matrix(new int[][]{{1,3,5,9}, {1,3,1,7}, {4,3,9,7}, {5,2,0,9}});
        System.out.println();
        System.out.println("Final determinant: " + mtr2.getDeterminant());
    }
}