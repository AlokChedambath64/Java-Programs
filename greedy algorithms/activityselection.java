import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class ActivitySelection {
    public static void main(String[] args){
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> arrList = new ArrayList<>();

        maxAct++;
        arrList.add(activities[0][0]);
        int endtime = end[0];

        for (int i = 1; i < end.length; i++){
            if (activities[i][1] >= endtime){
                arrList.add(i);
                maxAct++;
                endtime = end[i];
            }
        }

        for (int i = 0; i < maxAct; i++){
            System.out.println("A" + arrList.get(i));
        }
    }
}
