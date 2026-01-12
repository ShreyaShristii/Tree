public class TreeOperations {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildBST(int[] arr) {
        Node root = null;
        for (int x : arr) {
            root = insert(root, x);
        }
        return root;
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }
    static int countNodes(Node root){
        if(root==null)return 0;
        return countNodes(root.right)+ countNodes(root.left)+1;
    }
    static int leafNodes(Node root){
        if(root==null)return 0;
        if(root.left==null&& root.right==null){
            return 1;
        }
        else{
        return leafNodes(root.left)+leafNodes(root.right);}
        
    }
    static int height(Node root){
        if(root==null)return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
 
    public static void main(String[] args) {
        int[] values = {10, 5, 15, 3, 7, 12, 18, 1, 4,5,23,2,5};
        int[] a={1,2,3,4,5,6};
        Node root = buildBST(values);
        System.out.println("BST created successfully!");
        System.out.println("Total number of nodes in the tree are: "+countNodes(root));
        System.out.println("Number of leaf Nodes in the tree are: "+leafNodes(root));
        System.out.println("The height of the tree is :"+height(root));
        
    }
}
