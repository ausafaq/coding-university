package Graph;

import java.util.*;

public class Graph {

    // HashMap to store the Adjacency List
    private Map<Integer, List<Integer>> map = new HashMap<>();

    // Add Vertex
    public void addVertex(int vertex) {
        map.put(vertex, new LinkedList<Integer>());
    }

    // Add Edge
    public void addEdge(int source, int destination, boolean bidirectional) {
        if(!map.containsKey(source)) {
            addVertex(source);
        }

        if(!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if(bidirectional) {
            map.get(destination).add(source);
        }
    }

    // Number of Vertices
    public int getVertexCount() {
        return map.keySet().size();
    }

    // Number of Edges
    public int getEdgeCount(boolean bidirectional) {
        int count = 0;
        for(int v : map.keySet()) {
            count += map.get(v).size();
        }
        if(bidirectional) {
            count = count/2;
        }
        return count;
    }

    // Check if a Vertex is present or not
    public boolean hasVertex(int vertex) {
        return map.containsKey(vertex);
    }

    // Check if an edge is present or not
    public boolean hasEdge(int source, int destination) {
        return map.get(source).contains(destination);
    }

    // Print the adjacency List
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Integer vertex : map.keySet()) {
            sb.append(vertex.toString() + " : " );
            for(Integer val : map.get(vertex)) {
                sb.append(val.toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Driver Code
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);

        System.out.println("Graph Representation: \n" + graph.toString());
    }
}
