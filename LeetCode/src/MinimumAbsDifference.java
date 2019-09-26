import java.util.Arrays;
import java.util.*;
import java.util.Collection;

public class MinimumAbsDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        // SOLUTION I
//        Arrays.sort(arr);
//        int minDiff = arr[1] - arr[0];
//        for(int i = 1; i < arr.length - 1; i++) {
//            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        for(int i = 1; i < arr.length; i++) {
//            if(arr[i] - arr[i-1] == minDiff) {
//                result.add(Arrays.asList(arr[i-1], arr[i]));
//            }
//        }
//        return result;

        // SOLUTION II
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = arr[arr.length - 1] - arr[0];

        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < minDiff) {
                minDiff = arr[i + 1] - arr[i];
                ans.clear();
            }

            if (arr[i + 1] - arr[i] == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(i + 1);
                ans.add(pair);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        System.out.println(minimumAbsDifference(arr));
    }
}

