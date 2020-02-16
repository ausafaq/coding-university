package DijkstraAlgorithm;

import java.util.*;

public class Dijkstra {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V; // Number of vertices
    List<List<Node>> adj;

    public Dijkstra(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    // Function for Dijkstra's Algorithm
    public void dijkstraAlgo(List<List<Node>> adj, int src) {
        this.adj = adj;

        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        pq.add(new Node(src, 0));
        dist[src] = 0;
        while(settled.size() != V) {
            /* remove the minimum distance node
            from the priority queue */
            int u = pq.remove().node;
            settled.add(u);
            evalNeighbors(u);
        }
    }

    // Function to process all the neighbors
    // of the passed Node
    private void evalNeighbors(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for(int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // if the current node hasn't been processed
            if(!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // if the new distance is cheaper than the cost
                if(newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                }

                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<List<Node>>();

        for(int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        Dijkstra dijkstra = new Dijkstra(V);
        dijkstra.dijkstraAlgo(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dijkstra.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dijkstra.dist[i]);

    }

}
