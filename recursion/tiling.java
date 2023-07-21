//This program figures out the number of ways tiles of dimension 2 x 1 can be placed on a floor of dimension 2 x n using recursion.
public class tiling {

    public static int Ways(int n){
        if (n == 0 || n == 1 || n == 2){
            return n;
        }
        int fnm1 = Ways(n - 1);
        int fnm2 = Ways(n - 2);

        return fnm1 + fnm2;
    }

    public static void main(String args[]){
        System.out.println(Ways(3));
    }
}
