import java.sql.SQLOutput;
import java.util.*;

public class TopologicalSort {
    Stack<Node> stack;
    public TopologicalSort() {
        stack = new Stack<>();
    }

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbors;

        Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbors(Node neighborNode) {
            this.neighbors.add(neighborNode);
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<Node> neighbors) {
            this.neighbors = neighbors;
        }

        @Override
        public String toString() {
            return ""+data;
        }

    }

    // Recursive Topological Sort
    public void topologicalSort(Node node) {
        List<Node> neighbors = node.getNeighbors();
        for(int i = 0; i < neighbors.size(); i++) {
            Node n = neighbors.get(i);
            if(n != null && !n.visited) {
                topologicalSort(n);
                n.visited = true;
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        TopologicalSort topological = new TopologicalSort();
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addNeighbors(node10);
        node40.addNeighbors(node20);
        node10.addNeighbors(node30);
        node20.addNeighbors(node10);
        node20.addNeighbors(node30);
        node20.addNeighbors(node60);
        node20.addNeighbors(node50);
        node30.addNeighbors(node60);
        node60.addNeighbors(node70);
        node50.addNeighbors(node70);

        System.out.println("Topological Sorting Order: ");
        topological.topologicalSort(node40);

        // Print Content of a stack
        Stack<Node> resultStack = topological.stack;
        while(!resultStack.isEmpty()) {
            System.out.print(resultStack.pop() + " ");
        }
    }
}
