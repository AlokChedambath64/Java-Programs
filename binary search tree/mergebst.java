import java.util.ArrayList;

public class mergebst {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void populatelist(ArrayList<Integer> arr, Node root){
        if (root == null){
            return;
        }

        populatelist(arr, root.left);
        arr.add(root.data);
        populatelist(arr, root.right);

    }

    public static Node createBST(ArrayList<Integer> arr, int st, int end){
        if (st > end){
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }
    public static Node merge(Node root1, Node root2){
        //to track the elements of the first BST
        ArrayList<Integer> arr1 = new ArrayList<>();
        //to track the elements of the second BST
        ArrayList<Integer> arr2 = new ArrayList<>();
        //to combine both the BSTs
        ArrayList<Integer> arr3 = new ArrayList<>();

        //to populate the array lists
        populatelist(arr1, root1);
        populatelist(arr2, root2);

        //to populate the third array list
        int i = 0;
        int j = 0;

        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) >= arr2.get(j)){
                arr3.add(arr2.get(j));
                j++;
            }else {
                arr3.add(arr1.get(i));
                i++;
            }
        }

        while(i < arr1.size()){
            arr3.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()){
            arr3.add(arr2.get(j));
            j++;
        }

        return createBST(arr3, 0, arr3.size() - 1);
    }

    public static void inorder(Node root){
        if (root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void main(String[] args){
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.right = new Node(12);
        root2.left = new Node(3);

        inorder(merge(root1,root2));
    }
}
