import java.util.*;
public class Stacks {
    public static StringBuilder reversestring(String str){
        Stack <Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()){
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder revstr = new StringBuilder();
        while (!s.isEmpty()){
            revstr.append(s.pop());
        }
        return revstr;
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
      
        System.out.println(reversestring(""));
    }
}
