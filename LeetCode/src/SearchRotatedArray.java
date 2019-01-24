public class SearchRotatedArray {

    public static int searchRotate(int[] input, int element) {

        if (input.length == 0) {
            return -1;
        }

        if (input.length == 1) {
            if (input[0] == element)
                return 0;
            else
                return -1;
        }


        int pivotIndex = pivotRotate(input);
        //int index = -1;
        if (input[pivotIndex] == element) {
            return pivotIndex;
        }
        if (pivotIndex == 0) {
            return binarySearchArray(input, 0, input.length - 1, element);
        }

        if (element < input[pivotIndex]) {
            return binarySearchArray(input, pivotIndex, input.length - 1, element);
        }

        return binarySearchArray(input, 0, pivotIndex - 1, element);
    }

    public static int pivotRotate(int[] input) {

        int start = 0;
        int end = input.length - 1;

        if (input[start] < input[end]) {
            return 0;
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (input[mid] > input[mid + 1]) {
                return mid + 1;
            } else if (input[mid] < input[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }

    public static int binarySearchArray(int[] input, int start, int end, int element) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (input[mid] == element) {
                return mid;
            } else if (input[mid] > element) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {Integer.MAX_VALUE + 2};
        System.out.println(Integer.MAX_VALUE + 2);

        int searchIdx = searchRotate(input, Integer.MAX_VALUE + 1);

        System.out.println(searchIdx);
    }
}
