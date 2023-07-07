public class nqueens {
    public static boolean isSafe(char board[][], int row, int col){
        //vertical
        for (int i = row - 1; i >= 0; i--){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //left horizontal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i-- , j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        //right horizontal
        for (int i = row - 1, j = col + 1; i > 0 && j < board.length; i--, j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void print(char board[][]){
        System.out.println("---------------------------");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void nQueens(char board[][], int row){
        if (row == board.length){
            print(board);
            return;
        }
        //rows
        for (int j = 0; j < board.length; j++){
            if (isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static void main(String args[]){
        int n = 8;
        char board[][] = new char[n][n];
        //initialization
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ;j++){
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
    }
}
