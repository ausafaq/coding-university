import java.util.*;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, list, result);
        return result;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if(nums.length == list.size()) {
            result.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
                helper(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(permute(nums));
    }
}
