import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode {
        Map<Character, TrieNode> children = null;
        boolean isEnd = false;
        char ch;

        TrieNode() {};
        TrieNode(char ch) {
            this.ch = ch;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children == null) {
                node.children = new HashMap<Character, TrieNode>();
            }
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode(ch));
            }
        }
        node.isEnd = true;
    }

    // Search a word in a trie
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children == null || !node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isEnd;
    }

    // Check prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node.children == null || !node.children.containsKey(ch)) {
                return false;
            }
        }
        return true;
    }
}
