import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class queuepset {
    public static void reversek(Queue<Integer> q,int k){
        Stack <Integer> s = new Stack<>();

        for (int i = 0 ;i < k; i++) {
            s.push(q.remove());
        }

        for (int i = 0;i < k; i++){
            q.add(s.pop());
        }

        for (int i = 0; i < k ; i++){
            q.add(q.remove());
        }
    }
}
