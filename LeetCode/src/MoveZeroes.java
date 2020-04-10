import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int snowBallSize = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                snowBallSize++;
            } else if(snowBallSize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        moveZeroes(input);
    }
}
