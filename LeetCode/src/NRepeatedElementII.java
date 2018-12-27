import java.util.*;

public class NRepeatedElementII {

    public static int repeatedNTimes(int[] A) {
        int n = A.length / 2;
        int num = 0;
        Map<Integer, Integer> intCount = new HashMap<Integer, Integer>();
        for(int i : A) {
            if(intCount.containsKey(i)) {
                intCount.put(i, intCount.get(i) + 1);
            } else {
                intCount.put(i, 1);
            }
        }

        for(Map.Entry hm  : intCount.entrySet() ) {
            if((int)hm.getValue() == n) {
                num = (int) hm.getKey();
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 2, 5, 3, 2};
        System.out.println(repeatedNTimes(input));
    }
}

