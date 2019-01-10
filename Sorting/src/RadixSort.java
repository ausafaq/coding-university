public class RadixSort {

    public static int getMax(int[] input) {
        int max = input[0];

        for(int i = 1; i < input.length; i++) {
            if(input[i] > max)
                max = input[i];
        }

        return max;
    }

    public static void radixSort(int[] input) {

        int digitPlace = 1;
        int n = input.length;
        int[] result = new int[n];
        int largestNum = getMax(input);

        while(largestNum/digitPlace > 0) {
            int[] count = new int[10];

            for(int i = 0; i < n; i++) {
                count[input[i] / digitPlace % 10]++;
            }

            // Adjusting the count
            for(int i = 1; i < 10; i++) {
                count[i] += count[i-1];
            }

            // Build the resulting array
            for(int i = n - 1; i >= 0; i--) {
                result[count[input[i] / digitPlace % 10] - 1] = input[i];
                count[input[i] / digitPlace % 10]--;
            }

            for(int i = 0; i < result.length; i++) {
                input[i] = result[i];
            }

            digitPlace *= 10;
        }
    }



    public static void main(String[] args) {
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(radixArray);

        for(int num : radixArray) {
            System.out.print(num + " ");
        }
    }
}
