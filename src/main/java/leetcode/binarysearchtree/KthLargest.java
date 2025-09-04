package leetcode.binarysearchtree;

public class KthLargest {

    // Constraints:
    // 0 <= nums.length <= 10^4
    // 1 <= k <= nums.length + 1
    // -10^4 <= nums[i] <= 10^4
    // -10^4 <= val <= 10^4
    // At most 10^4 calls will be made to add.
    Node root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        if (nums == null || nums.length == 0) {
            return;
        }

        this.root = new Node(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insert(root, nums[i]);
        }
    }

    public int add(int val) {
        if (this.root == null) {
            this.root = new Node(val);
            return search(root, k);
        }

        insert(root, val);
        return search(root, k);
    }

    public void insert(Node root, int val) {
        if (root == null) {
            return;
        }

        root.count++;
        if (root.val >= val) {
            if (root.left == null) {
                root.left = new Node(val);
                return;
            }
            insert(root.left, val);
            return;
        }

        if (root.right == null) {
            root.right = new Node(val);
            return;
        }

        insert(root.right, val);
    }

    private int search(Node root, int k) {
        int right = root.right == null ? 0 : root.right.count;

        if (right + 1 == k) {
            return root.val;
        }

        if (right + 1 > k) {
            return search(root.right, k);
        }

        return search(root.left, k - right - 1);
    }

    class Node {
        int val;
        Node left;
        Node right;
        int count;

        public Node(int val) {
            this.val = val;
            this.count = 1;
        }
    }
}
