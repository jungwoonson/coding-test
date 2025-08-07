package leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // Constraints:
    // 1 <= preorder.length <= 3000
    // inorder.length == preorder.length
    // -3000 <= preorder[i], inorder[i] <= 3000
    // preorder and inorder consist of unique values.
    // Each value of inorder also appears in preorder.
    // preorder is guaranteed to be the preorder traversal of the tree.
    // inorder is guaranteed to be the inorder traversal of the tree.
    private int preIndex;
    private int[] preorder;
    private Map<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        preIndex = 0;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int idx = inorderMap.get(rootVal);

        root.left  = helper(inStart, idx - 1);
        root.right = helper(idx + 1, inEnd);

        return root;
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
