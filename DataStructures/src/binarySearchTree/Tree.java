package binarySearchTree;

public class Tree {
    private TreeNode root;

    // Insert into tree
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private TreeNode insertHelper(TreeNode node, int value) {
        TreeNode newNode = new TreeNode(value);
        if (node == null) {
            node = newNode;
        } else {
            if (value <= node.getData()) {
                node.setLeftChild(insertHelper(node.getLeftChild(), value));
            } else {
                node.setRightChild(insertHelper(node.getRightChild(), value));
            }
        }
        return node;
    }

    // InOrder traversal
    public void traverseInOrder() {

        traverseInOrderHelper(root);
    }

    private void traverseInOrderHelper(TreeNode root) {
        if (root == null)
            System.out.println("traverseInOrderHelper(null)");
        else
            System.out.println("traverseInOrderHelper(" + root.getData() + ")");
        if (root == null) {
            return;
        }
        traverseInOrderHelper(root.getLeftChild());
        System.out.print(root.getData() + ", ");
        traverseInOrderHelper(root.getRightChild());
    }

    // PreOrder Traversal
    public void traversePreOrder() {
        traversePreOrderHelper(root);
    }

    private void traversePreOrderHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + ", ");
        traversePreOrderHelper(root.getLeftChild());
        traversePreOrderHelper(root.getRightChild());
    }

    // PostOrder Traversal
    public void traversePostOrder() {
        traversePostOrderHelper(root);
    }

    private void traversePostOrderHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        traversePostOrderHelper(root.getLeftChild());
        traversePostOrderHelper(root.getRightChild());
        System.out.print(root.getData() + ", ");
    }

    // Size of the tree
    public int size() {
        int size = sizeHelper(root);
        return size;
    }

    public int sizeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int size = 1 + sizeHelper(root.getLeftChild()) + sizeHelper(root.getRightChild());
            return size;
        }
    }

    // Max Depth of the tree
    public int maxDepth() {
        int maxDepth = maxDepthHelper(root);
        return maxDepth;

    }

    private int maxDepthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepthHelper(root.getLeftChild());
            int rightDepth = maxDepthHelper(root.getRightChild());
            return (Math.max(leftDepth, rightDepth)) + 1;
        }
    }

    // Minimum value in the tree
    public int minimumValue(){
        return minimumValueHelper(root);
    }

    private int minimumValueHelper(TreeNode root){
        if(root.getLeftChild() == null){
            return root.getData();
        }
        else{
            return minimumValueHelper(root.getLeftChild());
        }
    }

    // Maximum value in the tree
    public int maximumValue(){
        return maximumValueHelper(root);
    }

    private int maximumValueHelper(TreeNode root){
        if(root.getRightChild() == null){
            return root.getData();
        }
        else {
            return maximumValueHelper(root.getRightChild());
        }
    }

    /* returns true if there is a path from the root down to
        a leaf, such that adding up all the values along the
        path equals the given sum */
    public boolean hasPathSum(int sum){
        return hasPathSumHelper(root, sum);
    }

    private boolean hasPathSumHelper(TreeNode root, int sum){
        if(root == null){
            return (sum == 0);
        }
        else {
            int buffer = sum - root.getData();
            boolean b = hasPathSumHelper(root.getLeftChild(), buffer) || hasPathSumHelper(root.getRightChild(), buffer);
            return b;
        }
    }


}
