import java.util.*;
import java.util.LinkedList;
public class reversal {

    public static void queuereversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        int size = q.size();

        for(int i = 0 ;i < size; i++){
            s.add(q.remove());
        }
        for (int i = 0;i < size; i++){
            q.add(s.pop());
        }
    }
    public static void main(String[] args){
        Queue <Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        queuereversal(q);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
