package leetcode.trie;

// Constraints:
// 1 <= word.length <= 25
// word in addWord consists of lowercase English letters.
// word in search consist of '.' or lowercase English letters.
// There will be at most 2 dots in word for search queries.
// At most 10^4 calls will be made to addWord and search.
class WordDictionary {

    private static final char start = 'a';
    private static final char dot = '.';
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.add(c);
            cur = cur.children[c - start];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchRecursive(word, 0, root);
    }

    private boolean searchRecursive(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char curChar = word.charAt(index);

        if (curChar == dot) {
            TrieNode[] children = node.children;

            for (TrieNode one : children) {
                if (one == null) {
                    continue;
                }
                boolean result = searchRecursive(word, index + 1, one);
                if (result) {
                    return true;
                }
            }
            return false;
        }

        if (node.has(curChar)) {
            return searchRecursive(word, index + 1, node.children[curChar - start]);
        }

        return false;
    }

    class TrieNode {

        TrieNode[] children;
        boolean isEnd = false;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public void add(char wordChar) {
            if (children[wordChar - start] == null) {
                children[wordChar - start] = new TrieNode();
            }
        }

        public boolean has(char wordChar) {
            return children[wordChar - start] != null;
        }
    }
}
