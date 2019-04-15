public class HouseRobber {

    public static int rob(int[] nums) {

        int sumOne = 0, sumTwo = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sumOne += nums[i];
        }

        for (int j = 1; j < nums.length; j += 2) {
            sumTwo += nums[j];
        }

        return Math.max(sumOne, sumTwo);
    }


    public static void main(String[] args) {
        int[] input = {2, 7, 9, 3, 1};
        System.out.println(rob(input));
    }
}
