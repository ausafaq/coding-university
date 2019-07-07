import java.util.*;

public class LongestSubstring {
    /* Brute-force solution
       O(n3)
     */
//    public static int lengthOfLongestSubstring(String str) {
//        int len = str.length();
//        int result = 0;
//        for(int i = 0; i < len; i++) {
//            for(int j = i + 1; j <= len; j++) {
//                if(allUnique(str, i, j)) {
//                    result = Math.max(result, j - i);
//                }
//            }
//        }
//        return result;
//    }
//
//    public static boolean allUnique(String str, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for(int i = start; i < end; i++) {
//            Character ch = str.charAt(i);
//            if(set.contains(ch)) {
//                return false;
//            }
//            set.add(ch);
//        }
//        return true;
//    }

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
