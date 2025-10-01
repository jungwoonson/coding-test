package leetcode.recursion;

public class KthSymbolInGrammar {

    // 1 <= n <= 30
    // 1 <= k <= 2^(n - 1)
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int half = 1 << (n - 2);            // 2^(n-2)
        if (k <= half) {
            return kthGrammar(n - 1, k);
        }
        return 1 ^ kthGrammar(n - 1, k - half);
    }
}
