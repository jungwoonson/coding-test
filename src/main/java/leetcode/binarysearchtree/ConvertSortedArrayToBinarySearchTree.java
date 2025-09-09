package leetcode.binarysearchtree;

public class ConvertSortedArrayToBinarySearchTree {

    // Constraints:
    // 1 <= nums.length <= 10^4
    // -10^4 <= nums[i] <= 10^4
    // nums is sorted in a strictly increasing order.
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, left, mid - 1);
        root.right = recursion(nums, mid + 1, right);

        return root;
    }

    public TreeNode recursion(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, left, mid - 1);
        root.right = recursion(nums, mid + 1, right);

        return root;
    }
}
