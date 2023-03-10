import java.util.*;
public class areaofsquare {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt();
        if (num>0)
        {
            System.out.print("The number is positive");
        }
        else if (num == 0)
        {
            System.out.print("The number is neither positve or negative");
        }
        else
        {
            System.out.print("The number is negative");
        }

    }
}
