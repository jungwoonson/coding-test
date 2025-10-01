package leetcode.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class KthSymbolInGrammarTest {

    @Test
    void test() {
        KthSymbolInGrammar kth = new KthSymbolInGrammar();
        int actual = kth.kthGrammar(2, 2);
        assertThat(actual).isEqualTo(1);
    }
}
