public class LongestIncreasingPathInMatrix {

    private static final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int m, n;

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache);
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        for(int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, cache);
                max = Math.max(max, len);
            }
        }
        cache[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(nums));
    }
}
