import sun.reflect.generics.tree.Tree;

import java.util.*;

public class AllNodesFromDistanceK {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParentMap(parentMap, root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        int level = 0;
        while(!queue.isEmpty()) {
            if(level == k) {
                return extractQueue(queue);
            }
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left != null && !seen.contains(currNode.left)) {
                    seen.add(currNode.left);
                    queue.offer(currNode.left);
                }

                if(currNode.right != null && !seen.contains(currNode.right)) {
                    seen.add(currNode.right);
                    queue.offer(currNode.right);
                }

                TreeNode parentCurrNode = parentMap.get(currNode);
                if(parentCurrNode != null && !seen.contains(parentCurrNode)) {
                    seen.add(parentCurrNode);
                    queue.offer(parentCurrNode);
                }
            }
            level++;
        }
        return new ArrayList<>();
    }

    private void populateParentMap(Map<TreeNode, TreeNode> parentMap, TreeNode node, TreeNode parent) {
        if(node == null) {
            return;
        }
        parentMap.put(node, parent);
        populateParentMap(parentMap, node.left, node);
        populateParentMap(parentMap, node.right, node);
    }

    private List<Integer> extractQueue(Queue<TreeNode> queue) {
        List<Integer> list = new ArrayList<>();
        for(TreeNode node : queue) {
            list.add(node.value);
        }
        return list;
    }

}
