import java.util.*;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String str) {
        int len = str.length();
        int result = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                if(allUnique(str, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    public static boolean allUnique(String str, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++) {
            Character ch = str.charAt(i);
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}