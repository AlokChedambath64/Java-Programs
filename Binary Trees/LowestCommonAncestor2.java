import java.util.LinkedList;
import java.util.*;

public class LowestCommonAncestor2 {
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
   public static Node lowestcommon2(Node root, int n1, int n2){
        if (root == null){
            return root;
        }
        if (root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lowestcommon2(root.left, n1, n2);
        Node rightlca = lowestcommon2(root.right, n1, n2);

        if (rightlca == null){
            return leftlca;
        }

        if (leftlca == null){
            return rightlca;
        }

        return root;
   }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lowestcommon2(root, 2, 7).data);

    }
}
