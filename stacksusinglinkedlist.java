import java.util.ArrayList;
public class Stacks {
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head = null;
    static class Stack {
        public static boolean isEmpty() {
            return head == null;
        }

        //push
        public static void push(int data) {
            Node newNode = new Node(data);

            if (!isEmpty()) {
                newNode.next = head;
            }
            head = newNode;
        }

        //pop
        public static void pop() {
            if (isEmpty()) {
                System.out.println("The stack is already empty");
                return;
            }
            head = head.next;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
