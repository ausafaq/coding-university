package StringManipulation.Medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    static Map<Integer, Integer> cache = new HashMap<>();

    // Recursive Implementation
    public static int numDecodingsRecusive(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        return recurseHelper(0, s);
    }

    private static int recurseHelper(int index, String s) {
        if(index == s.length()) {
            return 1;
        }

        if(s.charAt(index) == '0') {
            return 0;
        }

        if(index == s.length() - 1) {
            return 1;
        }

        if(cache.containsKey(index)) {
            return cache.get(index);
        }

        int ans = recurseHelper(index + 1, s);
        if(Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += recurseHelper(index + 2, s);
        }

        cache.put(index, ans);

        return ans;
    }


    // Iterative Implementation
    public static int numDecodingsIterative(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(numDecodingsRecusive("226"));
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " +timeElapsed);
        System.out.println(numDecodingsIterative("226"));
    }
}
