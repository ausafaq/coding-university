import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {


    public static void bucketSort(int[] input) {

        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                input[j++] = value;
            }
        }
    }

    public static int hash(int element) {
        return element / (int) 10;
    }

    public static void main(String[] args) {
        int[] intArray = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArray);

        for (int num : intArray) {
            System.out.print(num + " ");
        }

    }
}
