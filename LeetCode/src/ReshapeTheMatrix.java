import java.util.*;

public class ReshapeTheMatrix {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int[][] result = new int[r][c];
        int rows = nums.length;
        int cols = nums[0].length;

        Queue<Integer> matQueue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matQueue.add(nums[i][j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = matQueue.remove();
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] input = {{1, 2}, {3, 4}};
    }
}
