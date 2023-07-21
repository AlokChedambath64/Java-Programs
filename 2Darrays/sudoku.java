public class soduko {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //row
        for (int i = 0; i < 9; i++){
            if (sudoku[row][i] == digit){
                return false;
            }
        }
        //column
        for (int i = 0; i < 9; i++){
            if (sudoku[i][col] == digit){
                return false;
            }
        }
        //3x3
        int startrow = (row / 3) * 3;
        int startcol = (col / 3) * 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (sudoku[startrow + i][startcol + j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokusolver(int sudoku[][], int row, int col){
        //base case
        if (row == 9 && col == 0) {
            return true;
        }
        //recursion
        int NewRow = row, NewCol = col + 1;
        if (NewCol == 9){
            NewRow++;
            NewCol = 0;
        }
        if (sudoku[row][col] != 0){
            return sudokusolver(sudoku, NewRow, NewCol );
        }
        for (int digit = 1; digit <= 9; digit++){
            if (isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if (sudokusolver(sudoku, row, col)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void print(int soduko[][]){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(soduko[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int sodoku[][] = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (sudokusolver(sodoku, 0, 0)){
            System.out.println("Solution Exists");
            print(sodoku);
        }else{
            System.out.println("Does Not Exist");
        }
    }
}
