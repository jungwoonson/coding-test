package leetcode.trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WordDictionaryTest {

    @Test
    void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");

        assertThat(wordDictionary.search("bad")).isTrue();
        assertThat(wordDictionary.search(".ad")).isTrue();
        assertThat(wordDictionary.search("b..")).isTrue();
    }

    // ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
    // [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]

    @Test
    void test1() {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("a");
        wordDictionary.addWord("a");

        assertThat(wordDictionary.search(".")).isTrue();
        assertThat(wordDictionary.search("a")).isTrue();
        assertThat(wordDictionary.search("aa")).isFalse();
        assertThat(wordDictionary.search("a")).isTrue();
        assertThat(wordDictionary.search(".a")).isFalse();
        assertThat(wordDictionary.search("a.")).isFalse();
    }
}
