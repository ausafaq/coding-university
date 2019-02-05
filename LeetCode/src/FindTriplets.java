import java.util.*;

public class FindTriplets {

    public static List<Integer> findTriplets(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> output = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    output.add(nums[i]);
                    output.add(nums[j++]);
                    output.add(nums[k--]);
                } else if(sum > target) {
                    k--;
                } else if(sum < target) {
                    j++;
                }
            }
        }

        return output;
    }


    public static void main(String[] args) {
        int[] A = {1, 1, 0, 6, 10, 8};

        System.out.println(findTriplets(A, 2));

    }
}
