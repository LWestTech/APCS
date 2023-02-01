public class Matrix {
    private int[][] arr;
    private int determinant;

    public Matrix(int rows, int cols) {this.arr = new int[rows][cols];}
    public Matrix(int[][] arr) {this.arr = arr;}


    public void set(int row, int col, int content) {arr[row][col] = content;}
    public void set(int[][] arr) {this.arr = arr;}


    public int get(int row, int col) {return arr[row][col];}
    public int[][] get() {return arr;}

    public int[] getRow(int row) {return arr[row];}
    public int[] getCol(int col)
    {
        int[] colArr = new int[arr[0].length];

        for (int row = 0; row < arr.length; row++) {colArr[row] = arr[row][col];}

        return colArr;
    }
    public int getRow() {return arr.length;}
    public int getCol() {return arr[0].length;}


    public int getDeterminant()
    {
        if (arr.length == arr[0].length)
        {
            return determinant;
        }
        throw RuntimeException("Can\'t calculate determinant of a non-square 2d array");
    }
}