public class Dijkstra {

    private static final Graph[] GRAPH = {

    }

    class Graph {
        private final Map<String, Vertex> graph;

        public static class Edge {
            public final String v1, v2;
            public final int dist;

            public Edge(String v1, String v2, int dist) {
                this.v1 = v1;
                this.v2 = v2;
                this.dist = dist;
            }
        }
    }
}
