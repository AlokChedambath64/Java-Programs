import java.util.Stack;

public class stackstrappingrainwater {
    public static int totalwater(int arr[]){
        //declaring the needed variables
        int total = 0, trappedwater, waterlevel;
        //declaring the needed aux arrays of right max and left max
        int leftmax[] = new int[arr.length];
        int rightmax[] = new int[arr.length];
        //creating a stack for optimization
        Stack <Integer> s = new Stack<>();
        //for loop that runs from left to right in the array to find out the left maxmimums in the array
        for (int i = 0; i < arr.length; i++){
            //while loop that pops the top of stack if current element is greater than it
            while (!s.isEmpty() && s.peek() < arr[i]){
                s.pop();
            }
            //if all elements have been popped, meaning the current element is the largest one
            if(s.isEmpty()){
                leftmax[i] = arr[i];
            }else{//if the element at the top of the stack is larger
                leftmax[i] = leftmax[i - 1];
            }
            //adding the current element to the stack
            s.push(arr[i]);
        }
        //resetting the previously made stack
        s = new Stack<>();
        
        //for loop that runs through the array from right to left to create the right max array
        for (int j = arr.length - 1; j >= 0; j--){
            //while loop that checks if the element at the top of the stack is the larger than the current element
            while (!s.isEmpty() && s.peek() < arr[j]){
                s.pop();
            }
            //if all the elements in the stack has been popped, meaning the current array element is the largest one
            if(s.isEmpty()){
                rightmax[j] = arr[j];
            }else{//if the element at the top of the array is larger
                rightmax[j] = rightmax[j + 1];
            }
            //adding the current element to the stack
            s.push(arr[j]);
        }
        //for loop that runs through the entire array and finds the water level at each index
        for (int i = 0; i < arr.length - 1; i++){
            //checking which side has min water 
            waterlevel = Math.min(leftmax[i], rightmax[i]);
            //calculating water above each index
            trappedwater = (waterlevel - arr[i]);
            //adding to total
            total += trappedwater;
        }
        return total;
    }


    public static void main(String args[]){
        int arr[] = {4,2,0,3,2,5};

        System.out.println(totalwater(arr));
    }
}
