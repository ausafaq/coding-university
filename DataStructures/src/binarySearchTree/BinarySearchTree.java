package binarySearchTree;

public class BinarySearchTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public boolean isEmpty() {
        return root == null;
    }

    // Insert a value to the BST.
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private TreeNode insertHelper(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
        } else if (value <= node.value) {
            node.left = insertHelper(node.left, value);
        } else {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    // Max Depth or Height of the tree.
    public int maxDepth() {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepthHelper(node.left);
        int rightDepth = maxDepthHelper(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Preorder traversal of the tree.
    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + ", ");
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }

    // Inorder traversal of the tree.
    public void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(node.value + ", ");
            inorderHelper(node.right);
        }
    }

    // Postorder traversal of the tree.
    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(TreeNode node) {
        if (node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(node.value + ", ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.insert(4);
        myTree.insert(2);
        myTree.insert(5);
        myTree.insert(1);
        myTree.insert(3);

        System.out.println("Height of the tree: " + myTree.maxDepth());

        myTree.preorderTraversal();
        System.out.println();
        myTree.inorderTraversal();
        System.out.println();
        myTree.postorderTraversal();
    }
}
