package chapter10;

public class SparseSearch {

    private static int binarySearch(String[] input, String target, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (input[mid] == "") {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < low && right > high) {
                    return -1;
                }

                if (left >= low && input[left] != "") {
                    mid = left;
                    break;
                } else if (right <= high && input[right] != "") {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (input[mid] == target) {
            return mid;
        } else if (target.compareTo(input[mid]) > 0) {
            return binarySearch(input, target, mid + 1, high);
        } else {
            return binarySearch(input, target, low, mid - 1);
        }
    }

    public static int sparseSearch(String[] input, String target) {
        int n = input.length;

        return binarySearch(input, target, 0, n - 1);
    }

    public static void main(String[] args) {
        String[] arr = {"for", "geeks", "", "", "", "", "ide",
                "practice", "", "", "", "quiz"};

        System.out.println(sparseSearch(arr, "geeks"));
    }
}
