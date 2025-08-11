package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    // Constraints:
    // The number of nodes in the tree is in the range [0, 2^12 - 1].
    // -1000 <= Node.val <= 1000

    //        1
    //    2       3
    //  4   5   6   7
    // 8 9 0 0 0 0 0 0
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node beforeRight = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (node.left == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);

                if (beforeRight != null) {
                    beforeRight.next = node.left;
                }
                node.left.next = node.right;
                beforeRight = node.right;
            }
            beforeRight = null;
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
