import java.util.LinkedList;
import java.util.*;

public class LowestCommonAncestor1 {
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

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        //base function for recursion
        if (root == null){
            return false;
        }

        //adding the node to the array list
        path.add(root);

        //returning true if the target node is the current node in the traversal
        if (root.data == n){
            return true;
        }
        //to check the child node of the current node and the ones below by recursion
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        //to check if the node exists in one of the paths
        if (foundRight || foundLeft){
            return true;
        }

        //if nones of the return trues were triggered meaning the target node is not present in the path, then removing the last added element to the arraylist
        path.remove(path.size() - 1);

        return false;
    }
    public static Node Lowest_Common(Node root, int n1, int n2){
        //decalring the array lists that will store the nodes that in the path of the target node
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        //get path function will traverse through the binary tree and fill the array list the path node values
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //declaring I so that it can be used outside the for loop
        int i;
        for (i = 0; i < path1.size() && i < path2.size();i++){
            if (path1.get(i) != path2.get(i)){
                break;
            }
        }

        //last equal -> i - 1, because the loop breaks after inequality has been achieved
        Node lca = path1.get(i - 1);
        return lca;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(Lowest_Common(root, 2, 7).data);

    }
}
