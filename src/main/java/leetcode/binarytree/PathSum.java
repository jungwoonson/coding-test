package leetcode.binarytree;

public class PathSum {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 5000].
    // -1000 <= Node.val <= 1000
    // -1000 <= targetSum <= 1000
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recursion(root, targetSum, 0);
    }

    private boolean recursion(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;

        if (root.left == null && root.right == null && currentSum == targetSum) {
            return true;
        }

        return recursion(root.left, targetSum, currentSum) || recursion(root.right, targetSum, currentSum);
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
