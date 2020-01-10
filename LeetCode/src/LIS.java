import java.util.Arrays;

public class LIS {

// Recursion
//    public static int lengthOfLIS(int[] nums) {
//        return helper(nums, Integer.MIN_VALUE, 0);
//    }
//
//    private static int helper(int[] nums, int prev, int curr) {
//        if(curr == nums.length) {
//            return 0;
//        }
//        int taken = 0;
//        if(nums[curr] > prev) {
//            taken =  1 + helper(nums, nums[curr], curr + 1);
//        }
//        int notTaken = helper(nums, prev, curr + 1);
//        return Math.max(taken, notTaken);
//    }

//    // Dynamic Programming I
//
//    public static int lengthOfLIS(int[] nums) {
//        if(nums.length == 0) {
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int ans = 1;
//        for(int i=1; i < dp.length; i++) {
//            int max = 0;
//            for(int j = 0; j < i; j++) {
//                if(nums[i] > nums[j]) {
//                    max = Math.max(max, dp[j]);
//                }
//                dp[i] = max + 1;
//                ans = Math.max(max, dp[i]);
//            }
//        }
//        return ans;
//    }


    // Dynamic Programming II
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num: nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) {
                i = -(i+1);
            }
            dp[i] = num;
            if(i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
