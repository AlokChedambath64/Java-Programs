import java.util.LinkedList;
import java.util.*;

public class SumTreeTranformation {
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

   public static int sumtree(Node root){
        //base case
        if (root == null){
            return 0;
        }
        //calculating the node value of the left side and right side
        int left = sumtree(root.left);
        int right = sumtree(root.right);

        //calculating the total value at the root so that it can be returned upwards
        int total = root.data + right + left;
        //updating the value of the current node
        root.data = right + left;
        //returning the value of the current node
        return total;
   }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

   public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        sumtree(root);
        preorder(root);
    }
}
