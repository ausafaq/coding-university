public class BinarySearch {

    public static int binarySearchIter(int[] input, int target, int low, int high) {
        int index = -1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(target == input[mid]) {
                index = mid;
                break;
            } else if (target < input[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static int binarySearchRecur(int[] input, int target, int low, int high) {

        int mid = (low + high) / 2;

        if(high < low) {
            return -1;
        }

        if(target == input[mid]) {
            return mid;
        } else if (target < input[mid]) {
            return binarySearchRecur(input, target, low, mid - 1);
        } else {
            return binarySearchRecur(input, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] input = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(binarySearchIter(input, -105, 0, input.length - 1));
        System.out.println(binarySearchRecur(input, -105, 0, input.length - 1));
    }
}
