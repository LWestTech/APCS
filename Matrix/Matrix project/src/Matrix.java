public class Matrix {
    private int[][] arr;
    private int determinant;

    public Matrix(int rows, int cols) {this.arr = new int[rows][cols];}
    public Matrix(int[][] arr) {this.arr = arr;}

    public String toString() {
        String str = new String();
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                str += arr[r][c] + " ";
            }
            if (r+1 != arr.length) {
                str += "\n";
            }
        }
        return str;
    }


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

    public int getDeterminant()
    {
        if (arr.length == arr[0].length)
        {
            return calculateDeterminant(new Matrix(arr));
        }
        throw new RuntimeException("Can\'t calculate determinant of a non-square 2d array");
    }

    public int calculateDeterminant(Matrix mtr)
    {
        if (mtr.getCols() == 2 && mtr.getRows() == 2)
        {
            
            return mtr.get(0,0) * mtr.get(1,1) - mtr.get(1,0) * mtr.get(0,1);
        }
        else
        {
            System.out.println("Calculating determinant of");
            System.out.println(mtr);
            System.out.println("------");
            int determinant = 0;
            boolean minus = false;
            int[] minors = new int[mtr.getCols()];
            for (int c = 0; c < mtr.getCols(); c++)
            {
                Matrix subMtr = new Matrix(mtr.getNotAligned(c));
                int subDet = calculateDeterminant(subMtr);
                int scalar = mtr.get(0, c) * subDet;
                System.out.println("- Submatrix of id-" + c + " (" + mtr.get(0,c) + "):");
                System.out.println(subMtr);
                System.out.println("- Determinant: " + subDet);
                System.out.println("- Scalar: (" + mtr.get(0, c) + " x " + subDet + ") = " + scalar);
                System.out.println("- Sign: " + ((minus)? "plus" : "minus"));
                System.out.println();
                minors[c] = scalar;
            }

            for (int i : minors) {
                determinant += (minus)? -1 * i : i;
                System.out.println("Det" + ((minus)? " - " : " + ") + i + " = " + determinant);
                minus = !minus;
            }
            System.out.println();
            System.out.println("Determinant: " + determinant);
            System.out.println("------");
            return determinant;
        }     
    }
}