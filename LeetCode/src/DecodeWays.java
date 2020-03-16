import java.util.Map;
import java.util.HashMap;

public class DecodeWays {

    static Map<Integer, Integer> memo = new HashMap<>();

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0);
    }

    private static int helper(String s, int index) {
        if(index == s.length()) {
            return 1;
        }

        if(s.charAt(index) == '0') {
            return 0;
        }

        if(index == s.length() - 1) {
            return 1;
        }

        if(memo.containsKey(index)) {
            return memo.get(index);
        }

        int ans = helper(s, index + 1); // for single digit
        if(Integer.parseInt(s.substring(index, index + 2)) <= 26) { // for double digit
            ans += helper(s, index + 2);
        }

        memo.put(index, ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
