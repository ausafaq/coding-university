import com.sun.deploy.nativesandbox.NativeSandboxOutputStream;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(node, new Node(node.val, new ArrayList<>()));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node top = queue.remove();
            for(Node neighbor : top.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                map.get(top).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node A = new Node(1);
        Node B = new Node(2, Arrays.asList(A));
        Node C = new Node(3, Arrays.asList(B));

        CloneGraph cloneGraphService = new CloneGraph();
        System.out.println(cloneGraphService.cloneGraph(C).val);
        List<Node> list = cloneGraphService.cloneGraph(C).neighbors;
        for(Node node : list) {
            System.out.println(node.val);
        }


    }
}
