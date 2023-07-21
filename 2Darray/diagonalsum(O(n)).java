public class diagsum {
    public static int diagonalsum(int matrix[][]){
        int total = 0;
        for(int i = 0; i < matrix.length; i++){
            total += matrix[i][i];
            if(i != matrix.length - i - 1)
            total += matrix[i][matrix.length - i - 1];

        }
        return total;
    }
    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3, 4,},{5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(diagonalsum(matrix));
    }
}
