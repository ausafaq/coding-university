import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        // Sort by ascending order of start
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval: intervals) {
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size() - 1][]);
    }

    public static void main(String[] args) {
        int[][] input = {{1,4},{4,5}};
        int[][] output = merge(input);
        System.out.println(Arrays.deepToString(output));
    }
}
