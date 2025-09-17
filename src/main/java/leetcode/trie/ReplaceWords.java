package leetcode.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

    // Constraints:
    // 1 <= dictionary.length <= 1000
    // 1 <= dictionary[i].length <= 100
    // dictionary[i] consists of only lower-case letters.
    // 1 <= sentence.length <= 10^6
    // sentence consists of only lower-case letters and spaces.
    // The number of words in sentence is in the range [1, 1000]
    // The length of each word in sentence is in the range [1, 1000]
    // Every two consecutive words in sentence will be separated by exactly one space.
    // sentence does not have leading or trailing spaces.
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        for (String word : dictionary) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.containsKey(c)) {
                    current.put(c);
                }
                current = current.get(c);
            }
            current.end();
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode current = root;
            StringBuilder newWord = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                // 불일치 시 즉시 멈춤 → 접두사만 허용
                if (!current.containsKey(c)) {
                    newWord.setLength(0); // 매칭 실패 표시(선택)
                    break;
                }

                newWord.append(c);
                current = current.get(c);

                // 가장 짧은 root 발견 시 즉시 중단
                if (current.isEnd()) {
                    break;
                }
            }

            if (!newWord.isEmpty() && current.isEnd()) {
                result.append(newWord);
            } else {
                result.append(word);
            }

            if (i < words.length - 1) {
                result.append(' ');
            }
        }

        return result.toString();
    }

    class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
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

        public int size() {
            return children.size();
        }

        private void end() {
            isEnd = true;
        }

        private boolean isEnd() {
            return isEnd;
        }
    }
}
