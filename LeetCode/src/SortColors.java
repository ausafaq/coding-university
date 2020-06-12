import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int left = 0, right = nums.length - 1;
        int curr = 0;

        while(curr <= right) {
            if(nums[curr] == 0) swap(nums, left++, curr++);
            else if(nums[curr] == 2) swap(nums, curr, right--);
            else curr++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
