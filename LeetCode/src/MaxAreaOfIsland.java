public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = helper(grid, visited, i, j, rows, cols);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }


    private static int helper(int[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        if(i < 0 || i >= rows) {
            return 0;
        }
        if(j < 0 || j >= cols) {
            return 0;
        }
        if(visited[i][j]) {
            return 0;
        }
        if(grid[i][j] == 0) {
            return 0;
        }
        return 1 + helper(grid, visited, i-1, j, rows, cols) +
                helper(grid, visited, i+1, j, rows, cols) +
                helper(grid, visited, i, j-1, rows, cols) +
                helper(grid, visited, i, j+1, rows, cols);
    }
}
