package leetcode.binarytree;

public class LowestCommonAncestorOfABinaryTree {

    // Constraints:
    // The number of nodes in the tree is in the range [2, 10^5].
    // -10^9 <= Node.val <= 10^9
    // All Node.val are unique.
    // p != q
    // p and q will exist in the tree.
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return result;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);

        if (left && right) {
            result = root;
            return false;
        }

        if ((root == p || root == q) && (left || right)) {
            result = root;
            return false;
        }

        return root == p || root == q || left || right;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
