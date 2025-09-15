package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    private TrieNode trieNode;
    private Map<String, Integer> map;

    public MapSum() {
        trieNode = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        TrieNode current = trieNode;

        for (char c : key.toCharArray()) {
            if (!current.containsKey(c)) {
                current.put(c);
            }
            current = current.get(c);
            if (map.containsKey(key)) {
                current.sum -= map.get(key);
            }
            current.add(val);
        }

        map.put(key, val);
    }

    public int sum(String prefix) {
        TrieNode current = trieNode;

        for (char c : prefix.toCharArray()) {
            if (!current.containsKey(c)) {
                return 0;
            }
            current = current.get(c);
        }

        return current.getSum();
    }

    class TrieNode {

        private Map<Character, TrieNode> children;
        private int sum;

        public TrieNode() {
            this.children = new HashMap<>();
            this.sum = 0;
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

        public void add(int val) {
            this.sum += val;
        }

        public int getSum() {
            return this.sum;
        }
    }
}