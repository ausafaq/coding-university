import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean [nums.length];
        helper(nums, list, visited, result);
        return result;
    }

    private static void helper(int[] nums, List<Integer> list, boolean[] visited, List<List<Integer>> result) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            }
        }
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(visited[i]) continue;
                if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                list.add(nums[i]);
                helper(nums, list, visited, result);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
