public class BinarySearchTree {

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

    public boolean isEmpty() {
        return root == null;
    }

    // Insert value to the BST
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private TreeNode insertHelper(TreeNode node, int value) {
        if(node == null) {
            return new TreeNode(value);
        }

        if(value <= node.value) {
            node.left = insertHelper(node.left, value);
        } else {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    // Inorder traversal
    public void inorder() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode node) {
        if(node != null) {
            inorderHelper(node.left);
            System.out.print(node.value + ", ");
            inorderHelper(node.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode node) {
        if(node != null) {
            System.out.print(node.value + ", ");
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }

    // Postorder Traversal
    public void postorder() {
        preorderHelper(root);
    }

    private void postorderHelper(TreeNode node) {
        if(node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(node.value + ", ");
        }
    }


    // Delete a node from the BST
    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private TreeNode deleteHelper(TreeNode node, int value) {
        TreeNode parent = null;
        TreeNode curr = node;

        while(curr != null && curr.value != value) {
            parent  = curr;
            if(value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // return if value is not found in the tree
        if(curr == null) {
            return node;
        }

        // Case 1: Node to be deleted is a leaf node
        if(curr.left == null && curr.right == null) {
            if(curr != node) {
                if(parent.left == curr) {
                    parent.left = null;
                } else if(parent.right == curr) {
                    parent.right = null;
                }
            } else {
                root = null;
            }
        }
        // Case 2: Node to be deleted has two children
        else if(curr.left != null && curr.right != null) {
            TreeNode successor = minimumValue(curr.right);
            int val = successor.value;
            deleteHelper(root, successor.value);
            curr.value = val;
        }
        // Case 3: Node to be deleted has only one child
        else {
            TreeNode child = (curr.left != null) ? curr.left : curr.right;
            if(curr != root) {
                if(curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child;
            }
        }
        return node;
    }

    private TreeNode minimumValue(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Max-depth/Height of BST
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

}
