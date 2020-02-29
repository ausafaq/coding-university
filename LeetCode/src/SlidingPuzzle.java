import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    static final int NOT_FOUND = -1;

    public int slidingPuzzle(int[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int rows = board.length;
        int cols = board[0].length;

        String curr = "";
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                curr += board[i][j];
            }
        }

        if(curr.equals("123450")) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(curr);
        visited.add(curr);
        int moves = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currState = queue.poll();

            }
        }


        return 0;
    }
}
