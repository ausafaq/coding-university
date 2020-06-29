import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingElements {

    public static int countElements(int[] arr) {
        Set<Integer> intSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int count = 0;
        for(int num : arr) {
            if(intSet.contains(num + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input =  {1, 1, 2, 2};
        System.out.println(countElements(input));
    }
}
