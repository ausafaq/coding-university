public class TicTacToe {

    int[][] matrix;

    public TicTacToe(int n) {
        this.matrix = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        matrix[row][col] = player;

        // Check Horizontal
        boolean win = true;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[row][i] != player) {
                win = false;
                break;
            }
        }
        if(win) return player;

        // Check Vertical
        win = true;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] != player) {
                win = false;
                break;
            }
        }
        if(win) return player;

        // check back diagonal
        win = true;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] != player) {
                win = false;
                break;
            }
        }
        if(win) return player;

        // check forward diagonal
        win = true;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][matrix.length-i-1]!=player){
                win=false;
                break;
            }
        }

        if(win) return player;

        return 0;
    }

    // Alternate
    class TicTacToeII {
        int[] rows;
        int[] cols;
        int dc1;
        int dc2;
        int n;

        public TicTacToeII() {
            rows = new int[n];
            cols = new int[n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            int val = player == 1 ? 1 : -1;

            rows[row] += val;
            cols[col] += col;

            if(row == col) {
                dc1 += val;
            }

            if(col == n - row - 1) {
                dc2 += val;
            }

            if(Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(dc1) == n
                || Math.abs(dc2) == n) {
                return player;
            }
            return 0;
         }
    }
}
