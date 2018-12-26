import java.util.*;

public class MorseCode {

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> morseCodes = new HashSet<String>();
        for (String word : words) {
            String code = getCode(word);
            morseCodes.add(code);
        }
        return morseCodes.size();
    }

    public static String getCode(String w) {
        String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        StringBuilder sb = new StringBuilder();
        char[] word = w.toCharArray();
        for (char c : word) {
            sb.append(map[c - 'a']);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] test = {"gin", "zen", "gig", "msg" };
        System.out.println(uniqueMorseRepresentations(test));
    }
}
