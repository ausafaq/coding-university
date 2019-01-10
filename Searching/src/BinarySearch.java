public class BinarySearch {

    public static int binarySearch(int[] input, int start, int end, int element) {

        int mid = (start + end) / 2;

        if (end < start) {
            return -1;
        }
        if (element == input[mid]) {
            return mid;
        } else if (element < input[mid]) {
            return binarySearch(input, 0, mid - 1, element);
        } else {
            return binarySearch(input, mid + 1, end, element);
        }
    }

    public static void main(String[] args) {

        int[] input = {-22, 1, -15, 7, 20, 35, 55};

        System.out.println(binarySearch(input, 0, input.length, 8));

    }
}
