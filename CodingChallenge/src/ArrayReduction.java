import java.util.*;

public class ArrayReduction {

    public static int reduction(List<Integer> num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(num);
        int sum = pq.poll();
        int cost = 0;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (curr < sum) {
                pq.add(sum);
                sum = curr;
            } else {
                sum += curr;
                cost += sum;
                continue;
            }

            sum += pq.poll();
            cost += sum;
        }

        return cost;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(6);
        input.add(8);
        System.out.println(reduction(input));
    }
}
