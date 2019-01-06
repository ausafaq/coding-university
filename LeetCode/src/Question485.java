import java.util.*;

public class Question485 {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int result = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(input));
    }
}
