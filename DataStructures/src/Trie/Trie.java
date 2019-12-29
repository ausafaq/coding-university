package Trie;
import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
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
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    // Search String in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children == null || !node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isEnd;
    }

    // Check Prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node.children == null || !node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }
}
