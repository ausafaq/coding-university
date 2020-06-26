import java.util.LinkedList;
import java.util.List;

public class SurroundedRegions {

    int rows = 0;
    int cols = 0;

    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        if(board.length < 3 || board[0].length < 3) {
            return;
        }

        this.rows = board.length;
        this.cols = board[0].length;

        // list of border cells
        List<Pair> borders = new LinkedList<Pair>();
        for(int i = 0; i < rows; i++) {
            borders.add(new Pair(i, 0));
            borders.add(new Pair(i, cols - 1));
        }

        for(int j = 0; j < cols; j++) {
            borders.add(new Pair(0, j));
            borders.add(new Pair(rows - 1, j));
        }

        // mark the escaped cells
        for(Pair pair: borders) {
            dfsHelper(board, pair.first, pair.second);
        }

        // flip the cells to their final states
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }

    private void dfsHelper(char[][] board, int row, int col) {
        if(board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'E';
        if(row < 0 || row >= rows || col < 0 || col > cols) return;
        dfsHelper(board, row - 1, col);
        dfsHelper(board, row + 1, col);
        dfsHelper(board, row, col - 1);
        dfsHelper(board, row, col + 1);
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
