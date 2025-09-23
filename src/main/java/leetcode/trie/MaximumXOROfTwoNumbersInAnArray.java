package leetcode.trie;

public class MaximumXOROfTwoNumbersInAnArray {

    // Constraints:
    // 1 <= nums.length <= 2 * 10^5
    // 0 <= nums[i] <= 2^31 - 1
    private int w = Integer.MAX_VALUE;
    private BitNode root;

    public int findMaximumXOR(int[] nums) {
        root = new BitNode();

        // 최대 값
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // 최대 깊이
        w = (max == 0) ? 1 : (32 - Integer.numberOfLeadingZeros(max));

        for (int i = 0; i < nums.length; i++) {
            insert(root, nums[i]);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, search(root, nums[i]));
        }

        return result;
    }

    private void insert(BitNode root, int num) {
        BitNode cur = root;
        for (int i = w - 1; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (cur.bits[bit] == null) {
                cur.bits[bit] = new BitNode();
            }
            cur = cur.bits[bit];
        }
    }

    private int search(BitNode root, int num) {
        BitNode cur = root;
        int result = 0;
        for (int i = w - 1; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int not = 1 - bit;
            if (cur.bits[not] != null) {
                cur = cur.bits[not];
                result += (int) Math.pow(2, i);
                continue;
            }
            cur = cur.bits[bit];
        }
        return result;
    }

    class BitNode {
        BitNode[] bits = new BitNode[2];
    }
}
