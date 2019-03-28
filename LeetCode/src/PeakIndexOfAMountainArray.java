public class PeakIndexOfAMountainArray {

    public static int peakIndexMountainArray(int[] A) {

        if(A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(A[start] < A[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] input = {0, 2, 1, 0};
        System.out.println(peakIndexMountainArray(input));
    }
}
