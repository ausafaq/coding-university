public class RotateArray {

    public static void rotateArray(int[] input, int k) {

        rotateHelper(input, k);
        for (int num : input) {
            System.out.print(num + " ");
        }
    }

    private static void rotateHelper(int[] input, int k) {

        int len = input.length;
        if (k < 0)
            throw new IllegalArgumentException();

        if (k <= len) {
            reverse(input, 0, len - k - 1);
            reverse(input, len - k, len - 1);
            reverse(input, 0, len - 1);
        } else {
            while (k > len) {
                k = k - len;
            }
            //System.out.println(k);
            reverse(input, 0, len - k - 1);
            reverse(input, len - k, len - 1);
            reverse(input, 0, len - 1);
        }

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
        int[] input = {1, 2, 3, 4, 5, 6};

        rotateArray(input, 1000);
    }
}
