package DynamicProgramming;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println(rob(input));
    }

    public static int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob0(nums), rob1(nums));
    }

    private static int rob0(int[] nums) {
        int preMax = 0, curMax = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int t = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = t;
        }
        return curMax;
    }

    private static int rob1(int[] nums) {
        int preMax = 0, curMax = 0;
        for(int i = 1; i < nums.length; i++) {
            int t = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = t;
        }
        return curMax;
    }
}
