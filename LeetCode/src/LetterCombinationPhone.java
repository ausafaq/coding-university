import java.util.*;

public class LetterCombinationPhone {

    static List<String> results = new ArrayList<>();
    static String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombination(String digits) {
        if(digits == null || digits.length() == 0) {
            return results;
        }

        backtrack(digits, new StringBuilder(), 0);

        return results;
    }

    private static void backtrack(String digits, StringBuilder sb, int index) {
        if(index == digits.length()) {
            results.add(sb.toString());
        } else {
            for(char c : mapping[digits.charAt(index) - '0'].toCharArray()) {
                sb.append(c);
                backtrack(digits, sb, index + 1);
            }
        }
    }
}
