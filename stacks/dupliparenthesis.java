import java.util.Stack;

public class dupliparenthesis {

    public static boolean isdupli(String str){
        int count = 0;
        //Creating a stack
        Stack<Character> s = new Stack<>();
        //A for loop to traverse through the array
        for (int i = 0; i < str.length(); i++){
            //closing
            if(str.charAt(i) == ')'){
                count = 0;
                while (s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true;//duplicate exists
                } else {
                    s.pop();
                }
            }else{
                s.push(str.charAt(i));
            }
        }
        return false;
    }
    public static void main(String[] args){
        String str1 = "((a+b))";
        String str2 = "((a+b)+(c+d))";

        System.out.println(isdupli(str1));
    }
}
