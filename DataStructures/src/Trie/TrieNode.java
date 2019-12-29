package Trie;

import java.util.*;

public class TrieNode {

    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isEnd = false;
    char ch;

    // Initialize Trie data structure here
    public TrieNode() {}
    public TrieNode(char ch) {
        this.ch = ch;
    }

}
