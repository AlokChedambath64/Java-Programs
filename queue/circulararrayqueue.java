public class arrayqueues {
    public static class queue{
        static int arr[];
        static int rear;
        static int size;
        static int front;
        queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            //if the Queue still has its rear at -1, the index we assigned to it, then the queue is empty
            return rear == -1;
        }

        public static boolean Full(){
            return (rear + 1) % size == front;
        }
        public static void add(int data){
            if (Full()){
                System.out.println("The Queue is Full");
                return;
            }
            //case in which we are adding the first element
            if (front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove(){
            if (isEmpty()){
                System.out.println("The array is already empty");
            }

            //if the first element is getting added
            if (front == -1){
                front++;
            }
            int result = arr[front];
            //if the last element in the queue is getting deleted
            if (rear == front){
                //meaning the array is now empty
                rear = front = -1;
            }else {
                //Updating the value of front
                front = (front + 1) % size;
            }
            return result;
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
