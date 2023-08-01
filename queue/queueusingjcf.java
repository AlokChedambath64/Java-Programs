import java.util.*;
import java.util.LinkedList;

public class queueusingjcf {

    public static void main(String[] args){
        
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.add(10);
        q1.add(20);
        q1.add(30);

        while(!q1.isEmpty()){
            System.out.println(q1.remove());
        }
    }
}
