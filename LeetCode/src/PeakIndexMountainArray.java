public class PeakIndexMountainArray {

    public static int peakIndexInMountainArray(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < A[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String args[]) {
        int[] input = {0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(input));
    }
}
