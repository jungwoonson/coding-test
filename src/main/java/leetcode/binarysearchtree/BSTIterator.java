package leetcode.binarysearchtree;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode root) {
        if (root == null) {
            return;
        }

        stack.push(root);
        pushLeft(root.left);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
