import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if(nums == null) {
            return null;
        }
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j+1);
            swap(a, i, j);
        }
        return a;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        ShuffleAnArray obj = new ShuffleAnArray(input);
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}
