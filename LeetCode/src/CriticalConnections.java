import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {
    static int time = 0;
    static List<Integer>[] network;
    static int[] lowestVertex; // lowest vertex from current vertex
    static int[] discoveredTime; // discovered tie of vertex
    static boolean[] visited;
    static List<List<Integer>> result;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        initialization(n);
        buildNetwork(connections);
        getCriticalConnections(0, -1);

        return result;
    }

    public static void initialization(int n) {
        lowestVertex = new int[n];
        discoveredTime = new int[n];
        visited = new boolean[n];
        result = new ArrayList<>();
        network = new ;

        for(int i = 0; i < n; i++) {
            network[i]= new ArrayList<>();
        }
    }

    public static void buildNetwork(List<List<Integer>> connections) {
        for(List<Integer> connection : connections) {
            network[connection.get(0)].add(connection.get(1));
            network[connection.get(1)].add(connection.get(0));
        }
    }

    public static void getCriticalConnections(int current, int parent) {
        time++;
        lowestVertex[current] = time;
        discoveredTime[current] = time;
        visited[current] = true;

        for (int neighbor : network[current]) {
            if (neighbor == parent) {
                continue;
            }
            if (visited[current] == false) {
                getCriticalConnections(neighbor, current);
                lowestVertex[current] = Math.min(lowestVertex[current], lowestVertex[neighbor]);

                if (lowestVertex[current] > discoveredTime[current]) {
                    result.add(Arrays.asList(current, neighbor));
                }

            } else {
                lowestVertex[current] = Math.min(lowestVertex[current], discoveredTime[current]);
            }
        }
    }
}
