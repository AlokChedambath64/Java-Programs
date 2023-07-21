import java.util.*;

public class patterns {
    public static void butterfly(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < 2*(n-i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        for (int i = n; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print("#");
            }
            for (int j = 0; j < 2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        butterfly(n);
    }
}
