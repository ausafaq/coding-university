import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> threeSums = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if(nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            int twoTarget = -nums[i];
            int p = i + 1;
            int q = nums.length - 1;

            while(p < q) {
                if(nums[p] + nums[q] == twoTarget) {
                    threeSums.add(Arrays.asList(nums[i], nums[p++], nums[q--]));
                    while (p < q && nums[p] == nums[p - 1]) {
                        p++;
                    }
                    while (p < q && nums[q] == nums[q + 1]) {
                        q--;
                    }
                } else if(nums[p] + nums[q] < twoTarget) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return threeSums;
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(input));
    }
}
