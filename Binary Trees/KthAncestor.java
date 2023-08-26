import java.util.LinkedList;
import java.util.*;

public class topview {
    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
   public static int KthAncestor(Node root, int n, int k){
        //to check if the current node if null ie node does not exist
        if (root == null){
            return -1;
        }
        //if the current root is the target root
        if(root.data == n){
            return 0;
        }
        //traverse through the left half and right half of the tree
        int left = KthAncestor(root, n, k);
        int right = KthAncestor(root, n, k);
        //if both left and right are null then the target node does not exist in the that side
        if (left == -1 && right == -1){
            return -1;
        }
        //length of the current node from the target node, if current node is an ancestor
        int max = Math.max(left, right);
        //if condition to check if the distance equals k
        if (max + 1 == k){
            System.out.println(root.data);
        }
       //if the target node exists the current value is distance is increased by 1
        return max + 1;
   }




   public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
}
