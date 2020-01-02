public class IncreasingTriplets {
    public static boolean increasingTriplets(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int n: nums) {
            if(n <= first) {
                first = n;
            } else if(n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplets(input));
    }
}
