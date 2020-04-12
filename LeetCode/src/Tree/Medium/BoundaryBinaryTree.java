package Tree.Medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryBinaryTree {

    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */

    public boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    public void addLeaves(List<Integer> result, TreeNode node) {
        if(isLeaf(node)) {
            result.add(node.val);
        } else {
            if(node.left != null) {
                addLeaves(result, node.left);
            }
            if(node.right != null) {
                addLeaves(result, node.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        if(!isLeaf(root)) {
            result.add(root.val);
        }

        TreeNode temp = root.left;
        while(temp != null) {
            if(!isLeaf(temp)) {
                result.add(temp.val);
            }
            if(temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        addLeaves(result, root);

        Stack<Integer> stack = new Stack<>();
        temp = root.right;
        while(temp != null) {
            if(!isLeaf(temp)) {
                stack.add(temp.val);
            }
            if(temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
