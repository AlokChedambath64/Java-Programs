import java.util.ArrayList;
public class maxwater {
    public static int area(ArrayList <Integer> height){
        int maxwater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp){
            int ht = Math.min(height.get(lp),height.get(rp));
            int wi = rp - lp;
            maxwater = Math.max(ht*wi, maxwater);

            if (height.get(lp) > height.get(rp)){
                rp--;
            }else {
                lp++;
            }
        }
        return maxwater;
    }
    public static void main (String args[]){
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(area(height));
    }
}
