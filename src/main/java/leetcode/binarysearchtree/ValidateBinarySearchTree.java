package leetcode.binarysearchtree;

public class ValidateBinarySearchTree {

    // Constraints:
    // The number of nodes in the tree is in the range [1, 10^4].
    // -2^31 <= Node.val <= 2^31 - 1
    boolean result = true;
    Long number = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (number >= root.val) {
            result = false;
        }
        number = (long) root.val;
        inorder(root.right);
    }
}
