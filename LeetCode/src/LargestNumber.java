import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private static class LargeNumberComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return "";
        }

        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new LargeNumberComparator());

        if(arr[0].equals("0")) {
            return "0";
        }

        String largestNumberStr = new String();
        for(String str: arr) {
            largestNumberStr += str;
        }

        return largestNumberStr;
    }

    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(input));
    }
}
