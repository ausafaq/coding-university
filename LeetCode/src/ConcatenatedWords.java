import java.util.*;

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInDict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> cache = new HashMap<>();
        for (String word : words) {
            if (dfs(word, wordSet, cache)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean dfs(String word, Set<String> wordSet, Map<String, Boolean> cache) {
        if(cache.containsKey(word)) {
            return cache.get(word);
        }

        for(int i = 1; i < word.length(); i++) {
            if(wordSet.contains(word.substring(0, i))) {
                String suffix = word.substring(i);
                if(wordSet.contains(suffix) || dfs(suffix, wordSet, cache)) {
                    cache.put(word, true);
                    return true;
                }
            }
        }
        cache.put(word, false);
        return false;
    }
}
