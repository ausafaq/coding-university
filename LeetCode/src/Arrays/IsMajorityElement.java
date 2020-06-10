package Arrays;

public class IsMajorityElement {

    public static boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        if(len % 2 != 0) {
            return nums[len/2] == target;
        } else {
            return nums[len/2] == nums[len / 2 - 1] && nums[len / 2] == target;
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 4, 5, 5, 5, 5, 5, 6, 6};
        System.out.println(isMajorityElement(input, 5));
    }
}
