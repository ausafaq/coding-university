import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        if(s.length() == 0) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, result);
        return result;
    }

    private static void dfs(String s, int pos, List<String> list, List<List<String>> result) {
        if(pos == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < s.length(); i++) {
            if(isPalindrome(s, pos, i)) {
                list.add(s.substring(pos, i+1));
                dfs(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        System.out.println(partition(input));
    }
}
