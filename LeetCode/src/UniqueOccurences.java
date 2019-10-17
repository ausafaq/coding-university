import java.util.*;

public class UniqueOccurences {

    public static boolean uniqueOccurrences(int[] arr) {

        // store the frequency of the number in the arr
        HashMap<Integer, Integer> map = new HashMap<>();

        // store the values from the above map
        Set<Integer> set = new HashSet<>();

        for(int num: arr) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(int val: map.values()) {
            if(!set.add(val)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] input = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(input));
    }
}
