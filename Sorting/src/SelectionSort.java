public class SelectionSort {

    public static void selectionSort(int[] input) {

        int n = input.length;
        for(int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < n; j++) {
                if (input[j] < input[minIdx]) {
                    minIdx = j;
                }
                int temp = input[minIdx];
                input[minIdx] = input[i];
                input[i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {20, 35, -15, 7, 55, 1, -22};

        selectionSort(input);

        for(int num : input) {
            System.out.print(num + " ");
        }
    }
}
