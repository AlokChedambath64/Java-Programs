import java.util.*;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args){
        Integer denominations[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int count = 0;
        int change = 2591;

        Arrays.sort(denominations, Comparator.reverseOrder());

        //ArrayList <Integer> arrlist = new ArrayList<>();

        for (int i = 0; i < denominations.length; i++){
            if (change >= denominations[i]){
                int currcount = 0;
                while (change >= denominations[i]){
                    count++;
                    change -= denominations[i];
                }
            }
        }

        System.out.println("Denominations Required : " + count);
    }
}
