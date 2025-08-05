package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    // Constraints:
    // The number of nodes in the tree is in the range [1, 1000].
    // -100 <= Node.val <= 100
    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftValues = new ArrayList<>();
        List<Integer> rightValues = new ArrayList<>();

        left(root, leftValues);
        right(root, rightValues);

        return leftValues.equals(rightValues);
    }

    private void left(TreeNode node, List<Integer> values) {
        if (node == null) {
            values.add(Integer.MIN_VALUE);
            return;
        }

        values.add(node.val);
        left(node.left, values);
        left(node.right, values);
    }

    private void right(TreeNode node, List<Integer> values) {
        if (node == null) {
            values.add(Integer.MIN_VALUE);
            return;
        }

        values.add(node.val);
        right(node.right, values);
        right(node.left, values);
    }

    // 이 알고리즘이 재귀와 트리 순회를 정확히 이해한 사람만이 생각해 낼 수 있는 방법인 것 같다.
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
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
