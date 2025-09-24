package leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch2 {

    // Constraints:
    // m == board.length
    // n == board[i].length
    // 1 <= m, n <= 12
    // board[i][j] is a lowercase English letter.
    // 1 <= words.length <= 3 * 10^4
    // 1 <= words[i].length <= 10
    // words[i] consists of lowercase English letters.
    // All the strings of words are unique.
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final TrieNode root = new TrieNode();
    private char[][] board;
    private Set<String> result;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];

        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur.put(c);
                cur = cur.get(c);
            }
            cur.isEnd = true;
        }

        result = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.contains(board[i][j])) {
                    visited[i][j] = true;
                    search(root.children.get(board[i][j]), i, j, String.valueOf(board[i][j]));
                    visited[i][j] = false;
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void search(TrieNode node, int i, int j, String word) {
        if (node.isEnd) {
            result.add(word);
        }

        for (int[] direction : directions) {
            int a = i + direction[0];
            int b = j + direction[1];
            Map<Character, TrieNode> children = node.children;
            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || visited[a][b]) {
                continue;
            }
            if (node.contains(board[a][b])) {
                visited[a][b] = true;
                search(children.get(board[a][b]), a, b, word + board[a][b]);
                visited[a][b] = false;
            }
        }
    }

    class TrieNode {

        Map<Character, TrieNode> children;
        boolean isEnd = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public boolean contains(Character key) {
            return children.containsKey(key);
        }

        public void put(Character key) {
            if (!contains(key)) {
                children.put(key, new TrieNode());
            }
        }

        public TrieNode get(Character key) {
            return children.get(key);
        }
    }
}
