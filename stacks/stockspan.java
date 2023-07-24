import java.util.Stack;

public class stockspan {

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void StockSpan(int stocks[], int span[]){
        //declaring a new stack, as to find out the prev highs index with efficiency
        Stack <Integer> s = new Stack<>();
        //Initializing the first stack
        s.push(0);
        //The first value of span will always be 1 so,
        span[0] = 1;
        //for loop that runs through the all the stock values
        for (int i = 1; i < span.length; i++){
            //Getting the value of stock at the index(i)
            int currprice = stocks[i];
            //while loop that runs till either the stack is empty or till a greater element has been found
            while (!s.isEmpty() && currprice > stocks[s.peek()]){
                s.pop();
            }
            //if all the elements of the stack has been popped
            if (s.isEmpty()){
                span[i] = i;
            } else{
                span[i] = i - s.peek();
            }
            //push the value of the current index into the stack
            s.push(i);
        }
    }
    public static void main(String args[]){
        int stocks[] = {100, 80, 60, 10, 60, 85, 90};
        int span[] = new int [stocks.length];
        StockSpan(stocks, span);

        printArr(span);
    }

}
