package leetcode.trie;

// Constraints:
// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
class Trie {

    private TrieNode trieNode;

    public Trie() {
        trieNode = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = trieNode;

        for (char c : word.toCharArray()) {
            if (!current.containsKey(c)) {
                current.put(c);
            }
            current = current.get(c);
        }

        current.word();
    }
    
    public boolean search(String word) {
        TrieNode current = trieNode;

        for (char c : word.toCharArray()) {
            if (!current.containsKey(c)) {
                return false;
            }
            current = current.get(c);
        }

        return current.isWord();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = trieNode;

        for (char c : prefix.toCharArray()) {
            if (!current.containsKey(c)) {
                return false;
            }
            current = current.get(c);
        }

        return true;
    }
}