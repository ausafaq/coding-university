import java.util.*;


public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int sum = 0;
        int prevDiff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {

                int currSum = nums[i] + nums[j] + nums[k];
                int modDiff = (target > currSum ? target - currSum : currSum - target);

                if(modDiff == 0) {
                    return currSum;
                }

                if(modDiff < prevDiff) {
                    prevDiff = modDiff;
                    sum = currSum;
                }

                if(currSum > target) {
                    k--;
                } else {
                    j++;
                }

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] input = {-1, 2, 1, 4};
        int target = 1;
        System.out.println(threeSumClosest(input, target));
    }
}
