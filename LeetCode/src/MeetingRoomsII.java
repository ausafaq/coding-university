import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length, (a, b) -> a - b);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        queue.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > queue.peek()) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] input = {{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRooms(input));
    }
}
