package binaryTree;

public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    private Node insertHelper(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }

        if(node.right == null) {
            node.right = insertHelper(node.right, data);
        } else {
            node.left = insertHelper(node.left, data);
        }
        return node;
    }

    public int countNodes() {
        return countHelper(root);
    }

    private int countHelper(Node node) {
        if(node == null) {
            return 0;
        }

        int count = 1;
        count += countHelper(node.left);
        count += countHelper(node.right);

        return count;
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node node, int data) {
        if(node == null) {
            return false;
        }

        if(node.value == data) {
            return true;
        }

        if(node.left != null) {
            if(searchHelper(node.left, data)) {
                return true;
            }
        }

        if(node.right != null) {
            if(searchHelper(node.right, data)) {
                return true;
            }
        }
        return false;
    }

    // Maximum Depth
    public int MaxDepth(Node root) {
        return maxDepthHelper(root);
    }

    // Maximum Depth Helper
    private int maxDepthHelper(Node node) {
        if(node == null) {
            return 0;
        }
        int leftDepth = maxDepthHelper(node.left);
        int rightDepth = maxDepthHelper(node.right);
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;
        return maxDepth;
    }

}
