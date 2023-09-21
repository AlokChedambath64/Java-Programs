import java.util.*;
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        //if the tree is empty
        if (root == null){
            root = new Node(val);
            return root;
        }
        //if the root's data is greater than val; ie: it should go to the left of the node
        if (root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        } else {//visa vi
            //right subtree
            root.right = insert(root.right, val);
        }
        //returning root to
        return root;
    }
    public static void inorder(Node root){
        //if we have reached the last node
        if (root == null){
            return;
        }
        //traverse to the left node
        inorder(root.left);
        //print out the value of the current node
        System.out.print(root.data+" ");
        //traverse to the right node
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        //if the root is null then the key is not present in that direction
        if (root == null){
            return false;
        }
        //if the current node is the key then return true
        if (root.data == key){
            return true;
        }
        //deciding which direction in the tree to go to
        if (root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    public static Node delete(Node root, int val){
        if (root.data < val){
            root.right = delete(root.right, val);
        }else if (root.data > val){
            root.left = delete(root.left, val);
        }else{
            //case 1- leaf node
            if (root.left == null && root.right == null){
                return null;
            }
            //case 2- single child
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            //case 3 - both children
            Node IS = findInorderSucccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSucccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if (root == null){
            return;
        }
        if (root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if (root.data > k2){
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        //function to print the elements inside the arraylist
        for (int i = 0; i < path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        //base case that checks whether the current root is null
        if (root == null){
            return;
        }
        //adding the data in the root to the array list
        path.add(root.data);
        //to check if the root is the last node
        if(root.left == null && root.right == null){
            printPath(path);
        }
        //to traverse to the left child
        printRoot2Leaf(root.left, path);
        //to traverse to the right child
        printRoot2Leaf(root.right, path);
        //removing last node after the path has been printed
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        //if we go past the leaf node
        if (root == null){
            return true;
        }
        //if the nodes on the right of the tree fail the test
        if (min != null && root.data <= min.data){
            return false;
        }
        //if the nodes on the left of the tree fail the test
        else if (max != null && root.data >= max.data){
            return false;
        }
        //checks both the left side and right side of the binary tree
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args){
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }

        //inorder(root);
        //System.out.println();

        System.out.println(search(root, 11));

        root = delete(root, 10);

        inorder(root);
        System.out.println();
        printInRange(root, 5, 12);

        System.out.println();

        ArrayList<Integer> arr = new ArrayList<>();
        printRoot2Leaf(root, arr);
    }
}
