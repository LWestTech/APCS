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
    public int getRows() {return arr.length;}
    public int getCols() {return arr[0].length;}

    public int[][] getNotAligned(int row, int col)
    {
        int[][] output = new int[(arr.length - 1) * (arr[0].length - 1)];

        int x = 0;
        int y = 0;
        for (int r = 0; r < m.getRows(); r++)
        {
            if (r != row)
            {
                for (int c = 0; c < m.getCols(); c++)
                {
                    if (c != col)
                    {
                        output[y][x] = getCell(r, c);
                        x++;
                    }
                }
                y++;
            }
        }
        return output;
    }


    public int getDeterminant()
    {
        if (arr.length == arr[0].length)
        {
            return calcualteDeterminant(arr);
        }
        throw RuntimeException("Can\'t calculate determinant of a non-square 2d array");
    }

    public int calcualteDeterminant(int[][] arr)
    {
        if (arr.length == 1 && arr[0].length == 1)
        {
            return arr[0][0];
        }
        else
        {
            for (int r = 0; r < m.getRows(); r++)
            {
                for (int c = 0; c < m.getCols(); c++)
                {
                    calcualteDeterminant(getNotAligned(c, c));
                }
            }
        }        
    }
}