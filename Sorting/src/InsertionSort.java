public class InsertionSort {


    public static void sort(int[] arr) {

        int len = arr.length;

        for(int i = 1; i < len; i++) {

            int key = arr[i];
            int j = i - 1;

            while(j >=0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] input = {12, 13, 11, 6, 5};

        sort(input);

        for(int num : input) {
            System.out.print(num + " ");
        }
    }
}
