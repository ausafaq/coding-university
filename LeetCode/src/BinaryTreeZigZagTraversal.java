import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        boolean flag = true;
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            TreeNode currNode = queue.pollFirst();
            if(currNode != null) {
                if(flag) {
                    levelList.addLast(currNode.val);
                } else {
                    levelList.addFirst(currNode.val);
                }

                if(currNode.left != null) {
                    queue.addLast(currNode.left);
                }
                if(currNode.right != null) {
                    queue.addLast(currNode.right);
                }
            } else {
                result.add(levelList);
                levelList = new LinkedList<Integer>();
                if(!queue.isEmpty()) {
                    queue.addLast(null);
                }
                flag = !flag;
            }
        }
        return result;
    }

}
