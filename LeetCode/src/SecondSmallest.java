public class SecondSmallest {


    public static int minimum(int[] arr) {

        int min = arr[0];
        int min2 = arr[1];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min2 = min;
                min = arr[i];
            }
            else if(arr[i] < min2) {
                min2 = arr[i];
            }
        }

        return min2;
    }


    public static void main(String[] args) {

        int[] input = {3, 2, 5, 6};
        System.out.println(minimum(input));

    }
}
