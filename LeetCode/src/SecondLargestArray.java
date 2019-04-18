public class SecondLargestArray {

    public static int secondLargestInArray(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException();
        }

        int first, second;

        first = second = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > first) {
                second = first;
                first = input[i];
            } else if (input[i] > second && input[i] != first) {
                second = input[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] input = {12, 35, 1, 10, 34, 1};
        System.out.println(secondLargestInArray(input));
    }
}
