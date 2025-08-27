package leetcode.binarysearchtree;

public class SearchInABinarySearchTree {

    // Constraints:
    // The number of nodes in the tree is in the range [1, 5000].
    // 1 <= Node.val <= 10^7
    // root is a binary search tree.
    // 1 <= val <= 10^7
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return searchBST(root.right, val);
    }
}
