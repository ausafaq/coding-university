import java.util.*;

public class WordBreak {

//    RECURSION WITH MEMOIZATION
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        return wordBreakHelper(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
//    }
//
//    private static boolean wordBreakHelper(String s, Set<String> wordDict, int start, Boolean[] memo) {
//        if(start == s.length()) {
//            return true;
//        }
//
//        if(memo[start] != null) {
//            return memo[start];
//        }
//
//        for(int end = start + 1; end <= s.length(); end++) {
//            if(wordDict.contains(s.substring(start, end))) {
//                if(wordBreakHelper(s, wordDict, end, memo)) {
//                    return memo[start] = true;
//                }
//            }
//        }
//        return memo[start] = false;
//    }

//    DYNAMIC PROGRAMMING
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j]) {
                    if(wordDictSet.contains(s.substring(j, i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    }
}
