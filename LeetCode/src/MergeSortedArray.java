import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int mergedIdx = m + n - 1;

        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[mergedIdx] = nums2[i];
                i--;
            } else {
                nums1[mergedIdx] = nums1[i];
                j--;
            }
            mergedIdx--;
        }

        for(int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
