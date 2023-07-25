import java.util.Stack;

public class nextgreater {
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {6, 8, 0, 1, 3};
        int nextgreater[] = new int[arr.length];
        Stack <Integer> s = new Stack<>();

        //backwards traversing for loop
        for (int i = arr.length - 1; i >= 0; i--){
            //while loop that deals with the stack
            while (!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            //case where stack is empty
            if (s.isEmpty()){
                nextgreater[i] = -1;
            } else {
            //if not
                nextgreater[i] = s.peek();
            }
            //adding element to stack
            s.push(arr[i]);
        }

        printArr(nextgreater);
    }
}
