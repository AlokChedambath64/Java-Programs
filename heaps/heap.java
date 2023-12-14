import java.util.ArrayList;

public class heap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){//O(log(n))
            //add at last index;
            arr.add(data);

            int x = arr.size() - 1;//child index
            int par = (arr.size() - 2) / 2;//parent index

            while (arr.get(x) < arr.get(par)){//O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x - 1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public int remove(){
            int data = arr.get(0);

            //1. Swap First and Last Node
            int temp = arr.get(0);
            //arr[0] = last index value
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            //2. Delete Last Element
            arr.remove(arr.size() - 1);

            //3. Heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        private void heapify(int i){
            //to get the index values of the left, right children and the parent node
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            //to store the value of the left index in the minIdx location if left is not greater than the total size of the array and the value at that index is greater than the left child
            if ( left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            //visa vi for the right child. The first condition goes false when the parent is a root node.
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            //if there needs to some element that needs to be swapped
            if (minIdx != i){
                // swap those elements
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                //call heapify to fix any new issues that may have come, passing on the changed index
                heapify(minIdx);
            }
        }
    }

    public static void main(String[] args){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(5);

        while (!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }

    }
}
