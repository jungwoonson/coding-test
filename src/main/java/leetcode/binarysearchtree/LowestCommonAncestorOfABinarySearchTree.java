package leetcode.binarysearchtree;

public class LowestCommonAncestorOfABinarySearchTree {

    // Constraints:
    // The number of nodes in the tree is in the range [2, 10^5].
    // -10^9 <= Node.val <= 10^9
    // All Node.val are unique.
    // p != q
    // p and q will exist in the BST.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
