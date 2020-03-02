import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    public static int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i = 1; i < Math.sqrt(n) + 1; i++) {
            squares.add(i * i);
        }
        return minNumSquares(n, squares);
    }

    private static int minNumSquares(int k, List<Integer> squares) {
        if(squares.contains(k)) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int square : squares) {
            if(k < square) {
                break;
            }
            int newNum = minNumSquares(k - square, squares) + 1;
            min = Math.min(min, newNum);
        }
        return min;
    }


    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
