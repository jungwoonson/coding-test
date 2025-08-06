package leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    // Constraints:
    // 1 <= inorder.length <= 3000
    // postorder.length == inorder.length
    // -3000 <= inorder[i], postorder[i] <= 3000
    // inorder and postorder consist of unique values.
    // Each value of postorder also appears in inorder.
    // inorder is guaranteed to be the inorder traversal of the tree.
    // postorder is guaranteed to be the postorder traversal of the tree.

    // 9,3,15,20,7
    // 9,15,7,20,3
    private int postIndex;
    private int[] postorder;
    private Map<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postIndex = postorder.length - 1;
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

        // 1) 후위 순회의 현재 인덱스가 루트
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // 2) 중위 순회에서 루트 위치 찾기
        int idx = inorderMap.get(rootVal);

        // 3) 오른쪽 → 왼쪽 순으로 재귀 (postorder 특성 상)
        root.right = helper(idx + 1, inEnd);
        root.left  = helper(inStart, idx - 1);

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
