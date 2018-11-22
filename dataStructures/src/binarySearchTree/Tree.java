package binarySearchTree;

public class Tree {
    private TreeNode root;

    // Insert
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    // Get a node
    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    // Get min value
    public int min(){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        else{
            return root.min();
        }
    }

    // Get max value
    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        else{
            return root.max();
        }
    }


    // InOrder traversal
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    // PreOrder Traversal
    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    // PostOrder Traversal
    public void traverserPostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }
}
