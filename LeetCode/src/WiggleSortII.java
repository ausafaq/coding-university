import java.util.Arrays;

public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;

        int median = findMedian(nums, 0, n-1, (n-1)/2);

        int[] temp = new int[n];
        int left = 0;
        int right = n - 1;

        for(int i = 0; i < n; i++) {
            if(nums[i] < nums[median]) {
                temp[left] = nums[i];
                left++;
            } else if(nums[i] > nums[median]) {
                temp[right] = nums[i];
                right--;
            }
        }

        for(int i = left; i <= right; i++) {
            temp[i] = nums[median];
        }

        // Wiggle Sort
        left = (n - 1) / 2;
        right = n - 1;
        for(int i = 0; i < n; i++) {
            if((i % 2) == 0) {
                nums[i] = temp[left];
                left--;
            } else {
                nums[i] = temp[right];
                right--;
            }
        }
    }

    private static int findMedian(int[] nums, int low, int high, int k) {
        if(low >= high) {
            return low;
        }

        int pivot = partition(nums, low, high);
        if(pivot == k) {
            return pivot;
        }

        if(pivot > k) {
            return findMedian(nums, low, pivot - 1, k);
        } else {
            return findMedian(nums, pivot + 1, high, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[0];
        int i = low + 1;
        int j = high;

        while(i <= j) {
            while(i <= j && nums[i] < pivot) {
                i++;
            }
            while(i <= j && nums[j] > pivot) {
                j++;
            }
            if( i<= j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
