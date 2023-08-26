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

    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
  
   public static Node lowestcommon2(Node root, int n1, int n2){
        //to check if the current node is null, meaning the node is in the last level of the tree
        if (root == null){
            return null;
        }
        //if the root's data is equal to either of the nodes return thr root
        if (root.data == n1 || root.data == n2){
            return root;
        }
        //traversing through the right and left nodes
        Node leftlca = lowestcommon2(root.left, n1, n2);
        Node rightlca = lowestcommon2(root.right, n1, n2);

        //is the right lca is null meaning the node exists in the left side
        if (rightlca == null){
            return leftlca;
        }
        //same reason in reverse
        if (leftlca == null){
            return rightlca;
        }
        //if both sides returned true, then the current root is the lowest common ancestor
        return root;
   }

   public static int lcaDist(Node root, int n){
        //if the current root is the last level, return false
        if (root == null){
            return -1;
        }
        //if the current node is the target node, then return true
        if (root.data == n){
            return 0;
        }
        //check towards the left of the current node
        int left = lcaDist(root.left, n);
        //after the left of the current node has been checked, check the right
        int right = lcaDist(root.right, n);
        //if both return false, return false as well
        if (left == -1 && right == -1){
            return -1;
        } else if (left == -1){//if left was false and right was true return right + 1
            return right + 1;
        } else {//visa vi
            return left + 1;
        }
   }

   public static int mindistance(Node root, int n1, int n2){
        //We need to calculate the distance between the two target nodes and their lowest common ancestor.
        //Calculating the lca first
        Node lca = lowestcommon2(root, n1, n2);
        //figuring out the distance between both the nodes and their root node
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        //adding up both distances and returning the value
        return dist1 + dist2;
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
