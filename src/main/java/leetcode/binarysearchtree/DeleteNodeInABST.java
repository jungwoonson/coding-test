package leetcode.binarysearchtree;

public class DeleteNodeInABST {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 10^4].
    // -10^5 <= Node.val <= 10^5
    // Each node has a unique value.
    // root is a valid binary search tree.
    // -10^5 <= key <= 10^5
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }

        TreeNode succ = minNode(root.right);
        root.val = succ.val;
        root.right = deleteNode(root.right, succ.val);
        return root;
    }

    private TreeNode minNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
