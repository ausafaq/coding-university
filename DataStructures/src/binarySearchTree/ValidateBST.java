package binarySearchTree;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isBSTHelper(root, null, null);
    }

    private boolean isBSTHelper(TreeNode node, Integer min, Integer max) {
        if(node == null) {
            return true;
        }

        if(min != null && node.getValue() <= min) {
            return false;
        }

        if(max != null && node.getValue() >= max) {
            return false;
        }

        return isBSTHelper(node.getLeft(), min, node.getValue()) && isBSTHelper(node.getRight(), node.getValue(), max);
    }
}
