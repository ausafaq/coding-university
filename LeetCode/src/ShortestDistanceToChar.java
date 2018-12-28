import java.util.*;


public class ShortestDistanceToChar {

    public static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] output = new int[n];
        List<Integer> targetCharIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C)
                targetCharIndices.add(i);
        }

        int currIndex = targetCharIndices.get(0), nextIndex = -1;
        if (targetCharIndices.size() > 1)
            nextIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nextIndex == -1) {
                output[i] = Math.abs(i - currIndex);
                continue;
            }

            if (Math.abs(i - currIndex) < Math.abs(targetCharIndices.get(nextIndex) - i)) {
                output[i] = Math.abs(i - currIndex);
            } else {
                currIndex = targetCharIndices.get(nextIndex);
                output[i] = Math.abs(currIndex - i);
                if (targetCharIndices.size() > nextIndex + 1)
                    nextIndex++;
                else
                    nextIndex = -1;
            }
        }

        return output;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] ans = shortestToChar(s,c);
        for(int idx : ans) {
            System.out.print(idx + " ");
        }
    }
}
