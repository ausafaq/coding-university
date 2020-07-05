public class MergeSort {

    // Partitioning method
    public static void mergeSort(int[] input) {
        int len = input.length;

        int mid = len / 2;

        int[] l = new int[mid];
        int[] r = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = input[i];
        }

        for (int i = mid; i < len; i++) {
            r[i - mid] = input[i];
        }

        mergeSort(l);
        mergeSort(r);
        merge(input, l, r, mid, len - mid);
    }

    // Merging method
    public static void merge(int[] input, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                input[k++] = l[i++];
            } else {
                input[k++] = r[j++];
            }
        }

        while (i < left) {
            input[k++] = l[i++];
        }

        while (j < right) {
            input[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int[] input = {20, 35, -15, 7, 55, 1, -22};
        mergeSort(input);

        for (int num : input) {
            System.out.print(num + " ");
        }
    }
}
