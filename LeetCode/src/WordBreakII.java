import java.util.*;

public class WordBreakII {

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    private static List<String> wordBreakHelper(String s, Set<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if(start == s.length()) {
            res.add("");
        }
        for(int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if(wordDict.contains(sub)) {
                List<String> list = wordBreakHelper(s, wordDict, end);
                for (String str : list) {
                    res.add(str.length() == 0 ? sub : str + " " + sub);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> ans = wordBreak("catsanddog", new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(ans.toString());
    }
}
