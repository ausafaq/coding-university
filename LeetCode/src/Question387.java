import java.util.*;

public class Question387 {

    public static int firstUniqChar(String s) {

        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            } else {
                count.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
