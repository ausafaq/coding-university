import java.util.Arrays;

public class RotateArray {

    // Rotate an Array by k Steps
    // Time Complexity: O(n) | Space Complexity: O(1)
    public static void rotate(int[] nums, int k) {
        // if input is invalid
        if(nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid input");
        }

        int[] input = nums.clone(); // cloning to preserve the original array


        // if k is negative
        if (k < 0) {
            throw new RuntimeException("Value of K is negative");
        }

        int len = input.length;
        k = (k > len) ? k % len : k; // handles large value of k, when k > len
        reverse(input, 0, len - k - 1);
        reverse(input, len - k, len - 1);
        reverse(input, 0, len - 1);

        // Printing the rotated array
        System.out.println(Arrays.toString(input));
    }

    private static void reverse(int[] input, int start, int end) {

        while (start <= end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
//        int[] testInput1 = {};
//        rotate(null, 3); // Runtime exception invalid input
//        rotate(testInput1, 3); // Runtime exception for empty input

        int[] testInput2 = {1, 2, 3, 4, 5, 6, 7};
//        rotate(testInput2, -3); // Runtime exception for negative k
        rotate(testInput2, 3);
        rotate(testInput2, 10);
        rotate(testInput2, 100);
        rotate(testInput2, 1000);
    }
}
