import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static String getPermutation(int n, int k) {

        List<Integer> seqNum = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            seqNum.add(i);
        }

        StringBuilder result = new StringBuilder();
        k--;

        for(int i = 1; i <= n; i++) {
            int index = k/getFactorial(n - i);
            result.append(String.valueOf(seqNum.get(index)));
            seqNum.remove(index);
            k -= index * getFactorial(n-i);
        }

        return result.toString();
    }

    private static int getFactorial(int num) {
        int factorial = 1;
        for(int i = 1; i <= num; i++) {
            factorial = factorial * i;
        };
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }

}

