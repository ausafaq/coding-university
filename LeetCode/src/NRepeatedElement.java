import java.util.*;

public class NRepeatedElement {

    public static int repeatedNTimes(int[] A) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i : A) {
            if (hs.contains(i)) {
                return i;
            } else {
                hs.add(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 2, 5, 3, 2};
        System.out.println(repeatedNTimes(input));
    }
}
