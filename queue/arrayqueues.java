public class arrayqueues {
    public static class queue{
        static int arr[];
        static int rear;
        static int size;

        queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            //if the Queue still has its rear at -1, the index we assigned to it, then the queue is empty
            return rear == -1;
        }

        public static void add(int data){
            if (rear == size - 1){
                System.out.println("The Queue is Full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public static int remove(){
            if (isEmpty()){
                System.out.println("The array is already empty");
            }
            //retrieving the value of the first element in the array
            int front = arr[0];
            //for loop that brings forward the values of the array
            for (int i = 0; i < arr.length - 1; i++){
                arr[i] = arr[i + 1];
            }
            //Updating the value of rear
            rear = rear - 1;

            return front;
        }
        public static int peek(){
            if (isEmpty()){
                System.out.println("The Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args){
        queue q = new queue(5);

        q.add(2);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
