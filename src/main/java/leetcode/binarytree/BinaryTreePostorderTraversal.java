package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 100].
    // -100 <= Node.val <= 100
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursive(root, result);

        return result;
    }

    private void recursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        recursive(node.left, result);
        recursive(node.right, result);
        result.add(node.val);
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
