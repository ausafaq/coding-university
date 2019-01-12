import java.util.*;

public class Question49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>(null);

        Map<String, List> ans = new HashMap<String, List>();

        for (String s : strs) {
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String key = String.valueOf(chArray);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(String.valueOf(chArray)).add(s);
        }
        return new ArrayList(ans.values());
    }


    public static void main(String[] args) {

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};


        groupAnagrams(input);
    }
}
