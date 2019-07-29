public class FlippingAnImage {

    public static int[][] flip(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            reverse(A[i]);
            invert(A[i]);
        }
        return A;
    }

    public static void reverse(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - 1 - i] = temp;
        }
    }

    public static void invert(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

}
