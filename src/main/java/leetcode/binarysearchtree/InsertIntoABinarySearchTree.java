package leetcode.binarysearchtree;

public class InsertIntoABinarySearchTree {

    // Constraints:
    // The number of nodes in the tree will be in the range [0, 10^4].
    // -10^8 <= Node.val <= 10^8
    // All the values Node.val are unique.
    // -10^8 <= val <= 10^8
    // It's guaranteed that val does not exist in the original BST.
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            prev = curr;
            if (curr.val > val) {
                curr = curr.left;
                continue;
            }
            curr = curr.right;
        }

        if (prev == null) {
            return new TreeNode(val);
        }

        if (prev.val > val) {
            prev.left = new TreeNode(val);
            return root;
        }

        prev.right = new TreeNode(val);
        return root;
    }
}
