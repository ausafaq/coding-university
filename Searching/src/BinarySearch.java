public class BinarySearch {

    public static int binarySearch(int[] input, int start, int end, int element) {
        int mid = 0;
       while(start <= end) {
           mid = (start +  end) / 2;
           if(input[mid] == element) {
               return mid;
           } else if(input[mid] < element) {
               start = mid + 1;
           } else {
               end = mid - 1;
           }
       }
       return mid;
    }

    public static void main(String[] args) {

        int[] input = {-22, 1, -15, 7, 20, 35, 55};

        System.out.println(binarySearch(input, 0, input.length, -16));

    }
}
