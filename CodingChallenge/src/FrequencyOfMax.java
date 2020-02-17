import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FrequencyOfMax {

    public static List<Integer> mathworks(List<Integer> numbers, List<Integer> q) {
        int max = Integer.MIN_VALUE;
        int[] maxToRight = new int[numbers.size()];
        maxToRight[numbers.size() - 1] = 1;
        int count = 1;

        List<Integer> countList = new ArrayList<>(numbers.size());

        for(int i = numbers.size() - 1; i >= 0; i--) {
            if(numbers.get(i) > max) {
                max = numbers.get(i);
                count = 1;
            } else if(numbers.get(i) == max) {
                count += 1;
            }
            countList.add(count);
        }

        List<Integer> result = new ArrayList<>(numbers.size());

        for(int i : q) {
            result.add(countList.get(countList.size() - i));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 1, 2));
        List<Integer> q = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(mathworks(numbers, q));
    }
}
