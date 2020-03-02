import java.util.*;

public class MeetingScheduler {

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int[] slot : slots1) {
            if(slot[1] - slot[0] >= duration) {
                minHeap.offer(slot);
            }
        }

        for(int[] slot : slots2) {
            if(slot[1] - slot[0] >= duration) {
                minHeap.offer(slot);
            }
        }

        int[] prev = minHeap.poll();
        while(!minHeap.isEmpty()) {
            int[] next = minHeap.poll();
            if(next[0] + duration <= prev[1]) {
                return Arrays.asList(next[0], next[0] + duration);
            }
            prev = next;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;
        System.out.println(minAvailableDuration(slots1, slots2, duration).toString());
    }
}
