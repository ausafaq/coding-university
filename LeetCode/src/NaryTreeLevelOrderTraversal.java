import java.util.*;

public class NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {

        public List<List<Integer>> levelOrder(Node root) {

            if(root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> result = new ArrayList<>();

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                int level = queue.size();

                List<Integer> currentLevel = new ArrayList<>(level);
                for(int i = 0; i < level; i++) {
                    Node currentNode = queue.poll();
                    currentLevel.add(currentNode.val);

                    if(!currentNode.children.isEmpty()) {
                        List<Node> children = currentNode.children;
                        for(Node child : children) {
                            queue.add(child);
                        }

                    }
                }
                result.add(currentLevel);
            }
            return result;
        }
    }
}
