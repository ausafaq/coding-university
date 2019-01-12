class Question33 {
    int[] nums;
    int target;

    public int findRotateIndex(int low, int high) {
        if (nums[low] < nums[high])
            return 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            else {
                if (nums[mid] < nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return 0;
    }

    public int search(int low, int high) {
    /*
    Binary search
    */
        while (low <= high) {
            int pivot = (low + high) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    high = pivot - 1;
                else
                    low = pivot + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = findRotateIndex(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }

    public static void main(String[] args) {

    }
}