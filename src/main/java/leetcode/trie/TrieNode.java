package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    private Map<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }

    public boolean containsKey(char c) {
        return children.containsKey(c);
    }

    public void put(char c) {
        children.put(c, new TrieNode());
    }

    public TrieNode get(char c) {
        return children.get(c);
    }

    public void word() {
        this.isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }
}