public class Matrix
{
    private int[][] arr;

    /**
     * Constructs a matrix
     * @param rows number of rows
     * @param cols number of columns
     */
    public Matrix(int rows, int cols) {this.arr = new int[rows][cols];}

    /**
     * Constructs a matrix from a 2d array
     * @param arr 2d array
     */
    public Matrix(int[][] arr) {this.arr = arr;}

    /**
     * The matrix as a string
     * @return string representing this matrix
     */
    public String toString()
    {
        String str = new String();
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[0].length; c++) 
            {
                str += arr[r][c] + " ";
            }
            if (r+1 != arr.length)
            {
                str += "\n";
            }
        }
        return str;
    }

    /**
     * Checks to see if the contents of this and another matrix are identical
     * @param mtr matrix to compair with
     * @return if the two matrices match
     */
    public boolean equals(Matrix mtr)
    {
        if (mtr.getCols() == getCols() && mtr.getRows() == getRows())
        {
            boolean inequalityFound = false;
            for (int r = 0; r < getRows(); r++)
            {
                for (int c = 0; c < getCols(); c++)
                {
                    if (get(r, c) != mtr.get(r, c))
                    {
                        inequalityFound = true;
                    }
                }
            }
            return !inequalityFound;
        }
        return false;
    }

    /**
     * Sets the value of any given cell in the matrix
     * @param row cell's row index
     * @param col cell's column index
     * @param content new integer to be placed in the specified cell
     */
    public void set(int row, int col, int content) {arr[row][col] = content;}
    
    /**
     * Sets the entire matrix to contain a different set of data
     * @param arr two-dimensional int array
     */
    public void set(int[][] arr) {this.arr = arr;}

    /**
     * Gets the content of a specific cell
     * @param row cell's row index
     * @param col cell's column index
     */
    public int get(int row, int col) {return arr[row][col];}

    /**
     * Gets the 2d array that holds the data of the matrix
     * @return two-dimensional int array
     */
    public int[][] get() {return arr;}

    /**
     * Gets an int array containing all values in a specific row
     * @param row index of the row whose values are wanted
     * @return int array of values
     */
    public int[] getRow(int row) {return arr[row];}

    /**
     * Gets an int array containing all values in a specific column
     * @param col index of the column whose values are wanted
     * @return int array of values
     */
    public int[] getCol(int col)
    {
        int[] colArr = new int[arr[0].length];

        for (int row = 0; row < arr.length; row++) {colArr[row] = arr[row][col];}

        return colArr;
    }
    
    /**
     * Gets the total number of rows in the matrix
     * @return number of rows
     */
    public int getRows() {return arr.length;}

    /**
     * Gets the total number of columns in the matrix
     * @return number of columns
     */
    public int getCols() {return arr[0].length;}

    /**
     * Gets a 2d int array containing values from every cell in the matrix except
     * those in the first row and those that are in the specified column
     * @param col the horizontal index of the column to be excluded
     * @return two-dimensional array of integers
     */
    public int[][] getNotAligned(int col)
    {
        // System.out.println("getNotAligned(col[" + col + "] == " + arr[0][col] + ")\n{");
        int[][] output = new int[(arr.length - 1)][(arr[0].length - 1)];

        
        int y = 0;
        for (int r = 1; r < this.getRows(); r++)
        {
            int x = 0;
            for (int c = 0; c < this.getCols(); c++)
            {
                if (c != col)
                {
                    // System.out.println(" (c == " + c + ") {" + "  set output[" + y + "][" + x + "] to " + get(r, c) + "};");
                    output[y][x] = get(r, c);
                    x++;
                }
            }
            y++;
        }
        // System.out.println("} returns:");
        // System.out.println(new Matrix(output));
        return output;
    }
}