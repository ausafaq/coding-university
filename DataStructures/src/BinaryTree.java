public class BinaryTree {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private TreeNode insertHelper(TreeNode node, int value) {
        if(node == null) {
            return new TreeNode(value);
        }

        if(node.right == null) {
            node.right = insertHelper(node.right, value);
        } else {
            node.left = insertHelper(node.left, value);
        }
        return node;
    }

    public int countNodes() {
        return countHelper(root);
    }

    private int countHelper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int count = 1;
        count += countHelper(node.left);
        count += countHelper(node.right);
        return count;
    }

    public boolean search(int value) {
        return searchHelper(root, value);
    }

    private boolean searchHelper(TreeNode node, int value) {
        if(node == null) {
            return false;
        }

        if(node.value == value) {
            return true;
        }

        if(node.left != null) {
            return searchHelper(node.left, value);
        }

        if(node.right != null) {
            return searchHelper(node.right, value);
        }

        return false;
    }

    public int maxDepth() {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = maxDepthHelper(node.left);
        int right = maxDepthHelper(node.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

    }
}
