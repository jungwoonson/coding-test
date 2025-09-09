package leetcode.binarysearchtree;

import java.util.TreeSet;

public class BalancedBinaryTree {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 5000].
    // -10^4 <= Node.val <= 10^4
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        isBalanced(root, 0);
        return isBalanced;
    }

    public int isBalanced(TreeNode root, int level) {
        if (null == root) {
            return level;
        }

        int left = isBalanced(root.left, level + 1);
        int right = isBalanced(root.right, level + 1);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right);
    }
}
