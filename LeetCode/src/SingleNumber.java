public class SingleNumber {

    public static int singleNumber(int[] nums) {

        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int xor = 0;
        for(int n : nums) {
            xor ^= n;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] input = {};
        System.out.println(singleNumber(input));
    }
}
