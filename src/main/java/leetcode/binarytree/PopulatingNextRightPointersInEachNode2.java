package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 2^12 - 1].
    // -1000 <= Node.val <= 1000
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node before = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (node.left != null) {
                    if (before != null) {
                        before.next = node.left;
                    }
                    queue.add(node.left);
                    before = node.left;
                }

                if (node.right != null) {
                    if (before != null) {
                        before.next = node.right;
                    }
                    queue.add(node.right);
                    before = node.right;
                }
            }
            before = null;
        }

        return root;
    }

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
