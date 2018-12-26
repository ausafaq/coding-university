package binarySearchTree;

public class BinaryTree {
    private TreeNode root;

    public boolean isEmpty() {
        return root == null;
    }

    //Insert node
    public void insert(int data) {
        root = insertHelper(root, data);
    }

    //Insert Node Helper
    private TreeNode insertHelper(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
        } else if (data <= node.getValue()) {
            node.setLeft(insertHelper(node.getLeft(), data));
        } else {
            node.setRight(insertHelper(node.getRight(), data));
        }

        return node;
    }

    //Inorder Traversal
    public void inorderTraversal() {
        inorderTraversalHelper(root);
    }

    private void inorderTraversalHelper(TreeNode node) {
        if (node != null) {
            inorderTraversalHelper(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorderTraversalHelper(node.getRight());
        }
    }

    //PreOrder Traversal
    public void preOrderTraversal() {
        preOrderTraversalHelper(root);
    }

    //PreOrderTraversal Helper
    private void preOrderTraversalHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderTraversalHelper(node.getLeft());
            preOrderTraversalHelper(node.getRight());
        }
    }

    //PostOrder Traversal
    public void postOrderTraversal() {
        postOrderTraversalHelper(root);
    }

    //PostOrderTraversal Helper
    private void postOrderTraversalHelper(TreeNode node) {
        if (node != null) {
            postOrderTraversalHelper(node.getLeft());
            postOrderTraversalHelper(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    //MaxDepth or Height of a tree
    public int maxDepth() {
        return maxDepthHelper(root);
    }
    //Height helper
    private int maxDepthHelper(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            int leftDepth = maxDepthHelper(node.getLeft());
            int rightDepth = maxDepthHelper(node.getRight());
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }



}
