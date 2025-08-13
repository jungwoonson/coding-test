package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SerializeAndDeserializeBinaryTree {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 10^4].
    // -1000 <= Node.val <= 1000
    // Encodes a tree to a single string.
    private static final String SEP  = ",";
    private static final String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }


    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(SEP, -1);
        Deque<String> q = new ArrayDeque<>(Arrays.asList(arr));
        return build(q);
    }

    private TreeNode build(Deque<String> q) {
        if (q.isEmpty()) {
            return null;
        }
        String t = q.removeFirst();
        if (t.equals(NULL) || t.isEmpty()) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(t));
        node.left  = build(q);
        node.right = build(q);
        return node;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
