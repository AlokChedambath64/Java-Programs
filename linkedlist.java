public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    static int size;

    //this function need not be static because we are not directly calling this function from the static main function, we are indirectly calling
    //from the new object that has gotten created.
    public void addFirst(int data){
        //create new node
        Node newNode = new Node (data);
        size++;
        //if there is only one node, head and tail are on the same node
        if (head == null){
            tail = head = newNode;
            return;
        }
        //Giving the value of the old head to the new first node
        newNode.next = head; // link

        //setting the value of node to the new first node
        head = newNode;
    }

    public void addLast(int data){
        //creating a node
        Node newNode = new Node(data);
        size++;
        if (head == null){
            tail = head = newNode;
        }
        tail.next = newNode;

        tail = newNode;
    }

    public void print(){
        if (head == null){
            System.out.println("The LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int idx, int data){
        if (idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1){
            //System.out.println(head);
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removefirst(){
        if (size == 0){
            System.out.println("The Linked List is empty");
            return Integer.MAX_VALUE;
        }else if(size == 1){
            tail = head = null;
            size = 0;
            return 1;
        }
        int val = head.data;
        head = head.next;
        size--;
        return 1;
    }
    void removelast(){
        if (size == 0){
            System.out.println("The Linked List is empty");
            return;
        }else if (size == 1){
            tail = head = null;
            return;
        }
        Node prev = head;
        int i = 0;
        while (i < size - 2){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return;
    }

    int linearsearch(int key){
        int i = 0;
        Node temp = head;
        while (temp != null){
            if (temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;

        }
        return -1;
    }
    int helper (Node head, int key){
        if (head == null){
            return -1;
        }
        if (head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if (helper(head.next, key) == -1) {
            return -1;
        }
        return idx + 1;
    }

    int recsearch(int key){

        return helper(head, key);
    }

    void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void revremove(int n){
        int i = 1;
        int itofind = size - n;
        Node prev = head;
        while (i < itofind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    Node midnode(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    boolean palindrome(){
        if (head == null || head.next == null){
            return true;
        }
        //find mid node
        Node midnode = midnode();
        //2nd half reverse
        Node prev = null;
        Node curr = midnode;
        Node next = midnode.next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        //Check if left half equals the right half
        while (right != null){
            if (right.data != left.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    boolean islooping(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    void removeloop() {
        Node slow = head;
        Node fast = head;
        boolean looping = false;
        while (fast != null || fast.next == null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                looping = true;
                break;
            }
        }
        if (!looping) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            prev = fast;
        }
        // Update the next field of the last node in the loop to null
        prev.next = null;
    }
    public Node merge(Node newLeft, Node newRight){
        //Initialize a new ll with a dummy head node (-1)
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (newLeft != null && newRight != null){
            if (newLeft.data <= newRight.data){
                temp.next = newLeft;
                //to move the newLeft LL to the next
                newLeft = newLeft.next;
                //to move to the next node of the temporary LL
                temp = temp.next;
            } else {
                temp.next = newRight;
                newRight = newRight.next;
                temp = temp.next;
            }
        }
        while (newLeft != null){
            temp.next = newLeft;
            //to move the newLeft LL to the next
            newLeft = newLeft.next;
            //to move to the next node of the temporary LL
            temp = temp.next;
        }
        while (newRight != null){
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }
    Node mergesort(Node head){
        //edge case
        if (head == null || head.next == null){
            return head;
        }
        //finding the mid-node
        Node mid = findmid();
        //seperating the ll into two halfs
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergesort(head);
        Node newRight = mergesort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }
    //function that finds the first node of the right half
    Node findmid(){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    //Function that returns the last node of the first half
    Node findmidlf(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    void zigzag(){
        //1. Finding the mid-point
        Node mid = findmidlf();
        //2. 2nd half reverse
        //Left half
        Node prev = null;
        Node curr = mid.next;
        Node next;
        mid.next = null;
        while ( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node RH = prev;
        Node LH = head;
        //3. Alternate Merging
        Node nextL, nextR;

        while (LH != null && RH != null){
            //zig zagging steps
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;
            //updating steps
            LH = nextL;
            RH = nextR;
        }

    }

    void delNafterM(int M, int N){
        Node temp = head;
        Node temp2;

        while (temp != null){
            for (int i = 0; i < M - 1; i++){
                if (temp == null){
                    return;
                }
                temp = temp.next;
            }
            if (temp == null){
                return;
            }
            temp2 = temp;
            for (int j = 0; j < N; j++){
                if (temp.next == null){
                    return;
                }
                temp = temp.next;
            }
            temp2.next = temp.next;
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
    }
}
