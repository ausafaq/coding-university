public class MaxAreaOfIsland {

    // Maximum Area of an Island
    // Time Complexity: O(R * C) | Space Complexity: O(R * C), where R, C are rows, columns of grid respectively
    public static int maxAreaOfIsland(int[][] grid) {

        // Check edge-cases: Null and Empty Grid
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        // Track visited islands
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = helper(grid, visited, i, j, rows, cols); // DFS Traversal
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }


    private static int helper(int[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {

        // Check island indices are within the range
        if(i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }

        if(visited[i][j]) {
            return 0;
        }

        if(grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + helper(grid, visited, i-1, j, rows, cols) +
                helper(grid, visited, i+1, j, rows, cols) +
                helper(grid, visited, i, j-1, rows, cols) +
                helper(grid, visited, i, j+1, rows, cols);
    }

    public static void main(String[] args) {
        int[][] testInput1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                              {0,0,0,0,0,0,0,1,1,1,0,0,0},
                              {0,1,1,0,1,0,0,0,0,0,0,0,0},
                              {0,1,0,0,1,1,0,0,1,0,1,0,0},
                              {0,1,0,0,1,1,0,0,1,1,1,0,0},
                              {0,0,0,0,0,0,0,0,0,0,1,0,0},
                              {0,0,0,0,0,0,0,1,1,1,0,0,0},
                              {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println("Max Area of Island: " +maxAreaOfIsland(testInput1)); // 6

        int[][] testInput2 = {{1,1,0,0,0},
                              {1,1,1,0,0},
                              {0,0,0,1,1},
                              {0,1,0,1,1}};
        System.out.println("Max Area of Island: " +maxAreaOfIsland(testInput2)); // 5

        int[][] testInput3 = {{0,0,0,0,0},
                              {0,0,0,0,0}};
        System.out.println("Max Area of Island: " +maxAreaOfIsland(testInput3)); // 0 for no island

        System.out.println(maxAreaOfIsland(null)); // 0
        System.out.println(maxAreaOfIsland(new int[][] {{}})); // 0 for empty grid
    }
}
