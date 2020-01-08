import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> graph, boolean[] visited, int course) {
        if(visited[course]) {
            return false;
        } else {
            visited[course] = true;
        }

        for(int i = 0; i < graph.get(course).size(); i++) {
            if(!dfs(graph, visited, graph.get(course).get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }

    public static void main(String[] args) {
        int[][] courses = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, courses));
    }
}
