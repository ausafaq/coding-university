import java.util.Arrays;

public class LongestSubstringWithAtleastK {

    public static int longestSubstring(String s, int k) {
        char[] strArr = s.toCharArray();
        int[] map = new int[26];
        int h, i , j, idx, max = 0, unique, noLessThanK;

        for(h = 1; h <= 26; h++) {
            Arrays.fill(map, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while(j < strArr.length) {
                if(unique <= h) {
                    idx = strArr[j] - 'a';
                    if(map[idx] == 0) {
                        unique++;
                    }
                    map[idx]++;
                    if(map[idx] == k) {
                        noLessThanK++;
                    }
                    j++;
                } else {
                    idx = strArr[i] - 'a';
                    if(map[idx] == k) {
                        noLessThanK--;
                    }
                    map[idx]--;
                    if(map[idx] == 0) {
                        unique--;
                    }
                    i++;
                }
                if(unique == h && unique == noLessThanK) {
                    max = Math.max(j - i, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }
}
