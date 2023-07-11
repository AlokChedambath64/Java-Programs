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

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2, 7);

        ll.print();
        ll.revremove(3);
        ll.print();
    }
}
