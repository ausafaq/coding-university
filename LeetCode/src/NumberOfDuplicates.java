import java.util.*;

public class NumberOfDuplicates {

    public static int numberOfDuplicates(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int countDuplicates = 0;
        for(int i = 0; i < nums.length; i++) {
            if(numbers.get(nums[i]) != null) {
                countDuplicates++;
            } else {
                numbers.put(nums[i], nums[i]);
            }
        }
        return countDuplicates;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 3};
        System.out.println(numberOfDuplicates(input));
    }
}
