import java.sql.SQLOutput;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {

        if(nums.length == 0 || nums == null) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] + currSum < nums[i]) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, -7};
        System.out.println(maxSubArray(input));
    }
}
