public class QuickSort {

    public static void quickSort(int[] input, int start, int end) {
        if(end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);

        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        // Using first element as the pivot

        int pivot = input[start];
        int i = start;
        int j = end;

        while(i < j) {

            // empty loop
            while(i < j && input[--j] >= pivot);
            if(i < j) {
                input[i] = input[j];
            }

            // empty loop
            while(i < j && input[++i] <= pivot);
            if(i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;

        return j;
    }

    public static void main(String[] args) {
        int[] input = {20, 35, -15, 7, 55, 1, -22};

        quickSort(input, 0, input.length);

        for(int num : input) {
            System.out.print(num + " ");
        }
    }
}
