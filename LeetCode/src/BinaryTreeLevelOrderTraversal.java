import java.util.*;


public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {

            if(root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while(!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> current = new ArrayList<>();

                for(int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    current.add(currentNode.val);

                    TreeNode left = currentNode.left;
                    if(left != null) {
                        queue.offer(left);
                    }

                    TreeNode right = currentNode.right;
                    if(right != null) {
                        queue.offer(right);
                    }
                }
                result.add(current);
            }
            return result;
        }
    }

    public static void main(String args) {

    }
}
