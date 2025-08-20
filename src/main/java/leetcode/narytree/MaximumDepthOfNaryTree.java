package leetcode.narytree;

public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        return recursion(root, 0);
    }

    public int recursion(Node root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;
        int max = depth;
        for (Node child : root.children) {
            max = Math.max(max, recursion(child, depth));
        }
        return max;
    }
}
