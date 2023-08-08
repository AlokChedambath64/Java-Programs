import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args){
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        //Oth col => Org Index, 1st col => ratio
        for (int i = 0; i < val.length; i++){
            //storing the ratios makes it easier for us to call the weight values from the 1D array later on in line 24
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }
        //returns the 2D array sorted in ascending order w.r.t ratios(1st colum)
        Arrays.sort(ratio, Comparator.comparingDouble(o ->o[1]));

        int capacity = W;
        int finalval = 0;
        for (int i = ratio.length - 1; i >= 0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalval += val[idx];
                capacity -= weight[idx];
            }else{
                //include fractional item
                finalval += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println(finalval);
    }
}
