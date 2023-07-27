import java.util.Stack;

public class maxareainhistogram {

    public static int leftsmaller(int arr[], int n){
        //stack to store the values of the array indexes
        Stack <Integer> s = new Stack<>();
        //array to store the next smaller left at each index
        int nextsmallerleft[] = new int[arr.length];
        //for loop that traverses through the entire array
        for (int i = 0; i < arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nextsmallerleft[i] = -1;
            }else{
                nextsmallerleft[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return nextsmallerleft[n];
    }

    public static int rightsmaller(int arr[],int n){
        Stack<Integer> s = new Stack<>();

        int nextsmallerright[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nextsmallerright[i] = arr.length;
            }else{
                nextsmallerright[i] = s.peek();
            }
            s.push(i);
        }
        return nextsmallerright[n];
    }
    public static int maxarea(int arr[]){
        int areaatindex, largest = 0, height, width;

        for (int i = 0; i < arr.length; i++){
            height = arr[i];
            width = rightsmaller(arr, i) - leftsmaller(arr, i) - 1;

            areaatindex = height * width;
            if (areaatindex > largest){
                largest = areaatindex;
            }
        }
        return largest;
    }
    public static void main(String args[]){
        int arr[] = {2, 1, 5, 6, 2, 3};
        System.out.println(maxarea(arr));
    }
}
