import java.util.*;

public class Question888 {

    public static int[] fairCandySwap(int[] A, int[] B) {

        int sumA = 0, sumB = 0;
        Set<Integer> bob = new HashSet<Integer>();

        for (int x : A) {
            sumA += x;
        }

        for (int x : B) {
            bob.add(x);
            sumB += x;
        }

        int delta = (sumB - sumA) / 2;

        for (int x : A) {
            if (bob.contains(x + delta)) {
                return new int[]{x, x + delta};
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {2, 3};

        int[] ans = fairCandySwap(A, B);

        for(int i : ans) {
            System.out.print(i + " ");
        }

    }
}
