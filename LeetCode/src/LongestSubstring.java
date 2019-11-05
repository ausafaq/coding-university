import java.util.*;

public class LongestSubstring {

    /* Sliding-window solution
       O(n)
     */
    public static int lengthOfLongestSubstring(String str) {
        int len = str.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while(i < len && j < len) {
            if(!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(str.charAt(i++));
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
