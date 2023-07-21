public class patterns {
    
    public static void rhombus(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - i - 1; j++){
                System.out.print(".");
            }
            for (int j = 0; j < n; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void hollowrhombus(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - i - 1; j++){
                System.out.print(".");
            }
            for (int j = 0; j <= n; j++){
                if (i == 0 || j == n || i == n-1 || j == 0 )
                    System.out.print("#");
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        rhombus(4);
        hollowrhombus(4);
    }
}
