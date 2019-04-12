import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 == 0 || n2 == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<Integer>();

        int i = 0, j = 0;
        while(true) {
            if(i == n1 || j == n2) {
                break;
            }

            if(nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[result.size()];
        for(int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}