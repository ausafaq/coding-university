
public class NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
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

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                int level = q.size();

                List<Integer> currentLevel = new ArrayList<>(level);
                for(int i = 0; i < level; i++) {
                    Node currentNode = q.poll();
                    currentLevel.add(currentNode.val);

                    if(!currentNode.children.isEmpty()) {
                        List<Node> children = currentNode.children;
                        for(Node child : children) {
                            q.add(child);
                        }

                    }
                }
                result.add(currentLevel);
            }
            return result;
        }
    }
}
