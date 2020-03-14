import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minimumWindow(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0) {
            return "";
        }

        Map<Character, Integer> needleMap = new HashMap<>();
        for(int i = 0; i < needle.length(); i++) {
            needleMap.put(needle.charAt(i), needleMap.getOrDefault(needle.charAt(i), 0) + 1);
        }

        // Number of unique characters in needle, which should be present in the desired window
        int required = needleMap.size();
        int left = 0, right = 0;
        int formed = 0;

        // Dictionary to keep a count of all the unique characters in the window
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // {window length, left, right}

        while(right < haystack.length()) {
            char c = haystack.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if(needleMap.containsKey(c) && windowCounts.get(c) == needleMap.get(c)) {
                formed++;
            }
            while(left <= right && formed == required) {
                c = haystack.charAt(left);
                // Save the smallest window until now
                if(ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if(needleMap.containsKey(c) && windowCounts.get(c) < needleMap.get(c)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : haystack.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String haystack = "ADOBECODEBANC";
        String needle = "ABC";
        System.out.println(minimumWindow(haystack, needle));
    }
}
