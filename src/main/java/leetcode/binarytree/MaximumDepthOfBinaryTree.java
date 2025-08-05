package leetcode.binarytree;

public class MaximumDepthOfBinaryTree {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 10^4].
    // -100 <= Node.val <= 100
    public int maxDepth(TreeNode root) {
        return recursionDepth(root, 0);
    }

    private int recursionDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int left = recursionDepth(root.left, depth + 1);
        int right = recursionDepth(root.right, depth + 1);
        return Math.max(left, right);
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
